package com.oficina.backend.modules.usuario.dto;

import jakarta.validation.constraints.NotBlank;

public record RegisterRequestDTO(
    @NotBlank String nome,
    @NotBlank String email,
    @NotBlank String senha,
    @NotBlank String role
) {}