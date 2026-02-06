package com.example.crm.client;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "clients")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, unique = true)
    private String email;

    private String companyName;

    @Enumerated(EnumType.STRING)
    private ClientStatus status;

    private LocalDateTime createdAt;

    protected ClientEntity() {
    }

    public ClientEntity(String name, String email, String companyName) {
        this.name = name;
        this.email = email;
        this.companyName = companyName;
        this.status = ClientStatus.ACTIVE;
        this.createdAt = LocalDateTime.now();
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

    public ClientStatus getStatus() {
        return status;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setName(Object name) {
        this.name = name.toString();
    }

    public void setEmail(Object email) {
        this.email = email.toString();
    }

    public void setCompanyName(Object companyName) {
        this.companyName = companyName.toString();
    }
}
