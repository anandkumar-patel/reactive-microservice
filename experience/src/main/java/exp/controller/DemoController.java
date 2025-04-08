package exp.controller;

import exp.model.JobResponse;
import exp.model.PersonalUmbrellaLineResponse;
import exp.model.UWIssues;
import exp.service.DemoService;
import exp.model.VehicleExposuresResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class DemoController {

    @Autowired
    DemoService guidewireClient;

    @GetMapping("/{jobId}")
    public Mono<VehicleExposuresResponse> getVehiclesAndIssues(@PathVariable String jobId) {
        Mono<PersonalUmbrellaLineResponse> vehicleMono = guidewireClient.getVehicles();
        Mono<JobResponse> jobResponseMono = guidewireClient.getIssues().defaultIfEmpty(new JobResponse());

        return Mono.zip(vehicleMono, jobResponseMono,(personalUmbrellaLineResponse, jobResponse)->{
            System.out.println(jobResponse);
            List<UWIssues> issues = jobResponse.getIssuesList();

            return new VehicleExposuresResponse(personalUmbrellaLineResponse.getVehiclesList(), issues != null? issues : new ArrayList<>());
        });
    }

}

/*

        return Mono.zip(vehicleMono,jobResponseMono,((personalUmbrellaLineResponse, jobResponse) -> new VehicleExposuresResponse(personalUmbrellaLineResponse.getVehiclesList(), jobResponse.getIssuesList())));


        return vehicleMono.zipWith(jobResponseMono,(personalUmbrellaLineResponse, jobResponse) -> {
            return  new VehicleExposuresResponse(personalUmbrellaLineResponse.getVehiclesList(), jobResponse.getIssuesList());
                })
                .switchIfEmpty(Mono.just(new VehicleExposuresResponse(new ArrayList<>(), new ArrayList<>())));

 */