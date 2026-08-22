package com.ejemplo.servicio.impl;

import java.util.LinkedList;
import java.util.Scanner;

import com.ejemplo.modelo.Destinos;
import com.ejemplo.servicio.DestinosServicios;

public class DestinosServiciosImpl implements DestinosServicios {

    @Override
    public Destinos registrarDestino() {

        Destinos destino = new Destinos();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el nombre del destino: ");
        String nombre = scanner.nextLine();

        System.out.print("Ingrese tipo de destino: ");
        String tipo = scanner.nextLine();

        System.out.print("Ingrese la cantidad de pasajeros: ");
        int cantidadPasajeros = scanner.nextInt();

        System.out.println("¿El destino está disponible? (true/false): ");
        boolean disponible = scanner.nextBoolean();

        destino.setNombre(nombre);
        destino.setTipo(tipo);
        destino.setPasajeros(cantidadPasajeros);
        destino.setDisponible(disponible);
        return destino; // Retorna el destino registrado
    }

    @Override
    public void mostrarDestinos(LinkedList<Destinos> listaDestinos) {
        if (listaDestinos.isEmpty()) {
            System.out.println("No hay destinos registrados.");
        } else {
            System.out.println("Lista de Destinos:");
            for (Destinos destino : listaDestinos) {
                System.out.println(destino.toString());
            }
        }
    }

    @Override
    public void agregarDestino(Destinos destino, LinkedList<Destinos> listaDestinos) {
        listaDestinos.add(destino);
        System.out.println("Destino agregado exitosamente.");
    }

}
