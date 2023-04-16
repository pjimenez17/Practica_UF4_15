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

     int numero;
     String palo;

    public static final String[] PALS_ESPANOLA = {"Espadas", "Oros", "Copas", "Bastos"};
    public static final String[] PALS_FRANCESA = {"Diamantes", "Picas", "Treboles", "Corazones"};


    public Carta(int numero, String palo) {
        this.numero = numero;
        this.palo = palo;
    }

    @Override
    public String toString() {
        String carta = "";
        String nomFigura = "";

      
            if (palo.equals(PALS_ESPANOLA[0]) || palo.equals(PALS_ESPANOLA[1]) || palo.equals(PALS_ESPANOLA[2]) || palo.equals(PALS_ESPANOLA[3])) {
                switch (numero) {
                    case 1 -> nomFigura = "As";
                    case 10 -> nomFigura = "Sota";
                    case 11 -> nomFigura = "Caballo";
                    case 12 -> nomFigura = "Rey";
                    default ->  nomFigura = numero + "";
                }
                carta = nomFigura + " de " + palo;
            }else if(palo.equals(PALS_FRANCESA[0]) || palo.equals(PALS_FRANCESA[1]) || palo.equals(PALS_FRANCESA[2]) || palo.equals(PALS_FRANCESA[3])){
                switch (numero) {
                    case 1 -> nomFigura = "A";
                    case 11 -> nomFigura = "J";
                    case 12 -> nomFigura = "Q";
                    case 13 -> nomFigura = "K";
                    default ->  nomFigura = numero + "";
                }
                carta = nomFigura + " de " + palo;
            }
        

        return carta;
    }

}
