package monopoli;

/**
 * Casella viene utilizzata per definire
 * le caratteristiche degli elementi che compongono il 
 * tabellone di gioco
 * <p>
 * I metodi visibili al suo interno fanno riferimento:
 * </li> Il primo alla possibilit� di acquisto in base alla 
 * distinzione tra caselle acquistabili dai giocatori 
 * </li> Il secondo al nome della casella identificandola
 * </li> Il terzo alla tipologia di casella e quindi alla 
 * possibilit� di eseguire o meno determinate azioni
 */


public class Casella {
	
	
	/**
	 * Definisce la possibilit� di 
	 * effettuare l'acquisto di una casella da parte di un giocatore
	 * <p>
	 * Ha come parametro implicito l'oggetto cui appartiene di tipo Casella
	 * @return <code>true</code> (1)se la casella su cui viene
	 * invocato il metodo � acquistabile
	 *         <code>false</code> (0)se la casella non si pu� acquistare 
	 */
	
	public boolean isAcquistabile(){
		
		return false;}
	/**
	 * Fa riferimento all'oggetto di tipo Casella
	 * non riceve ingressi e restituisce come uscita la stringa corrispondente
	 * al nome della casella che lo invoca
	 * @return String una stringa contenente il nome 
	 * inizializzata a null
	 */
	public String getNome(){
		return null;}
	
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
	public String getTipo(){
		return null ;}
	
		
}
