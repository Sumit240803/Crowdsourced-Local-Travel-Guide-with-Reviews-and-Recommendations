package com.social.travelguide.models;

import lombok.Data;

import java.util.List;
@Data
public class Parameters {
    private List<String> mustVisit;
    private List<String> localCuisine;
    private List<String> scenicBeauty;
    private List<String> adventureActivities;
    private List<String> bestTimeToVisit;
    private List<String> culturalSignificance;

}
