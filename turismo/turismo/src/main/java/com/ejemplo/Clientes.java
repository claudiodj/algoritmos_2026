package com.ejemplo;

public class Clientes {

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private int dni;
    
    public Clientes() {
    }

    public Clientes(String nombre, String apellido, String email, String telefono, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }

    @Override
    public String toString() {
        return "Clientes [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono
                + ", dni=" + dni + "]";
    }

    
}   
