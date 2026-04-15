package com.ejemplo;

public class Destinos {

    private String nombre;
    String tipo;   
    int pasajeros;
    boolean disponible;
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public int getPasajeros() {
        return pasajeros;
    }
    public void setPasajeros(int pasajeros) {
        this.pasajeros = pasajeros;
    }
    public boolean isDisponible() {
        return disponible;
    }
    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }
    @Override
    public String toString() {
        return "Destinos [nombre=" + nombre + ", tipo=" + tipo + ", pasajeros=" + pasajeros + ", disponible="
                + disponible + "]";
    }

    

}
