
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
        Baraja b = null;
        boolean sortir = false;
        
        do{
            System.out.println("1. Baralla Española \n2. Baralla Francesa");
            int opcioBaralla = Utils.LlegirInt("Selecciona una opcio: ");
            
            switch(opcioBaralla){
                case 1 ->{
                     b = new BarajaEspanola();
                    sortir = true;
                }case 2 ->{
                    b = new BarajaFrancesa();
                    sortir = true;
                }default ->{
                    System.out.println("ERROR");
                }
            }
        
        }while(!sortir);
        
        sortir = false;
        
        do{
            System.out.println("1. Següent carta \n2. Cartes disponibles \n3. Demanar cartes \n4. Repartir Cartes \n5. Veure Munt");
            int opcio = Utils.LlegirInt("Selecciona una opció: ");
            
            switch(opcio){
                case 1 ->{
                    System.out.println(b.seguentCarta());
                }
                case 2 ->{
                    System.out.println(b.cartesDisponibles());                    
                }
                case 3 ->{
                    int numCartes = Utils.LlegirInt("Quantes cartes vols: ");                  
                    System.out.println(b.demanarCarta(numCartes));
                    
                }
                case 4 ->{
                    int numCartes = Utils.LlegirInt("Quantes cartes vols: ");
                    b.repartirCartes(numCartes);
                }
                case 5 ->{
                    b.veureMunt();                    
                }
                case 6 ->{
                    sortir = true;                    
                }
                default ->{
                    System.out.println("ERROR, TORNA A INTENTAR-HO ");
                }
            }       
        }while(!sortir);
        
        
    }
    
}
