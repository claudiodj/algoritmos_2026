package com.ejemplo;

import java.io.*;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.SwingUtilities;

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
        leerDatos(listaClientes, listaDestinos, listaReservas, listaViajes);
        
        // Iniciamos la interfaz gráfica en el hilo de eventos de Swing
        SwingUtilities.invokeLater(() -> {

            MainFrame ventana = new MainFrame();

            ventana.setVisible(true);
        });

        // Trabajamos con el menú de opciones en la consola para registrar y mostrar clientes, destinos, reservas y viajes
        /* 
        int opcion;

        do {
            Scanner scanner = new Scanner(System.in);

            // Mostrar el menú de opciones al usuario
            mostrarMenu();

            opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea pendiente

            // Procesar la opción seleccionada por el usuario
            switch (opcion) {
                case 1:
                    Clientes cli = clientesServicios.registrarCliente(); // Lógica para registrar un cliente
                    listaClientes.add(cli);
                    break;
                case 2:
                    clientesServicios.mostrarClientes(listaClientes); // Lógica para mostrar clientes
                    break;
                case 3:
                    Destinos dest = destinosServicios.registrarDestino(); // Lógica para registrar un destino
                    listaDestinos.add(dest);
                    break;
                case 4:
                    destinosServicios.mostrarDestinos(listaDestinos); // Lógica para mostrar destinos
                    break;
                case 5:
                    System.out.println("Buscar Cliente por DNI:");
                    System.out.print("Ingrese el DNI del cliente a buscar: ");
                    int dni = scanner.nextInt();
                    Clientes clienteEncontrado = clientesServicios.buscarClientePorDni(listaClientes, dni);
                    if (clienteEncontrado != null) {
                        System.out.println("Cliente encontrado: " + clienteEncontrado.toString());
                    } else {
                        System.out.println("Cliente no encontrado.");
                    }
                    break;
                
                case 88:
                    guardarDatos(listaClientes, listaDestinos, listaReservas, listaViajes);
                    break;
                case 0:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);
    */
    }

    /* 
    public static void mostrarMenu() {
        System.out.println("Menú Sistema de Turismo");
        System.out.println("-------------------------");
        System.out.println("1. Registrar cliente");
        System.out.println("2. Mostrar clientes");
        System.out.println("3. Registrar destino");
        System.out.println("4. Mostrar destinos");
        System.out.println("5. Buscar cliente por DNI");
        System.out.println("88. Guardar datos a archivos");
        System.out.println("0. Salir");
        System.out.print("Seleccione una opción: ");
    }
    */
    
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
