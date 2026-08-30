package com.ejemplo.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import com.ejemplo.Main;
import com.ejemplo.modelo.Clientes;
import com.ejemplo.modelo.Destinos;
import com.ejemplo.modelo.Reservas;

public class MainFrame extends JFrame {

    //private JTextField txtId;
    //private JTextField txtNombre;
    private JTextArea areaResultado;
    

    //private EstudianteService service;

    public MainFrame() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {

        setTitle("Sistema de Turismo");
        setSize(650, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));

        // Creamos un JTextArea para mostrar los resultados de las operaciones
        areaResultado = new JTextArea();
        JScrollPane scroll = new JScrollPane(areaResultado);

        add(panel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        // -------------------------- BOTONES REGISTRAR, BORRAR Y LISTAR CLIENTES -------------------------
        // Agregamos los botones para registrar y listar clientes
        JButton btnRegistrarCli = new JButton("Registrar Cliente");
        JButton btnListarCli = new JButton("Listar Clientes");
        JButton btnBorrarCli = new JButton("Borrar Cliente");
        // Agregamos al panel los botones registrar y listar clientes        
        panel.add(btnRegistrarCli);
        panel.add(btnListarCli);
        panel.add(btnBorrarCli);

        // Algoritmo para abrir la ventana de registro de clientes al hacer clic en el botón "Registrar Cliente"
        btnRegistrarCli.addActionListener(e -> {
            ClientesFrame ventanaCliFrame = new ClientesFrame();
            ventanaCliFrame.setVisible(true);
            //this.setVisible(false);
            this.dispose();
        });
        // Algoritmo para mostrar la lista de clientes al hacer clic en el botón "Listar Clientes"
        btnListarCli.addActionListener(e -> {
            areaResultado.setText("Lista de Clientes:\n");
            for (Clientes cliente : Main.listaClientes) {
                areaResultado.append(cliente.toString() + "\n");
            }
        });
        // Algoritmo para borrar un cliente al hacer clic en el botón "Borrar Cliente"
        btnBorrarCli.addActionListener(e -> {
            ClienteBorrarFrame ventanaBorrarCliFrame = new ClienteBorrarFrame();
            ventanaBorrarCliFrame.setVisible(true);
            this.dispose();
            //areaResultado.setText("Cliente borrado exitosamente.\n");
        });

        // -------------------------- BOTONES REGISTRAR Y LISTAR DESTINOS -------------------------
        // Agregamos los botones para registrar y listar destinos
        JButton btnRegistrarDes = new JButton("Registrar Destino");
        JButton btnListarDes = new JButton("Listar Destinos");
        // Agregamos al panel los botones registrar y listar destinos        
        panel.add(btnRegistrarDes);
        panel.add(btnListarDes);
        // Algoritmo para abrir la ventana de registro de destinos al hacer clic en el botón "Registrar Destino"
        btnRegistrarDes.addActionListener(e -> {
            DestinosFrame ventanaDesFrame = new DestinosFrame();
            ventanaDesFrame.setVisible(true);
            //this.setVisible(false);
            this.dispose();
        });
        // Algoritmo para mostrar la lista de destinos al hacer clic en el botón "Listar Destinos"
        btnListarDes.addActionListener(e -> {
            areaResultado.setText("Lista de Destinos:\n");
            for (Destinos destino : Main.listaDestinos) {
                areaResultado.append(destino.toString() + "\n");
            }
        });

        // -------------------------- BOTONES REGISTRAR Y LISTAR RESERVAS -------------------------
        // Agregamos los botones para registrar y listar reservas
        JButton btnRegistrarRes = new JButton("Registrar Reserva");
        JButton btnListarRes = new JButton("Listar Reservas");
        // Agregamos al panel los botones registrar y listar reservas        
        panel.add(btnRegistrarRes);
        panel.add(btnListarRes);
        // Algoritmo para abrir la ventana de registro de reservas al hacer clic en el botón "Registrar Reserva"
        btnRegistrarRes.addActionListener(e -> {
            ReservasFrame ventanaResFrame = new ReservasFrame();
            ventanaResFrame.setVisible(true);
            this.dispose();
        });
        // Algoritmo para mostrar la lista de reservas al hacer clic en el botón "Listar Reservas"
        btnListarRes.addActionListener(e -> {
            areaResultado.setText("Lista de Reservas:\n");
            for (Reservas reserva : Main.listaReservas) {
                areaResultado.append(reserva.toString() + "\n");
            }
        });

        // -------------------------- BOTONES REGISTRAR Y LISTAR VIAJES -------------------------
        // Agregamos los botones para registrar y listar viajes
        JButton btnRegistrarVia = new JButton("Registrar Viaje");
        JButton btnListarVia = new JButton("Listar Viajes");
        // Agregamos al panel los botones registrar y listar viajes        
        panel.add(btnRegistrarVia);
        panel.add(btnListarVia);

        // ------------------------- BOTON SALIR -------------------------
        // Agregamos el botón para salir del programa
        JButton btnSalir = new JButton("Salir");
        panel.add(btnSalir);
        // Algoritmo para salir del programa al hacer clic en el botón "Salir"
        btnSalir.addActionListener(e -> {
        System.out.println("Saliendo del sistema...");
        System.exit(0);
        });

        // ------------------------- BOTON GUARDAR -------------------------
        // Agregamos un botón para guardar los datos antes de salir
        JButton btnGuardar = new JButton("Guardar Datos");  
        panel.add(btnGuardar);
        // Algoritmo para guardar los datos al hacer clic en el botón "Guardar Datos"
        btnGuardar.addActionListener(e -> {
            Main.guardarDatos(Main.listaClientes, Main.listaDestinos, Main.listaReservas, Main.listaViajes);
            areaResultado.setText("Datos guardados exitosamente.");
        });

    }

}
