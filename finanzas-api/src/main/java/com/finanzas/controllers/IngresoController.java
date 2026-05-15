package com.finanzas.controllers;

import com.finanzas.models.Ingreso;
import com.finanzas.services.IngresoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/ingresos")
@RequiredArgsConstructor
public class IngresoController {

    private final IngresoService service;

    @GetMapping
    public List<Ingreso> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Ingreso obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @GetMapping("/consumidor/{cId}")
    public List<Ingreso> porConsumidor(@PathVariable Long cId) {
        return service.porConsumidor(cId);
    }

    @GetMapping("/estado/{estado}")
    public List<Ingreso> porEstado(@PathVariable String estado) {
        return service.porEstado(estado);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Ingreso crear(@RequestParam Long consumidorId,
            @Valid @RequestBody Ingreso i) {
        return service.guardar(consumidorId, i);
    }

    @PutMapping("/{id}")
    public Ingreso actualizar(@PathVariable Long id,
            @RequestParam Long consumidorId,
            @Valid @RequestBody Ingreso i) {
        return service.actualizar(id, consumidorId, i);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}