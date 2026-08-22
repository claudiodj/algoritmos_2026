package com.ejemplo.gui;
import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.ejemplo.Main;
import com.ejemplo.modelo.Clientes;
import com.ejemplo.modelo.Destinos;

public class ReservasFrame extends JFrame {

    // Declaración de componentes
    private JComboBox<Clientes> cmbClientes;
    private JComboBox<Destinos> cmbDestinos;
    private JTextField txtFechaRes;
    private JTextField txtNumRes;
    private JTextField txtPrecio;
    private JCheckBox chkPagado;

    private JButton btnGuardar;
    private JButton btnVolver;


    public ReservasFrame() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {
        setTitle("Reservas");
        setSize(600, 300);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        setLocationRelativeTo(null);        
        }

    private void inicializarComponentes() {

    JPanel panelPrincipal = new JPanel(new BorderLayout());

    JPanel panelFormulario = new JPanel(new GridLayout(6, 2, 20, 20));
        // Agregamos los campos al formulario
        panelFormulario.add(new JLabel("Cliente:", SwingConstants.CENTER));
        // Llenamos el combo de clientes desde Main.listaClientes
        DefaultComboBoxModel<Clientes> clientesModel = new DefaultComboBoxModel<>();
        for (Clientes c : Main.listaClientes) {
            clientesModel.addElement(c);
        }
        cmbClientes = new JComboBox<>(clientesModel);
        panelFormulario.add(cmbClientes);

        panelFormulario.add(new JLabel("Destino:", SwingConstants.CENTER));
        // Llenamos el combo de destinos desde Main.listaDestinos
        DefaultComboBoxModel<Destinos> destinosModel = new DefaultComboBoxModel<>();
        for (Destinos d : Main.listaDestinos) {
            destinosModel.addElement(d);
        }
        cmbDestinos = new JComboBox<>(destinosModel);
        panelFormulario.add(cmbDestinos);

        panelFormulario.add(new JLabel("Fecha:", SwingConstants.CENTER));
        txtFechaRes = new JTextField();
        panelFormulario.add(txtFechaRes);

        panelFormulario.add(new JLabel("Nro Reserva:", SwingConstants.CENTER));
        txtNumRes = new JTextField();
        panelFormulario.add(txtNumRes);

        panelFormulario.add(new JLabel("Precio:", SwingConstants.CENTER));
        txtPrecio = new JTextField();
        panelFormulario.add(txtPrecio);

        panelFormulario.add(new JLabel("Pagado:", SwingConstants.CENTER));
        chkPagado = new JCheckBox();
        panelFormulario.add(chkPagado);


    JPanel panelBotones = new JPanel();

        btnGuardar = new JButton("Guardar");
        btnVolver = new JButton("Volver");

        panelBotones.add(btnGuardar);
        panelBotones.add(btnVolver);

        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);
        panelPrincipal.add(panelBotones, BorderLayout.SOUTH);

        add(panelPrincipal);

        btnGuardar.addActionListener(e -> guardarReserva());

        btnVolver.addActionListener(e -> volver());
    }

        private void volver() {
            this.dispose(); // Cierra la ventana actual
            MainFrame ventanaPrincipal = new MainFrame();
            ventanaPrincipal.setVisible(true); // Abre la ventana principal
    }
        

    private void guardarReserva() {
        // Aquí puedes implementar la lógica para guardar la reserva
        // Por ejemplo, podrías validar los campos y luego almacenar la información en una base de datos o en una lista
    }

    private void limpiarFormulario() {

        txtNumRes.setText("");
        txtFechaRes.setText("");
        txtPrecio.setText("");
        chkPagado.setSelected(false);
        cmbClientes.requestFocus();
    }
}
