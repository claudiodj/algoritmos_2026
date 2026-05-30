package com.ejemplo.servicio.impl;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.LinkedList;
import java.util.Scanner;

import com.ejemplo.modelo.Clientes;
import com.ejemplo.servicio.ClientesServicios;

public class ClientesServiciosImpl implements ClientesServicios{
    
    @Override
    public int calcularEdad(Clientes cliente) {
        if (cliente.getFechaNacimiento() == null) return 0;
        return Period.between(cliente.getFechaNacimiento(), LocalDate.now()).getYears();
    }

    @Override
    public Clientes buscarClientePorDni(LinkedList<Clientes> listaClientes, int dni) {
        Clientes clienteEncontrado = null;
        if (!listaClientes.isEmpty()) {
            for (Clientes cliente : listaClientes) {
                if (cliente.getDni() == dni) {
                    clienteEncontrado = cliente;
                    break;
                }
            }
        }
        return clienteEncontrado;
    }

    @Override
    public Clientes registrarCliente() {

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

        ClientesServicios clientesServicios = new ClientesServiciosImpl();
        System.out.println("Edad del cliente: " + clientesServicios.calcularEdad(cliente));

        //System.out.println("Datos del cliente: " + cliente.toString());
        // scanner.close(); // Comentado para evitar cerrar System.in
        return cliente;
    }

}
