package com.ejemplo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Clientes cliente1 = new Clientes("Juan", "Pérez", "juan.perez@example.com", "123456789", 12345678);

        System.out.println("dato del cliente " + cliente1.toString());
        Destinos destino1 = new Destinos();
        destino1.setNombre("Playa del Carmen");
        System.out.println(destino1.getNombre());
        destino1.setPasajeros(100);
        /*
        destino1.nombre = "Cancún";
        Al ser el atributo nombre privado, no se puede acceder directamente desde la clase Main, 
        por lo que se debe utilizar el método setNombre para asignar un valor al atributo nombre del objeto destino1.
        */
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

        scanner.close();
    }
}