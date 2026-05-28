package com.dsi3.API.repository;

import com.dsi3.API.model.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long> {
    
    List<Producto> findByDisponible(Boolean disponible);
    List<Producto> findByCategoriaAndDisponible(String categoria, Boolean disponible);
}