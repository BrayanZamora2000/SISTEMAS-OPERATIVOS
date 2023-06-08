package com.proyectoanalisis.AnalisisPro.Interfaces;



import com.proyectoanalisis.AnalisisPro.Modelos.ModelReserva;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceReserva extends JpaRepository<ModelReserva, Integer> {
}