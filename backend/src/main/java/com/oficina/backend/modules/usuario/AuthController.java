package com.oficina.backend.modules.usuario;

import com.oficina.backend.modules.usuario.dto.LoginRequestDTO;
import com.oficina.backend.modules.usuario.dto.RegisterRequestDTO;
import com.oficina.backend.modules.usuario.dto.TokenResponseDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService service;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/register")
    public ResponseEntity<TokenResponseDTO> registrar(@RequestBody @Valid RegisterRequestDTO request) {
        return ResponseEntity.ok(service.registrar(request));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResponseDTO> autenticar(@RequestBody @Valid LoginRequestDTO request) {
        return ResponseEntity.ok(service.autenticar(request));
    }
}