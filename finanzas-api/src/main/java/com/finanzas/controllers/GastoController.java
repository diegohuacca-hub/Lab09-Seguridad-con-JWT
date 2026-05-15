package com.finanzas.controllers;

import com.finanzas.models.Gasto;
import com.finanzas.services.GastoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/gastos")
@RequiredArgsConstructor
public class GastoController {

    private final GastoService service;

    @GetMapping
    public List<Gasto> listar() {
        return service.listar();
    }

    @GetMapping("/{id}")
    public Gasto obtener(@PathVariable Long id) {
        return service.obtener(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Gasto crear(@Valid @RequestBody Gasto g) {
        return service.guardar(g);
    }

    @PutMapping("/{id}")
    public Gasto actualizar(@PathVariable Long id,
            @Valid @RequestBody Gasto g) {
        return service.actualizar(id, g);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id) {
        service.eliminar(id);
    }
}