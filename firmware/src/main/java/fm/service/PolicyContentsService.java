package fm.service;

import fm.entity.PolicyEntity;
import fm.model.AutoMobile;
import fm.model.PolicyContentResponse;
import fm.repository.PolicyContentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class PolicyContentsService {

    @Autowired
    PolicyContentsRepository repository;
    @Autowired
    PropertyService propertyService;
    @Autowired
    AutoMobileService autoMobileService;

    public Mono<PolicyContentResponse> getPolicyDetails(int policyId) {
        Mono<PolicyEntity> policy = repository.findById(policyId);
        Mono<AutoMobile> byId = autoMobileService.findById(11);


        return Mono.empty();
    }
}
