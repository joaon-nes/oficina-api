package com.oficina.backend.modules.ordemservico.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record OsRequestDTO(
        @NotNull Long clienteId,
        @NotNull Long veiculoId,
        @NotBlank String descricaoProblema) {
}