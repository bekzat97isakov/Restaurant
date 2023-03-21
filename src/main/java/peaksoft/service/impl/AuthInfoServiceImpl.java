package peaksoft.service.impl;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.config.jwtConfig.JwtUtil;
import peaksoft.dto.request.AuthRequest;
import peaksoft.dto.response.AuthResponse;
import peaksoft.entity.AuthInfo;
import peaksoft.entity.enums.Role;
import peaksoft.repository.AuthInfoRepository;
import peaksoft.service.AuthService;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AuthInfoServiceImpl implements AuthService {
    private final AuthInfoRepository authInfoRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authRequest.email(),
                        authRequest.password()
                )
        );
        AuthInfo authInfo = authInfoRepository.findByEmail(authRequest.email())
                .orElseThrow(()->new NoSuchElementException(
                        String.format("User with email: %s doesn't exists",authRequest.email())));
        String token = jwtUtil.generationToken(authInfo);
        return AuthResponse.builder()
                .token(token)
                .email(authInfo.getEmail())
                .build();
    }
    @PostConstruct
    public void init(){
        AuthInfo authInfo = new AuthInfo();
        authInfo.setEmail("admin@gmail.com");
        authInfo.setPassword(passwordEncoder.encode("admin"));
        authInfo.setRole(Role.Admin);
        authInfoRepository.save(authInfo);
    }
}
