package com.social.travelguide.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document(collection = "users")
@Data
public class User {
    @Id
    private String id;
    private String username;
    @Indexed(unique = true)
    private String email;
    @JsonIgnore
    private String password;
    private String city;
    private List<String> roles  = new ArrayList<>();

    private List<BucketList> bucketList = new ArrayList<>();
}
