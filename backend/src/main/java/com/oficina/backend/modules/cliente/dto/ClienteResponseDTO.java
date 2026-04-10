package com.oficina.backend.modules.cliente.dto;

import com.oficina.backend.modules.cliente.Cliente;

public record ClienteResponseDTO(Long id, String nome, String cpf, String telefone, String email) {
    public static ClienteResponseDTO fromEntity(Cliente cliente) {
        return new ClienteResponseDTO(
            cliente.getId(), 
            cliente.getNome(), 
            cliente.getCpf(), 
            cliente.getTelefone(), 
            cliente.getEmail()
        );
    }
}