package com.finanzas.services;

import com.finanzas.securities.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.Service;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthenticationManager authManager;
    private final UserDetailsService uds;
    private final JwtUtil jwtUtil;

    public Map<String, String> login(String username, String password) {
        authManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        String token = jwtUtil.generate(uds.loadUserByUsername(username));

        return Map.of(
                "token", token,
                "tipo", "Bearer",
                "usuario", username);
    }
}