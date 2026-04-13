package com.oficina.backend.modules.peca.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;

public record EstoqueDTO(
    @NotNull
    Long pecaId, 
    
    @NotNull
    @Min(0)
    Integer quantidadeEstoque
) {}