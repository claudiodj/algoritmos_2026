package com.ejemplo.modelo;

import java.time.LocalDate;

public class Reservas {

    private Clientes cliente;
    private Destinos destino;
    private LocalDate fechaViaje;
    private LocalDate fechaReserva;
    private int numeroReserva;
    private int precio;
    private boolean pagada;

    public Reservas() {
    }

    public Reservas(Clientes cliente, Destinos destino, LocalDate fechaViaje, LocalDate fechaReserva, int numeroReserva,
            int precio, boolean pagada) {
        this.cliente = cliente;
        this.destino = destino;
        this.fechaViaje = fechaViaje;
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

    public LocalDate getFechaViaje() {
        return fechaViaje;
    }

    public void setFechaViaje(LocalDate fechaViaje) {
        this.fechaViaje = fechaViaje;
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
        return "Reservas [cliente=" + cliente + ", destino=" + destino + ", fechaViaje=" + fechaViaje
                + ", fechaReserva=" + fechaReserva + ", numeroReserva=" + numeroReserva + ", precio=" + precio
                + ", pagada=" + pagada + "]";
    }

    
}
