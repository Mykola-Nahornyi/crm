package com.example.crm.contract;

import com.example.crm.contract.dto.ContractCreateRequest;
import com.example.crm.contract.dto.ContractResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ContractController {

    private final ContractService service;

    public ContractController(ContractService service) {
        this.service = service;
    }

    @PostMapping("/clients/{clientId}/contracts")
    public ContractResponse create(
            @PathVariable Long clientId,
            @Valid @RequestBody ContractCreateRequest request
    ) {
        return service.create(clientId, request);
    }

    @GetMapping("/clients/{clientId}/contracts")
    public List<ContractResponse> getByClient(@PathVariable Long clientId) {
        return service.getByClient(clientId);
    }

    @GetMapping("/contracts/{id}")
    public ContractResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }
}
