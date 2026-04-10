package com.oficina.backend.modules.veiculo;

import com.oficina.backend.modules.veiculo.dto.VeiculoRequestDTO;
import com.oficina.backend.modules.veiculo.dto.VeiculoResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/veiculos")
@RequiredArgsConstructor
public class VeiculoController {

    private final VeiculoService veiculoService;

    @PostMapping
    public ResponseEntity<VeiculoResponseDTO> cadastrar(@RequestBody @Valid VeiculoRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(veiculoService.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<VeiculoResponseDTO>> listarTodos() {
        return ResponseEntity.ok(veiculoService.listarTodos());
    }
}