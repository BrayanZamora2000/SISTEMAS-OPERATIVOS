package com.proyectoanalisis.AnalisisPro.Modelos;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_vuelo")
public class ModelVuelo {
    @Id
    @Column(name = "id_vuelo")
    private int idVuelo;

    @Column(name = "id_reserva")
    private int idReserva;

    @Column(name = "id_cliente")
    private int idCliente;

    @Column(name = "asiento")
    private String asiento;

    @Column(name = "hora_abordaje")
    private Date horaAbordaje;

    @Column(name = "tiempo_vuelo")
    private int tiempoVuelo;

    @Column(name = "no_ticket")
    private String noTicket;


    // Getters y Setters

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

    public String getAsiento() {
        return asiento;
    }

    public void setAsiento(String asiento) {
        this.asiento = asiento;
    }

    public Date getHoraAbordaje() {
        return horaAbordaje;
    }

    public void setHoraAbordaje(Date horaAbordaje) {
        this.horaAbordaje = horaAbordaje;
    }

    public int getTiempoVuelo() {
        return tiempoVuelo;
    }

    public void setTiempoVuelo(int tiempoVuelo) {
        this.tiempoVuelo = tiempoVuelo;
    }

    public String getNoTicket() {
        return noTicket;
    }

    public void setNoTicket(String noTicket) {
        this.noTicket = noTicket;
    }
}
