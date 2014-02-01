package monopoli;

/**
 * Questa Classe è stata creata per definire alcune delle caratteristiche del giocatore riferite prò alle caselle
 * di gioco
 * <p>
 * Esse si riferiscono percui:
 * </ul>
 * <li>all'acquisizione del prezzo che spetta a un giocatore qualora si voglia vendere o acquistare una casella nel corso del gioco
 * <li>richiesta di pagamento da parte di un giocatore proprietario della casella di una quota in denaro al giocatore che vi è sopra in transito
 * <li>memorizzare e ottenere informazioni rigurdanti l'indice corrispondente al giocatore proprietario di una casella 
 * @see Casella
 * @author La_donatac1
 *
 */
public class Proprietà extends Casella {
	
	/**
	 * Consente di ottenere il valore del prezzo di una casella
	 * posseduta da un giocatore
	 * @return int intero col valore corrispondente (in euro) 
	 * 
	 */
	public int getPrezzo(){
		return 0;}
	
	/**
	 * Ha lo scopo di ottenere il prezzo che deve pagare un giocatore
	 * in transito su una casella di proprietà di un'altro giocatore
	 * @return intero che definisce il prezzo da pagare al proprietario
	 */
	public int getAffitto(){
		return 0;}
	
	/**
	 * Si occupa di ottenere l'indice corrispondente al proprietario della casella (compatibilmente col tipo di casella)	
	 * @return int l'indice del proprietario nella lista di giocatori (inizializzato a 0)
	 */
	public int getProprietario(){
		return 0;}
	
	/**
	 * Associa come proprietario della casella il giocatore della lista con l'indice corrispondente
	 * @param proprietario intero che corrisponde all'indice del giocatore
	 */
	public void setProprietario(int proprietario){}

}
