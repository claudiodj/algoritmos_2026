package com.ejemplo.gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ejemplo.Main;
import com.ejemplo.modelo.Destinos;
import com.ejemplo.servicio.impl.DestinosServiciosImpl;

public class DestinosFrame extends JFrame {

    // Declaración de componentes
    private JTextField txtNombre;
    private JComboBox<String> cmbTipo;
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
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
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

        panelFormulario.add(new JLabel("Tipo:", SwingConstants.CENTER));
        cmbTipo = new JComboBox<>(new String[] {"Internacional", "Nacional", "Escapada"});
        panelFormulario.add(cmbTipo);

        panelFormulario.add(new JLabel("Pasajeros:", SwingConstants.CENTER));
        txtPasajeros = new JTextField();
        panelFormulario.add(txtPasajeros);

        panelFormulario.add(new JLabel("Disponible:", SwingConstants.CENTER));
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

        btnVolver.addActionListener(e -> volver());
    }

        private void volver() {
            this.dispose(); // Cierra la ventana actual
            
            MainFrame ventanaPrincipal = new MainFrame();
            ventanaPrincipal.setVisible(true); // Abre la ventana principal
    }

        private void guardarDestino() {

        try {

            String nombre = txtNombre.getText().trim();
            String tipo = (String) cmbTipo.getSelectedItem();

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
                    txtPasajeros.setBackground(java.awt.Color.WHITE);

            limpiarFormulario();

        } catch (NumberFormatException ex) {

            JOptionPane.showMessageDialog(
                    this,
                    "La cantidad de pasajeros debe ser numérica",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                    txtPasajeros.setText("");
                    txtPasajeros.setBackground(java.awt.Color.YELLOW);
                    txtPasajeros.requestFocus();

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
        //txtTipo.setText("");
        txtPasajeros.setText("");
        chkDisponible.setSelected(false);

        txtNombre.requestFocus();
    }

}
