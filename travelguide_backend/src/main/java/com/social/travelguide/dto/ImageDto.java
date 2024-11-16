package com.social.travelguide.dto;

import lombok.Data;

import java.util.List;

@Data
public class ImageDto {
    private String id;
    private List<String> images;
    private String caption;
}
