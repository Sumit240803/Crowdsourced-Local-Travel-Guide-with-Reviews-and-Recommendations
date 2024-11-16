package com.social.travelguide.services;

import com.social.travelguide.dto.Response;
import com.social.travelguide.models.LocalPlaces;
import com.social.travelguide.models.TravelPlaces;
import com.social.travelguide.repository.TravelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Response addAbout(String id, String name, String about) {
        Response response = new Response();

        try {
            Optional<TravelPlaces> travelPlacesOptional = travelRepository.findById(id);

            if (travelPlacesOptional.isPresent()) {
                TravelPlaces travelPlace = travelPlacesOptional.get();
                List<LocalPlaces> localPlaces = travelPlace.getLocalPlaces();

                boolean placeFound = false;

                for (LocalPlaces local : localPlaces) {
                    if (local.getName().equals(name)) {
                        local.setAbout(List.of(about)); // Update the `about` field
                        placeFound = true;
                        break;
                    }
                }

                if (placeFound) {
                    travelRepository.save(travelPlace); // Save the updated object to the database

                    response.setMessage("About information updated successfully.");
                } else {
                    ;
                    response.setMessage("Local place with the given name not found.");
                }
            } else {

                response.setMessage("Travel place with the given ID not found.");
            }
        } catch (Exception e) {

            response.setMessage("An error occurred: " + e.getMessage());
        }

        return response;
    }

    public Response addImage(String id, String name, String imageUrl) {
        Response response = new Response();

        try {
            Optional<TravelPlaces> travelPlacesOptional = travelRepository.findById(id);

            if (travelPlacesOptional.isPresent()) {
                TravelPlaces travelPlace = travelPlacesOptional.get();
                List<LocalPlaces> localPlaces = travelPlace.getLocalPlaces();

                boolean placeFound = false;

                for (LocalPlaces local : localPlaces) {
                    if (local.getName().equals(name)) {
                        local.getImages().add(imageUrl); // Add the image URL to the images list
                        placeFound = true;
                        break;
                    }
                }

                if (placeFound) {
                    travelRepository.save(travelPlace); // Save the updated object to the database

                    response.setMessage("Image added successfully.");
                } else {

                    response.setMessage("Local place with the given name not found.");
                }
            } else {

                response.setMessage("Travel place with the given ID not found.");
            }
        } catch (Exception e) {

            response.setMessage("An error occurred: " + e.getMessage());
        }

        return response;
    }


}
