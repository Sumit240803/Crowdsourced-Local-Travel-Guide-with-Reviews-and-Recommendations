package com.social.travelguide.dto;

import com.social.travelguide.models.LocalPlaces;
import com.social.travelguide.models.PostImages;
import com.social.travelguide.models.TravelPlaces;
import com.social.travelguide.models.User;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Response {
    private String message;
    private String token;
    private String error;
    private List<TravelPlaces> travelPlaces;
    private List<LocalPlaces> localPlaces;
    private User user;
    private List<PostImages> images = new ArrayList<>();
}
