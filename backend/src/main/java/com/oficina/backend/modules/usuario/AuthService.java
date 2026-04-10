package com.oficina.backend.modules.usuario;

import com.oficina.backend.core.security.JwtService;
import com.oficina.backend.modules.usuario.dto.LoginRequestDTO;
import com.oficina.backend.modules.usuario.dto.RegisterRequestDTO;
import com.oficina.backend.modules.usuario.dto.TokenResponseDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UsuarioRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public TokenResponseDTO registrar(RegisterRequestDTO request) {
        if (repository.findByEmail(request.email()).isPresent()) {
            throw new RuntimeException("Email já cadastrado");
        }

        var usuario = Usuario.builder()
                .nome(request.nome())
                .email(request.email())
                .senha(passwordEncoder.encode(request.senha()))
                .role(Usuario.Role.valueOf(request.role().toUpperCase()))
                .build();

        repository.save(usuario);
        var jwtToken = jwtService.generateToken(usuario);
        return new TokenResponseDTO(jwtToken);
    }

    public TokenResponseDTO autenticar(LoginRequestDTO request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.email(),
                        request.senha()));
        var usuario = repository.findByEmail(request.email()).orElseThrow();
        var jwtToken = jwtService.generateToken(usuario);
        return new TokenResponseDTO(jwtToken);
    }
}