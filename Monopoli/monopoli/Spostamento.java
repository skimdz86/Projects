package monopoli;

/**
 * Spostamento rappresenta il movimento che ogni giocatore compie 
 * quando-secondo il regolamento-possiede la facoltà di tirare i dadi
 * <p>
 * Questa classe quindi si occupa di  determinare le operazioni di lancio dei singoli dadi 
 * di effettuarne la somma e di controllare un eventuale lancio doppio
 * @param x1 intero a cui viene fatto corrispondere il valore del lancio del primo dado
 * @param x2 intero a cui viene assegnato il valore del lancio del secondo dado
 * @param dado1 oggetto di tipo Dadi utilizzato per effettuare il lancio dei dadi(random tra sei numeri)
 * @param dado2 oggetto di tipo Dadi utilizzato per effettuare il lancio dei dadi(random tra sei numeri)
 * @see Dadi
 * @author La_donatac1
 *
 */
public class Spostamento {
	
		private int x1,x2;
	
	private Dadi dado1=new Dadi();
	private Dadi dado2=new Dadi();
	
	/**
	 * Si occupa di effettuare la mossa del giocatore ossia effettuare il lancio dadi
	 * ritornando il valore del lancio 
	 * @return x1 rappresenta il numero che esce al primo lancio
	 */
	public int mossa1(){
		
		x1=dado1.lancio_dadi();
		return x1;
			
	}
	
	/**
	 * Si occupa di effettuare la mossa del giocatore ossia effettuare il lancio dadi
	 * ritornando il valore del lancio 
	 * @return x2 rappresenta il numero che esce al secondo lancio
	 */
	public int mossa2(){
		
		x2=dado2.lancio_dadi();
		return x2;
	}

	/**
	 * Determina la somma dei due lanci
	 * uno per dado
	 * @param d1 risultato del primo dado
	 * @param d2 risultato del secondo dado
	 * @return d1+d2 la somma dei due
	 */
public int somma(int d1,int d2){
		
		
		return d1+d2;
		}
		
/**
 * Controlla se nel lancio è avvenuto un doppio
 * @param d1 memorizza il risultato del primo lancio
 * @param d2 memorizza il risultato del secondo lancio
 * @return <true> se i due lanci sono uguali <false>viceversa
 */
		public boolean doppio(int d1,int d2){
			
			if (d1==d2) return true;
			else return false;
		}
}
