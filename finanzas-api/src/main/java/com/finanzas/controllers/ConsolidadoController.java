package com.finanzas.controllers;

import com.finanzas.services.ConsolidadoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/consolidado")
@RequiredArgsConstructor
public class ConsolidadoController {

    private final ConsolidadoService service;

    @GetMapping
    public Map<String, Object> consolidado() {
        return service.consolidado();
    }
}