package com.ejemplo;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            
        final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        
        Clientes cliente1 = new Clientes("Juan", "Pérez", "juan.perez@example.com", "123456789", 12345678, LocalDate.of(1989, 8, 8));

        System.out.println("dato del cliente " + cliente1.toString());
        
        /*
        Destinos destino1 = new Destinos();
        destino1.setNombre("Playa del Carmen");
        System.out.println(destino1.getNombre());
        destino1.setPasajeros(100);
        
        destino1.nombre = "Cancún";
        Al ser el atributo nombre privado, no se puede acceder directamente desde la clase Main, 
        por lo que se debe utilizar el método setNombre para asignar un valor al atributo nombre del objeto destino1.
        
        destino1.setNombre("Miami");


        System.out.println(destino1.getNombre());

        System.out.println("Alta de destinos");
        Destinos destino2 = new Destinos();
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el nombre del destino:");
        String dato = scanner.nextLine();
        destino2.setNombre(dato);

        System.out.println("Ingrese el tipo de destino:");
        dato = scanner.nextLine();
        destino2.setTipo(dato);

        // Aquí se instancia un nuevo objeto Destinos con todos los parametros necesarios para su creación, 
        // utilizando el constructor que se ha definido en la clase Destinos.
        Destinos destino3 = new Destinos("Cancún", "Playa", 200, true);
        
        System.out.println("Destino registrado: " + destino2.getNombre());
        */
        Scanner scanner = new Scanner(System.in);
        Clientes cliente2 = new Clientes();
        
        System.out.println("Ingrese el nombre del cliente:");
        String dato = scanner.nextLine();
        cliente2.setNombre(dato);

        System.out.println("Ingrese el apellido del cliente:");
        dato = scanner.nextLine();
        cliente2.setApellido(dato);

        System.out.println("Ingrese el email del cliente:");
        dato = scanner.nextLine();
        cliente2.setEmail(dato);

        System.out.println("Ingrese el teléfono del cliente:");
        dato = scanner.nextLine();
        cliente2.setTelefono(dato);
        
        System.out.println("Ingrese el DNI del cliente:");
        int dni = scanner.nextInt();
        cliente2.setDni(dni);

        scanner.nextLine(); // Consumir el salto de línea pendiente después de leer el DNI
        
        LocalDate fechaNac = null;
        System.out.print("Ingrese fecha de nacimiento (dd/MM/yyyy): ");
                String fechaStr = scanner.nextLine();
                fechaNac = LocalDate.parse(fechaStr, FORMATTER);
        cliente2.setFechaNacimiento(fechaNac);
        
        System.out.println("Edad del cliente: " + cliente2.getEdad());

        System.out.println("Datos del cliente: " + cliente2.toString());

        scanner.close();
    }
}