package com.dsi3.API.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.dsi3.API.model.entity.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {

}