package monopoli;


/**
 * Utilizzata per definire il gruppo di 2 elementi
 * costituito dalle caselle società:
 * </ul>
 * <li>acqua potabile
 * <li>elettrica
 * <p>
 * Ambedue hanno bisogno sia di essere identificate con alcuni metodi e attributi che fanno riferimento alla Classe astratta casella
 * come ad esempio la definizione di nome tipo e acquistabilità
 * ma anche dalla classe proprietà definendone il proprietario oltre che il prezzo da pagare per il transito
 * sia singole che in coppia(affitto-affitto2)
 * @param nome stringa che serve a contenere il nome della casella
 * @param tipo contiene il nome del tipo di casella
 * @param prezzo intero che definisce il valore della casella
 * @param acquistabile booleano che identifica la tipologia di casella acquistabile
 * @param affitto intero che definisce il prezzo da pagare al giocatore che possiede questa casella qualora si sia in possesso solo di una delle 2 Società
 * @param affitto2 valore di pagamento per il transito qualora il giocatore possedesse entrambe le caselle di tipo Società 
 * @param proprietario indice che determina il proprietario nella lista dei giocatori
 * @see Proprietà
 * @see Casella
 * @author La_donatac1
 *
 */
public class Società extends Proprietà {

	private String nome,tipo;
	private int prezzo;
	private boolean acquistabile;
	private int affitto,affitto2;//anche qui è per 2 se doppio
	private int proprietario;
		
	/**
	 *Costruttore che definisce le caselle società possedute in base al nome della casella
	 *al tipo e quindi Società al prezzo di vendita/acquisto al tipo di casella acquistabile al pagamento per il transito sia singolo che doppio 
	 *e all'identificazione del proprietario
	 * @param nome stringa contenente il nome della Società
	 * @param tipo stringa contenente il tipo di casella
	 * @param prezzo valore di mercato della casella
	 * @param acquistabile possibilità di essere acquistata
	 * @param affitto pagamento al transito x1
	 * @param affitto2 pagamento al transito x2
	 * @param proprietario indice del corrispondente proprietario
	 */
	public Società(String nome,String tipo,int prezzo,boolean acquistabile,int affitto,int affitto2,int proprietario){
		
		this.nome=nome;
		this.tipo=tipo;
		this.prezzo=prezzo;
		this.acquistabile=acquistabile;
		this.affitto=affitto;
		this.affitto2=affitto2;
		this.proprietario=proprietario;
				
	}
	
	/**
	 * Si occupa di ottenere l'indice corrispondente al proprietario della casella (compatibilmente col tipo di casella)	
	 * @return int l'indice del proprietario nella lista di giocatori (inizializzato a 0)
	 */
	public int getProprietario() {
		return proprietario;
	}
	
	/**
	 * Si occupa di ottenere l'indice corrispondente al proprietario della casella (compatibilmente col tipo di casella)	
	 * @return int l'indice del proprietario nella lista di giocatori (inizializzato a 0)
	 */
	public void setProprietario(int proprietario) {
		this.proprietario = proprietario;
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



	public void setAffitto(int affitto) {
		this.affitto = affitto;
	}



	public int getAffitto2() {
		return affitto2;
	}

	
}
