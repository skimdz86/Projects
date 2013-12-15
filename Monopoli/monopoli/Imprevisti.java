package monopoli;

/**
 * Classe che eredita tutti i metodi di casella e che rappresenta le
 * tipologie di casella non acquistabili e che determinano differenti azioni
 * a seconda dei cartellini selezionati tramite Random
 * @author La_donatac1
 * @param nome stringa he identifica il nome della casella degli imprevisti corrispondenti
 * @param tipo stringa che identifica una delle tipologie di caselle
 * @param acquistabile booleano che definisce se una casella può essere acquistata dal giocatore
 * @see Casella
 */
public class Imprevisti extends Casella {
	
	private String nome,tipo;
	private boolean acquistabile;
	
		/**
		 * Costruttore che inizializza il nome il tipo e l'acquistabilità della casella 
		 * @param nome assegna il nome
		 * @param tipo assegna il tipo
		 * @param acquistabile definisce se acquistabile
		 */
	public Imprevisti(String nome,String tipo,boolean acquistabile){
		
		this.nome=nome;
		this.tipo=tipo;
		this.acquistabile=acquistabile;
			
		
	}

	
/**
 * Metodo che restituisce false poichè la casella di tipo imprevisto non è acquistabile 
 * @return acquistabile definito in questo caso come false
 */
		public boolean isAcquistabile() {
		return acquistabile;
	}


/**
 * Metodo che serve a prendere il nome della casella 
 * @return nome stringa contenente il nome
 */
	public String getNome() {
		return nome;
	}

/**
 * Metodo che definisce il tipo di casella in questo caso di tipo Imprevisti
 * @return tipo stringa che memorizza il tipo di casella
 */
	public String getTipo() {
		return tipo;
	}



	

		

}
