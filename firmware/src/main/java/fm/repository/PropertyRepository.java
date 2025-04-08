package fm.repository;

import fm.entity.PropertyEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;

public interface PropertyRepository extends R2dbcRepository<PropertyEntity,Integer> {
}
