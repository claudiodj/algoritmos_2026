package com.ejemplo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Se crea una lista para almacenar los clientes registrados
        LinkedList<Clientes> listaClientes = new LinkedList<>();

        // Se crea una lista para almacenar los destinos registrados
        LinkedList<Destinos> listaDestinos = new LinkedList<>();

        int opcion;

        do {
            Scanner scanner = new Scanner(System.in);

            // Mostrar el menú de opciones al usuario
            mostrarMenu();

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            // Procesar la opción seleccionada por el usuario
            switch (opcion) {
                case 1:
                    Clientes cli = registrarCliente(); // Lógica para registrar un cliente
                    listaClientes.add(cli);
                    break;
                case 2:
                    mostrarClientes(listaClientes); // Lógica para mostrar clientes
                    break;
                case 3:
                    Destinos dest = registrarDestino(); // Lógica para registrar un destino
                    listaDestinos.add(dest);
                    break;
                case 4:
                    mostrarDestinos(listaDestinos); // Lógica para mostrar destinos
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    }

    public static Clientes registrarCliente() {

        final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        Scanner scanner = new Scanner(System.in);

        Clientes cliente = new Clientes();
        System.out.println("Ingrese el nombre del cliente:");
        String dato = scanner.nextLine();
        cliente.setNombre(dato);

        System.out.println("Ingrese el apellido del cliente:");
        dato = scanner.nextLine();
        cliente.setApellido(dato);

        System.out.println("Ingrese el email del cliente:");
        dato = scanner.nextLine();
        cliente.setEmail(dato);

        System.out.println("Ingrese el teléfono del cliente:");
        dato = scanner.nextLine();
        cliente.setTelefono(dato);

        System.out.println("Ingrese el DNI del cliente:");
        int dni = scanner.nextInt();
        cliente.setDni(dni);

        scanner.nextLine(); // Consumir el salto de línea pendiente después de leer el DNI

        LocalDate fechaNac = null;

        while (fechaNac == null) {
            try {
                System.out.print("Ingrese fecha de nacimiento (dd/MM/yyyy): ");
                String fechaStr = scanner.nextLine();
                fechaNac = LocalDate.parse(fechaStr, FORMATTER);

                // Validación adicional
                if (fechaNac.isAfter(LocalDate.now())) {
                    System.out.println("Fecha futura no permitida");
                    fechaNac = null;
                }
            } catch (DateTimeParseException e) {
                System.out.println("Formato incorrecto. Use dd/MM/yyyy");
            }
        }

        cliente.setFechaNacimiento(fechaNac);

        System.out.println("Edad del cliente: " + cliente.getEdad());

        System.out.println("Datos del cliente: " + cliente.toString());
        // scanner.close();
        return cliente;
    }

    public static void mostrarClientes(LinkedList<Clientes> listaClientes) {
        System.out.println("Lista de clientes registrados:");

        for (Clientes clientes : listaClientes) {
            System.out.println(clientes.toString());
        }
    }

    public static Destinos registrarDestino() {
        Scanner scanner = new Scanner(System.in);

        Destinos destino = new Destinos();
        System.out.println("Ingrese el nombre del destino:");
        String dato = scanner.nextLine();
        destino.setNombre(dato);

        System.out.println("Ingrese el tipo de destino:");
        dato = scanner.nextLine();
        destino.setTipo(dato);

        System.out.println("Ingrese la cantidad de pasajeros:");
        int pasajeros = scanner.nextInt();
        destino.setPasajeros(pasajeros);

        System.out.println("¿El destino está disponible? (true/false):");
        boolean disponible = scanner.nextBoolean();
        destino.setDisponible(disponible);

        System.out.println("Datos del destino: " + destino.toString());
        // scanner.close();
        return destino;
    }

    public static void mostrarDestinos(LinkedList<Destinos> listaDestinos) {
        System.out.println("Lista de destinos registrados:");

        for (Destinos destino : listaDestinos) {
            System.out.println(destino.toString());
        }
    }

    public static void mostrarMenu() {
        System.out.println("Menú Sistema de Turismo");
        System.out.println("-------------------------");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Mostrar clientes");
        System.out.println("3. Registrar destino");
        System.out.println("4. Mostrar destinos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }

}
