package monopoli;

/**
 * Serve a costruire le caselle di tipo terreno con tutte le loro caratteristiche
 * @param
 * <li>nome che definisce il nome
 * <li>tipo che identifica la stazione in questo caso
 * <li>prezzo di acquisto della casella
 * <li> colore che identifica i diversi gruppi di terreno
 * <li>acquistabile se  la casella è acquistabile
 * <li>affitto: il pagamento di transito x1
 * <li>affitto2: il pagamento di transito x2 o x3 a secnda dei gruppi di terreni
 * <li>proprietario: l'indice del proprietario
 * <li>numCase-numAlberghi: il numero di case o alberghi
 * @see Proprietà
 * @see Casella
 * @author La_donatac1
 */
public class Terreno extends Proprietà {

	
	private String nome,tipo;
	private int prezzo;
	private String colore;
	private boolean acquistabile;
	private int affitto,affitto2;//l'affitto per colore è x2, l'affitto con case è +10 per casa, +30 per albergo
	private int proprietario;
	private int numCase,numAlberghi;
	
	/**
	 * Inizializza tutte le caselle di tipo terreno con i seguenti attributi:
	 * @param nome nome della casella stazione
	 * @param tipo di casella 
	 * @param prezzo di acquisto della casella
	 * @param colore dei terreni dellostesso tipo
	 * @param acquistabile possibilità di acquistare la casella terreno
	 * @param affitto il pagamento al transito se si possiede 1 terreno
	 * @param affitto2 il pagamento al transito se si possiedono tutti i terreni dello stesso colore(2 o 3)
	 * @param proprietario chi è il giocatore in possesso dei terreni
	 * @param numCase numero di case edificate
	 * @param numAlberghi numero di alberghi edificati
	 */
	public Terreno(String nome,String tipo,int prezzo,String colore,boolean acquistabile,int affitto,int affitto2,int proprietario,int numCase,int numAlberghi){
		/*INSERIRE COME DATI IL NUMERO DI CASE E ALBERGHI PRESENTE + getters*/
		this.nome=nome;
		this.tipo=tipo;
		this.prezzo=prezzo;
		this.colore=colore;
		this.acquistabile=acquistabile;
		this.affitto=affitto;
		this.affitto2=affitto2;
		this.proprietario=proprietario;
		this.numCase=numCase;
		this.numAlberghi=numAlberghi;
			
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
	 * Serve a verificare il colore di un terreno
	 * @return colore memorizza il colore
	 */
	public String getColore() {
		return colore;
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
	 * Rappresenta il conteggio del numero degli alberghi edificati
	 * @return numAlberghi
	 */
	public int getNumAlberghi() {
		return numAlberghi;
	}

	/**
	 * Inserisce il numero di alberghi costruiti in relazione a un gruppo di terreni dello stesso colore
	 * @param numAlberghi numero di alberghi costruiti
	 */
	public void setNumAlberghi(int numAlberghi) {
		this.numAlberghi = numAlberghi;
	}

/**
 * Rappresenta il conteggio del numero delle case edificate
 * @return numCase il numero di case edificate
 */
	public int getNumCase() {
		return numCase;
	}

	/**
	 * Inserisce il numero di case costruiti in relazione a un gruppo di terreni dello stesso colore
	 * @param numCase numero di case costruiti
	 */
	public void setNumCase(int numCase) {
		this.numCase = numCase;
	}

	/**
	 * Definisce il valore del pagamento al transito da parte di un giocatore non proprietario
	 * @param affitto quando non si possiedono tutti i terreni di uno stesso colore e i giocatori non proprietari devono pagare la quota al transito
	 */
	public void setAffitto(int affitto) {
		this.affitto = affitto;
	}

	/**
	 * Consente il pagamento raddoppiato per chi non proprietario transita su gruppi di terreni di 3 o 2 tutti appartenenti a un unico giocatore
	 * @return affitto2 valore da pagare al transito
 	 */
	public int getAffitto2() {
		return affitto2;
	}

}	