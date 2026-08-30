package com.ejemplo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;

import javax.swing.SwingUtilities;

import com.ejemplo.DAO.ClientesDAO;
import com.ejemplo.gui.MainFrame;
import com.ejemplo.modelo.Clientes;
import com.ejemplo.modelo.Destinos;
import com.ejemplo.modelo.Reservas;
import com.ejemplo.modelo.Viajes;
import com.ejemplo.servicio.ClientesServicios;
import com.ejemplo.servicio.DestinosServicios;
import com.ejemplo.servicio.ReservasServicios;
import com.ejemplo.servicio.ViajesServicios;
import com.ejemplo.servicio.impl.ClientesServiciosImpl;
import com.ejemplo.servicio.impl.DestinosServiciosImpl;
import com.ejemplo.servicio.impl.ReservasServiciosImpl;
import com.ejemplo.servicio.impl.ViajesServiciosImpl;

public class Main {

    // Se crea una lista para almacenar los clientes registrados
    // Se la declara como public static final 
    public static final LinkedList<Clientes> listaClientes = new LinkedList<>();
    
    // Se crea una lista para almacenar los destinos registrados
    public static final LinkedList<Destinos> listaDestinos = new LinkedList<>();
    
    // Se crea una lista para almacenar las reservas realizadas
    public static final LinkedList<Reservas> listaReservas = new LinkedList<>();
    
    // Se crea una lista para almacenar los viajes realizados
    public static final LinkedList<Viajes> listaViajes = new LinkedList<>();

    public static void main(String[] args) {

        // Se crea una instancia de ClientesServicios para manejar las operaciones
        // relacionadas con los clientes
        ClientesServicios clientesServicios = new ClientesServiciosImpl();

        // Se crea una instancia de DestinosServicios para manejar las operaciones relacionadas
        // con los destinos
        DestinosServicios destinosServicios = new DestinosServiciosImpl();

        // Se crea una instancia de ReservasServicios para manejar las operaciones relacionadas
        // con las reservas
        ReservasServicios reservasServicios = new ReservasServiciosImpl();

        // Se crea una instancia de ViajesServicios para manejar las operaciones relacionadas
        // con los viajes
        ViajesServicios viajesServicios = new ViajesServiciosImpl();

        // Recupero de archivos los datos previamente guardados (si existen)
        //leerDatos(listaClientes, listaDestinos, listaReservas, listaViajes);
        
        // Recupero de la base de datos los datos previamente guardados (si existen)
        ClientesDAO clientesDAO = new ClientesDAO();
        listaClientes.addAll(clientesDAO.obtenerClientes());

        // Iniciamos la interfaz gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {

            MainFrame ventana = new MainFrame();

            ventana.setVisible(true);
        });

    }
    
    public static void guardarDatos(LinkedList<Clientes> listaClientes, LinkedList<Destinos> listaDestinos, LinkedList<Reservas> listaReservas, LinkedList<Viajes> listaViajes) {
        String rutaDirectorio = "C:\\datos\\";
        File directorio = new File("C:\\datos");
        if (!directorio.exists()) {
            directorio.mkdirs(); // Crea el directorio si no existe
        }

        try (ObjectOutputStream oosClientes = new ObjectOutputStream(new FileOutputStream(rutaDirectorio + "clientes.dat"));
                ObjectOutputStream oosDestinos = new ObjectOutputStream(new FileOutputStream(rutaDirectorio + "destinos.dat"));
                ObjectOutputStream oosReservas = new ObjectOutputStream(new FileOutputStream(rutaDirectorio + "reservas.dat"));
                ObjectOutputStream oosViajes = new ObjectOutputStream(new FileOutputStream(rutaDirectorio + "viajes.dat"))) {

            oosClientes.writeObject(listaClientes);
            oosDestinos.writeObject(listaDestinos);
            oosReservas.writeObject(listaReservas);
            oosViajes.writeObject(listaViajes);
            System.out.println("Datos guardados correctamente en: " + rutaDirectorio);

        } catch (IOException e) {
            System.out.println("Error al guardar los datos: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public static void leerDatos(LinkedList<Clientes> listaClientes, LinkedList<Destinos> listaDestinos, LinkedList<Reservas> listaReservas, LinkedList<Viajes> listaViajes) {
        String rutaDirectorio = "C:\\datos\\";
        
        try (ObjectInputStream oisClientes = new ObjectInputStream(new FileInputStream(rutaDirectorio + "clientes.dat"));
                ObjectInputStream oisDestinos = new ObjectInputStream(new FileInputStream(rutaDirectorio + "destinos.dat"));
                ObjectInputStream oisReservas = new ObjectInputStream(new FileInputStream(rutaDirectorio + "reservas.dat"));
                ObjectInputStream oisViajes = new ObjectInputStream(new FileInputStream(rutaDirectorio + "viajes.dat"))
            ) {

            LinkedList<Clientes> clientesCargados = (LinkedList<Clientes>) oisClientes.readObject();
            LinkedList<Destinos> destinosCargados = (LinkedList<Destinos>) oisDestinos.readObject();
            LinkedList<Reservas> reservasCargadas = (LinkedList<Reservas>) oisReservas.readObject();
            LinkedList<Viajes> viajesCargados = (LinkedList<Viajes>) oisViajes.readObject();

            listaClientes.clear();
            listaClientes.addAll(clientesCargados);

            listaDestinos.clear();
            listaDestinos.addAll(destinosCargados);

            listaReservas.clear();
            listaReservas.addAll(reservasCargadas);

            listaViajes.clear();
            listaViajes.addAll(viajesCargados);

            System.out.println("Datos cargados correctamente desde: " + rutaDirectorio);

        } catch (FileNotFoundException e) {
            System.out.println("Archivos de datos no encontrados en " + rutaDirectorio + ". Asegúrese de guardar los datos primero.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer los datos: " + e.getMessage());
        }
    }

}
