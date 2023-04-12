/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_uf4_15;

/**
 *
 * @author Pablo Jiménez
 */
public class Carta {

    private int numero;
    private String palo;

    public static final String[] PALS = {"Espadas", "Oros", "Copas", "Bastos"};
    public static final int MAX_NUM_CARTA = 12; 

    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }
    
    @Override
    public String toString(){
        return numero + " de " + palo;
    }

  

}
