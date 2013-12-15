package monopoli;


/**
 * La classe CartelliniImp rappresenta i cartellini imprevisti
 * Ogni cartellino è identificato da una stringa
 * @author La_donatac1
 */


public class CartelliniImp {
	

	private String cart1="Andate in prigione direttamente senza passare dal Via",cart2="Uscite gratis di prigione",cart3="Avete vinto un terno al lotto ritirate 10000",cart4="Fate tre passi indietro(con tanti auguri)";
	
	
	/**
	 * Questo metodo viene utilizzato per stampare a video uno dei quattro cartellini della classe CartelliniImp
	 * I suoi attributi sono quattro stringhe:
	 * <p>
	 * <li> cart1
	 * <li> cart2
	 * <li> cart3
	 * <li> cart4
	 * @param n variabile di tipo intero che viene passata al metodo per effettuare la scelta del cartellino da stampare a video 
	 */	
	
	
	public void azioneCartellino(int n){
		
		switch(n){
		case 1:System.out.println(cart1);break;
		case 2:System.out.println(cart2);break;
		case 3:System.out.println(cart3);break;
		       
		      
		case 4:System.out.println(cart4);break;
		}
	}
	
}
