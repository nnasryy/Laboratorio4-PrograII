package GUI;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class ResultadoFinal extends JFrame {

    private JLabel labelDeResultado;
    private JButton btnSalir;


    public ResultadoFinal(boolean gano) {
        setTitle("Resultado Final");
        setBounds(0, 0, 450, 300); 
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        getContentPane().setBackground(new Color(35, 35, 35));

  
        labelDeResultado = new JLabel();
        labelDeResultado.setBounds(50, 50, 350, 60);
        labelDeResultado.setHorizontalAlignment(SwingConstants.CENTER);
        labelDeResultado.setFont(new Font("Segoe UI", Font.BOLD, 28));
        
        if (gano) {
            labelDeResultado.setText("¡VICTORIA!");
            labelDeResultado.setForeground(new Color(46, 204, 113));
        } else {
            labelDeResultado.setText("GAME OVER");
            labelDeResultado.setForeground(new Color(231, 76, 60)); 
        }
        add(labelDeResultado);

        btnSalir = new JButton("Finalizar Juego");
        btnSalir.setBounds(150, 160, 150, 40);
        btnSalir.setBackground(Color.WHITE);
        btnSalir.setForeground(Color.BLACK);
        btnSalir.setFocusPainted(false);
        btnSalir.setFont(new Font("Segoe UI", Font.BOLD, 14));
        

        btnSalir.addActionListener(e -> System.exit(0));
        
        add(btnSalir);

        setLocationRelativeTo(null); 
    }
}
