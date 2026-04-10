package com.oficina.backend.modules.cliente;

import com.oficina.backend.modules.cliente.dto.ClienteRequestDTO;
import com.oficina.backend.modules.cliente.dto.ClienteResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository repository;

    public ClienteResponseDTO criar(ClienteRequestDTO dto) {
        if (repository.existsByCpf(dto.cpf())) {
            throw new RuntimeException("CPF já registado na base de dados.");
        }
        Cliente cliente = Cliente.builder()
                .nome(dto.nome())
                .cpf(dto.cpf())
                .telefone(dto.telefone())
                .email(dto.email())
                .build();

        return ClienteResponseDTO.fromEntity(repository.save(cliente));
    }

    public List<ClienteResponseDTO> listarTodos() {
        return repository.findAll().stream().map(ClienteResponseDTO::fromEntity).toList();
    }
}