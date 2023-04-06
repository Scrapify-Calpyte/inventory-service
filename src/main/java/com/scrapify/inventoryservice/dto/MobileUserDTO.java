package com.scrapify.inventoryservice.dto;

import lombok.Data;

import javax.persistence.Column;

@Data
public class MobileUserDTO {
    private String id;
    private String name;
    private String firstName;
    private String lastName;
    private String mobileNumber;
    private String email;
    private String userType;

    @Column(columnDefinition = "boolean default true")
    private Boolean isActive;

    private String password;
}
