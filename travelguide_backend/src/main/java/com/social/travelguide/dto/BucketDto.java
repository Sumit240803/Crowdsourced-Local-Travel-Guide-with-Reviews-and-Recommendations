package com.social.travelguide.dto;

import com.social.travelguide.models.BucketList;
import com.social.travelguide.models.LocalPlaces;
import lombok.Data;

import java.util.List;
@Data
public class BucketDto {
    private String name;
    private BucketList bucketList;
    private String description;
    private List<LocalPlaces> localPlaces;
}
