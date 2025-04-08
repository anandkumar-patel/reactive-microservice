package fm.controller;

import fm.model.PolicyContentResponse;
import fm.service.PolicyContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/firmware/policy")
public class PolicyContentsController {

    @Autowired
    PolicyContentsService policyContentsService;

    @GetMapping("/{policyId}")
    public Mono<PolicyContentResponse> getPolicyDetails(@PathVariable int policyId) {
        return policyContentsService.getPolicyDetails(policyId);
    }

}
