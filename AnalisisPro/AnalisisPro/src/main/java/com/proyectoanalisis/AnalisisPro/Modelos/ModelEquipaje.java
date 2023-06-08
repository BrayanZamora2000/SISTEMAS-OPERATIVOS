package com.proyectoanalisis.AnalisisPro.Modelos;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_equipaje")
public class ModelEquipaje {
    @Id
    @Column(name = "id_equipaje")
    private int idEquipaje;

    @Column(name = "id_vuelo")
    private int idVuelo;

    @Column(name = "id_reserva")
    private int idReserva;

    @Column(name = "id_cliente")
    private int idCliente;

    @Column(name = "no_equipaje")
    private String noEquipaje;

    @Column(name = "peso_equipaje")
    private int pesoEquipaje;

    @Column(name = "validacion")
    private String validacion;

    @Column(name = "hora_reserva")
    private Date horaReserva;


    // Getters y Setters

    public int getIdEquipaje() {
        return idEquipaje;
    }

    public void setIdEquipaje(int idEquipaje) {
        this.idEquipaje = idEquipaje;
    }

    public int getIdVuelo() {
        return idVuelo;
    }

    public void setIdVuelo(int idVuelo) {
        this.idVuelo = idVuelo;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNoEquipaje() {
        return noEquipaje;
    }

    public void setNoEquipaje(String noEquipaje) {
        this.noEquipaje = noEquipaje;
    }

    public int getPesoEquipaje() {
        return pesoEquipaje;
    }

    public void setPesoEquipaje(int pesoEquipaje) {
        this.pesoEquipaje = pesoEquipaje;
    }

    public String getValidacion() {
        return validacion;
    }

    public void setValidacion(String validacion) {
        this.validacion = validacion;
    }

    public Date getHoraReserva() {
        return horaReserva;
    }

    public void setHoraReserva(Date horaReserva) {
        this.horaReserva = horaReserva;
    }
}

