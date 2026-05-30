package com.ejemplo.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

    private JTextField txtId;
    private JTextField txtNombre;
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
/* 
        panel.add(new JLabel("ID:"));
        txtId = new JTextField();
        panel.add(txtId);

        panel.add(new JLabel("Nombre:"));
        txtNombre = new JTextField();
        panel.add(txtNombre);
*/
        // Agregamos los botones para registrar y listar clientes
        JButton btnRegistrarCli = new JButton("Registrar Cliente");
        JButton btnListarCli = new JButton("Listar Clientes");
        // Agregamos al panel los botones registrar y listar clientes        
        panel.add(btnRegistrarCli);
        panel.add(btnListarCli);

        // Agregamos los botones para registrar y listar destinos
        JButton btnRegistrarDes = new JButton("Registrar Destino");
        JButton btnListarDes = new JButton("Listar Destinos");
        // Agregamos al panel los botones registrar y listar destinos        
        panel.add(btnRegistrarDes);
        panel.add(btnListarDes);

        // Agregamos los botones para registrar y listar reservas
        JButton btnRegistrarRes = new JButton("Registrar Reserva");
        JButton btnListarRes = new JButton("Listar Reservas");
        // Agregamos al panel los botones registrar y listar reservas        
        panel.add(btnRegistrarRes);
        panel.add(btnListarRes);

        // Agregamos los botones para registrar y listar viajes
        JButton btnRegistrarVia = new JButton("Registrar Viaje");
        JButton btnListarVia = new JButton("Listar Viajes");
        // Agregamos al panel los botones registrar y listar viajes        
        panel.add(btnRegistrarVia);
        panel.add(btnListarVia);


        areaResultado = new JTextArea();
        JScrollPane scroll =
                new JScrollPane(areaResultado);

        add(panel, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);

        //btnRegistrar.addActionListener(this::registrarEstudiante);

        //btnBuscar.addActionListener(this::buscarEstudiante);
    }
/* 
    private void registrarEstudiante(
            ActionEvent e) {

        try {

            int id =
                    Integer.parseInt(txtId.getText());

            String nombre =
                    txtNombre.getText();

            //service.registrarEstudiante(id,nombre);

            areaResultado.append(
                    "Estudiante registrado\n");

        } catch (Exception ex) {

            areaResultado.append(
                    "Error al registrar\n");
        }
    }

    private void buscarEstudiante(
            ActionEvent e) {

        try {

            int id =
                    Integer.parseInt(txtId.getText());

            //Estudiante estudiante = service.buscarEstudiante(id);
            
            if (estudiante != null) {

                areaResultado.append(
                        estudiante.toString()
                                + "\n");

            } else {

                areaResultado.append(
                        "No encontrado\n");
            }

        } catch (Exception ex) {

            areaResultado.append(
                    "Error en búsqueda\n");
        }
    }
*/
}
