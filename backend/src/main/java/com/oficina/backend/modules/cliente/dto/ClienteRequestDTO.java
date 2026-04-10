package com.oficina.backend.modules.cliente.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClienteRequestDTO(
    @NotBlank(message = "O nome é obrigatório") 
    String nome,
    
    @NotBlank(message = "O CPF é obrigatório") 
    @Pattern(regexp = "\\d{11}", message = "O CPF deve conter 11 dígitos")
    String cpf,
    
    @NotBlank(message = "O telefone é obrigatório") 
    String telefone,
    
    String email
) {}