package GUI;

import java.awt.*;
import javax.swing.*;
import lab4_prograii.JuegoAhorcadoBase;

public class PantallaJuego extends JFrame {
    private JuegoAhorcadoBase juego;
    private JLabel lblPalabra, lblIntentos, lblLetrasUsadas;
    private JTextArea areaAhorcado;
    private JTextField txtEntrada;
    private JButton btnAdivinar;

    public PantallaJuego(JuegoAhorcadoBase juego, String modo) {
        this.juego = juego;
        configurarVentana(modo);
        inicializarComponentes();
        actualizarPantalla(); // Esto pone los "____" desde el segundo 1
    }

    private void configurarVentana(String modo) {
        setTitle("Jugando - Modo " + modo);
        setSize(500, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(30, 30, 30));
        setLocationRelativeTo(null);
    }

    private void inicializarComponentes() {
        // Figura del Ahorcado (ASCII)
        areaAhorcado = new JTextArea();
        areaAhorcado.setBounds(150, 20, 200, 150);
        areaAhorcado.setEditable(false);
        areaAhorcado.setBackground(new Color(30, 30, 30));
        areaAhorcado.setForeground(Color.CYAN);
        areaAhorcado.setFont(new Font("Monospaced", Font.BOLD, 16));
        add(areaAhorcado);

        // Palabra Secreta (Los guiones ____)
        lblPalabra = new JLabel("", SwingConstants.CENTER);
        lblPalabra.setBounds(50, 200, 400, 40);
        lblPalabra.setFont(new Font("Monospaced", Font.BOLD, 30));
        lblPalabra.setForeground(Color.WHITE);
        add(lblPalabra);

        // Intentos restantes
        lblIntentos = new JLabel("Intentos: 6");
        lblIntentos.setBounds(50, 260, 200, 30);
        lblIntentos.setForeground(new Color(231, 76, 60));
        lblIntentos.setFont(new Font("Segoe UI", Font.BOLD, 18));
        add(lblIntentos);

        // Letras usadas
        lblLetrasUsadas = new JLabel("Letras: ");
        lblLetrasUsadas.setBounds(50, 300, 400, 30);
        lblLetrasUsadas.setForeground(Color.LIGHT_GRAY);
        add(lblLetrasUsadas);

        // Entrada de texto
        txtEntrada = new JTextField();
        txtEntrada.setBounds(150, 350, 50, 40);
        txtEntrada.setFont(new Font("Segoe UI", Font.BOLD, 20));
        txtEntrada.setHorizontalAlignment(JTextField.CENTER);
        add(txtEntrada);

        // Botón Adivinar
        btnAdivinar = new JButton("ADIVINAR");
        btnAdivinar.setBounds(210, 350, 120, 40);
        btnAdivinar.setBackground(new Color(41, 128, 185));
        btnAdivinar.setForeground(Color.WHITE);
        btnAdivinar.addActionListener(e -> procesarIntento());
        add(btnAdivinar);
        
        // Permitir usar "Enter" para adivinar
        getRootPane().setDefaultButton(btnAdivinar);
    }

    private void procesarIntento() {
        String texto = txtEntrada.getText().trim().toUpperCase();
        if (texto.isEmpty()) return;

        char letra = texto.charAt(0);
        juego.jugar(letra); // Llama a tu lógica de JuegoAhorcadoFijo/Azar
        
        actualizarPantalla();
        txtEntrada.setText("");
        txtEntrada.requestFocus();

        verificarEstadoJuego();
    }

    private void actualizarPantalla() {
        lblPalabra.setText(juego.getPalabraActual()); // Muestra _ _ _ _
        lblIntentos.setText("Intentos: " + juego.getIntentos());
        lblLetrasUsadas.setText("Letras usadas: " + juego.getLetrasUsadascomoTexto());
        areaAhorcado.setText(juego.getFiguraActual());
    }

    private void verificarEstadoJuego() {
        if (juego.hasGanado()) {
            new ResultadoFinal(true, juego.getPalabraSecreta()).setVisible(true);
            this.dispose();
        } else if (juego.getIntentos() <= 0) {
            new ResultadoFinal(false, juego.getPalabraSecreta()).setVisible(true);
            this.dispose();
        }
    }
}