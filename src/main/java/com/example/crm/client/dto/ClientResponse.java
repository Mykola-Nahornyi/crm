package com.example.crm.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(description = "Client response")
public class ClientResponse {

    private Long id;
    private String name;
    private String email;
    private String companyName;
    private String status;
    private LocalDateTime createdAt;

    public ClientResponse(Long id, String name, String email,
                          String companyName, String status,
                          LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.companyName = companyName;
        this.status = status;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
