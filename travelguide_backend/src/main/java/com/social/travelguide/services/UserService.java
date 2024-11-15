package com.social.travelguide.services;

import com.social.travelguide.dto.Response;
import com.social.travelguide.models.BucketList;
import com.social.travelguide.models.LocalPlaces;
import com.social.travelguide.models.TravelPlaces;
import com.social.travelguide.models.User;
import com.social.travelguide.repository.TravelRepository;
import com.social.travelguide.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private TravelRepository travelRepository;
    @Autowired
    private  UserRepository userRepository;

    public User getLoggedUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null && authentication.isAuthenticated()) {
            Object principal = authentication.getPrincipal();

            if (principal instanceof UserDetails) {
                // Return the username of the logged-in user
                String username = ((UserDetails) principal).getUsername();
                Optional<User> user = userRepository.findByUsername(username);
                if(user.isPresent()){
                    return user.get();
                }
            }
        }
        return null; // No logged-in user
    }

    public Response createBucket(String name ,String description, List<LocalPlaces> localPlaces){
        try{
            User user = getLoggedUser();
            BucketList bucketList = new BucketList();
            bucketList.setName(name);
            bucketList.setPlaces(localPlaces);
            bucketList.setDescription(description);
            user.getBucketList().add(bucketList);
            userRepository.save(user);
            Response response = new Response();
            response.setMessage("Bucket Created");
            response.setUser(user);
            return response;
        }catch (Exception e) {
            Response response = new Response();
            response.setError(e.getLocalizedMessage());
            return response;
        }
    }
    public Response deleteBucket(String  name){
        try{
            User user = getLoggedUser();
            List<BucketList> bucketLists = user.getBucketList();
            for(BucketList bucket : bucketLists ){
                if(bucket.getName().equals(name)){
                    user.getBucketList().remove(bucket);
                }
            }
            Response response = new Response();
            response.setMessage("Bucket Deleted");
            response.setUser(user);
            return response;
        }catch (Exception e) {
            Response response = new Response();
            response.setError(e.getLocalizedMessage());
            return response;
        }
    }
    public Response editBucket(BucketList bucketList , String bucketName){
        try{
            User user = getLoggedUser();
            List<BucketList> bucketLists = user.getBucketList();
            boolean updated = false;
            for(BucketList bucket : bucketLists){
                if(bucket.getName().equals(bucketName)){
                    bucket.setName(bucketList.getName());
                    bucket.setDescription(bucketList.getDescription());
                    bucket.setPlaces(bucketList.getPlaces());
                    updated = true;
                    break;
                }
            }
            Response response = new Response();
            if(!updated){
                response.setError(("Bucket Not Found"));
            }
            user.setBucketList(bucketLists);
            userRepository.save(user);

            response.setMessage("Bucket Updated");
            response.setUser(user);
            return response;
        }catch (Exception e) {
            Response response = new Response();
            response.setError(e.getLocalizedMessage());
            return response;
        }
    }
}