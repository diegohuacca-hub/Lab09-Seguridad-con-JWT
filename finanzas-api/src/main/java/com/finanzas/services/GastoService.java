package com.finanzas.services;

import com.finanzas.models.Gasto;
import com.finanzas.repositories.GastoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class GastoService {

    private final GastoRepository repo;

    public List<Gasto> listar() {
        return repo.findAll();
    }

    public Gasto obtener(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public Gasto guardar(Gasto g) {
        return repo.save(g);
    }

    public Gasto actualizar(Long id, Gasto g) {
        g.setId(id);
        return repo.save(g);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}