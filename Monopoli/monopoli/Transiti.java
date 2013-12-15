package monopoli;

/**
 * Rappresenta il tipo di casella che comporta transiti passivi
 * senza oneri aggiunti
 * @param nome  definisce il nome della casella
 * @param tipo definisce il tipo di casella
 * @param acquistabile se la casella � di tipo acquistabile
 * @author La_donatac1
 */

public class Transiti extends Casella {

	private String nome,tipo;
	private boolean acquistabile;
	/**
	 * Il costruttore consente di inizializzare i parametri che definiscono la casella
	 * @param nome definisce il nome
	 * @param tipo definisce il tipo della casella
	 * @param acquistabile se si pu� comprare da parte di un giocatore(non in questo caso)
	 */
	public Transiti(String nome,String tipo,boolean acquistabile){
		
		this.nome=nome;
		this.tipo=tipo;
		this.acquistabile=acquistabile;
		
	}
	
	/**
	 * Definisce la possibilit� di 
	 * effettuare l'acquisto di una casella da parte di un giocatore
	 * <p>
	 * Ha come parametro implicito l'oggetto cui appartiene di tipo Casella
	 * @return <code>true</code> (1)se la casella su cui viene
	 * invocato il metodo � acquistabile
	 *         <code>false</code> (0)se la casella non si pu� acquistare 
	 */
	
	public boolean isAcquistabile() {
		return acquistabile;
	}


	/**
	 * Fa riferimento all'oggetto di tipo Casella
	 * non riceve ingressi e restituisce come uscita la stringa corrispondente
	 * al nome della casella che lo invoca
	 * @return String una stringa contenente il nome 
	 * inizializzata a null
	 */
	public String getNome() {
		return nome;
	}


	/**
	 * Identifica la tipologia di casella che pu� 
	 * essere di tipo:
	 * </ul> 
	 * <li>Terreno 
	 * <li>Transito  
	 * <li>Prigione
	 * <li>Imprevisti
	 * <li>Probabilit�
	 * <li>Societ�
	 * <li>Stazioni
	 * @return String che identifica il nome del tipo inizializzata a null
	 */
	public String getTipo() {
		return tipo;
	}
}
