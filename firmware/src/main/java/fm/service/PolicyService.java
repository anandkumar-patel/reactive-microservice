package fm.service;

import fm.entity.Policy;
import fm.entity.PolicyContents;
import fm.repository.PolicyContentsRepository;
import fm.repository.PolicyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class PolicyService {

    @Autowired
    PolicyRepository policyRepository;
    @Autowired
    PolicyContentsRepository policyContentsRepository;
    @Autowired
    PropertyService propertyService;
    @Autowired
    AutoMobileService autoMobileService;

    public Flux<Policy> getAllPolicies() {
        return policyRepository.findAll()
                .flatMap(this::populatePolicyDetails);
    }

    public Mono<Policy> getPolicyDetails(long policyId) {
        return policyRepository.findById(policyId)
                .flatMap(this::populatePolicyDetails);
    }

    public Mono<Policy> populatePolicyDetails(Policy policy) {
        return policyContentsRepository.findByPolicyId(policy.getId())
                .collectList()
                .map(contents -> {
                    policy.setContents(contents);
                    return policy;
                });
    }

    public Mono<Policy> createPolicy(Policy policy) {
        return policyRepository.save(new Policy(null,policy.getName(), policy.getStartYear(),policy.getEndYear(),policy.getPremium(), null))
                .flatMap(saved -> {
                    List<PolicyContents> contents = policy.getContents().stream()
                            .peek(d -> d.setPolicyId(saved.getId()))
                            .toList();
                    return policyContentsRepository.saveAll(contents).collectList()
                            .map(savedDetails -> {
                                saved.setContents(savedDetails);
                                return saved;
                            });
                });
    }

    public Mono<Policy> updatePolicy(long id, Policy policy) {
        return policyRepository.findById(id)
                .flatMap(existing -> {
                    existing.setName(policy.getName());
                    existing.setStartYear(policy.getStartYear());
                    existing.setEndYear(policy.getEndYear());
                    existing.setPremium(policy.getPremium());
                    return policyRepository.save(existing);
                }).flatMap(updated -> {
                    return policyContentsRepository.deleteByPolicyId(updated.getId())  // Clear old details
                            .thenMany(policyContentsRepository.saveAll(
                                    policy.getContents().stream()
                                            .peek(d -> d.setPolicyId(updated.getId()))
                                            .toList()
                            )).collectList()
                            .map(newContents -> {
                                updated.setContents(newContents);
                                return updated;
                            });
                });
    }

    public Mono<Void> deletePolicy(long policyId) {
        return  policyContentsRepository.deleteByPolicyId(policyId).then(policyRepository.deleteById(policyId));
    }
}
