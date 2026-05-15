package com.finanzas.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "ingresos")
public class Ingreso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consumidor_id")
    private Consumidor consumidor;

    @NotNull
    @Positive
    private BigDecimal monto;

    @NotNull
    private LocalDate fecha;

    private String categoria; // venta_directa | servicios | suscripciones
    private String estado; // cobrado | pendiente
}