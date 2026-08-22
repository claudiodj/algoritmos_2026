package com.ejemplo.servicio;

import java.util.LinkedList;

import com.ejemplo.modelo.Clientes;

public interface ClientesServicios {

    // Método útil: calcular edad actual
    public int calcularEdad(Clientes cliente);
    public Clientes buscarClientePorDni(LinkedList<Clientes> listaClientes, int dni);
    public Clientes registrarCliente();
    public void agregarCliente(Clientes cliente, LinkedList<Clientes> listaClientes);
    default void mostrarClientes(LinkedList<Clientes> listaClientes) {
        if (listaClientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("Lista de Clientes:");
            for (Clientes cliente : listaClientes) {
                System.out.println(cliente.toString());
            }
        }
    }

}
