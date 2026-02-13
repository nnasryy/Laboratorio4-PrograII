package GUI;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import lab4_prograii.*;

public class MenuModalidad extends JFrame {
    private JButton btnFijo, btnAzar, btnSalir, btnAgregar; // Nuevo botón agregado
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
        setSize(600, 450); // Aumenté un poco el alto para acomodar el nuevo botón
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

        lblSeleccionar = new JLabel("Seleccione una opción", SwingConstants.CENTER);
        lblSeleccionar.setBounds(100, 100, 400, 30);
        lblSeleccionar.setForeground(new Color(150, 150, 150));
        lblSeleccionar.setFont(new Font("Segoe UI", Font.ITALIC, 18));
        add(lblSeleccionar);

        // --- BOTÓN MODO FIJO ---
        btnFijo = new JButton("MODO FIJO");
        btnFijo.setBounds(120, 160, 160, 50);
        estilizarBoton(btnFijo, new Color(41, 128, 185));
        btnFijo.addActionListener(e -> {
            JuegoAhorcadoFijo juego = new JuegoAhorcadoFijo("ARROZ");
            abrirPantallaJuego(juego, "Fijo");
        });

        // --- BOTÓN MODO AZAR ---
        btnAzar = new JButton("MODO AZAR");
        btnAzar.setBounds(300, 160, 160, 50);
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

        // --- BOTÓN AGREGAR PALABRA (NUEVO) ---
        btnAgregar = new JButton("AÑADIR PALABRA");
        btnAgregar.setBounds(120, 230, 160, 50);
        estilizarBoton(btnAgregar, new Color(142, 68, 173)); // Color Púrpura
        btnAgregar.addActionListener(e -> accionAgregarPalabra());

        // --- BOTÓN SALIR ---
        btnSalir = new JButton("SALIR");
        btnSalir.setBounds(300, 230, 160, 50);
        estilizarBoton(btnSalir, new Color(192, 57, 43));
        btnSalir.addActionListener(e -> System.exit(0));

        add(btnFijo);
        add(btnAzar);
        add(btnAgregar);
        add(btnSalir);
    }

    // Lógica para capturar la nueva palabra
    private void accionAgregarPalabra() {
        String nuevaPalabra = JOptionPane.showInputDialog(this, 
                "Ingrese la nueva palabra secreta:", 
                "Configuración", JOptionPane.QUESTION_MESSAGE);
        
        if (nuevaPalabra != null && !nuevaPalabra.trim().isEmpty()) {
            adminPalabras.agregarPalabra(nuevaPalabra.trim().toUpperCase());
            JOptionPane.showMessageDialog(this, "¡Palabra agregada con éxito!");
        }
    }

    private void estilizarBoton(JButton btn, Color colorBase) {
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setBackground(colorBase);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(colorBase.brighter(), 2));
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));

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