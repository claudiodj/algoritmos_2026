package com.ejemplo.servicio;

import java.util.LinkedList;

import com.ejemplo.modelo.Destinos;

public interface DestinosServicios {

    Destinos registrarDestino();
    void mostrarDestinos(LinkedList<Destinos> listaDestinos);
    void agregarDestino(Destinos destino, LinkedList<Destinos> listaDestinos);

}
