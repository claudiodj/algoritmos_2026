package com.ejemplo.servicio;

import java.util.LinkedList;

import com.ejemplo.modelo.Clientes;

public interface ClientesServicios {

    // Método útil: calcular edad actual
    public int calcularEdad(Clientes cliente);
    public Clientes buscarClientePorDni(LinkedList<Clientes> listaClientes, int dni);

}
