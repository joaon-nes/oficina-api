package com.oficina.backend.modules.peca;

import com.oficina.backend.modules.peca.dto.PecaDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/pecas")
@RequiredArgsConstructor
public class PecaController {

    private final PecaService service;

    @PostMapping
    public ResponseEntity<PecaDTO> cadastrar(@RequestBody @Valid PecaDTO dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<PecaDTO>> listarTodas() {
        return ResponseEntity.ok(service.listarTodas());
    }
}