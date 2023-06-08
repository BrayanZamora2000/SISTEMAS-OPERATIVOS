package com.proyectoanalisis.AnalisisPro.Interfaces;

import com.proyectoanalisis.AnalisisPro.Modelos.ModelCliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceCliente extends JpaRepository<ModelCliente, Integer> {
}
