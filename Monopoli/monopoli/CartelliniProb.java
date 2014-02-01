package monopoli;
/**
 * Questa è la classe public che identifica nella struttura di gioco i quattro cartellini delle probabilità
 * Ogni cartellino è identificato da una stringa di tipo private in quanto usata solo all'interno di questa classe
 
 * @author La_donatac1
 */


public class CartelliniProb {
	
	private String cart1="Ereditate da un lontano parente 10000",cart2="Pagate una multa di 1000 o prendete un cartoncino Imprevisti",cart3="Uscite gratis di prigione",cart4="Avete vinto il secondo premio ad un concorso di bellezza e ritirate 1000";
	
	
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
