package com.ejemplo.servicio;

import java.util.LinkedList;

import com.ejemplo.modelo.Reservas;

public interface ReservasServicios {

    void mostrarReservas(LinkedList<Reservas> listaReservas);
    void agregarReserva(Reservas reserva, LinkedList<Reservas> listaReservas);

}
