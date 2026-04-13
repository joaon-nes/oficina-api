package com.oficina.backend.modules.cliente;

import com.oficina.backend.modules.cliente.dto.ClienteRequestDTO;
import com.oficina.backend.modules.cliente.dto.ClienteResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PreAuthorize("hasAnyRole('ADMIN', 'MECANICO')")
    @PostMapping
    public ResponseEntity<ClienteResponseDTO> criar(@RequestBody @Valid ClienteRequestDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MECANICO')")
    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }
}