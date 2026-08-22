package com.ejemplo.servicio.impl;

import java.util.LinkedList;

import com.ejemplo.modelo.Reservas;
import com.ejemplo.servicio.ReservasServicios;

public class ReservasServiciosImpl implements ReservasServicios {

    @Override
    public void agregarReserva(Reservas reserva, LinkedList<Reservas> listaReservas) {
        listaReservas.add(reserva);
        System.out.println("Reserva agregada exitosamente.");

    }

    @Override
    public void mostrarReservas(LinkedList<Reservas> listaReservas) {
        // Implementación para mostrar las reservas
        if (listaReservas.isEmpty()) {
            System.out.println("No hay reservas registradas.");
            } else {
                System.out.println("Lista de Reservas:");
                for (Reservas reserva : listaReservas) {
                    System.out.println(reserva.toString());
                }
            }
    }

}
    


