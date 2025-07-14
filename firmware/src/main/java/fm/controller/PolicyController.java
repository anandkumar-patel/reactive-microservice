package fm.controller;

import fm.entity.Policy;
import fm.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/firmware/policy")
public class PolicyController {

    @Autowired
    PolicyService policyService;

    @GetMapping
    public Flux<Policy> getAllPolicies(){
        return policyService.getAllPolicies();
    }

    @GetMapping("/{policyId}")
    public Mono<Policy> getPolicyDetails(@PathVariable int policyId) {
        return policyService.getPolicyDetails(policyId);
    }

    @PostMapping
    public Mono<Policy> createPolicy(@RequestBody Policy policy){
        return policyService.createPolicy(policy);
    }

    @PutMapping("/{policyId}")
    public  Mono<Policy> updatePolicy(@PathVariable long policyId, @RequestBody Policy policy){
        return policyService.updatePolicy(policyId, policy);
    }
    @DeleteMapping("/{policyId}")
    public  Mono<Void> deletePolicy(@PathVariable long policyId){
        return policyService.deletePolicy(policyId);
    }

}
