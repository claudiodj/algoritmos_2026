package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hola! Este es un ejemplo de un programa en Java que utiliza un bucle for y un bucle do-while.");
        Scanner teclado = new Scanner(System.in);
        Object[][] personas = new Object[5][3];
        for (int i = 0; i < personas.length; i++) {
            System.out.println("Dime tu nombre: ");
            do{
                personas[i][0] = teclado.nextLine(); // Aqui guardare el nombre en la primera columna del arreglo
                if (personas[i][0].toString().isEmpty()) {
                    System.out.println("El nombre no puede estar vacío. Por favor, ingresa un nombre válido.");
                }
            } while (personas[i][0].toString().isEmpty());
            System.out.println("Dime tu apellido: ");
            do{
                personas[i][1] = teclado.nextLine(); // Aqui guardare el apellido en la tercera columna del arreglo
                if (personas[i][1].toString().isEmpty()) {
                    System.out.println("El apellido no puede estar vacío. Por favor, ingresa un apellido válido.");
                }
            } while (personas[i][1].toString().isEmpty());
            System.out.println("Dime tu edad: ");
            do{
                int edad = teclado.nextInt();
                if (edad <= 0) {
                    System.out.println("La edad debe ser un número positivo. Por favor, ingresa una edad válida.");
                } else {
                    personas[i][2] = edad; // Aqui guardare la edad en la segunda columna del arreglo
                }
            } while (personas[i][2] == null || (int) personas[i][2] <= 0);
            if ((int) personas[i][2] < 60 && (int) personas[i][2] > 55) {
                System.out.println("Estas proximo a jubilarte  " + personas[i][0]);

            } else {
                System.out.println("Aun no estas proximo a jubilarte " + personas[i][0]);
            }
            teclado.nextLine(); // Limpiar el buffer después de leer un número
        }
        System.out.println("Los datos ingresados son: ");
        for (int i = 0; i < personas.length; i++) {
            System.out.println("Nombre: " + personas[i][0] + ", Apellido: " + personas[i][1] + ", Edad: " + personas[i][2]);
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