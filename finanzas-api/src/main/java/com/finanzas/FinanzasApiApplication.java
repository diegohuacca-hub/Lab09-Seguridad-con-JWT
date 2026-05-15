package com.finanzas;

import com.finanzas.models.Usuario;
import com.finanzas.repositories.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class FinanzasApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(FinanzasApiApplication.class, args);
    }

    @Bean
    CommandLineRunner seed(UsuarioRepository repo, PasswordEncoder encoder) {
        return args -> {
            if (repo.findByUsername("admin").isEmpty()) {
                Usuario u = new Usuario();
                u.setUsername("admin");
                u.setPassword(encoder.encode("admin123"));
                u.setRol("ADMIN");
                repo.save(u);
                System.out.println("=== Usuario creado: admin / admin123 ===");
            }
        };
    }
}