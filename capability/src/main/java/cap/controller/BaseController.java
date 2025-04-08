package cap.controller;

import cap.firmware.model.User;
import cap.model.AutoAndPropsResponse;
import cap.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/capability")
public class BaseController {

    @Autowired
    BaseService service;

    @GetMapping("/users/{id}")
    public Mono<User> getUserDetails(@PathVariable int id) {
        return service.getUserDetails(id);
    }

    @GetMapping("/auto-props/{id}")
    public Mono<AutoAndPropsResponse> getAutoAndProps(@PathVariable int id) {
        return service.getAutoAndProps(id);
    }
}
