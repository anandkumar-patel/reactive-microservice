package fm.service;

import fm.entity.PropertyEntity;
import fm.mapper.PropertyMapper;
import fm.model.House;
import fm.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PropertyService {

    @Autowired
    PropertyMapper mapper;

    @Autowired
    private PropertyRepository repository;

    public Flux<House> findAll() {
        return repository.findAll().map(mapper::toModel);
    }

    public Mono<House> findById(long id) {
        return repository.findById(id)
                .map(mapper::toModel);
    }

    public Mono<House> createPropertyData(House house) {
        return repository.save(mapper.toEntity(house)).map(mapper::toModel);
    }

    public Mono<House> updatePropertyData(long id,House house) {
        return repository.findById(id)
                .flatMap(existingProperty -> {
                    existingProperty.setName(house.getName());
                    existingProperty.setCity(house.getCity());
                    return repository.save(existingProperty).map(mapper::toModel);
                });
    }

    public Mono<Void> deleteById(long id) {
        return repository.deleteById(id);
    }
}
