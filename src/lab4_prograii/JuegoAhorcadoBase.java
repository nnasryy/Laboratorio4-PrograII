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
    
    JuegoAhorcadoBase(String palabraSecreta){
        limiteIntentos=6;
        intentos=6;
        figuraAhorcado= new ArrayList<>();
        letrasUsadas= new ArrayList();
        palabraActual="";
        this.palabraSecreta=palabraSecreta;
    }
    
    public abstract void actualizarPalabraActual(char letra);
    public abstract void verificarLetra(char letra);
    public abstract boolean hasGanado();
}
