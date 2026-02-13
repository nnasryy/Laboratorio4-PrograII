/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab4_prograii;

import java.util.ArrayList;

/**
 *
 * @author emyca
 */
public abstract class JuegoAhorcadoBase implements JuegoAhorcado{
    protected String palabraSecreta;
    protected String palabraActual;
    protected int intentos;
    protected int limiteIntentos;
    protected ArrayList<Character> letrasUsadas;
    protected ArrayList<String> figuraAhorcado;
    
    JuegoAhorcadoBase(){
        limiteIntentos=6;
        intentos=6;
        figuraAhorcado= new ArrayList<>();
        letrasUsadas= new ArrayList();
        palabraActual="";
        palabraSecreta="";
    }
    
    public abstract void actualizarPalabraActual(char letra);
    public abstract boolean verificarLetra(char letra);
    public abstract boolean hasGanado();
    
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
   
}
