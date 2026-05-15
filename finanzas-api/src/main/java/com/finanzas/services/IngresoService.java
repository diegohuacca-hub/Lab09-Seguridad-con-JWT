package com.finanzas.services;

import com.finanzas.models.Ingreso;
import com.finanzas.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class IngresoService {

    private final IngresoRepository repo;
    private final ConsumidorRepository consumidorRepo;

    public List<Ingreso> listar() {
        return repo.findAll();
    }

    public Ingreso obtener(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<Ingreso> porConsumidor(Long cId) {
        return repo.findByConsumidorId(cId);
    }

    public List<Ingreso> porEstado(String estado) {
        return repo.findByEstado(estado);
    }

    public Ingreso guardar(Long consumidorId, Ingreso i) {
        i.setConsumidor(consumidorRepo.findById(consumidorId).orElseThrow());
        return repo.save(i);
    }

    public Ingreso actualizar(Long id, Long consumidorId, Ingreso i) {
        i.setId(id);
        i.setConsumidor(consumidorRepo.findById(consumidorId).orElseThrow());
        return repo.save(i);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}