package com.oficina.backend.core.config;

import com.oficina.backend.modules.usuario.Usuario;
import com.oficina.backend.modules.usuario.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class AdminSetupConfig {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    @Bean
    public CommandLineRunner initDefaultAdmin() {
        return args -> {
            if (usuarioRepository.count() == 0) {
                Usuario admin = Usuario.builder()
                        .nome("Administrador Principal")
                        .email("admin@oficina.com")
                        .senha(passwordEncoder.encode("admin123"))
                        .role(Usuario.Role.ADMIN)
                        .build();
                
                usuarioRepository.save(admin);
                System.out.println("Usuário ADMIN padrão criado com sucesso!");
            }
        };
    }
}