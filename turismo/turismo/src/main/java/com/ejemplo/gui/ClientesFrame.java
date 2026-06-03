package com.ejemplo.gui;

import javax.swing.*;
import java.awt.*;

public class ClientesFrame extends JFrame {

    private JTextArea areaResultado;

    public ClientesFrame() {
        configurarVentana();
        inicializarComponentes();
    }

    private void configurarVentana() {

        setTitle("Clientes");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        areaResultado = new JTextArea();
        areaResultado.setEditable(false);
        JScrollPane scroll = new JScrollPane(areaResultado);

        JButton btnVolver = new JButton("Volver");
        JPanel panelBoton = new JPanel();
        panelBoton.add(btnVolver);

        panel.add(panelBoton, BorderLayout.NORTH);

}
}
