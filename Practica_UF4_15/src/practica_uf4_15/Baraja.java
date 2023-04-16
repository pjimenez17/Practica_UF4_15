/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package practica_uf4_15;

/**
 *
 * @author Pablo Jiménez
 */
import java.util.Random;

public abstract class Baraja {

    Carta[] cartas;
     int posSiguienteCarta;
     int numCartas;
     int cartasPalo;

    public Baraja() {
        this.posSiguienteCarta = 0;

    }

    /*private void crearBaraja() {
        int pos = 0;
        String palos[] = Carta.PALS;
        for (int i = 0; i < NUM_PALS; i++) {
            for (int j = 1; j <= Carta.MAX_NUM_CARTA; j++) {
                cartas[pos] = new Carta(j, palos[i]);
                pos++;
            }
        }
    }*/
    public abstract void crearBaraja();

    public void barrejar() {
        Random rnd = new Random();

        int posicioAleatoria = 0;
        Carta c;

        for (int i = 0; i < cartas.length; i++) {
            posicioAleatoria = rnd.nextInt(0, numCartas - 1);

            c = cartas[i];
            cartas[i] = cartas[posicioAleatoria];
            cartas[posicioAleatoria] = c;
        }

    }

    public Carta seguentCarta() {
        Carta carta = null;
        if (posSiguienteCarta == numCartas) {
            System.out.println("No hay mes cartes en la baralla.");
        } else {
            carta = cartas[posSiguienteCarta];
            posSiguienteCarta++;
        }
        return carta;
    }

    public int cartesDisponibles() {
        return numCartas - posSiguienteCarta;
    }

    public Carta[] demanarCarta(int numCartes) {
        Carta[] cartasDemanades = null;
        if (cartesDisponibles() >= numCartes) {
            cartasDemanades = new Carta[numCartes];
            for (int i = 0; i < numCartes; i++) {
                cartasDemanades[i] = seguentCarta();
                System.out.println(cartasDemanades[i]);
            }
        } else if (numCartes > numCartas) {
            System.out.println("ERROR");
        } else {
            System.out.println("No hi ha suficients cartes en la baralla.");
        }
        return cartasDemanades;
    }

    public void repartirCartes(int numCartes) {
        if (cartesDisponibles() >= numCartes) {
            for (int i = 0; i < numCartes; i++) {
                seguentCarta();
            }
        } else {
            System.out.println("No hi ha suficients cartes en la baralla.");
        }
    }

    public void veureMunt() {
        System.out.println("Cartas ja usades:");
        for (int i = 0; i < posSiguienteCarta; i++) {
            System.out.println(cartas[i]);
        }
    }
}
