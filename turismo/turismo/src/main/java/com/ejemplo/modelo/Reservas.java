package com.ejemplo.modelo;

import java.io.Serializable;
import java.time.LocalDate;

public class Reservas implements Serializable {

    private Clientes cliente;
    private Destinos destino;
    private LocalDate fechaReserva;
    private int numeroReserva;
    private int precio;
    private boolean pagada;

    public Reservas() {
    }

    public Reservas(Clientes cliente, Destinos destino, LocalDate fechaReserva, int numeroReserva,
            int precio, boolean pagada) {
        this.cliente = cliente;
        this.destino = destino;
        this.fechaReserva = fechaReserva;
        this.numeroReserva = numeroReserva;
        this.precio = precio;
        this.pagada = pagada;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public Destinos getDestino() {
        return destino;
    }

    public void setDestino(Destinos destino) {
        this.destino = destino;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {
        this.fechaReserva = fechaReserva;
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int numeroReserva) {
        this.numeroReserva = numeroReserva;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public boolean isPagada() {
        return pagada;
    }

    public void setPagada(boolean pagada) {
        this.pagada = pagada;
    }

    @Override
    public String toString() {
        return "Reservas [cliente=" + cliente + ", destino=" + destino + ", fechaReserva=" + fechaReserva + ", numeroReserva=" + numeroReserva + ", precio=" + precio
                + ", pagada=" + pagada + "]";
    }

    
}
