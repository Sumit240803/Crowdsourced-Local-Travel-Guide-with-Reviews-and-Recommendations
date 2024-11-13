package com.social.travelguide.services;

import com.social.travelguide.dto.Register;
import com.social.travelguide.dto.Response;
import com.social.travelguide.models.User;
import com.social.travelguide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    public Response register(Register register){
        try{
            User existingUser = userRepository.findByEmail(register.getEmail());
            Response response = new Response();
            if(existingUser==null){
                User user = new User();
                user.setUsername(register.getUsername());
                user.setEmail(register.getEmail());
                user.setPassword(passwordEncoder.encode(register.getPassword()));
                user.setCity(register.getCity());
                user.setRoles(List.of("USER"));
                userRepository.save(user);
                response.setMessage("User registered Successfully");
            }else {
                response.setError("User Already Exists");
            }
            return response;
        } catch (Exception e) {
           Response response = new Response();
           response.setError(e.getLocalizedMessage());
           return response;
        }
    }
}
