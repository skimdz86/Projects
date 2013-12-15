package monopoli;

import java.util.*;

/**
 * Questa classe in cui è presente il main permette di richiamare l'interfaccia grafica che si occupa di richiamare i vari metodi durante il gioco
 * e il menu grafico di scelta iniziale dei personaggi  (GUI)
 * @author La_donatac1
 */
public class Monopoli {

	/**
	 * Classe main in cui si richiamano i metodi di interfaccia grafica e si crea l'oggetto di tipo interfaccia GUI
	*  @see #ShowNumber()
	 */
	public static void main(String[] args) {
		/*METTERE TUTTI GLI ATTRIBUTI PRIVATE*/
		
		GUI grafica=new GUI();
		
		grafica.ShowNumber();
		
		
		
		////startgame->getgiocatore->lanciodadi->getturno
		////è cosi che poi si chiamano nel game
		
		//forse i parametri che passo alle varie funzioni è meglio che nn abbiano tutti o stesso nome:listagioc, tavolo...
		
	}//main
}//class
