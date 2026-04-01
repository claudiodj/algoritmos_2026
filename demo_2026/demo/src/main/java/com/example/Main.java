package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        Scanner teclado = new Scanner(System.in);
        String[] nombres;
        nombres = new String[5];
        for (int i = 0; i < nombres.length; i++) {
            System.out.println("Dime tu nombre: ");
            nombres[i] = teclado.nextLine();
            System.out.println("Dime tu edad: ");
            int edad = teclado.nextInt();
            if (edad < 60 && edad > 55) {
                System.out.println("Estas proximo a jubilarte  " + nombres[i]);

            } else {
                System.out.println("Aun no estas proximo a jubilarte " + nombres[i]);
            }
            teclado.nextLine(); // Limpiar el buffer después de leer un número
        }
        String teclaPresionada;
        do {
            System.out.println("Presione una tecla para continuar (Sale con Z): ");
            teclaPresionada = teclado.nextLine();
            switch (teclaPresionada) {
                case "A":
                case "a":
                    System.out.println("Has presionado la tecla A");
                    break;
                case "B":
                    System.out.println("Has presionado la tecla B");
                    break;
                case "C":
                    System.out.println("Has presionado la tecla C");
                    break;
                default:
                    System.out.println("Has presionado una tecla no reconocida");
                    break;
            }
        } while (teclaPresionada.equalsIgnoreCase("Z") == false);
    }
}