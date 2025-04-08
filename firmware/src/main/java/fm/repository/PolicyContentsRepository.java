package fm.repository;

import fm.entity.PolicyEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface PolicyContentsRepository extends R2dbcRepository<PolicyEntity,Integer> {
}
