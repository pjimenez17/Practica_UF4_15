
package practica_uf4_15;
import utils.Utils;
/**
 *
 * @author Pablo Jiménez
 */
public class Practica_UF4_15 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Baraja b = new Baraja();
        
        
        boolean sortir = false;
        
        do{
            System.out.println("1. Barrejar cartes \n 2. Següent carta \n 3. Cartes disponibles \n 4. Demanar cartes \n 5. Repartir Cartes \n 6. Veure Munt");
            int opcio = Utils.LlegirInt("Selecciona una opció: ");
            
            switch(opcio){
                case 1 ->{
                    b.barrejar();
                    System.out.println("Cartas Barallades \n");
                }
                case 2 ->{
                    System.out.println(b.seguentCarta());
                    
                }
                case 3 ->{
                    System.out.println(b.cartesDisponibles());
                    
                }
                case 4 ->{
                    int numCartes = Utils.LlegirInt("Quantes cartes vols: ");
                   
                    System.out.println(b.demanarCarta(numCartes));
                }
                case 5 ->{
                    int numCartes = Utils.LlegirInt("Quantes cartes vols: ");
                    b.repartirCartes(numCartes);
                    
                }
                case 6 ->{
                    
                    b.veureMunt();
                }
                case 7 ->{
                    sortir = true;
                }
                default ->{
                    System.out.println("ERROR, TORNA A INTENTAR-HO ");
                }
            }       
        }while(!sortir);
        
        
    }
    
}
