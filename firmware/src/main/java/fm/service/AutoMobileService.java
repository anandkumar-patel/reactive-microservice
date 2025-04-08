package fm.service;

import fm.entity.AutoMobileEntity;
import fm.mapper.AutoMobileMapper;
import fm.model.AutoMobile;
import fm.repository.AutoMobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class AutoMobileService {

    @Autowired
    AutoMobileMapper mapper;

    @Autowired
    private AutoMobileRepository repository;

    public Flux<AutoMobile> findAll() {
        return repository.findAll().map(mapper::toModel);
    }
    public Mono<AutoMobile> findById(int id) {
        return repository.findById(id)
                .map(mapper::toModel);
    }

    public Flux<AutoMobile> findByMake(String make) {
        return repository.findByMake(make)
                .map(mapper::toModel);
    }

    public Mono<AutoMobile> createAutoData(AutoMobile auto) {
        return repository.save(mapper.toEntity(auto)).map(mapper::toModel);
    }

    public Mono<AutoMobile> updateAutoData(int id,AutoMobile auto) {
        return repository.findById(id)
                //.switchIfEmpty(Mono.error(new RuntimeException("AutoMobile not found with id: " + id))) // Handle missing data
                .flatMap(existingAuto -> {
            existingAuto.setMake(auto.getMake());
            existingAuto.setModel(auto.getModel());
            return repository.save(existingAuto).map(mapper::toModel);
        });
    }
    public Mono<AutoMobile> putAutoData(int id,AutoMobile auto) {
        return repository.findById(id)
                .flatMap(existingAuto -> {
                    AutoMobileEntity newAuto = mapper.toEntity(auto);
                    newAuto.setId(id);
                    return repository.save(newAuto).map(mapper::toModel);
                });
    }
    public Mono<AutoMobile> patchAutoData(int id,AutoMobile auto) {
        return repository.findById(id)
                .flatMap(existingAuto -> {
                    mapper.updateEntityFromModel(auto,existingAuto);
                    return repository.save(existingAuto).map(mapper::toModel);
                });
    }
    public Mono<Void> deleteById(int id) {
        return repository.deleteById(id);
    }

    public Mono<Void> deleteByObject(AutoMobile auto) {
        return Mono.empty();
    }
}
