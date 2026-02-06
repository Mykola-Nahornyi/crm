package com.example.crm.client.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ClientUpdateRequest {

    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    private String companyName;

    public Object getName() {
        return name;
    }

    public Object getEmail() {
        return email;
    }

    public Object getCompanyName() {
        return companyName;
    }
}
