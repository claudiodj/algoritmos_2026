package com.ejemplo.gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ejemplo.Main;
import com.ejemplo.modelo.Clientes;
import com.ejemplo.servicio.impl.ClientesServiciosImpl;

public class ClientesFrame extends JFrame {

    // Declaración de componentes
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtEmail;
    private JTextField txtTelefono;
    private JTextField txtDNI;
    private JTextField txtFechaNacimiento;

    private JButton btnGuardar;
    private JButton btnVolver;

    public ClientesFrame() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("Clientes");
        setSize(400, 300);
        //setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        JPanel panelPrincipal = new JPanel(new BorderLayout());

        JPanel panelFormulario = new JPanel(new GridLayout(6, 2, 20, 15));
        panelFormulario.add(new JLabel("Nombre:", SwingConstants.CENTER));
        // El JTextField para el nombre
        txtNombre = new JTextField();
        panelFormulario.add(txtNombre);

        panelFormulario.add(new JLabel("Apellido:", SwingConstants.CENTER));
        txtApellido = new JTextField();
        panelFormulario.add(txtApellido);

        panelFormulario.add(new JLabel("Email:", SwingConstants.CENTER));
        txtEmail = new JTextField();
        panelFormulario.add(txtEmail);

        panelFormulario.add(new JLabel("Teléfono:", SwingConstants.CENTER));
        txtTelefono = new JTextField();
        panelFormulario.add(txtTelefono);

        panelFormulario.add(new JLabel("DNI:", SwingConstants.CENTER));
        txtDNI = new JTextField();
        panelFormulario.add(txtDNI);

        panelFormulario.add(new JLabel("Fecha de Nacimiento:", SwingConstants.CENTER));
        txtFechaNacimiento = new JTextField();
        panelFormulario.add(txtFechaNacimiento);

        btnVolver = new JButton("Volver");
        btnGuardar = new JButton("Guardar");
    
        JPanel panelBotones = new JPanel();
        panelBotones.add(btnVolver);
        panelBotones.add(btnGuardar);

        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);

        // Aqui declaro los eventos de los botones 
        btnGuardar.addActionListener(e -> { guardarCliente(); });

        btnVolver.addActionListener(e -> { volver(); });


} // --- Aqui termina el constructor de la clase ClientesFrame

// -- Aqui van los métodos de la clase ClientesFrame
        private void volver() {
            this.dispose(); // Cierra la ventana actual
            
            MainFrame ventanaPrincipal = new MainFrame();
            ventanaPrincipal.setVisible(true); // Abre la ventana principal
    }

        private void guardarCliente() {
            // Lógica para guardar el cliente
            String nombre = txtNombre.getText().trim();
            String apellido = txtApellido.getText().trim();
            String email = txtEmail.getText().trim();
            String telefono = txtTelefono.getText().trim();
            int dni = Integer.parseInt(txtDNI.getText().trim());
            String fechaNacimiento = txtFechaNacimiento.getText().trim();

            final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNac = LocalDate.parse(fechaNacimiento, FORMATTER);

            if (nombre.isEmpty() || apellido.isEmpty() || email.isEmpty() || telefono.isEmpty() || txtDNI.getText().isEmpty() || fechaNacimiento.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Clientes cliente = new Clientes(nombre, apellido, email, telefono, dni, fechaNac);

            // Aquí agrega el objeto cliente a la lista
            ClientesServiciosImpl servicios = new ClientesServiciosImpl();
            servicios.agregarCliente(cliente, Main.listaClientes);

            JOptionPane.showMessageDialog(this, "Cliente guardado correctamente.");
            
            limpiarFormulario();
        }

        private void limpiarFormulario() {
            txtNombre.setText("");
            txtApellido.setText("");
            txtEmail.setText("");
            txtTelefono.setText("");
            txtDNI.setText("");
            txtFechaNacimiento.setText("");


}
}