package fm.controller;

import fm.model.AutoMobile;
import fm.service.AutoMobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/firmware/auto")
public class AutomobileController {

    @Autowired
    private AutoMobileService service;

    @GetMapping
    public Flux<AutoMobile> getAllAutoData() {
        return service.findAll().delayElements(Duration.ofSeconds(3)).log();
    }

    @GetMapping("/{id}")
    public Mono<AutoMobile> getAutoData(@PathVariable int id) {
        return service.findById(id);
    }

    @GetMapping("/make/{make}")
    public Flux<AutoMobile> getAutoDataByMake(@PathVariable String make) {
        return service.findByMake(make);
    }

    @PostMapping
    public Mono<AutoMobile> postAutoData(@RequestBody AutoMobile auto) {
        return service.createAutoData(auto);
    }

    @PutMapping("/{id}")
    public Mono<ResponseEntity<AutoMobile>> update(@PathVariable int id, @RequestBody AutoMobile auto) {
        return service.putAutoData(id, auto).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }
    @PatchMapping("/{id}")
    public Mono<ResponseEntity<AutoMobile>> patch(@PathVariable int id, @RequestBody AutoMobile auto) {
        return service.patchAutoData(id, auto).map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public Mono<Void> deleteById(@PathVariable int id) {
        return service.deleteById(id);
    }
}
