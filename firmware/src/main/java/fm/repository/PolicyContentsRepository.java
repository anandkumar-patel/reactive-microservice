package fm.repository;

import fm.entity.PolicyContents;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public interface PolicyContentsRepository extends R2dbcRepository<PolicyContents, Long> {
    Flux<PolicyContents> findByPolicyId(long policyId);
    Mono<Void> deleteByPolicyId(long policyId);
}
