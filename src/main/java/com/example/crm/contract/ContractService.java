package com.example.crm.contract;

import com.example.crm.client.ClientEntity;
import com.example.crm.client.ClientRepository;
import com.example.crm.contract.dto.ContractCreateRequest;
import com.example.crm.contract.dto.ContractResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractService {

    private final ContractRepository contractRepository;
    private final ClientRepository clientRepository;

    public ContractService(
            ContractRepository contractRepository,
            ClientRepository clientRepository
    ) {
        this.contractRepository = contractRepository;
        this.clientRepository = clientRepository;
    }

    public ContractResponse create(Long clientId, ContractCreateRequest request) {
        ClientEntity client = clientRepository.findById(clientId)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));

        ContractEntity contract = new ContractEntity(
                client,
                request.getStartDate(),
                request.getEndDate(),
                request.getMonthlyFee()
        );

        return map(contractRepository.save(contract));
    }

    public List<ContractResponse> getByClient(Long clientId) {
        return contractRepository.findByClientId(clientId)
                .stream()
                .map(this::map)
                .toList();
    }

    public ContractResponse getById(Long id) {
        return contractRepository.findById(id)
                .map(this::map)
                .orElseThrow(() -> new IllegalArgumentException("Contract not found"));
    }

    private ContractResponse map(ContractEntity c) {
        return new ContractResponse(
                c.getId(),
                c.getClient().getId(),
                c.getStartDate(),
                c.getEndDate(),
                c.getMonthlyFee(),
                c.getStatus().name(),
                c.getCreatedAt()
        );
    }
}
