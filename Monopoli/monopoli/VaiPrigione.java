package monopoli;

/**
 * Definisce la tipologia di casella che impone il transito forzato nella 
 * nella prigione
 * <p>
 * E' definita dalle caratteristiche di ogni casella:
 * @param
 * </ul>
 * <li>nome contiene il nome della casella
 * <li>tipo definisce il tipo di casella
 * <li>acquistabile definisce se la casella si pu� comprare o no
 * @see Casella
 * @author La_donatac1
 *
 */
public class VaiPrigione extends Casella {

	private String nome,tipo;
	private boolean acquistabile;
	
	/**
	 * Inizializza gli attributi fondamentali della casella Vai in prigione
	 * @param nome definisce il nome
	 * @param tipo definisce che tipo di casella �
	 * @param acquistabile se si pu� comprare (true)
	 */
	public VaiPrigione(String nome,String tipo,boolean acquistabile){
		
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
