package com.ejemplo.servicio.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.LinkedList;

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
        // Implementación del método
        return null;
    }

}
