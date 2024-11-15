package com.social.travelguide.controllers;

import com.social.travelguide.dto.Response;
import com.social.travelguide.dto.TravelDto;
import com.social.travelguide.services.TravelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/public")
public class Public {
    @Autowired
    private TravelService travelService;
    @GetMapping("/category")
    public ResponseEntity<?> getPlaceByCategory(@RequestParam String category){
        try{
            Response response= travelService.findCategory(category);
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            Response response = new Response();
            response.setError(e.getLocalizedMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    @GetMapping("/state")
    public ResponseEntity<?> getPlaceByState(@RequestParam String state){
        try{
            Response response= travelService.findByState(state);
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            Response response = new Response();
            response.setError(e.getLocalizedMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
    @GetMapping("/localPlace")
    public ResponseEntity<?> getPlaceByLocalPlace(@RequestParam String place){
        try{
            Response response= travelService.findByLocalPlace(place);
            return ResponseEntity.ok().body(response);
        }catch (Exception e){
            Response response = new Response();
            response.setError(e.getLocalizedMessage());
            return ResponseEntity.badRequest().body(response);
        }
    }
}
