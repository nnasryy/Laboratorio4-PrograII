/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_prograii;


import javax.swing.JOptionPane;
/**
 *
 * @author Fabio Sierra
 */
public class JuegoAhorcadoFijo extends JuegoAhorcadoBase {
    
    public JuegoAhorcadoFijo(String palabraSecreta){
        inicializarPalabraSecreta();
    }
    
    @Override
    public void inicializarPalabraSecreta(){
        this.palabraActual="";
        for(int contador=0;contador<palabraSecreta.length();contador++){
            this.palabraActual=palabraActual+"_ ";
        }
    }
    
    @Override
    public void verificarLetra(char letra){
        try{
            letra=Character.toLowerCase(letra);
            if(!Character.isLetter(letra)){
                throw new Exception("Favor ingresar una letra valida.");
            }
            if(letrasUsadas.contains(letra)){
                JOptionPane.showMessageDialog(null, "La letra: " +letra+ " ya fue usada.");
            }
            letrasUsadas.add(letra);
            
            if(palabraSecreta.indexOf(letra)>=0){
                actualizarPalabraActual(letra);
            } else{
                intentos--;
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public boolean hasGanado(){
        return palabraActual.equals(palabraSecreta);
    }
    
    @Override
    public void actualizarPalabraActual(char letra){
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
    public void jugar() {
        inicializarPalabraSecreta();
        hasGanado();
    }
}
