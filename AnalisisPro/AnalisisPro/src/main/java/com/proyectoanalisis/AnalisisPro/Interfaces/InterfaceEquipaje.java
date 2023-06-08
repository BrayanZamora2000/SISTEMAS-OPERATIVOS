package com.proyectoanalisis.AnalisisPro.Interfaces;

import com.proyectoanalisis.AnalisisPro.Modelos.ModelEquipaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterfaceEquipaje extends JpaRepository<ModelEquipaje, Integer> {
}
