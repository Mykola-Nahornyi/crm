package com.example.crm.contract.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ContractCreateRequest {

    @NotNull
    private LocalDate startDate;

    @NotNull
    private LocalDate endDate;

    @Positive
    private BigDecimal monthlyFee;

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public BigDecimal getMonthlyFee() {
        return monthlyFee;
    }
}
