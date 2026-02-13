package GUI;

import javax.swing.*;
import java.awt.*;
import lab4_prograii.JuegoAhorcadoBase;

public class PantallaJuego extends JFrame {

    private JuegoAhorcadoBase juego;

    private JLabel lblPalabra;
    private JLabel lblIntentos;
    private JLabel lblFigura;
    private JLabel lblUsadas;

    private JTextField txtLetra;
    private JButton btnProbar;

    // ================= CONSTRUCTOR =================
    public PantallaJuego(JuegoAhorcadoBase juego, String palabraInicial) {
        this.juego = juego;
        juego.inicializarPalabraSecreta(palabraInicial);

        setTitle("Juego del Ahorcado");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(null);

        inicializarComponentes();
        actualizarPantalla();

        setVisible(true);
    }

    // ================= COMPONENTES =================
    private void inicializarComponentes() {

        lblPalabra = new JLabel();
        lblPalabra.setFont(new Font("Arial", Font.BOLD, 26));
        lblPalabra.setBounds(50, 40, 400, 40);
        add(lblPalabra);

        lblIntentos = new JLabel();
        lblIntentos.setBounds(50, 90, 300, 25);
        add(lblIntentos);

        lblFigura = new JLabel();
        lblFigura.setFont(new Font("Monospaced", Font.BOLD, 22));
        lblFigura.setBounds(50, 130, 200, 150);
        add(lblFigura);

        lblUsadas = new JLabel();
        lblUsadas.setBounds(50, 290, 400, 25);
        add(lblUsadas);

        txtLetra = new JTextField();
        txtLetra.setBounds(50, 330, 50, 30);
        add(txtLetra);

        btnProbar = new JButton("Probar");
        btnProbar.setBounds(120, 330, 100, 30);
        add(btnProbar);

        btnProbar.addActionListener(e -> procesarLetra());
    }

    // ================= LÓGICA GUI =================
    private void procesarLetra() {

        String entrada = txtLetra.getText().toLowerCase();

        if (entrada.isEmpty() || entrada.length() != 1 || !Character.isLetter(entrada.charAt(0))) {
            JOptionPane.showMessageDialog(this, "Ingrese UNA letra válida.");
            txtLetra.setText("");
            return;
        }

        char letra = entrada.charAt(0);
        juego.jugar(letra);
        txtLetra.setText("");

        actualizarPantalla();
        verificarEstado();
    }

    private void actualizarPantalla() {
        lblPalabra.setText(juego.getPalabraActual());
        lblIntentos.setText("Intentos restantes: " + juego.getIntentos());
        lblFigura.setText("<html>" + juego.getFiguraActual().replace("\n", "<br>") + "</html>");
        lblUsadas.setText("Letras usadas: " + juego.getLetrasUsadascomoTexto());
    }

    private void verificarEstado() {

        if (juego.hasGanado()) {
            JOptionPane.showMessageDialog(this, "¡Ganaste!");
            dispose();
        }

        if (juego.getIntentos() == 0) {
            JOptionPane.showMessageDialog(this,
                    "Perdiste\nLa palabra era: " + juego.getPalabraSecreta());
            dispose();
        }
    }
}
