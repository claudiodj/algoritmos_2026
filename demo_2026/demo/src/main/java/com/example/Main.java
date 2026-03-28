package com.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        System.out.println("Mi nombre es Juan");
        System.out.println("Tengo 25 años");
        int edad = 25;
        String nombre = "Juan";
        if (edad < 60 && edad > 55) {
            System.out.println("Estas proximo a jubilarte  " + nombre);
            
        }else{
            System.out.println("Aun no estas proximo a jubilarte " + nombre);
        }

    Scanner teclado = new Scanner(System.in);
    String teclaPresionada;
    do{
    System.out.println("Presione una tecla para continuar (Sale con Z): ");
    teclaPresionada = teclado.nextLine();
    switch (teclaPresionada) {
        case "A":
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
}while (teclaPresionada.equalsIgnoreCase("Z") == false);
    }
}