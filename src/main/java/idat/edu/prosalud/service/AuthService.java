package idat.edu.prosalud.service;

import idat.edu.prosalud.dto.LoginRequest;
import idat.edu.prosalud.dto.LoginResponse;
import idat.edu.prosalud.dto.RegisterRequest;
import idat.edu.prosalud.entity.Usuario;
import idat.edu.prosalud.repository.UsuarioRepository;
import idat.edu.prosalud.security.JwtService;
import idat.edu.prosalud.security.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authenticationManager;
    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;
    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoder passwordEncoder;

    public LoginResponse login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
        );

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        String token = jwtService.generateToken(userDetails);

        Usuario usuario = usuarioRepository.findByUsername(request.getUsername()).orElseThrow();

        return new LoginResponse(token, usuario.getUsername(), usuario.getRole());
    }

    public LoginResponse register(RegisterRequest request) {
        if (usuarioRepository.existsByUsername(request.getUsername()))
            throw new RuntimeException("El username ya está en uso");
        if (usuarioRepository.existsByEmail(request.getEmail()))
            throw new RuntimeException("El email ya está en uso");

        Usuario usuario = Usuario.builder()
                .username(request.getUsername())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(request.getRole())
                .build();

        usuarioRepository.save(usuario);

        UserDetails userDetails = userDetailsService.loadUserByUsername(usuario.getUsername());
        String token = jwtService.generateToken(userDetails);

        return new LoginResponse(token, usuario.getUsername(), usuario.getRole());
    }
}

