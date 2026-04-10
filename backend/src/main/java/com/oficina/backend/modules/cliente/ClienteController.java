package com.oficina.backend.modules.cliente;

import com.oficina.backend.modules.cliente.dto.ClienteRequestDTO;
import com.oficina.backend.modules.cliente.dto.ClienteResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteRepository repository;

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody @Valid ClienteRequestDTO dto) {
        if (repository.existsByCpf(dto.cpf())) {
            return ResponseEntity.badRequest().body("CPF já registado na base de dados.");
        }

        Cliente cliente = Cliente.builder()
                .nome(dto.nome())
                .cpf(dto.cpf())
                .telefone(dto.telefone())
                .email(dto.email())
                .build();
        
        Cliente salvo = repository.save(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(ClienteResponseDTO.fromEntity(salvo));
    }

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarTodos() {
        List<ClienteResponseDTO> clientes = repository.findAll().stream()
                .map(ClienteResponseDTO::fromEntity)
                .toList();
        return ResponseEntity.ok(clientes);
    }
}