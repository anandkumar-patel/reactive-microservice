package fm.repository;

import fm.entity.AutoMobileEntity;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;


public interface AutoMobileRepository extends R2dbcRepository<AutoMobileEntity,Integer> {
    Flux<AutoMobileEntity> findByMake(String make);
}
