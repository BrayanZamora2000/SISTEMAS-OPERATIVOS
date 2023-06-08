package com.proyectoanalisis.AnalisisPro.Interfaces;

import com.proyectoanalisis.AnalisisPro.Modelos.ModelPersona;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
@Transactional
public interface InterfacePersona extends JpaRepository<ModelPersona, Integer> {
    Optional<ModelPersona> findByIdIdentificacion(Integer idIdentificacion);
}
