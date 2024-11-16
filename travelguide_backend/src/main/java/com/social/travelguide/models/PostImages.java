package com.social.travelguide.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@Document(collection = "postImages")
public class PostImages {
    @Id
    private String id;

    private String userId;
    private List<String> multiImages = new ArrayList<>();
    private String caption;
}
