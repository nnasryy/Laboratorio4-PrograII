package GUI;

import java.awt.*;
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
        setVisible(true);  // Agregado: Para mostrar la ventana al crear la instancia
    }

    private void configurarVentana() {
        setTitle("Ahorcado - Menú Principal");
        setSize(580, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(35, 35, 35));
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        // Título y Subtítulo
        lblTitulo = new JLabel("AHORCADO", SwingConstants.CENTER);
        lblTitulo.setBounds(90, 40, 400, 50);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 36));
        add(lblTitulo);

        lblSeleccionar = new JLabel("Seleccione la modalidad de juego:", SwingConstants.CENTER);
        lblSeleccionar.setBounds(90, 100, 400, 30);
        lblSeleccionar.setForeground(new Color(200, 200, 200));
        lblSeleccionar.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        add(lblSeleccionar);

        // Botones
        iniciarBotones();
    }

    private void iniciarBotones() {
        // Modo Fijo
        btnFijo = new JButton("Modo Fijo");
        btnFijo.setBounds(50, 180, 150, 50);
        estilizarBoton(btnFijo, new Color(41, 128, 185));
        btnFijo.addActionListener(e -> {
            JuegoAhorcadoFijo juego = new JuegoAhorcadoFijo("ARROZ");
            abrirPantallaJuego(juego, "Fijo");
        });

        // Modo Azar
        btnAzar = new JButton("Modo Azar");
        btnAzar.setBounds(215, 180, 150, 50);
        estilizarBoton(btnAzar, new Color(39, 174, 96));
        btnAzar.addActionListener(e -> {
            String palabraAleatoria = adminPalabras.obtenerPalabraRandom();
            JuegoAhorcadoAzar juego = new JuegoAhorcadoAzar(palabraAleatoria);
            abrirPantallaJuego(juego, palabraAleatoria);
        });

        // Salir
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(380, 180, 150, 50);
        estilizarBoton(btnSalir, new Color(192, 57, 43));
        btnSalir.addActionListener(e -> System.exit(0));

        add(btnFijo);
        add(btnAzar);
        add(btnSalir);
    }

    private void abrirPantallaJuego(JuegoAhorcadoBase juego, String modo) {
        PantallaJuego pantalla = new PantallaJuego(juego, modo);
        pantalla.setVisible(true);  // Agregado: Para mostrar la nueva ventana de juego
        this.dispose();
    }

    private void estilizarBoton(JButton btn, Color color) {
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setBorder(BorderFactory.createEmptyBorder());
    }
}