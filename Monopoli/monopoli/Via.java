package monopoli;

/**
 * Rappresenta la casella di partenza che viene definita con gli attributi di casella principali:
 * @param
 * </ul>
 * <li>acquistabile true se si può comprare(in questo caso false)
 * <li>nome che definisce il nome della casella
 * <li>tipo definisce il tipo di casella
 * @see Casella
 * @author La_donatac1
 */
public class Via extends Casella {

	private boolean acquistabile;
	private String nome,tipo;
	/**
	 * Costruttore che inizializza questa casella con nome tipo acquistabile
	 * @param nome definisce il nome
	 * @param tipo definisce che tipo di casella è
	 * @param acquistabile true se si può comprare (in questo caso false)
	 */
	public Via(String nome,String tipo,boolean acquistabile){
		
		this.nome=nome;
		this.tipo=tipo;
		this.acquistabile=acquistabile;
		
	}
	
	/**
	 * Definisce la possibilità di 
	 * effettuare l'acquisto di una casella da parte di un giocatore
	 * <p>
	 * Ha come parametro implicito l'oggetto cui appartiene di tipo Casella
	 * @return <code>true</code> (1)se la casella su cui viene
	 * invocato il metodo è acquistabile
	 *         <code>false</code> (0)se la casella non si può acquistare 
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
	 * Identifica la tipologia di casella che può 
	 * essere di tipo:
	 * </ul> 
	 * <li>Terreno 
	 * <li>Transito  
	 * <li>Prigione
	 * <li>Imprevisti
	 * <li>Probabilità
	 * <li>Società
	 * <li>Stazioni
	 * @return String che identifica il nome del tipo inizializzata a null
	 */
	public String getTipo() {
		return tipo;
	}
	
}
