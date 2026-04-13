package com.oficina.backend.modules.usuario.dto;

import com.oficina.backend.modules.usuario.Usuario.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record RegisterRequestDTO(
        @NotBlank(message = "O nome não pode estar em branco") 
        String nome,
        
        @NotBlank(message = "O email é obrigatório") 
        @Email(message = "Formato de email inválido") 
        String email,
        
        @NotBlank(message = "A senha é obrigatória") 
        @Size(min = 6, message = "A senha deve ter no mínimo 6 caracteres") 
        String senha,
        
        @NotNull(message = "O cargo é obrigatório") 
        Role role
) {}