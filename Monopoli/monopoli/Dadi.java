package monopoli;
import java.util.Random;

/**
 * Questa classe ha lo scopo di identificare l'azione del 
 * lancio dadi
 * @author La_donatac1
 */
public class Dadi {

	/**
	 * Il metodo lancio_dadi esegue il random tra sei numeri e ne 
	 * determina uno che rappresenta il valore del lancio di un dado
	 * a sei facce
	 * <p>
	 * Viene quindi generato il costruttore dell'oggetto Random
	 * già predefinito da Java
	 * @return x il numero intero scelto
	 */	
	public int lancio_dadi(){
		
          Random r=new Random();
		
		  int x=1+r.nextInt(6);
		  
		  return x;
	}
	
	
	
	
	
}
