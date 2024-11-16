package com.social.travelguide.controllers;

import com.social.travelguide.dto.BucketDto;
import com.social.travelguide.dto.Response;
import com.social.travelguide.models.BucketList;
import com.social.travelguide.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/testing")
    public ResponseEntity<?> testing(){
        return ResponseEntity.ok().body("Hello from server");
    }
    @PostMapping("/createBucket")
    public ResponseEntity<?> createBucket(@RequestBody BucketDto bucketDto){
        try{
            Response response = userService.createBucket(bucketDto.getName() , bucketDto.getDescription(),bucketDto.getLocalPlaces());
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            Response response = new Response();
            response.setError(e.getLocalizedMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @DeleteMapping("/deleteBucket")
    public ResponseEntity<?> deleteBucket(@RequestBody BucketDto bucketDto){
        try{
            Response response = userService.deleteBucket(bucketDto.getName());
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            Response response = new Response();
            response.setError(e.getLocalizedMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }

    @PostMapping("/editBucket")
    public ResponseEntity<?> editBucket(@RequestBody BucketDto bucketDto){
        try{
            Response response = userService.editBucket(bucketDto.getBucketList(),bucketDto.getName());
            return ResponseEntity.ok().body(response);
        } catch (Exception e){
            Response response = new Response();
            response.setError(e.getLocalizedMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
