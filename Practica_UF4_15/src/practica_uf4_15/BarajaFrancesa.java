/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_uf4_15;

/**
 *
 * @author ausias
 */
public class BarajaFrancesa extends Baraja {

    public BarajaFrancesa() {
        super();
        this.numCartas = 52;
        this.cartasPalo = 13;
        crearBaraja();
        super.barrejar();

    }

    @Override
    public void crearBaraja() {
        this.cartas = new Carta[numCartas];
        String valorCarta;

        int pos = 0;
        String palos[] = Carta.PALS_FRANCESA;
        for (int i = 0; i < palos.length; i++) {
            for (int j = 1; j <= cartasPalo; j++) {
                cartas[pos] = new Carta(j, palos[i]);
                pos++;
            }
        }
    }
    
    public boolean vermell(Carta c){
        return c.palo.equals(Carta.PALS_FRANCESA[0]) || c.palo.equals(Carta.PALS_FRANCESA[3]);
    }
    
    public boolean negre(Carta c){
        return c.palo.equals(Carta.PALS_FRANCESA[1]) || c.palo.equals(Carta.PALS_FRANCESA[2]);
    }

}
