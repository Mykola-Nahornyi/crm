package com.example.crm.client;

import com.example.crm.client.dto.ClientCreateRequest;
import com.example.crm.client.dto.ClientResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {

    private final ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public ClientResponse create(ClientCreateRequest request) {
        if (repository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("Client with this email already exists");
        }

        ClientEntity entity = new ClientEntity(
                request.getName(),
                request.getEmail(),
                request.getCompanyName()
        );

        ClientEntity saved = repository.save(entity);
        return mapToResponse(saved);
    }

    public ClientResponse getById(Long id) {
        ClientEntity entity = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Client not found"));
        return mapToResponse(entity);
    }

    public List<ClientResponse> getAll() {
        return repository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    private ClientResponse mapToResponse(ClientEntity entity) {
        return new ClientResponse(
                entity.getId(),
                entity.getName(),
                entity.getEmail(),
                entity.getCompanyName(),
                entity.getStatus().name(),
                entity.getCreatedAt()
        );
    }
}
