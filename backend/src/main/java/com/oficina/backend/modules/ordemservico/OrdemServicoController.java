package com.oficina.backend.modules.ordemservico;

import com.oficina.backend.modules.ordemservico.dto.OsRequestDTO;
import com.oficina.backend.modules.ordemservico.dto.OsResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/os")
@RequiredArgsConstructor
public class OrdemServicoController {

    private final OrdemServicoService service;

    @PreAuthorize("hasAnyRole('ADMIN', 'MECANICO')")
    @PostMapping
    public ResponseEntity<OsResponseDTO> abrirOS(@RequestBody @Valid OsRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.abrirOS(dto));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MECANICO')")
    @GetMapping
    public ResponseEntity<List<OsResponseDTO>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }
}