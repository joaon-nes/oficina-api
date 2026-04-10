package com.oficina.backend.modules.peca.dto;

import com.oficina.backend.modules.peca.Peca;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.math.BigDecimal;

public record PecaDTO(Long id, @NotBlank String nome, @NotBlank String codigoOriginal, @NotNull BigDecimal preco,
        @NotNull Integer quantidadeEstoque) {
    public static PecaDTO fromEntity(Peca peca) {
        return new PecaDTO(peca.getId(), peca.getNome(), peca.getCodigoOriginal(), peca.getPreco(),
                peca.getQuantidadeEstoque());
    }
}