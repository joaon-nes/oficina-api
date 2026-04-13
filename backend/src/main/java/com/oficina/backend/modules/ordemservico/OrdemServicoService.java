package com.oficina.backend.modules.ordemservico;

import com.oficina.backend.core.exceptions.RecursoNaoEncontradoException;
import com.oficina.backend.core.exceptions.RegraNegocioException;
import com.oficina.backend.modules.cliente.Cliente;
import com.oficina.backend.modules.cliente.ClienteRepository;
import com.oficina.backend.modules.ordemservico.dto.OsRequestDTO;
import com.oficina.backend.modules.ordemservico.dto.OsResponseDTO;
import com.oficina.backend.modules.veiculo.Veiculo;
import com.oficina.backend.modules.veiculo.VeiculoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class OrdemServicoService {

    private final OrdemServicoRepository osRepository;
    private final ClienteRepository clienteRepository;
    private final VeiculoRepository veiculoRepository;

    public OsResponseDTO abrirOS(OsRequestDTO dto) {
        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Cliente não encontrado."));

        Veiculo veiculo = veiculoRepository.findById(dto.veiculoId())
                .orElseThrow(() -> new RecursoNaoEncontradoException("Veículo não encontrado."));

        if (!veiculo.getCliente().getId().equals(cliente.getId())) {
            throw new RegraNegocioException("O veículo informado não pertence a este cliente.");
        }

        OrdemServico os = OrdemServico.builder()
                .cliente(cliente)
                .veiculo(veiculo)
                .descricaoProblema(dto.descricaoProblema())
                .build();

        return OsResponseDTO.fromEntity(osRepository.save(os));
    }

    public List<OsResponseDTO> listarTodas() {
        return osRepository.findAll().stream().map(OsResponseDTO::fromEntity).toList();
    }
}