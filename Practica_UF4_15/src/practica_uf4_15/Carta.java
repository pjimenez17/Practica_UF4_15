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

    private String numero;
    private String palo;

    public static final String[] PALS_ESPANOLA = {"Espadas", "Oros", "Copas", "Bastos"};
    public static final String[] PALS_FRANCESA = {"Diamantes", "Picas", "Treboles", "Corazones"};
    public static final int MAX_NUM_CARTA = 12;
    
    
    public Carta(String numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }
    
    @Override
    public String toString(){
        return numero + " de " + palo;
    }

  

}
