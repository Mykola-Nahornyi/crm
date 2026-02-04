package com.example.crm.client;

import com.example.crm.client.dto.ClientCreateRequest;
import com.example.crm.client.dto.ClientResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clients")
@Tag(name = "Clients", description = "Client management API")
public class ClientController {

    private final ClientService service;

    public ClientController(ClientService service) {
        this.service = service;
    }

    @PostMapping
    public ClientResponse create(@RequestBody ClientCreateRequest request) {
        return service.create(request);
    }

    @GetMapping("/{id}")
    public ClientResponse getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ClientResponse> getAll() {
        return service.getAll();
    }
}
