package com.oficina.backend.modules.veiculo.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record VeiculoRequestDTO(
        @NotBlank(message = "A placa é obrigatória") String placa,
        @NotBlank(message = "A marca é obrigatória") String marca,
        @NotBlank(message = "O modelo é obrigatório") String modelo,
        @NotNull(message = "O ano é obrigatório") Integer ano,
        @NotNull(message = "O ID do cliente é obrigatório") Long clienteId) {
}