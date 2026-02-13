/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_prograii;


import java.util.ArrayList;
import javax.swing.JOptionPane;
/**
 *
 * @author Fabio Sierra
 */
public class JuegoAhorcadoFijo extends JuegoAhorcadoBase {
    
    public JuegoAhorcadoFijo(String palabra){
        super();
        this.palabraSecreta=palabra.toLowerCase();
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
                  "+---+  \n"
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
        inicializarPalabraSecreta(this.palabraSecreta);
    }
    
    @Override
    public void inicializarPalabraSecreta(String palabraSecreta){
        this.palabraActual=palabraSecreta;
        this.palabraActual="";
        for(int contador=0;contador<palabraSecreta.length();contador++){
            this.palabraActual=palabraActual+"_";
        }
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

    public String getPalabraSecreta() {
        return palabraSecreta;
    }

    public String getPalabraActual() {
        String resultado = "";
        for (char c : palabraActual.toCharArray()) {
            resultado += c + " ";
        }
        return resultado;
    }

    public int getIntentos() {
        return intentos;
    }

    public String getLetrasUsadascomoTexto() {
        String texto = "";
        for (char c : letrasUsadas) {
            texto += c + " ";
        }
        return texto;
    }

    public String getFiguraActual() {
         int indice = limiteIntentos - intentos;
        if (indice >= 0 && indice < figuraAhorcado.size()) {
            return figuraAhorcado.get(indice);
        }
        return "";
    }
    
    @Override
    public boolean hasGanado(){
        return palabraActual.equals(palabraSecreta);
    }
    
    public void actualizarFigura(){
        int indice=limiteIntentos-intentos-1;
        if(indice>=0 && indice<figuraAhorcado.size()){
            String parte=figuraAhorcado.get(indice);
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
}
