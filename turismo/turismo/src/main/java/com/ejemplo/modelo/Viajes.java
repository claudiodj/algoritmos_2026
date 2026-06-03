package com.ejemplo.modelo;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Viajes implements Serializable {

    private Destinos destino; 
    private ArrayList<Clientes> clientes; 
    private LocalDate fechaViaje;
    private LocalDate fechaRegreso;

    public Viajes() {
    }

    public Destinos getDestino() {
        return destino;
    }

    public void setDestino(Destinos destino) {
        this.destino = destino;
    }

    public ArrayList<Clientes> getClientes() {
        return clientes;
    }

    public void setClientes(ArrayList<Clientes> clientes) {
        this.clientes = clientes;
    }

    public LocalDate getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(LocalDate fechaViaje) {
        this.fechaViaje = fechaViaje;
    }

    public LocalDate getFechaRegreso() {
        return fechaRegreso;
    }

    public void setFechaRegreso(LocalDate fechaRegreso) {
        this.fechaRegreso = fechaRegreso;
    }

    @Override
    public String toString() {
        return "Viajes [destino=" + destino + ", clientes=" + clientes + ", fechaViaje=" + fechaViaje
                + ", fechaRegreso=" + fechaRegreso + "]";
    }



}
