package com.rentiT.userMs.dto;


import lombok.Data;

@Data
public class UserResponseDTO {
    private Long id;
    private String name;
    private String email;
    private String location;
    private String organization;
    private String preferences;
}