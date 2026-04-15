package com.ejemplo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        Destinos destino1 = new Destinos();
        destino1.setNombre("Playa del Carmen");
        /*
        destino1.nombre = "Cancún";
        Al ser el atributo nombre privado, no se puede acceder directamente desde la clase Main, 
        por lo que se debe utilizar el método setNombre para asignar un valor al atributo nombre del objeto destino1.
        */
        destino1.setNombre("Miami");


        System.out.println(destino1.getNombre());
    }
}