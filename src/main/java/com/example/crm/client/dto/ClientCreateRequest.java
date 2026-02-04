package com.example.crm.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(description = "Request to create a client")
public class ClientCreateRequest {

    @Schema(example = "John Doe")
    private String name;

    @Schema(example = "john.doe@email.com")
    private String email;

    @Schema(example = "Acme Corp")
    private String companyName;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }
}
