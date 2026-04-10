package com.oficina.backend.modules.ordemservico.dto;

import com.oficina.backend.modules.ordemservico.OrdemServico;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public record OsResponseDTO(Long id, String nomeCliente, String placaVeiculo, String descricaoProblema, String status,
        BigDecimal valorTotal, LocalDateTime dataAbertura) {
    public static OsResponseDTO fromEntity(OrdemServico os) {
        return new OsResponseDTO(os.getId(), os.getCliente().getNome(), os.getVeiculo().getPlaca(),
                os.getDescricaoProblema(), os.getStatus().name(), os.getValorTotal(), os.getDataAbertura());
    }
}