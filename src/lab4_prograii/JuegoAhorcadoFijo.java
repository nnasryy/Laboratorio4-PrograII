/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_prograii;

/**
 *
 * @author Fabio Sierra
 */
public class JuegoAhorcadoFijo extends JuegoAhorcadoBase {
    
    public JuegoAhorcadoFijo(String palabraSecreta){
        super(palabraSecreta);
        inicializarPalabraSecreta();
    }
    

    public void iniciarPalabraSecreta(){
        this.palabraActual="";
        for(int contador=0;contador<palabraSecreta.length();contador++){
            
        }
    }
    
    
    public void verificarLetra(){
        
    }
    
    @Override
    public boolean hasGanado(){
        
    }
    
    public void actualizarPalabraActual(){
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
    public void actualizarPalabraActual(char letra) {
        
    }

    @Override
    public void verificarLetra(char letra) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void inicializarPalabraSecreta() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void jugar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
