package com.oficina.backend.modules.veiculo;

import com.oficina.backend.modules.cliente.Cliente;
import com.oficina.backend.modules.cliente.ClienteRepository;
import com.oficina.backend.modules.veiculo.dto.VeiculoRequestDTO;
import com.oficina.backend.modules.veiculo.dto.VeiculoResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VeiculoService {

    private final VeiculoRepository veiculoRepository;
    private final ClienteRepository clienteRepository;

    public VeiculoResponseDTO cadastrar(VeiculoRequestDTO dto) {
        if (veiculoRepository.existsByPlaca(dto.placa())) {
            throw new RuntimeException("Placa já registada no sistema.");
        }

        Cliente cliente = clienteRepository.findById(dto.clienteId())
                .orElseThrow(() -> new RuntimeException("Cliente não encontrado."));

        Veiculo veiculo = Veiculo.builder()
                .placa(dto.placa())
                .marca(dto.marca())
                .modelo(dto.modelo())
                .ano(dto.ano())
                .cliente(cliente)
                .build();

        return VeiculoResponseDTO.fromEntity(veiculoRepository.save(veiculo));
    }

    public List<VeiculoResponseDTO> listarTodos() {
        return veiculoRepository.findAll().stream()
                .map(VeiculoResponseDTO::fromEntity)
                .toList();
    }
}