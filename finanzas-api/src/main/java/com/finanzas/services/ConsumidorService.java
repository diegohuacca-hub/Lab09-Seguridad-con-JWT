package com.finanzas.services;

import com.finanzas.models.Consumidor;
import com.finanzas.repositories.ConsumidorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ConsumidorService {

    private final ConsumidorRepository repo;

    public List<Consumidor> listar() {
        return repo.findAll();
    }

    public Consumidor obtener(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Consumidor guardar(Consumidor c) {
        return repo.save(c);
    }

    public Consumidor actualizar(Long id, Consumidor c) {
        c.setId(id);
        return repo.save(c);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}