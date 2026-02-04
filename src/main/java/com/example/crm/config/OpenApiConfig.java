package com.example.crm.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.context.annotation.Configuration;

@OpenAPIDefinition(
        info = @Info(
                title = "B2B Contracts & Billing API",
                version = "1.0.0",
                description = "REST API for managing clients, contracts, invoices and payments"
        )
)

@Configuration

public class OpenApiConfig {
}
