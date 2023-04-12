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

public class Baraja {

    private final int NUM_CARTES = 48;
    private final int NUM_PALS = 4;


    private Carta[] cartas;
    private int posSiguienteCarta;

    public Baraja() {
        cartas = new Carta[NUM_CARTES];
        posSiguienteCarta = 0;
        crearBaraja();
    }

    private void crearBaraja() {
        int pos = 0;
        String palos[] = Carta.PALS;
        for (int i = 0; i < NUM_PALS; i++) {
            for (int j = 1; j <= Carta.MAX_NUM_CARTA; j++) {
                cartas[pos] = new Carta(j, palos[i]);
                pos++;
            }
        }
    }

    public void barrejar() {
        Random rnd = new Random();

        int posicioAleatoria = 0;
        Carta c;

        for (int i = 0; i < 10; i++) {
            posicioAleatoria = rnd.nextInt(0, NUM_CARTES - 1);

            c = cartas[i];
            cartas[i] = cartas[posicioAleatoria];
            cartas[posicioAleatoria] = c;
        }

    }

    public Carta seguentCarta() {
        Carta carta = null;
        if (posSiguienteCarta == NUM_CARTES) {
            System.out.println("No hay mes cartes en la baralla.");
        } else {
            carta = cartas[posSiguienteCarta];
            posSiguienteCarta++;
        }
        return carta;
    }

    public int cartesDisponibles() {
        return NUM_CARTES - posSiguienteCarta;
    }

    public Carta[] demanarCarta(int numCartes) {
        Carta[] cartasDemanades = null;
        if (cartesDisponibles() >= numCartes) {
            cartasDemanades = new Carta[numCartes];
            for (int i = 0; i < numCartes; i++) {
                cartasDemanades[i] = seguentCarta();
                System.out.println(cartasDemanades[i]);
            }
        }else if(numCartes > NUM_CARTES){
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
