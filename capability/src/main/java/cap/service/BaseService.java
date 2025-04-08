package cap.service;

import cap.client.FirmwareClient;
import cap.firmware.model.User;
import cap.model.AutoAndPropsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class BaseService {
    @Autowired
    FirmwareClient client;

    public Mono<User> getUserDetails(int id) {
        return client.getUserDetails(id);
    }

    public Mono<AutoAndPropsResponse> getAutoAndProps(int id) {
        return client.getAutoAndProps(id);
    }
}
