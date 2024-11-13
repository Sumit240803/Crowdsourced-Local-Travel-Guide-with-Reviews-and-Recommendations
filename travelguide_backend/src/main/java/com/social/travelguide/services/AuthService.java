package com.social.travelguide.services;

import com.social.travelguide.dto.LoginDto;
import com.social.travelguide.dto.Register;
import com.social.travelguide.dto.Response;
import com.social.travelguide.models.User;
import com.social.travelguide.repository.UserRepository;
import com.social.travelguide.utils.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtUtils jwtUtils;
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
    public Response login(LoginDto loginDto){
        try{
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDto.getUsername() , loginDto.getPassword()
                    )
            );
            String jwt = jwtUtils.createToken(loginDto.getUsername());
            Response response = new Response();
            response.setMessage("Login Success");
            response.setToken(jwt);
            return response;
        } catch (Exception e) {
           Response response = new Response();
           response.setError(e.getLocalizedMessage());
           return response;
        }
    }

}
