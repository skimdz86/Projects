package monopoli;

/**
 * Stazione definisce tutte le caratteristiche di questo tipo di casella
 * <p>
 * Come le altre tipologie di casella essa è identificata da:
 * </ul>
 * <li>un nome
 * <li>il tipo cioè casella di tipo Stazione
 * <li>da un prezzo di acquisto
 * <li>la possibilità di acquistarla
 * <li>il pagamento del transito per il possesso di una sola stazione
 * <li>il pagamento per il transito con tutte e 4 le stazioni
 * <li>il proprietario che ne è in possesso
 * @see Proprietà
 * @see Casella
 * @author La_donatac1
 *
 */
public class Stazione extends Proprietà {

	private String nome,tipo;
	private int prezzo;
	private boolean acquistabile;
	private int affitto,affitto2;//per 4 se le hai tutte
	private int proprietario;
		
	/**
	 * Il costruttore asegna a caselle di tipo Stazione i suoi parametri chiave ossia:
	 * </ul>
	 * <li>nome
	 * <li>tipo
	 * <li>prezzo
	 * <li>prezzo
	 * <li>acquistabilità
	 * <li> affitto x1
	 * <li>affitto x4
	 * <li>giocatore proprietario
	 * @param nome definisce il nome della stazione
	 * @param tipo definisce il tipo di casella
	 * @param prezzo definisce il prezzo di acquisto
	 * @param acquistabile definisce se la casella è di tipo acquistabile
	 * @param affitto definisce il prezzo da pagare al transito se si dispone di 1 stazione
	 * @param affitto2 definisce il prezzo da pagare al transito se si dispone di 4 stazioni
	 * @param proprietario definisce il giocatore proprietario
	 */
	public Stazione(String nome,String tipo,int prezzo,boolean acquistabile,int affitto,int affitto2,int proprietario){
		
		this.nome=nome;
		this.tipo=tipo;
		this.prezzo=prezzo;
		this.acquistabile=acquistabile;
		this.affitto=affitto;
		this.affitto2=affitto2;
		this.proprietario=proprietario;
		
		
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
	 * Si occupa di ottenere l'indice corrispondente al proprietario della casella (compatibilmente col tipo di casella)	
	 * @return int l'indice del proprietario nella lista di giocatori (inizializzato a 0)
	 */	
	public int getProprietario() {
		return proprietario;
	}

	/**
	 * Associa come proprietario della casella il giocatore della lista con l'indice corrispondente
	 * @param proprietario intero che corrisponde all'indice del giocatore
	 */
	public void setProprietario(int proprietario) {
		this.proprietario = proprietario;
	}

	/**
	 * Ha lo scopo di ottenere il prezzo che deve pagare un giocatore
	 * in transito su una casella di proprietà di un'altro giocatore
	 * @return intero che definisce il prezzo da pagare al proprietario
	 */
	public int getAffitto() {
		return affitto;
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
	 * Consente di ottenere il valore del prezzo di una casella
	 * posseduta da un giocatore
	 * @return int intero col valore corrispondente (in euro) 
	 * 
	 */
	public int getPrezzo() {
		return prezzo;
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

	/**
	 * Assegna il costo in denaro per chi transita su una casella di tipo Stazione al proprietario di una di esse
	 * @param affitto detiene l'informazione di quanto occorre pagare
	 */
	public void setAffitto(int affitto) {
		this.affitto = affitto;
	}
	
/**
 * Definisce la quota di pagamento per chi transita su una casella di tipo Stazione nel caso in cui il proprietario detiene tutte e quattro le stazioni
 * @return affitto2 che è l'intero che definisce quanto occorre pagare per il transito di un giocatore quando il proprietario possiede tutte le stazioni
 */
	public int getAffitto2() {
		return affitto2;
	}

	
	
}
