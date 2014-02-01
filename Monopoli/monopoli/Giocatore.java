package monopoli;

import java.util.ArrayList;
/**
 * Questa classe Giocatore permette di definire tutte le caratteristiche
 * che possiedono i giocatori durante la partita
 *<p>
 * Si rappresenta il lato statico del giocatore caratterizzato da un nome  
 * dalle proprietà assegnate a inizio partita dal denaro che possiede e dal numero di turno
 * tramite le variabili nome denaro numero proprietà
 * <p>
 * Si rappresenta anche il lato dinamico:
 * </ul>
 * <li>la possibilità di ritirarsi 
 * <li>la variazione di posizione
 * <li>la variazione di denaro
 * <li>la variazione di proprietà
 * <li>la possibilità di finire/uscire di prigione
 * @ param nome variabile di tipo String che viene utilizzata
 * per associare a un oggetto di tipo giocatore il nome
 * @param denaro numero intero (int) che rappresenta la quantità di denaro  disponibile per il giocatore
 * @param posizione intero che definisce il numero della posizione assunta dal giocatore
 * @param n_turni_fermo variabile di tipo int che tiene il conto di quanti turni il giocatore non può tirare i dadi ed è inizializzata a 0
 * @param ritirato intero che identifica se un giocatore abbandona il gioco(assume il valore 1) o viceversa(assume 0) 
 * @param numero variabile intero che identifica l'ordine numerico dei giocatori
 * @param uscita variabile booleana con cui si definisce se si è in possesso del cartellino necessario per uscire dallo stato di prigione  inizializzato a falso ovvero non in possesso
 * @param proprietà variabile di riferimento di tipo ArrayList determina una lista di Caselle con le loro proprietà di cui il giocatore è in possesso
 * @author La_donatac1
 */
public class Giocatore {

	private String nome;
	private int denaro,posizione=0,n_turni_fermo,ritirato,numero;
	private boolean uscita=false;//se ha il cartellino esci gratis
	private ArrayList<Casella> proprietà=new ArrayList<Casella>();
	
	/**
	 * Costruttore che inizializza l'oggetto di tipo Giocatore
	 * assegnandogli i suoi attributi per il gioco:
	 * </ul>
	 * <li>il nome
	 * <li>il numero per il turno
	 * <li>il denaro
	 * <li>la posizione
	 * <li>i turni senza tirare i dadi
	 * <li>il possesso del cartellino per uscire di prigione
	 * <li>lo stato di partecipazione al gioco   
	 * @param numero intero che definisce il turno dei giocatori in gioco
	 * @param nome Stringa che rappresenta il nome del giocatore
	 * @param denaro intero che memorizza il denaro del giocatore
	 * @param posizione indice che indica la posizione del giocatore sul tabellone
	 * @param esci_prigione booleano che indica la possibilità di uscire dalla prigione grazie al cartellino corrispondente
	 * @param n_turni_fermo indice che memorizza il numero di turni da saltare
	 * @param ritirato  intero che identifica se il giocatore abbandona il gioco
	 * e ritorna 1 se sei ritira e 0 se resta in gioco
	 */
	public Giocatore(int numero,String nome,int denaro,int posizione,boolean esci_prigione,int n_turni_fermo,int ritirato) {
	/*forse mettere distribuzione terreni all'inizio*/
		
		this.nome=nome;
		this.numero=numero;
		this.denaro=denaro;
		this.posizione=posizione;
		this.n_turni_fermo=n_turni_fermo;
		esci_prigione=uscita;
		this.ritirato=ritirato;
				
	}
	
	/**
	 * Metodo che serve a definire lo stato di possesso da parte del giocatore
	 * del cartellino degli impresvisti per uscire dalla prigione nel caso in cui ci finisse 
	 * @return boolean true se si ha il cartellino(1) e false(0)altrimenti
	 */
	
	public boolean isUscita() {
		return uscita;
	}
	
