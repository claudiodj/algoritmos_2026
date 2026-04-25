package com.ejemplo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        /*
         * Destinos destino1 = new Destinos();
         * destino1.setNombre("Playa del Carmen");
         * System.out.println(destino1.getNombre());
         * destino1.setPasajeros(100);
         * 
         * destino1.nombre = "Cancún";
         * Al ser el atributo nombre privado, no se puede acceder directamente desde la
         * clase Main,
         * por lo que se debe utilizar el método setNombre para asignar un valor al
         * atributo nombre del objeto destino1.
         * 
         * destino1.setNombre("Miami");
         * 
         * 
         * System.out.println(destino1.getNombre());
         * 
         * System.out.println("Alta de destinos");
         * Destinos destino2 = new Destinos();
         * 
         * Scanner scanner = new Scanner(System.in);
         * System.out.println("Ingrese el nombre del destino:");
         * String dato = scanner.nextLine();
         * destino2.setNombre(dato);
         * 
         * System.out.println("Ingrese el tipo de destino:");
         * dato = scanner.nextLine();
         * destino2.setTipo(dato);
         * 
         * // Aquí se instancia un nuevo objeto Destinos con todos los parametros
         * necesarios para su creación,
         * // utilizando el constructor que se ha definido en la clase Destinos.
         * Destinos destino3 = new Destinos("Cancún", "Playa", 200, true);
         * 
         * System.out.println("Destino registrado: " + destino2.getNombre());
         */
        Scanner scanner = new Scanner(System.in);

        LinkedList<Clientes> listaClientes = new LinkedList<>();

        do {

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

            listaClientes.add(cliente);

            System.out.println("Desea registrar otro cliente? (s/n) ");
            String respuesta = scanner.nextLine();
            if (!respuesta.equalsIgnoreCase("s")) {
                break;
            }
        } while (true); // Cambia a true para permitir múltiples registros

        System.out.println("Lista de clientes registrados:");

        for (Clientes clientes : listaClientes) {
            System.out.println(clientes.toString());
        }
        scanner.close();

    }
}