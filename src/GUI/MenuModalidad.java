package GUI;

import java.awt.*;
import javax.swing.*;
import lab4_prograii.AdminPalabrasSecretas;
import lab4_prograii.JuegoAhorcadoAzar;
import lab4_prograii.JuegoAhorcadoFijo;

public class MenuModalidad extends JFrame {

    private JButton btnFijo, btnAzar, btnSalir;
    private JLabel lblTitulo, lblseleccionar;

    public MenuModalidad() {

        setTitle("Menú Principal");
        setBounds(0, 0, 580, 350);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(35, 35, 35));

        iniciarLabel();
        seleccionarLabel();
        iniciarBotonFijo();
        iniciarBotonAzar();
        iniciarBotonSalir();

        setVisible(true);
        setLocationRelativeTo(null);
    }

    private void iniciarLabel() {
        lblTitulo = new JLabel("AHORCADO", SwingConstants.CENTER);

        lblTitulo.setBounds(90, 50, 400, 40);
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 30));
        add(lblTitulo);
    }

    private void seleccionarLabel() {
        lblseleccionar = new JLabel("Selecciona la modalidad: ");
        lblseleccionar.setBounds(150, 100, 350, 40);
        lblseleccionar.setForeground(Color.WHITE);
        lblseleccionar.setFont(new Font("Segoe UI", Font.BOLD, 22));
        add(lblseleccionar);

    }

    private void iniciarBotonFijo() {
        btnFijo = new JButton("Ahorcado Fijo");
        btnFijo.setBounds(50, 180, 150, 50);
        estilizarBoton(btnFijo, new Color(41, 128, 185));

        btnFijo.addActionListener(e -> {
            JuegoAhorcadoFijo juego = new JuegoAhorcadoFijo("arroz");
            new PantallaJuego(juego, "Fijo");
            dispose();
        });

        add(btnFijo);
    }

    private void iniciarBotonAzar() {
        AdminPalabrasSecretas palabrasecreta = new AdminPalabrasSecretas();
        btnAzar = new JButton("Ahorcado Azar");
        btnAzar.setBounds(215, 180, 150, 50);
        estilizarBoton(btnAzar, new Color(39, 174, 96));

        btnAzar.addActionListener(e -> {

        });
        add(btnAzar);
    }

    private void iniciarBotonSalir() {
        btnSalir = new JButton("Salir");
        btnSalir.setBounds(380, 180, 150, 50);
        estilizarBoton(btnSalir, new Color(192, 57, 43));

        btnSalir.addActionListener(e -> System.exit(0));
        add(btnSalir);
    }

    private void estilizarBoton(JButton btn, Color color) {
        btn.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btn.setBackground(color);
        btn.setForeground(Color.WHITE);
        btn.setFocusPainted(false);
        btn.setBorder(BorderFactory.createLineBorder(color.brighter()));
    }

}
