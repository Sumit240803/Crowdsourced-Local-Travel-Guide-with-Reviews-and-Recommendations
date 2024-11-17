package com.social.travelguide.dto;

import com.social.travelguide.models.About;
import lombok.Data;

import java.util.List;

@Data
public class ImageDto {
    private String id;
    private List<String> images;
    private String caption;
    private String localPlaceName;
    private String url;
    private About about = null;
}