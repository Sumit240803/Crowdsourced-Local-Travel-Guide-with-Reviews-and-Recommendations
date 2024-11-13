package com.social.travelguide.dto;

import lombok.Data;

@Data
public class Response {
    private String message;
    private String token;
    private String error;
}
