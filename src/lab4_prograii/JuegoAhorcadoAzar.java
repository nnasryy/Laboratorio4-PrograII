/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4_prograii;

import javax.swing.JOptionPane;

/**
 *
 * @author emyca
 */
public class JuegoAhorcadoAzar extends JuegoAhorcadoBase{
    
    JuegoAhorcadoAzar(String palabraSecreta){
        super();
        inicializarPalabraSecreta(palabraSecreta);
    }
    
    @Override
    public void inicializarPalabraSecreta(String palabraSecreta) {
       this.palabraSecreta=palabraSecreta;
       palabraActual="";
        for(int contador=0;contador<palabraSecreta.length();contador++){
            this.palabraActual=palabraActual+"_ ";
        }
    }
    
    @Override
    public void jugar(char letra) {
        try{
            letra=Character.toLowerCase(letra);
            if(!Character.isLetter(letra)){
                throw new Exception("Favor ingresar una letra valida.");
            }
            if(verificarLetra(letra)){
                JOptionPane.showMessageDialog(null, "Prediccion correcta");
                actualizarPalabraActual(letra);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
        
    }
    
    @Override
    public void actualizarPalabraActual(char letra) {
        String nuevaPalabra="";
        for(int contador=0; contador<palabraSecreta.length(); contador++){
           if(palabraSecreta.charAt(contador)==letra){
               nuevaPalabra=nuevaPalabra+letra;
           } else{
               nuevaPalabra=nuevaPalabra+palabraActual.charAt(contador);
           }
        }
        palabraActual=nuevaPalabra; 
    }

    @Override
    public boolean verificarLetra(char letra) {
            if(letrasUsadas.contains(letra)){
                JOptionPane.showMessageDialog(null, "La letra: " +letra+ " ya fue usada.");
                return false;
            }
            letrasUsadas.add(letra);
            
            if(palabraSecreta.indexOf(letra)>=0){
                return true;
            } else{
                JOptionPane.showMessageDialog(null, "Prediccion incorrecta");
                intentos--;
                return false;
            }
    }

    @Override
    public boolean hasGanado() {
        return palabraActual.equals(palabraSecreta);
    }
    
    
}
