package com.proyectoanalisis.AnalisisPro.Modelos;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_reserva")
public class ModelReserva {
    @Id
    @Column(name = "id_reserva")
    private int idReserva;

    @Column(name = "id_cliente")
    private int idCliente;

    @Column(name = "num_reserva")
    private String numReserva;

    @Column(name = "num_vuelo")
    private String numVuelo;

    @Column(name = "num_salida")
    private String numSalida;

    @Column(name = "destino")
    private String destino;

    @Column(name = "hora_salida")
    private Date horaSalida;

    @Column(name = "hora_llegada")
    private Date horaLlegada;

    @Column(name = "fecha_salida")
    private Date fechaSalida;

    @Column(name = "fecha_llegada")
    private Date fechaLlegada;


    // Getters y Setters

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

    public String getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(String numReserva) {
        this.numReserva = numReserva;
    }

    public String getNumVuelo() {
        return numVuelo;
    }

    public void setNumVuelo(String numVuelo) {
        this.numVuelo = numVuelo;
    }

    public String getNumSalida() {
        return numSalida;
    }

    public void setNumSalida(String numSalida) {
        this.numSalida = numSalida;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }

    public Date getHoraLlegada() {
        return horaLlegada;
    }

    public void setHoraLlegada(Date horaLlegada) {
        this.horaLlegada = horaLlegada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }
}
