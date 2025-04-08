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
    public Mono<House> findById(int id) {
        return repository.findById(id)
                .map(mapper::toModel);
    }

    public Mono<House> createAutoData(House auto) {
        return repository.save(mapper.toEntity(auto)).map(mapper::toModel);
    }

    public Mono<House> putAutoData(int id,House auto) {
        return repository.findById(id)
                .flatMap(existingProps -> {
                    PropertyEntity  props = mapper.toEntity(auto);
                    props.setId(id);
                    return repository.save(props).map(mapper::toModel);
                });
    }
    public Mono<House> patchAutoData(int id,House auto) {
        return repository.findById(id)
                .flatMap(existingAuto -> {
                    mapper.updateEntityFromModel(auto,existingAuto);
                    return repository.save(existingAuto).map(mapper::toModel);
                });
    }
    public Mono<Void> deleteById(int id) {
        return repository.deleteById(id);
    }

}
