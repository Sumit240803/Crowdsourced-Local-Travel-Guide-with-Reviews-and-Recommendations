package com.social.travelguide.controllers;

import com.social.travelguide.dto.LoginDto;
import com.social.travelguide.dto.Register;
import com.social.travelguide.dto.Response;
import com.social.travelguide.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthService authService;
    @PostMapping("/register")
    public Response register(@RequestBody Register register){
        try{
            return authService.register(register);
        }catch (Exception e){
            Response response = new Response();
            response.setError(e.getLocalizedMessage());
            return response;
        }
    }

    @PostMapping("/login")
    public Response login(@RequestBody LoginDto loginDto){
        try{
            return authService.login(loginDto);
        }catch (Exception e){
            Response response = new Response();
            response.setError(e.getLocalizedMessage());
            return response;
        }
    }
}
