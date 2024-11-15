package com.social.travelguide.models;

import lombok.Data;


import java.util.List;

@Data
public class BucketList {


    private String name;
    private String description;
    private List<LocalPlaces> places;
    private Boolean checked;
}
