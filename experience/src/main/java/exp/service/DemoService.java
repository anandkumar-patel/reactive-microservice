package exp.service;

import exp.model.JobResponse;
import exp.model.PersonalUmbrellaLineResponse;
import exp.model.UWIssues;
import exp.model.Vehicles;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class DemoService {

    public Mono<PersonalUmbrellaLineResponse> getVehicles() {

        List<Vehicles> vehicles = List.of(new Vehicles(11,"hundai","santro"), new Vehicles(12,"honda","city"));
        PersonalUmbrellaLineResponse obj = new PersonalUmbrellaLineResponse(vehicles);
        return Mono.justOrEmpty(obj);
    }

    public Mono<JobResponse> getIssues() {
        List<UWIssues> issues = List.of(new UWIssues(11,"desc1","comment1"));
        JobResponse jobResponse = new JobResponse(issues);
        //return Mono.justOrEmpty(jobResponse);
        return Mono.empty();
    }
}
