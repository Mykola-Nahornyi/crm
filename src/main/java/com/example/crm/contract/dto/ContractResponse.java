package com.example.crm.contract.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class ContractResponse {

    private Long id;
    private Long clientId;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal monthlyFee;
    private String status;
    private LocalDateTime createdAt;

    public ContractResponse(
            Long id,
            Long clientId,
            LocalDate startDate,
            LocalDate endDate,
            BigDecimal monthlyFee,
            String status,
            LocalDateTime createdAt
    ) {
        this.id = id;
        this.clientId = clientId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.monthlyFee = monthlyFee;
        this.status = status;
        this.createdAt = createdAt;
    }

}
