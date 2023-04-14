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
        super.barrejar();

    }

    @Override
    public void crearBaraja() {
        this.cartas = new Carta[numCartas];
        String valorCarta = "";

        String palos[] = Carta.PALS_ESPANOLA;
        for (int i = 0; i < cartasPalo; i++) {
            for (int j = 1; j <= numCartas; j++) {
                if (!(j == 8 || j == 9)) {
                    if (j > 9) {
                        if (j == 10) {
                            valorCarta = "Sota";
                        } else if (j == 11) {
                            valorCarta = "Caballo";
                        } else if (j == 12) {
                            valorCarta = "Rey";
                        }
                        cartas[((i * cartasPalo) + j)] = new Carta(valorCarta, palos[i]);
                    } else {
                        if (j == 1) {
                            valorCarta = "As";
                        } else {
                            valorCarta = String.valueOf(j);
                        }
                        cartas[((i * cartasPalo-2) + j)] = new Carta(valorCarta, palos[i]);
                    }
                }

            }
        }
    }

}
