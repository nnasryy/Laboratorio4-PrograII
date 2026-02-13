package GUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import lab4_prograii.*;

public class MenuModalidad extends JFrame {
    private JButton btnFijo, btnAzar, btnSalir;
    private JLabel lblTitulo, lblSeleccionar;
    private AdminPalabrasSecretas adminPalabras;

    public MenuModalidad() {
        adminPalabras = new AdminPalabrasSecretas();

        configurarVentana();
        inicializarComponentes();
        setVisible(true);
    }

    private void configurarVentana() {
        setTitle("Ahorcado Pro - Menú");
        setSize(600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(25, 25, 25)); 
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void inicializarComponentes() {
        lblTitulo = new JLabel("AHORCADO", SwingConstants.CENTER);
        lblTitulo.setBounds(100, 40, 400, 50);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 42));
        add(lblTitulo);

        lblSeleccionar = new JLabel("Seleccione la modalidad de juego", SwingConstants.CENTER);
        lblSeleccionar.setBounds(100, 100, 400, 30);
        lblSeleccionar.setForeground(new Color(150, 150, 150));
        lblSeleccionar.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        add(lblSeleccionar);


        btnFijo = new JButton("MODO FIJO");
        btnFijo.setBounds(70, 200, 140, 50);
        estilizarBoton(btnFijo, new Color(41, 128, 185));
        btnFijo.addActionListener(e -> {
            JuegoAhorcadoFijo juego = new JuegoAhorcadoFijo("ARROZ");
            abrirPantallaJuego(juego, "Fijo");
        });


        btnAzar = new JButton("MODO AZAR");
        btnAzar.setBounds(230, 200, 140, 50);
        estilizarBoton(btnAzar, new Color(39, 174, 96));
        btnAzar.addActionListener(e -> {
            String palabra = adminPalabras.obtenerPalabraRandom();
            if(palabra != null) {
                JuegoAhorcadoAzar juego = new JuegoAhorcadoAzar(palabra);
                abrirPantallaJuego(juego, "Azar");
            } else {
                JOptionPane.showMessageDialog(this, "No hay palabras disponibles.");
            }
        });


        btnSalir = new JButton("SALIR");
        btnSalir.setBounds(390, 200, 140, 50);
        estilizarBoton(btnSalir, new Color(192, 57, 43));
        btnSalir.addActionListener(e -> System.exit(0));

        add(btnFijo);
        add(btnAzar);
        add(btnSalir);
    }

    private void estilizarBoton(JButton btn, Color colorBase) {
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBackground(colorBase);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(colorBase.brighter(), 2));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // Efecto Hover
        btn.addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { btn.setBackground(colorBase.brighter()); }
            public void mouseExited(MouseEvent e) { btn.setBackground(colorBase); }
        });
    }

    private void abrirPantallaJuego(JuegoAhorcadoBase juego, String modo) {
        new PantallaJuego(juego, modo).setVisible(true);
        this.dispose();
    }
}