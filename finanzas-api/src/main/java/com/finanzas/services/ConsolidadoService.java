package com.finanzas.services;

import com.finanzas.repositories.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ConsolidadoService {

    private final IngresoRepository ingresoRepo;
    private final GastoRepository gastoRepo;

    public Map<String, Object> consolidado() {
        BigDecimal ingresos = ingresoRepo.sumTotal();
        BigDecimal gastos = gastoRepo.sumTotal();

        return Map.of(
                "totalIngresos", ingresos,
                "totalGastos", gastos,
                "cajaNeta", ingresos.subtract(gastos));
    }
}
