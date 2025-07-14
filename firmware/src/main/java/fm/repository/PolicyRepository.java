package fm.repository;

import fm.entity.Policy;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends R2dbcRepository<Policy, Long> {
}
