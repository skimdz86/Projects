package monopoli;

/**
 * Permette di definire il pagamento di una tassa predefinita al transito di una specifica casella
 * al passaggio di ogni giocatore
 * E' definita dalle caratteristiche di:
 * </ul>
 * <li>Nome che ne specifica il nome
 * <li>tipo che definisce che si tratta della casella di tasse imposte predefinita
 * <li>affitto che rappresenta quanto occorre pagare per il transito
 * <li>acquistabile se la casella � acquistabile o no
 * @param nome definisce il nome della casella
 * @param tipo stabilisce che tipo di casella �
 * @param affitto quanto occurre pagare per il transito
 * @param acquistabile se si pu� comprare o no
 * @see Casella
 * @author La_donatac1
 *
 */
public class Tasse extends Casella {

	private String nome,tipo;
	private int affitto;
	private boolean acquistabile;

	/**
	 * Definisce l'inizializzazione della casella tasse per definirne il nome il tipo pagamento al transito e l'acquistabilit�
	 * @param nome definisce il nome della casella
	 * @param tipo definisce che tipologia di casella
	 * @param affitto il denaro da pagare al transito
	 * @param acquistabile se � possibile acquistarla
	 */
	public Tasse(String nome,String tipo,int affitto,boolean acquistabile){
		
		this.nome=nome;
		this.tipo=tipo;
		this.affitto=affitto;
		this.acquistabile=acquistabile;
		
	}

	/**
	 * Ha lo scopo di ottenere il prezzo che deve pagare un giocatore
	 * in transito su una casella di propriet� di un'altro giocatore
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
