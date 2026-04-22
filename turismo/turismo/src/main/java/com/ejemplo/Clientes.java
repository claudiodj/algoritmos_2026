package com.ejemplo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Clientes {

    private String nombre;
    private String apellido;
    private String email;
    private String telefono;
    private int dni;
    private LocalDate fechaNacimiento;

    public Clientes() {
    }

    public Clientes(String nombre, String apellido, String email, String telefono, int dni, LocalDate fechaNacimiento) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
        this.telefono = telefono;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public String toString() {
        return "Clientes [nombre=" + nombre + ", apellido=" + apellido + ", email=" + email + ", telefono=" + telefono
                + ", dni=" + dni + ", fechaNacimiento=" + fechaNacimiento + "]";
    }

    
    // Método útil: calcular edad actual
    public int getEdad() {
        if (fechaNacimiento == null) return 0;
        return Period.between(fechaNacimiento, LocalDate.now()).getYears();
    }
    
    // Método útil: formatear fecha
    public String getFechaFormateada() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return fechaNacimiento.format(formatter);
    }
    
}   
