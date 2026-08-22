package com.ejemplo.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ejemplo.DAO.ClientesDAO;

public class ClienteBorrarFrame extends JFrame {

    // Declaración de componentes 
    private JTextField idCliente;
    private JButton btnBorrar;
    private JButton btnVolver;

    public ClienteBorrarFrame() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("Borrar Cliente");
        setSize(400, 200);
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {

        JPanel panelPrincipal = new JPanel(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(1, 2, 20, 25));
        panelFormulario.add(new JLabel("Ingrese Id Cliente a Borrar:", SwingConstants.CENTER));
        // El JTextField para el nombre
        idCliente = new JTextField();
        panelFormulario.add(idCliente);

        btnVolver = new JButton("Volver");
        btnBorrar = new JButton("Borrar");

        JPanel panelBotones = new JPanel();
        panelBotones.add(btnVolver);
        panelBotones.add(btnBorrar);

        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);

        // Aqui declaro los eventos de los botones 
        btnBorrar.addActionListener(e -> { borrarCliente(); });

        btnVolver.addActionListener(e -> { volver(); });

    }

    private void volver() {
        this.dispose(); // Cierra la ventana actual
            
        MainFrame ventanaPrincipal = new MainFrame();
        ventanaPrincipal.setVisible(true); // Abre la ventana principal
    }

    private void borrarCliente() {

        if (idCliente.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Ingrese el ID del cliente a borrar.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            } else {
                try {
                    Integer.parseInt(idCliente.getText().trim());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "El ID debe ser un número válido.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }

        int idCliBorrar = Integer.parseInt(idCliente.getText().trim());
        
        if (idCliBorrar > 0) {
            // Llamar al método para borrar el cliente
            boolean borrado;
            try {
                borrado = ClientesDAO.borrarClientePorId(idCliBorrar);
                if (borrado) {
                javax.swing.JOptionPane.showMessageDialog(this, "Cliente con ID " + idCliBorrar + " borrado correctamente.");
                idCliente.setText(""); // Limpiar el campo de texto después de borrar
                    } else {
                        javax.swing.JOptionPane.showMessageDialog(this, "No se pudo borrar el cliente. Verifique el ID.");
                        }
                } catch (Exception e) {
                // Si el método lanza una excepción, la capturamos y mostramos un mensaje de error
                    JOptionPane.showMessageDialog(this, "Ocurrió un error al intentar borrar el cliente");
                    e.printStackTrace();
                    }

        } else {
            javax.swing.JOptionPane.showMessageDialog(this, "Ingrese un ID mayor a cero.");
            }
                                                        
    }

}
