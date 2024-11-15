package com.social.travelguide.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.List;

@Data
@Document(collection = "travelplaces")
public class TravelPlaces {
    @Id
    private String id;

    private String category;
    private String state;
    @Field(name = "localPlaces")
    private List<LocalPlaces> localPlaces;
}
