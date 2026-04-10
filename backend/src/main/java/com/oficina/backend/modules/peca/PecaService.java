package com.oficina.backend.modules.peca;

import com.oficina.backend.modules.peca.dto.PecaDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PecaService {

    private final PecaRepository repository;

    public PecaDTO cadastrar(PecaDTO dto) {
        Peca peca = Peca.builder()
                .nome(dto.nome())
                .codigoOriginal(dto.codigoOriginal())
                .preco(dto.preco())
                .quantidadeEstoque(dto.quantidadeEstoque())
                .build();
        return PecaDTO.fromEntity(repository.save(peca));
    }

    public List<PecaDTO> listarTodas() {
        return repository.findAll().stream().map(PecaDTO::fromEntity).toList();
    }
}