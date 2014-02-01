package monopoli;

/**
 * Questa Classe definisce un altro tipo di casella presente nel 
 * tabellone di gioco ossia la prigione
 * <p>
 * Come per le Classi che estendono la Classe Casella presenta le sue caratteristiche che 
 * le vengono assegnate dai metodi che definiscono:
 * </ul>
 * <li>se tale casella è di tipo acquistabile(ovviamente non lo è)
 * <li>se tale casella risulta per un qualche turno occupata da qualche giocatore
 * @param occupante Stringa che definisce il nome del giocatore che la occupa
 * @param acquistabile booleano che definisce la tipologia acquistabile (inizializzato a false fisso)
 * @see Casella
 * @author La_donatac1
 */
public class Prigione extends Casella {
	
	private String occupante;
	private boolean acquistabile;
	
	/**
	 * Costruttore che permette di inizializzare l'oggetto di tipo prigione assegnando come
	 * attributi dell'oggetto di tipo prigione corrente chi la occupa e la possibilità(ovviamente fissa a false)
	 * di acquistarla
	 * @param occupante Stringa che definisce il nome del giocatore che la occupa
	 * @param acquistabile booleano che memorizza la possibilità di acquistarla(false)
	 */
	public Prigione(String occupante,boolean acquistabile){
		
		this.acquistabile=acquistabile;
		this.occupante=occupante;
		}
	
	/**
	 * Metodo che serve a prendere nel corso del gioco il nome di chi
	 * occupa la casella di tipo prigione
	 * @return occupante che è una stringa contenente tale nome
	 */
	public String getOccupante() {
		return occupante;
	}
	
	/**
	 * Metodo che serve ad assegnare alla casella prigione come attributo
	 * il nome di chi la occupa 
	 * @param occupante stringa che memorizza il nome
	 */
	public void setOccupante(String occupante) {
		this.occupante = occupante;
	}

/**
 * Metodo che definisce se tale casella è acquistabile o meno
 * @return acquistabile che restituisce true(1)se acquistabile e (0)viceversa
 */
	public boolean isAcquistabile() {
		return acquistabile;
	}


	

}
