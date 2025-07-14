package fm.repository;

import fm.entity.AutoMobileEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface AutoMobileRepository extends R2dbcRepository<AutoMobileEntity,Long> {
    Flux<AutoMobileEntity> findByMake(String make);
}
