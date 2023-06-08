package com.proyectoanalisis.AnalisisPro.Interfaces;

import com.proyectoanalisis.AnalisisPro.Modelos.ModelUsuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InterfaceUsuario extends JpaRepository<ModelUsuario, Integer> {

    Optional<ModelUsuario> findByNombreUsuarioAndContraseña(String nombreUsuario, String contraseña);
}
