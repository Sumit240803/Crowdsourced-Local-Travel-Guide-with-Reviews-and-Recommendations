package com.social.travelguide.models;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class LocalPlaces {
    private String name;
    private Parameters parameters;
    private List<String> about= new ArrayList<>();
    private List<String> images = new ArrayList<>();
}
