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
    
    public JuegoAhorcadoFijo(String palabra){
        super();
        inicializarPalabraSecreta(palabraSecreta);
        figuraAhorcado.add(
                "  +---+\n"
                + "  |   |\n"
                + "      |\n"
                + "      |\n"
                + "      |\n"
                + "      |\n"
                + "========="
        );
        figuraAhorcado.add(
                "  +---+\n"
                + "  |   |\n"
                + "  O   |\n"
                + "      |\n"
                + "      |\n"
                + "      |\n"
                + "========="
        );
        figuraAhorcado.add(
                "  +---+\n"
                + "  |   |\n"
                + "  O   |\n"
                + "  |   |\n"
                + "      |\n"
                + "      |\n"
                + "========="
        );
        figuraAhorcado.add(
                "  +---+\n"
                + "  |   |\n"
                + "  O   |\n"
                + " /|   |\n"
                + "      |\n"
                + "      |\n"
                + "========="
        );
        figuraAhorcado.add(
                "  +---+\n"
                + "  |   |\n"
                + "  O   |\n"
                + " /|\\ |\n"
                + "      |\n"
                + "      |\n"
                + "========="
        );
        figuraAhorcado.add(
                "  +---+\n"
                + "  |   |\n"
                + "  O   |\n"
                + " /|\\ |\n"
                + " /    |\n"
                + "      |\n"
                + "========="
        );
        figuraAhorcado.add(
                "  +---+\n"
                + "  |   |\n"
                + "  O   |\n"
                + " /|\\ |\n"
                + " / \\ |\n"
                + "      |\n"
                + "========="
        );
        
    }
    
    @Override
    public void inicializarPalabraSecreta(String palabraSecreta){
        this.palabraActual=palabraSecreta;
        for(int contador=0;contador<palabraSecreta.length();contador++){
            this.palabraActual=palabraActual+"_";
        }
    }
    
    @Override
    public boolean verificarLetra(char letra) {
            if(letrasUsadas.contains(letra)){
                JOptionPane.showMessageDialog(null, "La letra: " +letra+ " ya fue usada.");
            }
            letrasUsadas.add(letra);
            
            if(palabraSecreta.indexOf(letra)>=0){
                return true;
            } else{
                intentos--;
                return false;
            }
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
    public boolean hasGanado(){
        return palabraActual.equals(palabraSecreta);
    }
    
    private void actualizarFigura(){
        
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
            }else{
                JOptionPane.showMessageDialog(null, "Prediccion incorrecta");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error de entrada", JOptionPane.ERROR_MESSAGE);
        }
        
    }
}
