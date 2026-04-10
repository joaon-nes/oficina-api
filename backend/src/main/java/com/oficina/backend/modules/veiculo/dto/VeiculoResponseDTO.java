package com.oficina.backend.modules.veiculo.dto;

import com.oficina.backend.modules.veiculo.Veiculo;

public record VeiculoResponseDTO(Long id, String placa, String marca, String modelo, Integer ano, String nomeCliente) {
    public static VeiculoResponseDTO fromEntity(Veiculo veiculo) {
        return new VeiculoResponseDTO(
                veiculo.getId(),
                veiculo.getPlaca(),
                veiculo.getMarca(),
                veiculo.getModelo(),
                veiculo.getAno(),
                veiculo.getCliente().getNome());
    }
}