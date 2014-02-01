package monopoli;

/**
 * Classe che definisce lo spostamento prodotto dalla mossa del giocatore
 * attraverso il lancio dei dadi e che determina lo spostamento come somma dei dadi
 * e stabilisce l'eventuale possibilità di ritirare facendo doppio coi dadi grazie alla funzione
 * ritirare()
 * @param z1 è il numero che identifica il numero che esce al lancio del I dado
 * @param z2 è il numero che identifica il numero che esce al lancio del II dado
 * @param ritira è un booleano che verifica che nel lancio i dadi hanno dato un doppio(2 numeri uguali) con la conseguente possibilità di ritirare
 * @param spost1 è un oggetto di tipo Spostamento creato per associare al numero uscito col lancio dei dadi uno spostamento effettivo della posizione del giocatore 
 * @see Spostamento
 * @author La_donatac1 
 */
public class Mossa {
	
	
	private int z1,z2;
	private int totale;
	private boolean ritira;
	
	private Spostamento spost1=new Spostamento();
	
	/**
	 * Questo metodo associa al lancio dei dadi che viene richiamato nella classe Spostamento
	 * le variabili z1 e z2 che memorizzano il risultato dei 2 dadi e ne effettua la somma
	 * @see #somma(int,int)
	 * @see #muovi()
	 * @return totale intero in cui viene memorizzata la somma
	 */
	public int muovi(){
		
		z1=spost1.mossa1();
		z2=spost1.mossa2();
		totale=spost1.somma(z1, z2);
		return totale;
	}
	
	/**
	 * Questo metodo verifica attraverso il richiamo del metodo doppio che
	 * i numeri z1 e z2 sono uguali
	 * @see #doppio(int,int)
	 * @return ritirare booleano che ritorna true(1)se è uscito un doppio da lancio dadi o false(0) altrimenti
	 */
	public boolean ritirare(){
		
		ritira=spost1.doppio(z1, z2);
		return ritira;
	}
	
	
	
}
