package GUI;

import java.awt.*;
import javax.swing.*;

public class ResultadoFinal extends JFrame {

    private JLabel labelDeResultado, lblRevelarPalabra;
    private JButton btnSalir, btnReiniciar;

    public ResultadoFinal(boolean gano, String palabraCorrecta) {
        setTitle("Resultado Final");
        setSize(450, 350); // Un poco más alta para que quepan los dos botones
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(35, 35, 35));

        // Etiqueta de Victoria o Derrota
        labelDeResultado = new JLabel();
        labelDeResultado.setBounds(50, 40, 350, 60);
        labelDeResultado.setHorizontalAlignment(SwingConstants.CENTER);
        labelDeResultado.setFont(new Font("Segoe UI", Font.BOLD, 36));
        
        if (gano) {
            labelDeResultado.setText("¡VICTORIA!");
            labelDeResultado.setForeground(new Color(46, 204, 113)); // Verde Esmeralda
        } else {
            labelDeResultado.setText("GAME OVER");
            labelDeResultado.setForeground(new Color(231, 76, 60)); // Rojo Alizarin
        }
        add(labelDeResultado);

        // Subtítulo para mostrar la palabra que era
        lblRevelarPalabra = new JLabel("La palabra era: " + palabraCorrecta.toUpperCase());
        lblRevelarPalabra.setBounds(50, 110, 350, 30);
        lblRevelarPalabra.setHorizontalAlignment(SwingConstants.CENTER);
        lblRevelarPalabra.setForeground(Color.LIGHT_GRAY);
        lblRevelarPalabra.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        add(lblRevelarPalabra);

        // Botón Volver al Menú (Reiniciar)
        btnReiniciar = new JButton("Volver a Jugar");
        btnReiniciar.setBounds(125, 170, 200, 45);
        estilizarBoton(btnReiniciar, new Color(41, 128, 185)); // Azul
        btnReiniciar.addActionListener(e -> {
            new MenuModalidad().setVisible(true);
            this.dispose();
        });
        add(btnReiniciar);

        // Botón Salir
        btnSalir = new JButton("Salir del Juego");
        btnSalir.setBounds(125, 230, 200, 45);
        estilizarBoton(btnSalir, new Color(149, 165, 166)); // Gris
        btnSalir.addActionListener(e -> System.exit(0));
        add(btnSalir);

        setLocationRelativeTo(null); 
    }

    private void estilizarBoton(JButton btn, Color color) {
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFont(new Font("Segoe UI", Font.BOLD, 14));
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createEmptyBorder());
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }
}