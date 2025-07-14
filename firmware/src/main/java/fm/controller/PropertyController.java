package fm.controller;

import fm.model.House;
import fm.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@RestController
@RequestMapping("/firmware/props")
public class PropertyController {

    @Autowired
    private PropertyService service;

    @GetMapping
    public Flux<House> getAllPropertyData() {
        return service.findAll().delayElements(Duration.ofSeconds(3)).log();
    }

    @GetMapping("/{id}")
    public Mono<House> getPropertyData(@PathVariable int id) {
        return service.findById(id);
    }

    @PostMapping
    public Mono<House> postPropertyData(@RequestBody House house) {
        return service.createPropertyData(house);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<House>> update(@PathVariable int id, @RequestBody House house) {
        return service.updatePropertyData(id, house).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable int id) {
        return service.deleteById(id);
    }
}
