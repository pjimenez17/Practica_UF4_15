/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_uf4_15;

/**
 *
 * @author ausias
 */
public class BarajaEspanola extends Baraja {

    public BarajaEspanola() {
        super();
        this.numCartas = 40;
        this.cartasPalo = 10;
        crearBaraja();
        //super.barrejar();

    }

    @Override
    public void crearBaraja() {
        this.cartas = new Carta[numCartas];

        String palos[] = Carta.PALS_ESPANOLA;

        for (int i = 0; i < palos.length; i++) {

            for (int j = 0; j < cartasPalo; j++) {

                if (j >= 7) {
                    cartas[((i * cartasPalo) + j)] = new Carta(j + 3, palos[i]);
                } else {
                    cartas[((i * cartasPalo) + j)] = new Carta(j + 1, palos[i]);
                }
            }

        }
    }
}