	/**
	 * Metodo che serve a settare la condizione di possesso nel corso del gioco del cartellino di uscita dalla prigione
	 * @param uscita serve a memorizzare nel parametro uscita dell'oggetto giocatore il possesso del cartellino 
	 */
	
	public void setUscita(boolean uscita) {
		this.uscita = uscita;
	}
	
	/**
	 * Metodo che ritorna dinamicamente nel corso del gioco lo stato del denaro del 
	 * giocatore 
	 * @return denaro che rappresenta il denaro corrente 
	 */
	
	public int getDenaro() {
		return denaro;
	}
	
	/**
	 * Metodo setter che aggiorna lo stato del denaro del
	 * giocatore e lo memorizza nel auo attributo
	 * @param denaro   corrente in attributo del giocatore
	 */
	public void setDenaro(int denaro) {
		this.denaro = denaro;
	}
	
	/**
	 * Metodo getter che fornisce qualora invocato il nome del giocatore
	 * corrente
	 * @return nome la stringa in cui è memorizzato il nome del giocatore
	 */
	
	public String getNome() {
		return nome;
	}
	
	/**
	 * Metodo che inserisce il nome del giocatore nel suo campo
	 * attributi
	 * @param nome stringa contenente il nome memorizzato come attributo
	 * del giocatore
	 */
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	/**
	 * Metodo che restituisce dinamicamente la posizione durante
	 * il gioco del giocatore dopo aver effettuato il lancio
	 * dei dadi
	 * @return posizione variabile intero che indica il numero della casella dopo il lancio
	 */
	
	public int getPosizione() {
		return posizione;
	}
	
	/**
	 * Metodo setter che inserisce negli attributi del giocatore la posizione dopo il lancio dei dadi 
	 * @param posizione memorizza la posizione nell'oggetto giocatore
	 */
	
	public void setPosizione(int posizione) {
		this.posizione = posizione;
	}
	
	/**
	 * Metodo che identifica il numero di turni fermi
	 * di un giocatore
	 * @return n_turni_fermo è l'intero che rappresenta il numero
	 * di turni fermo
	 */
	
	public int getN_turni_fermo() {
		return n_turni_fermo;
	}
	
	/**
	 * Metodo che stabilisce il numero di turni fermi
	 * @param n_turni_fermo numero di turni fermi settato
	 */
	public void setN_turni_fermo(int n_turni_fermo) {
		this.n_turni_fermo = n_turni_fermo;
	}
	
	/**
	 * Metodo che identifica lo stato di ritirato di un giocatore
	 * @return ritirato intero che identifica quale giocatore abbandona il gioco
	 */
	public int getRitirato() {
		return ritirato;
	}
	
	/**
	 * Metodo che inserisce negli attributi del giocatore lo stato 
	 * di partecipazione o rinuncia al gioco
	 * @param ritirato setta se il giocatore si ritira(1)
	 */
	public void setRitirato(int ritirato) {
		this.ritirato = ritirato;
	}
	
	/**
	 * Metodo che permette tramite l'inserimento progressivo dei giocatori 
	 * di indicarne l'ordine di gioco  
	 * @return numero intero che identifica il turno di gioco del giocatore
	 */
	
	public int getNumero() {
		return numero;
	}
	
	/**
	 * Metodo che inserisce l'indice di gioco nei parametri di giocatore
	 * @param numero attributo che memorizza l'indice
	 */
	public void setNumero(int numero) {
		this.numero = numero;
	}
/**
 * Metodo che consente durante il gioco di aggiungere tipi di caselle di cui il giocatore può diventare proprietario
 * e inserirli nella lista di proprietà del giocatore
 * @param c variabile di tipo Casella che viene inserta nelle proprietà del giocatore 
 */
	public void setProprietà(Casella c){
		proprietà.add(c);//cosi dovrebbe andare, anche la get sotto
	}
	
	/**
	 * Metodo che consente di prendere la lista di proprietà del giocatore
	 * @return proprietà un ArrayList di tipo casella contenente le proprietà settate del giocatore
	 */
	public ArrayList<Casella> getProprietà(){
		return proprietà;
	}
}
