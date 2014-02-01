package monopoli;

import java.util.ArrayList;
/**
 * Rappresenta il collegamento tra tutte le funzioni di gioco che verranno utilizzate anche
 * dall'utente tramite l'interfaccia GUI
 * @author La_donatac1
 *
 */
public interface UserInterfaceConnector {
	
	/**
	 *Serve ad aggiungere un nuovo giocatore alla partita 
	 * @param numgioc di giocatori che partecipano al game
	 */
	public void addPlayer(int numgioc);
	/**
	 * Serve a creare le caselle del tabellone di gioco
	 */
	public void getTabellone();
	/**
	 * Serve a ottenere se il giocatore ha diritto a effettuare il lancio dadi
	 * @return boolean[] un array di booleani che identificano la possibilità di tirare i dadi da parte di un giocatore(return true)
	 */
	public boolean[] getTurno();
	/**
	 * Serve a identificare il giocatore corrente
	 * @param gioMax numero massimo di giocatori
	 * @return
	 */
	public int getGiocatore(int gioMax);
	/**
	 * Funzione che decreta l'inizio del gioco creando e inizializzando
	 * il tabellone e avviando la GUI l'interfaccia grafica
	 */
	public void startGame();
	/**
	 * Viene chiuso il gioco con uscita dopo che i giocatori si ritirano e vengono consegnati i terreni e le proprietà alla banca
	 */
	public void endGame();
	/**
	 * Effettua l'estrazione random dei dadi
	 * @return int che rappresenta il valore del dado 
	 */
	public int lancioDadi();
	/**
	 * Verifica se il lancio dei dadi restituisce due numeri uguali
	 * @return boolean true se i due dadi danno lo stesso numero
	 */
	public boolean getDoppio();
	/**
	 * Verifica la posizione sul tabellone di un giocatore dopo un lancio dadi
	 * @return int numero della posizione
	 */
	public int getPosition();
	/**
	 * Restituisce la posizione del giocatore prima del lancio dadi
	 * @return int restituisce la posizione
	 */
	public int getPrevPosition();
	/**
	 * Rappresenta la rimozione di un giocatore dalla lista dei giocatori quando si ritira
	 */
	public void getRemove();
	
	/**
	 * Definisce il pagamento o l'acquisto a causa di un transito  da parte del giocatore che transita nei confronti del proprietario
	 * <p>
	 * Ci possono essere 2 diversi tipi di pagamento rispettivamente per Terreni Stazioni e Società:
	 * </ul>
	 * <li>terreno singolo con pagamento
	 * <li>tutti i terreni dello stesso colore (con eventuali case e alberghi) con pagamento raddoppiato
	 * <li>stazioni singole con pagamento
	 * <li>tutte le stazioni(4) con pagamento raddoppiato
	 * <li>società singola con pagamento
	 * <li>società doppia con pagamento raddoppiato
	 * @return string restituisce le caratteristiche della casella + l'azione particolare da eseguire
	 */
	public String getObbligo();
	/**
	 * Aggiunge il nome del giocatore e gli associa un indice
	 * @param nomeGioc memorizza il nome
	 * @param indice il numero di turno del giocatore
	 */
	public void addNamePlayer(String nomeGioc,int indice);
	/**
	 * Restituisce le informazioni dei giocatori
	 * @return String le informazioni
	 */
	public String infoGioc();
	/**
	 * Restituisce le informazioni che riguardano le proprietà di un giocatore
	 * @return ArrayList<String> l'array che contiene le stringhe di informazione
	 */
	public ArrayList<String> infoProp();
	/**
	 * Restituisce le informazioni delle caselle su cui si trova il giocatore
	 * @return  ArrayList<String> contiene la lista di stringhe di informazioni
	 */
	public ArrayList<String> infoCasella();
	/**
	 * Verifica che il giocatore abbia denaro sufficiente e compra la casella di tipo acquistabile
	 */
	public String compraCasella();
	/**
	 * Verifica la condizione di essere su terreni di avere un numero di case inferiore a 4 e di avere sufficiente denaro per comprare un numero di case 
	 * e in seguito permette di acquistare le case inserendole sulla casella con la funzione appropriata 
	 * @return string contiene l'informazione sull'azione compiuta
	 */
	public String compraCase(int numCase);
	
	/**
	 * Verifica la condizione di essere su terreni di avere un numero di case uguale a 4 e di avere sufficiente denaro per comprare un albergo
	 * e in seguito inserisce l'albergo  sulla casella con la funzione appropriata 
	 * @return string contiene l'informazione sull'azione compiuta
	 */
	public String compraAlbergo();
	
	/**
	 * Rappresenta la possibilità di uscire di prigione col cartellino e setta lo stato di possesso di nuovo a false e il numero di turni fermo a 0
	 */
	public void usaEsciGratis();
	
	/**
	 * Serve a uscire di prigione pagando:
	 * definisce il numero di turni fermo 0
	 */
	public void pagaPrigione();
	
	/**
	 * Verifica la condizione di uscita tramite un doppio con un massimo di tre tentativi
	 * @return string la stringa che avvisa che i 2 dadi sono diversi
	 */
	public String tiraPrigione();
	
	/**
	 * Verifica che si può uscire di prigione
	 * @return boolean true se si può uscire
	 */ 
	public boolean uscitaOk();
	//public void setPrigione();inutile!!
	
	/**
	 * Verifica che il turno di un giocatore è definito >0 se in prigione
	*@return boolean true se si è in prigione
	 */
	public boolean isGattaBuia();
	/**
	 * Stabilisce quando un giocatore perde in base al fatto che si ritira
	
	 * @return boolean true se il giocatore ha perso
	 * 
	 * 
	 */
	public boolean haiPerso();
	//public void inGalera();no, è interna
	
	
	
	/**
	 * Imposta la posizione del giocatore a 10
	 
	 */
	public void setStopped();
	//public void setGattaBuia();

}
