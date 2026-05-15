package com.finanzas.controllers;

import com.finanzas.models.Consumidor;
import com.finanzas.services.ConsumidorService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/consumidores")
@RequiredArgsConstructor
public class ConsumidorController {

    private final ConsumidorService service;

    @GetMapping
    public List<Consumidor> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Consumidor obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Consumidor crear(@Valid @RequestBody Consumidor c) {
        return service.guardar(c);
    }

    @PutMapping("/{id}")
    public Consumidor actualizar(@PathVariable Long id,
            @Valid @RequestBody Consumidor c) {
        return service.actualizar(id, c);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}