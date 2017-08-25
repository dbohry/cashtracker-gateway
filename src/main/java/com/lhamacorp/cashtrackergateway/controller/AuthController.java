package com.lhamacorp.cashtrackergateway.controller;

import com.lhamacorp.cashtrackergateway.client.AuthClient;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/ct-gateway/auth")
public class AuthController {

    @Autowired
    private AuthClient client;

    @CrossOrigin(allowedHeaders = "*")
    @ApiOperation(value = "Inform username and password to get a valid token", response = String.class)
    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@RequestParam("user") String user,
                                        @RequestParam("pass") String pass) {
        return client.login(user, pass);
    }

    @CrossOrigin(allowedHeaders = "*")
    @ApiOperation(value = "Inform username and password to get a valid token", response = String.class)
    @PostMapping(value = "/register")
    public ResponseEntity<String> register(@RequestParam("user") String user,
                                           @RequestParam("pass") String pass,
                                           @RequestParam("email") String email) {
        return client.register(user, pass, email);
    }

}
