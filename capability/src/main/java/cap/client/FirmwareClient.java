package cap.client;

import cap.firmware.model.AutoMobile;
import cap.firmware.model.House;
import cap.firmware.model.User;
import cap.model.AutoAndPropsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.List;

@Component
public class FirmwareClient {
    @Autowired
    WebClient webClient;

    public Mono<User> getUserDetails(int id) {
        return webClient.get()
                .uri("/user/{id}", id)
                .retrieve()
                .bodyToMono(User.class);
    }


    public Mono<AutoAndPropsResponse> getAutoAndProps(int id) {
        Mono<AutoMobile> autoMono = webClient.get()
                .uri("/auto/{id}", id)
                .retrieve()
                .bodyToMono(AutoMobile.class);

        Mono<List<House>> housesMono = webClient.get()
                .uri("/props")
                .retrieve()
                .bodyToFlux(House.class)
                .collectList();

        return Mono.zip(autoMono, housesMono)
                .map(tuple -> new AutoAndPropsResponse(tuple.getT1(), tuple.getT2()));
    }
}
