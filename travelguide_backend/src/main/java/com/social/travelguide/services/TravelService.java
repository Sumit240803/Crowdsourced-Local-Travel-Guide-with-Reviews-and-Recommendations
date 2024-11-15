package com.social.travelguide.services;

import com.social.travelguide.dto.Response;
import com.social.travelguide.models.TravelPlaces;
import com.social.travelguide.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TravelService {
    @Autowired
    private TravelRepository travelRepository;

    public Response findCategory(String category){
        try{
            List<TravelPlaces> travelPlaces = travelRepository.findByCategory(category);
            Response response = new Response();
            if(travelPlaces!=null){
                response.setMessage("Response added");
                response.setTravelPlaces(travelPlaces);
            }else {
                response.setMessage("No places exists");
            }
            return response;
        } catch (Exception e) {
            Response response = new Response();
            response.setError(e.getLocalizedMessage());
            return response;
        }
    }
    public Response findByState(String state){
        try{
            List<TravelPlaces> travelPlaces= travelRepository.findByState(state);
            Response response = new Response();
            if(travelPlaces!=null){
                response.setMessage("Response added");
                response.setTravelPlaces(travelPlaces);
            }else {
                response.setMessage("No places exists");
            }
            return response;
        } catch (Exception e) {
            Response response = new Response();
            response.setError(e.getLocalizedMessage());
            return response;
        }
    }

    public Response findByLocalPlace(String name){
        try{
            List<TravelPlaces> travelPlaces= travelRepository.findByLocalPlacesName(name);
            Response response = new Response();
            if(travelPlaces!=null){
                response.setMessage("Response added");
                response.setTravelPlaces(travelPlaces);
            }else {
                response.setMessage("No places exists");
            }
            return response;
        } catch (Exception e) {
            Response response = new Response();
            response.setError(e.getLocalizedMessage());
            return response;
        }
    }
}
