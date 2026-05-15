package com.finanzas.repositories;

import com.finanzas.models.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.math.BigDecimal;
import java.util.List;

public interface IngresoRepository extends JpaRepository<Ingreso, Long> {
    List<Ingreso> findByConsumidorId(Long consumidorId);

    List<Ingreso> findByEstado(String estado);

    @Query("SELECT COALESCE(SUM(i.monto), 0) FROM Ingreso i")
    BigDecimal sumTotal();
}