/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4_prograii;

/**
 *
 * @author emyca
 */
public class JuegoAhorcadoAzar extends JuegoAhorcadoBase{
    private String palabraSecretaAzar;
    
    JuegoAhorcadoAzar(String palabraSecreta){
        super();
        this.palabraSecretaAzar=palabraSecreta;
        inicializarPalabraSecreta();
    }
    
    @Override
    public void inicializarPalabraSecreta() {
       super.palabraSecreta=palabraSecretaAzar;
    }
    
    @Override
    public void jugar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    @Override
    public void actualizarPalabraActual(char letra) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void verificarLetra(char letra) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean hasGanado() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
}
