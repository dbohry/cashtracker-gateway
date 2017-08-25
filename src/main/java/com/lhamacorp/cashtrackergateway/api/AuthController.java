package com.lhamacorp.cashtrackergateway.api;

import com.lhamacorp.cashtrackergateway.client.AuthClient;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;

@RestController
@RequestMapping(value = "/ct-gateway/auth")
public class AuthController {

    @Autowired
    private AuthClient client;

    @CrossOrigin(allowedHeaders = "*")
    @ApiOperation(value = "Inform username and password to get a valid token", response = String.class)
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<String> login(@RequestParam("user") String user,
                                        @RequestParam("pass") String pass) throws ServletException {
        return client.login(user, pass);
    }


}
