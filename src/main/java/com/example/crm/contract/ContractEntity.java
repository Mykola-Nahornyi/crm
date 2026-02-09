package com.example.crm.contract;

import com.example.crm.client.ClientEntity;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contracts")
public class ContractEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "client_id")
    private ClientEntity client;

    private LocalDate startDate;
    private LocalDate endDate;

    private BigDecimal monthlyFee;

    private LocalDateTime createdAt;

    protected ContractEntity() {
    }

    public ContractEntity(
            ClientEntity client,
            LocalDate startDate,
            LocalDate endDate,
            BigDecimal monthlyFee
    ) {
        this.client = client;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthlyFee = monthlyFee;
        this.createdAt = LocalDateTime.now();
    }

    public ContractStatus getStatus() {
        return endDate.isBefore(LocalDate.now())
                ? ContractStatus.EXPIRED
                : ContractStatus.ACTIVE;
    }

    public Long getId() {
        return id;
    }

    public ClientEntity getClient() {
        return client;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public BigDecimal getMonthlyFee() {
        return monthlyFee;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
