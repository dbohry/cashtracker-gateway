package com.lhamacorp.cashtrackergateway.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("cashtracker-auth")
@RequestMapping(value = "/ct/auth")
public interface AuthClient {

    @PostMapping(value = "/login")
    ResponseEntity<String> login(@RequestParam("user") String user,
                                 @RequestParam("pass") String pass);

}
