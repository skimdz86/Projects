package monopoli;

/**
 * Questa è la Classe  che definisce le caselle delle probabilità
 * definendone 3 aspetti:
 * </ul>
 * <li>il nome ovvero il nome della casella 
 * <li>il tipo di casella (evidentemente di tipo Probabilità)
 * <li>la sua acquistabilità da parte dei giocatori(evidentemente predisposta non acquistabile) 
 * @param acquistabile boolenao che ritorna true se la casella di tipo probabilità è acquistabile-false(0)altrimenti
 * @param nome Stringa in cui viene contenuto il nome della casella
 * @param tipo Stringa in cui si memorizza il tipo di casella
 * @see Casella
 * @author La_donatac1
 *
 */
public class Probabilità extends Casella {
	
	
	private boolean acquistabile;
	private String nome,tipo;
	
	/**
	 * Questo costruttore serve a definire l'oggetto relativo alla casella
	 * delle probabilità definendone subito le caratteristiche utili al riconoscimento come il nome il tipo e l'acquistabilità di questo tipo di casella
	 * @param nome assegna il nome della casella alla variabile di tipo string
	 * @param tipo assegna il tipo della casella alla variabile di tipo string
	 * @param acquistabile assegna true se è acquistabile e false se non lo è
	 */
	public Probabilità(String nome,String tipo,boolean acquistabile){
		
		this.nome=nome;
		this.tipo=tipo;
				this.acquistabile=acquistabile;
	
	}

	
/**
 * Metodo che verifica se una casella è acquistabile da parte dei giocatori
 * @return acquistabile booleano assegna true se è acquistabile e false se non lo è
 */
	public boolean isAcquistabile() {
		return acquistabile;
	}

	
	/**
	 * Metodo che assume il nome della casella attraverso la variabile nome
	 * @return nome stringa che contene il nome della casella 
	 */
	public String getNome() {
		return nome;
	}

	public String getTipo() {
		return tipo;
	}

}
