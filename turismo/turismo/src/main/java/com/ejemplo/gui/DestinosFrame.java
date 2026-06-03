package com.ejemplo.gui;
import javax.swing.*;

import com.ejemplo.Main;
import com.ejemplo.modelo.Destinos;
import com.ejemplo.servicio.impl.DestinosServiciosImpl;

import java.awt.*;
import java.util.LinkedList;

public class DestinosFrame extends JFrame {

    // Declaración de componentes
    private JTextField txtNombre;
    private JTextField txtTipo;
    private JTextField txtPasajeros;
    private JCheckBox chkDisponible;

    private JButton btnGuardar;
    private JButton btnVolver;

    public DestinosFrame() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("Destinos");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
    JPanel panelPrincipal = new JPanel(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 20, 20));
        // Agregamos los campos al formulario
        // El JLabel Nombre con el texto centrado
        panelFormulario.add(new JLabel("Nombre:", SwingConstants.CENTER));
        // El JTextField para el nombre
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Tipo:"));
        txtTipo = new JTextField();
        panelFormulario.add(txtTipo);

        panelFormulario.add(new JLabel("Pasajeros:"));
        txtPasajeros = new JTextField();
        panelFormulario.add(txtPasajeros);

        panelFormulario.add(new JLabel("Disponible:"));
        chkDisponible = new JCheckBox();
        panelFormulario.add(chkDisponible);

        JPanel panelBotones = new JPanel();

        btnGuardar = new JButton("Guardar");
        btnVolver = new JButton("Volver");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnVolver);

        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);

        btnGuardar.addActionListener(e -> guardarDestino());

        btnVolver.addActionListener(e -> dispose());
    }

        private void guardarDestino() {

        try {

            String nombre = txtNombre.getText().trim();
            String tipo = txtTipo.getText().trim();

            int pasajeros = Integer.parseInt(
                    txtPasajeros.getText().trim());

            boolean disponible =
                    chkDisponible.isSelected();

            Destinos destino = new Destinos(
                    nombre,
                    tipo,
                    pasajeros,
                    disponible);

            // Aquí agrega el objeto destino a la lista
            DestinosServiciosImpl servicios = new DestinosServiciosImpl();
            servicios.agregarDestino(destino, Main.listaDestinos);

            JOptionPane.showMessageDialog(
                    this,
                    "Destino guardado correctamente");

            limpiarFormulario();

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "La cantidad de pasajeros debe ser numérica",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    this,
                    ex.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarFormulario() {

        txtNombre.setText("");
        txtTipo.setText("");
        txtPasajeros.setText("");
        chkDisponible.setSelected(false);

        txtNombre.requestFocus();
    }

}
