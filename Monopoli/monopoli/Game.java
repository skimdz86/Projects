package monopoli;


import java.io.*;
import java.util.*;

/**
 * Rappresenta il motore di gioco del monopoli
 * <p>
 * Qui si crea il tabellone formato da una lista di caselle e anche la lista dei giocatori della partita
 * e vengono implementati tutti i metodi di gioco:
 * </ul>
 * <li>il lancio dei dadi per consentire ai giocatori di spostarsi al loro turno tramite la loro mossa
 * <li>la possibilità di comprare determinati tipi di caselle decrementando il proprio denaro
 * <li>la possibilità di acquisire case e alberghi e inserirli come caratteristiche delle proprie proprietà
 * <li>le azioni determinate da estrazioni Random di cartellini imprevisti e probabilità
 * <li>altre azioni connesse a particolari caselle
 * <li>l'obbligo di pagare imposizioni o transiti su proprietà altrui
 * <li>l'obbligo di restare fermi in prigione e saltare turni
 * <li>le possibilità di uscire dalla prigione
 * <li>la chiusura del gioco per ritiro o perdita di denaro(<0)
 * <li>la distribuzione iniziale e finale delle caselle acquistabili
 * @param listagioc ArrayList che indica la lista di giocatori partecipanti alla partita
 * @param tavolo ArrayList di caselle di gioco del tabellone
 * @param tabell oggetto che rappresenta il tabellone di gioco
 * @param mazzoImp ArrayList che contiene i cartellini di tipo imprevisti
 * @param mazzoProb ArrayList che contiene i cartellini di tipo probabilità
 * @param cart4 un cartellino delle probabilità
 * @param x conta il risultato dei dadi
 * @param y controlla doppio dei dadi
 * @param i variabile per contare numero tiri doppi effettuati
 * @param position memorizza la posizione a lancio dadi effettuati
 * @param prevposition memorizza la posizione prima del lancio dei dadi
 * @param p indice del giocatore
 * @param puoiUscire booleano che indica la condizione di uscita dalla prigione(true)
 * @param creditore indice del giocatore proprietario della casella
 * @param j scandisce l'array di caselle del tabellone
 * @param k scorre tutte le caselle per verificare quella su cui costruire le case
 * @param sameColor2 verifica se il giocatore possiede tutti i terreni(a due) dello stesso colore 
 * @param sameColor3 verifica se il giocatore possiede tutti i terreni(a tre) dello stesso colore
 * @param etichetta memorizza i dati da stampare a video in base alle azioni di gioco 
 * @author La_donatac1
 *
 */
public class Game implements UserInterfaceConnector { 

	/*private Scanner input1=new Scanner(System.in);
	private Scanner input2=new Scanner(System.in);
	private Scanner input3=new Scanner(System.in);*/
	private ArrayList<Giocatore> listagioc=new ArrayList<Giocatore>();
	private ArrayList<Casella> tavolo=new ArrayList<Casella>();
	private Tabellone tabell=new Tabellone();
	private ArrayList<CartelliniImp> mazzoImp=new ArrayList<CartelliniImp>();
	private ArrayList<CartelliniProb> mazzoProb=new ArrayList<CartelliniProb>();
	private CartelliniProb cart4=new CartelliniProb();

	
		
	private int x;//conta il risultato dei dadi 
	private boolean y=false;//doppio dei dadi
	private int i;//variabile per contare numero tiri doppi effettuati
	private int position;//pos corr
	private int prevposition;//pos preced
	private int p=0;
	//private Scanner tiro=new Scanner(System.in);
	private boolean puoiUscire=false;
	//private boolean gattabuia=false;
	//private boolean stopTurno;
	//private int giocFermo;

	private int creditore;
	private int j,k;
	private boolean sameColor3=false,sameColor2=false;//vede se ho tutti i terreni di un colore
	//private int numCase,numAlberghi;
	private String etichetta;
	/*private Scanner choose=new Scanner(System.in);
	private Scanner nCase=new Scanner(System.in);
	private Scanner nAlberghi=new Scanner(System.in);*/
//////////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * E' costruita per inizializzare gli elementi principali di gioco come tabellone e caselle 
	  */
	public void startGame() {
		// decide se far iniziare il gioco
		System.out.println("*********MONOPOLI*********");
		tavolo=tabell.creaTabellone();
		
		//getGiocatore();
		

	}
//////////////////////////////////////////////////////////////////////////////////////////////	
	
	/**
	 * Serve a memorizzare il tabellone creato
	 */
	public  void getTabellone() {
		
		

	}
	
//	dichiaro un arraylist di giocatori/////////////////////////////////////////////////////////
	
	/**
	 * Dichiara ArrayList di giocatori che inizializza i giocatori tramite le loro caratteristiche:
	 * </ul>
	 * <li>nome
	 * <li>indice
	 * <li>soldi di partenza
	 * <li>posizione iniziale
	 * <li>possibilità di uscita prigione tramite cartellino
	 * <li>turni fermo
	 * <li>stato di gioco
	 * <p>
	 * Provvede inoltre a definire il denaro per i giocatori e scandisce la lista inserendo tale denaro come attributo al giocatore
	 * Distribuisce random alcune proprietà in base al numero dei giocatori
	 * @see #isAcquistabile()
	 * @see #getProprietario(int)
	 * @see #setProprietà(Casella)
	 * @see #setProprietario(int)
	 * @see #getProprietario()
	 * @see Giocatore
	 * @see Casella
	 * @see Terreno 
	 * @param numgioc numero di partecipanti, serve per inizializzare i giocatori
	 */
	public void addPlayer(int numgioc) {
		// aggiungo i giocatori nella lista
		
		String gioc=null;
		int soldi=0;
		int n;
		int k1=0;
		int i=0;
		int index=0;//numero contratti da distribuire
		int rand;//numero random per scegliere la casella da dare
		Random r=new Random();
		
		/*do{
		System.out.println("In quanti volete giocare?Da 1 a 6 giocatori");
		numgioc=input3.nextInt();
		}while(numgioc<1 || numgioc>6);*/
		
		switch(numgioc){
		//case 1: soldi=50000000;break;/////////meettere cifre giuste
		case 2: soldi=8750;break;
		case 3: soldi=7500;break;
		case 4: soldi=6250;break;
		case 5: soldi=5000;break;
		case 6:	soldi=3750;break;
		}
		
		do{
			//System.out.println("Che pedina sei? Candela, fiasco, fungo, pera, mela o pianta?(O altri personaggi)");
			//String gioc=input2.nextLine();
			listagioc.add(new Giocatore(i,gioc,soldi,0,false,0,0));//mettere i soldi di partenza al posto di 300
			i++;
		}while(i<numgioc);
		
		switch(numgioc){
		//case 1:index=8;break;
		case 2:index=7;break;
		case 3:index=6;break;
		case 4:index=5;break;
		case 5:index=4;break;
		case 6:index=3;break;
		}
		do{		
			//System.out.println("Proprietà assegnate a: "+listagioc.get(k1).getNome());
			n=0;
		do{
			rand=r.nextInt(40);
			if(tavolo.get(rand).isAcquistabile() && ((Proprietà)tavolo.get(rand)).getProprietario()==6) {
				listagioc.get(k1).setProprietà(tavolo.get(rand));
		        ///////qui ci va di settare il proprietario alle caselle:devo passargli anche il tavolo quindi
				((Proprietà)tavolo.get(rand)).setProprietario(k1);
				System.out.println(listagioc.get(k1).getProprietà().get(n).getNome());
				n++;
			}
			
		}while(n<index);
		k1++;
		System.out.println("\n");
		}while(k1<numgioc);
		
		

	}
///////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Determina l'azione di lancio dadi e spostamento dei vari giocatori verificandone l'idoneità alla mossa del tiro dei dadi-vedi condizione di prigione
	 * <p>
	 * E' costituita dall'oggetto mossa che consente di richiamare la funzione lancioDadi che a sua volta è in stretta connessione con la classe Spostamento
	 * e allo stesso tempo con il movimento dei giocatori sul tabellone 
	 * Essa infatti recupera la posizione corrente tramite l'apposita funzione a cui poi somma l'effetto del random lancio dadi che somma il risultato dei 2 dadi consegnando la nuova posizione in setPosizione
	 * @see #muovi()
	 * @see#ritirare()
	 * @see #getNome()
	 * @see #getPosizione()
	 * @see #setDenaro(int)
	 * @see #setPosizione(int)
	 * @see #getDenaro()
	 * @see #setRitirato(int)
	 * @see Giocatore
	 * @see Mossa
	 * @return x totale punteggio ottenuto con i due dadi
	 */
	public int lancioDadi(){
		i=0;
		
			////////////////////////////////////////////////////////tiro il dado
			Mossa muovi=new Mossa();
			
			if(listagioc.get(p).getN_turni_fermo()==0) {
			
			System.out.println(listagioc.get(p).getNome()+": premi Invio per lanciare i dadi\n"); 
		    //tiro.nextLine();//per bloccare l'esecuzione un momento
				
		    x=muovi.muovi();
			y=muovi.ritirare();
			//gattabuia=false;				
			System.out.println(listagioc.get(p).getNome()+ " ha lanciato i dadi: è uscito "+x);
			if (y) System.out.println("Doppio!Puoi ritirare");
			position=((listagioc.get(p).getPosizione()));//PROVA,POITOGLERE TUTTI QUESTI
			prevposition=((listagioc.get(p).getPosizione()));
			System.out.println("POSIZIONE I"+position);//PROVA				
			position=((listagioc.get(p).getPosizione())+x);
     		if(position>39) {position=position-40;       //condizione per cui alla 40 torna indietro
         	                 System.out.println("Passi dal Via e ritiri 500 €\n");
			                 listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()+500);//mettere la cifra giusta
			                 }
			System.out.println("POSIZIONE F"+position);//PROVA	
			listagioc.get(p).setPosizione(position);//imposto la nuova posizione
							
			System.out.println("Sei arrivato sulla casella "+tavolo.get(position).getNome());//inserire la csaella da richiamare
			}
			
			
			
			if (listagioc.get(p).getDenaro()<0) {
				listagioc.get(p).setRitirato(1);
				System.out.println("Giocatore "+listagioc.get(p).getNome()+", sei in bancarotta: hai perso!");
				/*break;*/}//se vado in negativo esce dal ciclo e poi da gioco
			
			//i++;
			
			return x;
			
	}
	
	/**
	 * Verifica la condizione che serve a ritirare i dadi ossia al lancioDadi devono comparire 2 numeri uguali per i dadi
	 * @return y  true se il giocatore ha diritto a ritirare false altrimenti
	 */
public boolean getDoppio(){
	return y;
}	

/**
 * Ricava la posizione del giocatore dopo avere effettuato il lancio dei dadi
 * @return position indica la posizione
 */
public int getPosition(){
	return position;
}

/**
 * Ricava la posizione del giocatore prima di avere effettuato il lancio dei dadi
 * @return prevposition indica la posizione
 */
public int getPrevPosition(){
	return prevposition;
}
///////////////////////////////////////////////////////////////////////////////////////

/**
 * Serve a terminare il game imponendo che tutti i giocatori si ritirino e ridistribuendo le proprietà alla banca(giocatore di indice 6)
 * @see #setRitirato(int)
 * @see #isAcquistabile()
 * @see #getProprietario()
 * @see Giocatore
 * @see Casella
 */
	public void endGame() {
		// questo fa i conti finali ai giocatori
		listagioc.get(p).setRitirato(1);
		int j;
		for(j=0;j<40;j++){
			if(tavolo.get(j).isAcquistabile()){
				if(((Proprietà)tavolo.get(j)).getProprietario()==p) ((Proprietà)tavolo.get(j)).setProprietario(6);
			}
		}
		

	}
/////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Fa ruotare il turno di ogni giocatore
	 * @param gioMax numero  di giocatori della partita
	 * @return p indice di turno
	 * 
	 */
	public int getGiocatore(int gioMax) {////gira il turno di ogni giocatore
		
		if(p==gioMax-1) {p=0;}
		else p++;
		
		
		
		//while(true){
			
			
			/*for(p=0;p<listagioc.size();p++){
				//lancioDadi();			
				//qualcosa la grafica deve passarglielo
				
				if(i==3) {listagioc.get(p).setPosizione(10);
				          listagioc.get(p).setN_turni_fermo(2); 
				}//se tiro 3 doppi vado in prigione
			}*/
			

			
		//}//while(true)

     return p;
		
	}
	
	/**
	 * Rimuove dalla lista di giocatori quelli che si sono ritirati e possiedono il parametro di getRitirato uguale a 1
	 * @see #getRitirato(int)
	 * @see Giocatore 
	 */
	public void getRemove(){
		int ptemp=0;
for(int p=0;p<listagioc.size();p++){
			
	        //int boh;
			if (listagioc.get(p).getRitirato()==1) {
                                                    		
			listagioc.remove(p);
			//boh=listagioc.size();
			//System.out.println(boh);
			//System.out.println(p);
			if(p==listagioc.size()) ptemp=0;
			else if (p==0) ptemp=0;
			else ptemp=p;//////////////controllare perche forse nn va
			
			    }
			
			}
           resetProprietà();
           p=ptemp;
	}
	
	
	/**
	 * Stabilisce quando un giocatore perde in base al fatto che si ritira
	 * @see #getRitirato(int)
	 * @see #getRemove()
	 * @return perso true se il giocatore ha perso
	 * 
	 * 
	 */
	public boolean haiPerso(){
		boolean perso;
		if(listagioc.get(p).getRitirato()==1) {
			getRemove();
			perso=true;
		}
		else perso=false;
		return perso;
	}
/////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Definisce tutte le mosse che un giocatore per regolamento è obbligato a svolgere:
	 * </ul>
	 * <li>pagare il transito singolo o doppio al proprietario del terreno
	 * <li>pagare qualora siano presenti case o alberghi
	 * <li>rispettare la condizione di prigione
	 * <li>rispettare gli obblighi imposti qualora il giocatore si trovi su caselle Probabilità o Imprevisti
	 * <li>obblighi di pagamento previsti per particolari caselle
	 * <li>possibilità di acquistare le caselle acquistabili
	 * @see #getTipo()
	 * @see #getProprietario(int)
	 * @see #getNome()
	 * @see #setDenaro(int)
	 * @see #getDenaro()
	 * @see #getAffitto2()
	 * @see #getAffitto()
	 * @see #SorteggioProb()
	 * @see #SorteggioImp()
	 * @see #VaiInGalera()
	 * @see Proprietà
	 * @see Stazione
	 * @sse Terreno
	 * @see Società
	 * @return st2 stringa che indica la frase da mostrare al giocatore sulle azioni fisse 
	 * @author La_donatac1
	 * 
	 */
	public String getObbligo(){
		String st1,st2,stcart1,stcart2;
		etichetta="";
		String proprietario=null;
//////////////////////////////////////////////////////Azioni fisse per caselle
		if(tavolo.get(position).getTipo().contentEquals("Terreno")){
			
             if(((Terreno)tavolo.get(position)).getProprietario()!=6 && ((Terreno)tavolo.get(position)).getProprietario()!=p) {
            	 proprietario=listagioc.get(((Terreno)tavolo.get(position)).getProprietario()).getNome();
            	 sameColor3=tabell.scanColorex3(tavolo.get(position),listagioc.get(p));

            	 if(sameColor3){
					//System.out.println("Paghi l'affitto di "+((Terreno)tavolo.get(position)).getAffitto2()+" € al giocatore "+((Terreno)tavolo.get(position)).getProprietario()+"\n");
					etichetta="Paghi l'affitto di "+((Terreno)tavolo.get(position)).getAffitto2()+" € al giocatore "+proprietario+"\n";
					listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-((Terreno)tavolo.get(position)).getAffitto2());//sottrae a chi paga
				    creditore=((Terreno)tavolo.get(position)).getProprietario();
				    listagioc.get(creditore).setDenaro(listagioc.get(creditore).getDenaro()+((Terreno)tavolo.get(position)).getAffitto2());//aggiunge al proprietario
				}
				else{
				//System.out.println("Paghi l'affitto di "+((Terreno)tavolo.get(position)).getAffitto()+" € al giocatore "+((Terreno)tavolo.get(position)).getProprietario()+"\n");
				etichetta="Paghi l'affitto di "+((Terreno)tavolo.get(position)).getAffitto()+" € al giocatore "+proprietario+"\n";
				listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-((Terreno)tavolo.get(position)).getAffitto());//sottrae a chi paga
			    creditore=((Terreno)tavolo.get(position)).getProprietario();
			    listagioc.get(creditore).setDenaro(listagioc.get(creditore).getDenaro()+((Terreno)tavolo.get(position)).getAffitto());//aggiunge al proprietario
				}
			}
             else if(((Terreno)tavolo.get(position)).getProprietario()==p) etichetta="Il terreno è tuo";
             else etichetta="Il terreno è della banca: puoi comprarlo";
		}
		else if(tavolo.get(position).getTipo().contentEquals("Terreno a 2")){
			
            if(((Terreno)tavolo.get(position)).getProprietario()!=6 && ((Terreno)tavolo.get(position)).getProprietario()!=p) {
            	proprietario=listagioc.get(((Terreno)tavolo.get(position)).getProprietario()).getNome();
            	sameColor2=tabell.scanColorex2(tavolo.get(position),listagioc.get(p));

            	if(sameColor2){
				   //System.out.println("Paghi l'affitto di "+((Terreno)tavolo.get(position)).getAffitto2()+" € al giocatore "+((Terreno)tavolo.get(position)).getProprietario()+"\n");
				   etichetta="Paghi l'affitto di "+((Terreno)tavolo.get(position)).getAffitto2()+" € al giocatore "+proprietario+"\n";
					listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-((Terreno)tavolo.get(position)).getAffitto2());//sottrae a chi paga
				    creditore=((Terreno)tavolo.get(position)).getProprietario();
				    listagioc.get(creditore).setDenaro(listagioc.get(creditore).getDenaro()+((Terreno)tavolo.get(position)).getAffitto2());//aggiunge al proprietario
			   }
			   else{
				//System.out.println("Paghi l'affitto di "+((Terreno)tavolo.get(position)).getAffitto()+" € al giocatore "+((Terreno)tavolo.get(position)).getProprietario()+"\n");
				etichetta="Paghi l'affitto di "+((Terreno)tavolo.get(position)).getAffitto()+" € al giocatore "+proprietario+"\n";
				listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-((Terreno)tavolo.get(position)).getAffitto());//sottrae a chi paga
			    creditore=((Terreno)tavolo.get(position)).getProprietario();
			    listagioc.get(creditore).setDenaro(listagioc.get(creditore).getDenaro()+((Terreno)tavolo.get(position)).getAffitto());//aggiunge al proprietario
			   }
			}
            else  if(((Terreno)tavolo.get(position)).getProprietario()==p) etichetta="Il terreno è tuo";
            else etichetta="Il terreno è della banca: puoi comprarlo";
		}
		else if(tavolo.get(position).getTipo().contentEquals("Via")){etichetta="";}
		else if(tavolo.get(position).getTipo().contentEquals("Società")){////fare scansione se ho 2 societa
			
             if(((Società)tavolo.get(position)).getProprietario()!=6 && ((Società)tavolo.get(position)).getProprietario()!=p) {
            	 proprietario=listagioc.get(((Società)tavolo.get(position)).getProprietario()).getNome();
            	 if(tabell.allSoc(listagioc.get(p))){
					//System.out.println("Paghi l'affitto di "+((Società)tavolo.get(position)).getAffitto2()+" € al giocatore "+((Società)tavolo.get(position)).getProprietario()+"\n");
					etichetta="Paghi l'affitto di "+((Società)tavolo.get(position)).getAffitto2()+" € al giocatore "+proprietario+"\n";
					listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-((Società)tavolo.get(position)).getAffitto2());//sottrae a chi paga
				    creditore=((Società)tavolo.get(position)).getProprietario();
				    listagioc.get(creditore).setDenaro(listagioc.get(creditore).getDenaro()+((Società)tavolo.get(position)).getAffitto2());//aggiunge al proprietario
				}
				else{
				//System.out.println("Paghi l'affitto di "+((Società)tavolo.get(position)).getAffitto()+" € al giocatore "+((Società)tavolo.get(position)).getProprietario()+"\n");
				etichetta="Paghi l'affitto di "+((Società)tavolo.get(position)).getAffitto()+" € al giocatore "+proprietario+"\n";
				listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-((Società)tavolo.get(position)).getAffitto());//sottrae a chi paga
			    creditore=((Società)tavolo.get(position)).getProprietario();
			    listagioc.get(creditore).setDenaro(listagioc.get(creditore).getDenaro()+((Società)tavolo.get(position)).getAffitto());//aggiunge al proprietario
				}
			}
             else  if(((Società)tavolo.get(position)).getProprietario()==p) etichetta="La società è tua";
             else etichetta="La società è della banca: puoi comprarla"; 
		}
		else if(tavolo.get(position).getTipo().contentEquals("Stazione")){////fare scansione se ho 4 stazioni
			
             if(((Stazione)tavolo.get(position)).getProprietario()!=6 && ((Stazione)tavolo.get(position)).getProprietario()!=p) {
            	 proprietario=listagioc.get(((Stazione)tavolo.get(position)).getProprietario()).getNome();
            	 if(tabell.allStaz(listagioc.get(p))){
					//System.out.println("Paghi l'affitto di "+((Stazione)tavolo.get(position)).getAffitto2()+" € al giocatore "+((Stazione)tavolo.get(position)).getProprietario()+"\n");
					etichetta="Paghi l'affitto di "+((Stazione)tavolo.get(position)).getAffitto2()+" € al giocatore "+proprietario+"\n";
					listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-((Stazione)tavolo.get(position)).getAffitto2());//sottrae a chi paga
				    creditore=((Stazione)tavolo.get(position)).getProprietario();
				    listagioc.get(creditore).setDenaro(listagioc.get(creditore).getDenaro()+((Stazione)tavolo.get(position)).getAffitto2());//aggiunge al proprietario
				}
				else {
				//System.out.println("Paghi l'affitto di "+((Stazione)tavolo.get(position)).getAffitto()+" € al giocatore "+((Stazione)tavolo.get(position)).getProprietario()+"\n");
				etichetta="Paghi l'affitto di "+((Stazione)tavolo.get(position)).getAffitto()+" € al giocatore "+proprietario+"\n";
				listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-((Stazione)tavolo.get(position)).getAffitto());//sottrae a chi paga
			    creditore=((Stazione)tavolo.get(position)).getProprietario();
			    listagioc.get(creditore).setDenaro(listagioc.get(creditore).getDenaro()+((Stazione)tavolo.get(position)).getAffitto());//aggiunge al proprietario
				}
			}
             else  if(((Stazione)tavolo.get(position)).getProprietario()==p) etichetta="La stazione è tua";
             else etichetta="La stazione è della banca: puoi comprarla"; 
		}
		else if(tavolo.get(position).getTipo().contentEquals("Transiti")){etichetta="";}
		else if(tavolo.get(position).getTipo().contentEquals("Tasse")){
			//System.out.println("Paghi "+((Tasse)tavolo.get(position)).getAffitto()+" € di tasse\n");
			etichetta="Paghi "+((Tasse)tavolo.get(position)).getAffitto()+" € di tasse\n";
			listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-((Tasse)tavolo.get(position)).getAffitto());
		}
		else if(tavolo.get(position).getTipo().contentEquals("Probabilità")){
			//System.out.println("Peschi una carta Probabilità:\n");
			stcart1="Peschi una carta Probabilità:\n";
			stcart2=SorteggioProb();
			etichetta=stcart1+stcart2;
		}
		else if(tavolo.get(position).getTipo().contentEquals("Imprevisti")){
			//System.out.println("Peschi una carta Imprevisti:\n");
			stcart1="Peschi una carta Imprevisti:\n";
			stcart2=SorteggioImp();
			etichetta=stcart1+stcart2;
		}
		else if(tavolo.get(position).getTipo().contentEquals("VaiPrigione")){
			System.out.println("Vai in Prigione direttamente senza passare dal Via\n");
			etichetta="Vai in Prigione direttamente senza passare dal Via\n";
			VaiInGalera();
			
			
		}
		else if(tavolo.get(position).getTipo().contentEquals("Prigione")){
			etichetta="";
			/*if(listagioc.get(p).getN_turni_fermo()>0) gattabuia=true;*/}
		
		st1="Sei arrivato sulla casella "+tavolo.get(position).getNome()+"\n";
		st2=st1+etichetta;
		return st2;
	}
//////////////////////////////////////////////////////////////////////////////////////////
	
	/**
	 * Consente di richiamare una scansione delle proprietà di un giocatore e in base al tipo di casella e allo stato di gioco del player offre una serie di menù testuali con cui compiere delle azioni:
	 * </ul>
	 * <li>se un giocatore è su una casella acquistabile di proprietà della banca può acquistarla
	 * <li>se un giocatore ha tutte le caselle dei gruppi di terreni(a 2 o a 3)dello stesso colore viene abilitata l'opzione di acquisto case
	 * <li>se un giocatore possiede i requisiti per edificare un albergo (4 case  e nessuno già edificato) viene abilitata l'opzione di costruire albergo
	 * <li>se un giocatore capita sui cartellini di probabilità o imprevisti gli viene offerto il solito menù per cui effettuato l'obbligo passa il turno
	 * <li>se un giocatore capita su caselle d'obbligo espleta i suoi obblighi e passa il turno
	 * <li>se un giocatore capita su stazioni e società può comprarle se di proprietà della banca
	 * @return vociMenu[] booleani che identificano l'abilitazione di un menu scelte in base all'azione
	 * @see #getTipo()
	 * @see #scanColorex3(Casella,Giocatore)
	 * @see #getProprietario() 
	 * @see #getNumCase()
	 * @see #getNumAlberghi()
	 * @see #scanColorex2(Casella,Giocatore)
	 * @see #getN_turni_fermo() 
	 * @see #setN_turni_fermo(int)
	 * @see #isUscita()
	 * @see Tabellone
	 * @see Giocatore
	 * @see Casella
	 * @see Proprietà 
	 * @see Terreno
	 * 
	 */
	public boolean[] getTurno() {
			boolean[] vociMenu=new boolean[11];
			
			
			vociMenu[0]=true;
			vociMenu[1]=true;
			vociMenu[2]=true;
			vociMenu[6]=true;
			vociMenu[7]=true;
		//////////////////////////////////////menu a scelta
		
////////////////////////////////////////////////////////////TERRENI
		if(tavolo.get(position).getTipo().contentEquals("Terreno")){
			sameColor3=tabell.scanColorex3(tavolo.get(position),listagioc.get(p));

			System.out.println("---Menu scelte---");
			System.out.println("0-Info giocatore");
			
			System.out.println("1-Mostra proprietà");
			System.out.println("2-Info casella");
			if(((Terreno)tavolo.get(position)).getProprietario()==6) {
					System.out.println("3-Compra");
					vociMenu[3]=true;
			}
								
								
			if(sameColor3 && ((Terreno)tavolo.get(position)).getNumCase()<4 && ((Terreno)tavolo.get(position)).getNumAlberghi()==0) {
				System.out.println("4-Costruisci case");
				vociMenu[4]=true;
			}
			else if(((Terreno)tavolo.get(position)).getNumCase()==4 && ((Terreno)tavolo.get(position)).getNumAlberghi()==0) {
				System.out.println("5-Costruisci albergo");
				vociMenu[5]=true;
			}
			System.out.println("6-Passa il turno");
			System.out.println("7-Ritirati");
			//scelta=choose.nextInt();
			
		}
		///////////////////////////////////////////////////////////////TERRENI A 2
		else if(tavolo.get(position).getTipo().contentEquals("Terreno a 2")) {
			sameColor2=tabell.scanColorex2(tavolo.get(position),listagioc.get(p));
			
			System.out.println("---Menu scelte---");
			System.out.println("0-Info giocatore");
			System.out.println("1-Mostra proprietà");
			System.out.println("2-Info casella");
			if(((Terreno)tavolo.get(position)).getProprietario()==6) {
				
				System.out.println("3-Compra");
				vociMenu[3]=true;
			}
			
		
			
			if(sameColor2 && ((Terreno)tavolo.get(position)).getNumCase()<4 && ((Terreno)tavolo.get(position)).getNumAlberghi()==0) {
				System.out.println("4-Costruisci case");
				vociMenu[4]=true;
			}
			else if(((Terreno)tavolo.get(position)).getNumCase()==4 && ((Terreno)tavolo.get(position)).getNumAlberghi()==0) {
				System.out.println("5-Costruisci albergo");
				vociMenu[5]=true;
			}
			System.out.println("6-Passa il turno");
			System.out.println("7-Ritirati");
			//scelta=choose.nextInt();
		}
		/////////////////////////////////////////////////////////////////VIA
		else if(tavolo.get(position).getTipo().contentEquals("Via")){
			
			System.out.println("---Menu scelte---");
			System.out.println("0-Info giocatore");
			System.out.println("1-Mostra proprietà");
			System.out.println("2-Info casella");
			System.out.println("6-Passa il turno");
			System.out.println("7-Ritirati");
			//scelta=choose.nextInt();
		}
		//////////////////////////////////////////////////////////////////SOCIETA
		else if(tavolo.get(position).getTipo().contentEquals("Società")){
			
            System.out.println("---Menu scelte---");
			System.out.println("0-Info giocatore");
			System.out.println("1-Mostra proprietà");
			System.out.println("2-Info casella");
			if(((Società)tavolo.get(position)).getProprietario()==6) {
				
			System.out.println("3-Compra");
			vociMenu[3]=true;
			}
			
			System.out.println("6-Passa il turno");
			System.out.println("7-Ritirati");
			//scelta=choose.nextInt();
		}
		/////////////////////////////////////////////////////////////////STAZIONI
		else if(tavolo.get(position).getTipo().contentEquals("Stazione")){
			
            System.out.println("---Menu scelte---");
			System.out.println("0-Info giocatore");
			System.out.println("1-Mostra proprietà");
			System.out.println("2-Info casella");
			if(((Stazione)tavolo.get(position)).getProprietario()==6) {
				
			System.out.println("3-Compra");
			vociMenu[3]=true;
			}
			
			System.out.println("6-Passa il turno");
			System.out.println("7-Ritirati");
			//scelta=choose.nextInt();
		}
		////////////////////////////////////////////////////////////////TRANSITI
		else if(tavolo.get(position).getTipo().contentEquals("Transiti")){
			
			System.out.println("---Menu scelte---");
			System.out.println("0-Info giocatore");
			System.out.println("1-Mostra proprietà");
			System.out.println("2-Info casella");
			System.out.println("6-Passa il turno");
			System.out.println("7-Ritirati");
			//scelta=choose.nextInt();
		}
		////////////////////////////////////////////////////////////////TASSE
		else if(tavolo.get(position).getTipo().contentEquals("Tasse")){
			
			System.out.println("---Menu scelte---");
			System.out.println("0-Info giocatore");
			System.out.println("1-Mostra proprietà");
			System.out.println("2-Info casella");
			System.out.println("6-Passa il turno");
			System.out.println("7-Ritirati");
			//scelta=choose.nextInt();
		}
		/////////////////////////////////////////////////////////////PROBABILITA
		else if(tavolo.get(position).getTipo().contentEquals("Probabilità")){
			
			System.out.println("---Menu scelte---");
			System.out.println("0-Info giocatore");
			System.out.println("1-Mostra proprietà");
			System.out.println("2-Info casella");
			System.out.println("6-Passa il turno");
			System.out.println("7-Ritirati");
			//scelta=choose.nextInt();
		}
		///////////////////////////////////////////////////////////IMPREVISTI
		else if(tavolo.get(position).getTipo().contentEquals("Imprevisti")){
			
			System.out.println("---Menu scelte---");
			System.out.println("0-Info giocatore");
			System.out.println("1-Mostra proprietà");
			System.out.println("2-Info casella");
			System.out.println("6-Passa il turno");
			System.out.println("7-Ritirati");
			//scelta=choose.nextInt();
		}
		////////////////////////////////////////////////////////////VAI IN PRIGIONE
		else if(tavolo.get(position).getTipo().contentEquals("VaiPrigione")){
			
		}
		/////////////////////////////////////////////////////////PRIGIONE
		else if(tavolo.get(position).getTipo().contentEquals("Prigione")){
			
			System.out.println("---Menu scelte---");
			System.out.println("0-Info giocatore");
			System.out.println("1-Mostra proprietà");
			System.out.println("2-Info casella");
			System.out.println("6-Passa il turno");
			System.out.println("7-Ritirati");
			System.out.println("giocator:"+p);
			if(listagioc.get(p).getN_turni_fermo()>0) {System.out.println("Sei in prigione: cosa vuoi fare?");////qui aggiungere il menu se uno è fermo in prigione, inoltre nn si puo tirare e questo va nel turno del giocatore
			
			listagioc.get(p).setPosizione(10);
			System.out.println("9-Paga per uscire");
			System.out.println("10-Tira i dadi");
			vociMenu[9]=true;
			vociMenu[10]=true;}
			if(listagioc.get(p).getN_turni_fermo()>0 && listagioc.get(p).isUscita()) {
				if(listagioc.get(p).isUscita()) System.out.println("8-Usa cartellino 'Esci gratis di prigione'");
				
				vociMenu[8]=true;
				listagioc.get(p).setN_turni_fermo(listagioc.get(p).getN_turni_fermo()-1);
				if(listagioc.get(p).getN_turni_fermo()==0) listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-125);////mettere cifra giusta
			}
			
			//scelta=choose.nextInt();
		}
		return vociMenu;
	}///getturno	
	
/*public void getScelta(int scelta){	////////////////////////////////////////////////////da sistemare con la gui
		/////////////////////richiama le funzioni delle caselle che vanno richiamate
		////////////////////////////////////////////////////////////////////////////
		if(scelta==0){//FATTA
			System.out.println(listagioc.get(p).getNome()+": "+listagioc.get(p).getDenaro());
			System.out.println(listagioc.get(p).getN_turni_fermo());//di prova
			}
		else if(scelta==1){//FATTA
			/*for(j=0;j<listagioc.get(p).getProprietà().size();j++){
				System.out.println(listagioc.get(p).getProprietà().get(j).getNome());
			}
		}
		else if(scelta==2){//FATTA
			System.out.println(tavolo.get(position).getNome());
			if(tavolo.get(position).getTipo().contentEquals("Terreno") || tavolo.get(position).getTipo().contentEquals("Terreno a 2")){
				System.out.println("Costo: "+((Terreno)tavolo.get(position)).getPrezzo());
				System.out.println("Affitto: "+((Terreno)tavolo.get(position)).getAffitto());
				System.out.println("Colore: "+((Terreno)tavolo.get(position)).getColore());
				System.out.println("Numero di case: "+((Terreno)tavolo.get(position)).getNumCase());
				System.out.println("Numero di alberghi: "+((Terreno)tavolo.get(position)).getNumAlberghi());
			}
			
			if(tavolo.get(position).getTipo().contentEquals("Stazione") || tavolo.get(position).getTipo().contentEquals("Società")) {
				System.out.println("Costo"+((Proprietà)tavolo.get(position)).getPrezzo());
				System.out.println("Affitto: "+((Proprietà)tavolo.get(position)).getAffitto());
			}
		}
		else if(scelta==3){//FATTA
			if(listagioc.get(p).getDenaro()>((Proprietà)tavolo.get(position)).getPrezzo()){
			listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-((Proprietà)tavolo.get(position)).getPrezzo());
			listagioc.get(p).setProprietà(tavolo.get(position));
			((Proprietà)tavolo.get(position)).setProprietario(p);
			}
			else System.out.println("Non hai abbastanza soldi!");
		}
		else if(scelta==4){//FATTA
			///////////////////////FARE QUESTO E ALBERGHI
			/*System.out.println("Quante case vuoi comprare (per ogni terreno)? Da 1 a 4, costo di una casa 50 €");
			//numCase=nCase.nextInt();
			if(numCase+((Terreno)tavolo.get(position)).getNumCase()<=4 && listagioc.get(p).getDenaro()>=numCase*50){
			
		     switch(numCase){
			case 1: 
				for(k=0;k<tavolo.size();k++){
				if(tavolo.get(k).getTipo().contentEquals("Terreno")||tavolo.get(k).getTipo().contentEquals("Terreno a 2")){
					if(((Terreno)tavolo.get(k)).getColore().contentEquals(((Terreno)tavolo.get(position)).getColore())) {
						((Terreno)tavolo.get(k)).setAffitto(((Terreno)tavolo.get(k)).getAffitto()+1*10);
						((Terreno)tavolo.get(k)).setNumCase(numCase);
					}//////cambia l'affitto di tutti e tre i terreni (o 2)
				}
			}
					
			         listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-1*50);//toglie soldi al giocatore
			         break;
			case 2:
				for(k=0;k<tavolo.size();k++){
					if(tavolo.get(k).getTipo().contentEquals("Terreno")||tavolo.get(k).getTipo().contentEquals("Terreno a 2")){
						if(((Terreno)tavolo.get(k)).getColore().contentEquals(((Terreno)tavolo.get(position)).getColore())) {
							((Terreno)tavolo.get(k)).setAffitto(((Terreno)tavolo.get(k)).getAffitto()+2*10);
							((Terreno)tavolo.get(k)).setNumCase(numCase);
						}//////cambia l'affitto di tutti e tre i terreni (o 2)
					}
				}
						
				         listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-1*50);//toglie soldi al giocatore
				         break;
			case 3:
				for(k=0;k<tavolo.size();k++){
					if(tavolo.get(k).getTipo().contentEquals("Terreno")||tavolo.get(k).getTipo().contentEquals("Terreno a 2")){
						if(((Terreno)tavolo.get(k)).getColore().contentEquals(((Terreno)tavolo.get(position)).getColore())) {
							((Terreno)tavolo.get(k)).setAffitto(((Terreno)tavolo.get(k)).getAffitto()+3*10);
							((Terreno)tavolo.get(k)).setNumCase(numCase);
						}//////cambia l'affitto di tutti e tre i terreni (o 2)
					}
				}
						
				         listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-1*50);//toglie soldi al giocatore
				         break;
			case 4:
				for(k=0;k<tavolo.size();k++){
					if(tavolo.get(k).getTipo().contentEquals("Terreno")||tavolo.get(k).getTipo().contentEquals("Terreno a 2")){
						if(((Terreno)tavolo.get(k)).getColore().contentEquals(((Terreno)tavolo.get(position)).getColore())) {
							((Terreno)tavolo.get(k)).setAffitto(((Terreno)tavolo.get(k)).getAffitto()+4*10);
							((Terreno)tavolo.get(k)).setNumCase(numCase);
						}//////cambia l'affitto di tutti e tre i terreni (o 2)
					}
				}
						  
				listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-1*50);//toglie soldi al giocatore
				break;
				
			}
		    }
			else if(listagioc.get(p).getDenaro()<numCase*50) System.out.println("Non hai abbastanza soldi!");
			else	System.out.println("Puoi avere al massimo 4 case!");
		}
		else if(scelta==5){//FATTA
			if(((Terreno) tavolo.get(position)).getNumCase()<4 && listagioc.get(p).getDenaro()>100){
				listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-100);
				//((Terreno)tavolo.get(position)).setNumAlberghi(1);inutile
				for(k=0;k<tavolo.size();k++){
					if(tavolo.get(k).getTipo().contentEquals("Terreno")||tavolo.get(k).getTipo().contentEquals("Terreno a 2")){
						if(((Terreno)tavolo.get(k)).getColore().contentEquals(((Terreno)tavolo.get(position)).getColore())) {
							((Terreno)tavolo.get(k)).setAffitto(((Terreno)tavolo.get(k)).getAffitto()+20);//mettere costo giusto
							((Terreno)tavolo.get(k)).setNumAlberghi(1);
						}//////cambia l'affitto di tutti e tre i terreni (o 2)
					}
				}
			}
			else System.out.println("Non puoi comprare un albergo!");
			
		}
		else if(scelta==6){/*niente, basta che esce}
		else if(scelta==7){listagioc.get(p).setRitirato(1);System.out.println("Ti sei ritirato dal gioco");}//FATTA
		else if(scelta==8){//FATTA
			listagioc.get(p).setUscita(false);
			listagioc.get(p).setN_turni_fermo(0);////ma una volta che esci puoi tirare subito???
			mazzoProb.add(cart4);
		}
		else if(scelta==9){//FATTA
			listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-125);
			listagioc.get(p).setN_turni_fermo(0);
		}
		else if(scelta==10){//FATTA	
			Mossa dadiPrig=new Mossa();
			int nlanci=0;
			do{
			System.out.println("E' uscito "+dadiPrig.muovi());
			if(dadiPrig.ritirare()) System.out.println("Il lancio è un doppio!Puoi uscire gratis di prigione");
			else System.out.println("I due dadi sono diversi");
			nlanci++;
			}while(nlanci<3 && dadiPrig.ritirare());
			if(nlanci==3) {
				System.out.println("Che sfortuna!!");
			    
			}
			else if(dadiPrig.ritirare()) {listagioc.get(p).setN_turni_fermo(0);}
		}
		
			
	}*///getscelta
	
	/**
	 * Definisce un mazzo con 4 cartellini di imprevisti in cui con l'estrazione di uno di questi che avviene random
	 * -per questo si crea l'oggetto random-si definisce una azione di gioco che viene messa in una stringa
	  * @see #azioneCartellino(int)
	 * @see CartelliniImp
	 * @return s stringa con contenuto del cartellino
	 */
	 
	  
	  
	public String SorteggioImp(){
		int x;
		String s;
		Random r=new Random();
		
		CartelliniImp cart1=new CartelliniImp();
		CartelliniImp cart2=new CartelliniImp();
		CartelliniImp cart3=new CartelliniImp();
		CartelliniImp cart4=new CartelliniImp();
		
		mazzoImp.add(0, cart1);
	    mazzoImp.add(1, cart2);
	    mazzoImp.add(2, cart3);
	    mazzoImp.add(3, cart4);
		
		x=r.nextInt(4);
		System.out.println(x);
		s=mazzoImp.get(x).azioneCartellino(x);
		return s;
	
}

	
	
	/**
	 * Definisce un mazzo con 4 cartellini di probabilità in cui con l'estrazione di uno di questi che avviene random
	 * -per questo si crea l'oggetto random-si definisce una azione di gioco che viene messa in una stringa
	 * e se un giocatore possiede il cartellino di uscita dalla prigione esso viene tolto dalla lista di cartellini probabilità.
	 * Viceversa viene incluso nel mazzo
	 * @see #azioneCartellino(int)
	 * @see CartelliniProb
	 * @return s stringa con contenuto del cartellino
	 */
public String SorteggioProb(){
		
		int x;
		String s;
		int w,counter=0;
		Random r=new Random();
		
		CartelliniProb cart1=new CartelliniProb();
		CartelliniProb cart2=new CartelliniProb();
		CartelliniProb cart3=new CartelliniProb();
		
		for(w=0;w<listagioc.size();w++){
			if(listagioc.get(w).isUscita()) counter++;
		}
		if(counter==1){
		mazzoProb.add(0, cart1);
	    mazzoProb.add(1, cart2);
	    mazzoProb.add(2, cart3);
	    x=r.nextInt(3);
		}
		else {
			mazzoProb.add(0, cart1);
		    mazzoProb.add(1, cart2);
		    mazzoProb.add(2, cart3);
		    mazzoProb.add(3, cart4);	
		x=r.nextInt(4);
		}
		s=mazzoProb.get(x).azioneCartellino(x);
		return s;
		
	}//per le probabilita*/

/**
 * Vengono definiti tutti i 4 cartellini imprevisti e le loro azioni
 * @param cart1 stringa che definisce il primo cartellino degli imprevisti
 * @param cart2 stringa che definisce il secondo cartellino degli imprevisti
 * @param cart3 stringa che definisce il terzo cartellino degli imprevisti
 * @param cart4 stringa che definisce il quarto cartellino degli imprevisti
 * @author La_donatac1
 *
 */
private class CartelliniImp{
	
private String cart1="Andate in prigione direttamente senza passare dal Via",cart2="Matrimonio in famiglia: spese impreviste: Paga 375 €",cart3="Avete vinto un terno al lotto ritirate 250 €",cart4="Siete impazziti per fare questo Monopoli: andate dallo psichiatra e spendete 200 €";
	
/**
 * Riceve in ingresso il random dell'estrazione a cui fa corrispondere un cartellino
 * @param n numero che identifica il cartellino da scegliere
 * @return str contiene la frase del cartellino
 * @see #getDenaro()
 * @see #setDenaro(int)
 * @see Giocatore
 */
	public String azioneCartellino(int n){
		
		String str=null;
		switch(n){
		case 0:System.out.println(cart1);
		       VaiInGalera();
		       str=cart1;
		       break;
		case 1:System.out.println(cart2);
		       listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-375);
		       str=cart2;
		       break;
		case 2:System.out.println(cart3);
		       listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()+250);
		       str=cart3;
		       break;
		case 3:System.out.println(cart4);
		       listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-200);
		       str=cart4;
		       break;
		}
		return str;
	}
	
	
}//inner class imprevisti

/**
 * Vengono definiti tutti i 4 cartellini probabilità e le loro azioni
 * @param cart1 stringa che definisce il primo cartellino degli probabilità
 * @param cart2 stringa che definisce il secondo cartellino degli probabilità
 * @param cart3 stringa che definisce il terzo cartellino degli probabilità
 * @param cart4 stringa che definisce il quarto cartellino degli probabilità
 * @param opzione oggetto che serve per consentire all'utente di scegliere tra 2 opzioni all'uscita di un particolare cartellino
 * @param str  contiene la frase del cartellino
 * @param pesca crea un nuovo mazzo di cartellini imprevisti
 * @param ran oggetto che definisce il random tra i 4 cartellini
 * @param num
 * @author La_donatac1
 *
 */
private class CartelliniProb{
	Scanner opzione=new Scanner(System.in);
    String str;
	private String cart1="Ereditate da un lontano parente 250 €",cart2="E' il vostro compleanno: ogni giocatore vi regala 25 €",cart3="Avete vinto il secondo premio ad un concorso di bellezza e ritirate 25 €",cart4="Uscite gratis di prigione";
	CartelliniImp pesca=new CartelliniImp();
	Random ran=new Random();
	
	/**
	 * Riceve in ingresso il random dell'estrazione a cui fa corrispondere un cartellino
	 * @param n numero di cartellino estratto
	 * @return str contiene la frase del cartellino
	 * @see #getDenaro()
	 * @see #setDenaro(int)
	 * @see #setUscita(boolean)
	 * @see #remove(int)
	 * 
	 * @see Giocatore
	 */
	public String azioneCartellino(int n){
		int scorr;
		int ngioc;
		switch(n){
		case 0:System.out.println(cart1);
		       listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()+250);
		       str=cart1;
		       break;
		case 1:System.out.println(cart2);
		       str=cart2;
		       ngioc=listagioc.size();
		       listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()+25*ngioc);
		       for(scorr=0;scorr<listagioc.size();scorr++){
		    	   if(!listagioc.get(scorr).equals(listagioc.get(p))) listagioc.get(scorr).setDenaro(listagioc.get(scorr).getDenaro()-25);
		       }
		       break;
		case 2:System.out.println(cart3);
		       listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()+25);
		       str=cart3;
		       break;
		case 3:System.out.println(cart4);
		       listagioc.get(p).setUscita(true);
		       mazzoProb.remove(3);
		       str=cart4;
		       break;
		}
		return str;
	}
	
}
 

/**
 * 
 * Inserisce correttamente in base a un indice il nome del giocatore
 * @param nomeGioc contiene il nome del giocatore
 * @param indice contiene l'indice di riferimento
 * @see setNome(String)
 */
public void addNamePlayer(String nomeGioc,int indice){
	
	listagioc.get(indice).setNome(nomeGioc);
}

/**
 * Serve a mostrare le informazioni riguardo a un giocatore come il nome e il denaro
 * @see #getDenaro()
 * @see Giocatore
 * @return s1 nome e denaro giocatore
 */
public String infoGioc(){
	String s1;
		
	s1=listagioc.get(p).getNome()+" : "+listagioc.get(p).getDenaro()+" €";
	return s1;
}

/**
 * Serve a determinare le informazioni su una casella definendo se terreno:
 * </ul>
 * <li>costo
 * <li>pagamento al transito da parte dei non proprietari
 * <li>colore
 * <li>numero di case
 * <li>numero di alberghi
 * @return sx contiene l'ArrayList di stringhe informative
 * @see #getTipo()
 * @see #getPrezzo()
 * @see #getAffitto()
 * @see #getColore()
 * @see #getNumCase()
 * @see #getNumAlberghi()
 * @see Casella
 * @see Terreni
 * @see Società
 */
public ArrayList<String> infoCasella(){
	ArrayList<String> sx=new ArrayList<String>();
	
	sx.add(tavolo.get(position).getNome()+"\n");
	if(tavolo.get(position).getTipo().contentEquals("Terreno") || tavolo.get(position).getTipo().contentEquals("Terreno a 2")){
		sx.add("Costo: "+((Terreno)tavolo.get(position)).getPrezzo()+"\n");
		sx.add("Affitto: "+((Terreno)tavolo.get(position)).getAffitto()+"\n");
		sx.add("Colore: "+((Terreno)tavolo.get(position)).getColore()+"\n");
		sx.add("Numero di case: "+((Terreno)tavolo.get(position)).getNumCase()+"\n");
		sx.add("Numero di alberghi: "+((Terreno)tavolo.get(position)).getNumAlberghi()+"\n");
	}
	if(tavolo.get(position).getTipo().contentEquals("Stazione") || tavolo.get(position).getTipo().contentEquals("Società")){
		sx.add("Costo"+((Proprietà)tavolo.get(position)).getPrezzo()+"\n");
		sx.add("Affitto: "+((Proprietà)tavolo.get(position)).getAffitto()+"\n");
	}
	
	return sx;
}

/**
 * Serve a definire informazioni sulle proprietà dei giocatori
 * @return sp arraylist che identifica le informazioni sulle proprietà 
 * @see #getProprietà()
 * @see #getTipo()
 * @see #getColore()
 * @see Terreno
 * @see Società
 * @see Casella
 */
public ArrayList<String> infoProp(){
	ArrayList<String> sp=new ArrayList<String>();
	String col=null;
	int scorr;
	for(scorr=0;scorr<listagioc.get(p).getProprietà().size();scorr++){
		col="";
		if(listagioc.get(p).getProprietà().get(scorr).getTipo().contentEquals("Terreno") || listagioc.get(p).getProprietà().get(scorr).getTipo().contentEquals("Terreno a 2")){
			col=": "+((Terreno)listagioc.get(p).getProprietà().get(scorr)).getColore();
		}
		sp.add((listagioc.get(p).getProprietà().get(scorr).getNome())+col);
		}
	return sp;
	
}

/**
 * Verifica la condizione di possesso di sufficiente denaro e poi acquista la casella
 * su cui il giocatore finisce dopo il lancio dei dadi se acquistabile
 * @see #getDenaro()
 * @see #getPrezzo()
 * @see #setDenaro(int)
 * @see Proprietà 
 * @return ret identifica l'azione se è andata a buon fine o meno
 */
public String compraCasella(){
	String ret;
	if(listagioc.get(p).getDenaro()>((Proprietà)tavolo.get(position)).getPrezzo()){
		listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-((Proprietà)tavolo.get(position)).getPrezzo());
		listagioc.get(p).setProprietà(tavolo.get(position));
		((Proprietà)tavolo.get(position)).setProprietario(p);
		ret="Hai comprato la casella!";
		}
	else ret="Non hai abbastanza soldi!";
	return ret;
}

/**
 * Verifica la condizione di essere su terreni di avere un numero di case inferiore a 4 e di avere sufficiente denaro per comprare un numero di case 
 * e in seguito permette di acquistare le case inserendole sulla casella con la funzione appropriata 
 * @see #getTipo()
 * @see #getNumCase()
 * @see #getDenaro()
 * @see #getColore()
 * @see #setAffitto(int)
 * @see #getAffitto()
 * @see #setNumCase(int)
 * @see Terreno
 * @see Casella
 * @param numCase numero di case da acquistare
 * @return sterr contiene l'informazione sull'azione compiuta
 */
public String compraCase(int numCase){
	String sterr;
	
		if(numCase+((Terreno)tavolo.get(position)).getNumCase()<=4 && listagioc.get(p).getDenaro()>=numCase*50){
			
		     switch(numCase){
			case 1: 
				for(k=0;k<tavolo.size();k++){
				if(tavolo.get(k).getTipo().contentEquals("Terreno")||tavolo.get(k).getTipo().contentEquals("Terreno a 2")){
					if(((Terreno)tavolo.get(k)).getColore().contentEquals(((Terreno)tavolo.get(position)).getColore())) {
						((Terreno)tavolo.get(k)).setAffitto(((Terreno)tavolo.get(k)).getAffitto()+1*10);
						((Terreno)tavolo.get(k)).setNumCase(numCase);
					}//////cambia l'affitto di tutti e tre i terreni (o 2)
				}
			}
					
			         listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-1*50);//toglie soldi al giocatore
			         break;
			case 2:
				for(k=0;k<tavolo.size();k++){
					if(tavolo.get(k).getTipo().contentEquals("Terreno")||tavolo.get(k).getTipo().contentEquals("Terreno a 2")){
						if(((Terreno)tavolo.get(k)).getColore().contentEquals(((Terreno)tavolo.get(position)).getColore())) {
							((Terreno)tavolo.get(k)).setAffitto(((Terreno)tavolo.get(k)).getAffitto()+2*10);
							((Terreno)tavolo.get(k)).setNumCase(numCase);
						}//////cambia l'affitto di tutti e tre i terreni (o 2)
					}
				}
						
				         listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-2*50);//toglie soldi al giocatore
				         break;
			case 3:
				for(k=0;k<tavolo.size();k++){
					if(tavolo.get(k).getTipo().contentEquals("Terreno")||tavolo.get(k).getTipo().contentEquals("Terreno a 2")){
						if(((Terreno)tavolo.get(k)).getColore().contentEquals(((Terreno)tavolo.get(position)).getColore())) {
							((Terreno)tavolo.get(k)).setAffitto(((Terreno)tavolo.get(k)).getAffitto()+3*10);
							((Terreno)tavolo.get(k)).setNumCase(numCase);
						}//////cambia l'affitto di tutti e tre i terreni (o 2)
					}
				}
						
				         listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-3*50);//toglie soldi al giocatore
				         break;
			case 4:
				for(k=0;k<tavolo.size();k++){
					if(tavolo.get(k).getTipo().contentEquals("Terreno")||tavolo.get(k).getTipo().contentEquals("Terreno a 2")){
						if(((Terreno)tavolo.get(k)).getColore().contentEquals(((Terreno)tavolo.get(position)).getColore())) {
							((Terreno)tavolo.get(k)).setAffitto(((Terreno)tavolo.get(k)).getAffitto()+4*10);
							((Terreno)tavolo.get(k)).setNumCase(numCase);
						}//////cambia l'affitto di tutti e tre i terreni (o 2)
					}
				}
						  
				listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-4*50);//toglie soldi al giocatore
				break;
				
			}
		     sterr="Hai comprato "+numCase+" case!"; 
		    }
			else if(listagioc.get(p).getDenaro()<numCase*50) sterr="Non hai abbastanza soldi!";
			else  sterr="Puoi avere al massimo 4 case!";
		return sterr;
}

/**
 * Verifica la condizione di essere su terreni di avere un numero di case uguale a 4 e di avere sufficiente denaro per comprare un albergo
 * e in seguito inserisce l'albergo  sulla casella con la funzione appropriata 
 * @see #getTipo()
 * @see #getNumCase()
 * @see #getDenaro()
 * @see #getColore()
 * @see #setAffitto(int)
 * @see #getAffitto()
 * @see #setNumAlberghi(int)
 * @see #setNumCase(int)
 * @see Terreno
 * @see Casella
 * @return ret contiene l'informazione sull'azione compiuta
 */
public String compraAlbergo(){
	String ret;
	if(((Terreno) tavolo.get(position)).getNumCase()<4 && listagioc.get(p).getDenaro()>100){
		listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-100);
		//((Terreno)tavolo.get(position)).setNumAlberghi(1);inutile
		for(k=0;k<tavolo.size();k++){
			if(tavolo.get(k).getTipo().contentEquals("Terreno")||tavolo.get(k).getTipo().contentEquals("Terreno a 2")){
				if(((Terreno)tavolo.get(k)).getColore().contentEquals(((Terreno)tavolo.get(position)).getColore())) {
					((Terreno)tavolo.get(k)).setAffitto(((Terreno)tavolo.get(k)).getAffitto()+20);//mettere costo giusto
					((Terreno)tavolo.get(k)).setNumAlberghi(1);
					((Terreno)tavolo.get(k)).setNumCase(0);
				}//////cambia l'affitto di tutti e tre i terreni (o 2)
			}
		}
		ret="Hai comprato un albergo!";
	}
	else ret="Non puoi comprare un albergo!";
	return ret;
}



/**
 * Rappresenta la possibilità di uscire di prigione col cartellino e setta lo stato di possesso di nuovo a false e il numero di turni fermo a 0
 * @see #setUscita(boolean)
 * @see #setN_turni_fermo (int)
 * @see Giocatore
 */
public void usaEsciGratis(){
	listagioc.get(p).setUscita(false);
	listagioc.get(p).setN_turni_fermo(0);////ma una volta che esci puoi tirare subito???
	
}

/**
 * Serve a uscire di prigione pagando:
 * definisce il numero di turni fermo 0
 * @see #setN_turni_fermo (int)
 * @see #setDenaro(int)
 * @see #getDenaro()
 * @see Giocatore
 */
public void pagaPrigione(){
	listagioc.get(p).setDenaro(listagioc.get(p).getDenaro()-125);
	listagioc.get(p).setN_turni_fermo(0);
	
	
}


/**
 * Verifica la condizione di uscita tramite un doppio con un massimo di tre tentativi
  * @see #setN_turni_fermo(int)
 * @see #ritirare()
 * @see #muovi()
 * @see Giocatore
 * @see Mossa
 * @return  p3 la stringa che avvisa che i 2 dadi sono diversi
 */
public String tiraPrigione(){
	Mossa dadiPrig=new Mossa();
	String p1,p2,p3;
	puoiUscire=false;
	p1="Hai tirato! E' uscito "+dadiPrig.muovi();
	if(dadiPrig.ritirare()) {
		p2=": il lancio è un doppio!Puoi uscire gratis di prigione";
		listagioc.get(p).setN_turni_fermo(0);
		puoiUscire=true;
		//gattabuia=false;
		}
	else p2=": i due dadi sono diversi";
	p3=p1+p2;
	return p3;
}

/**
 * Verifica che si può uscire di prigione
 * @return puoiUscire true se si può uscire
 */ 
public boolean uscitaOk(){
	return puoiUscire;
}


/**
 * Verifica che il turno di un giocatore è definito >0 se in prigione
 * @see  #getN_turni_fermo()
 * @return true se in prigione false altrimenti
 * @see Giocatore
 */
public boolean isGattaBuia(){
	if(listagioc.get(p).getN_turni_fermo()>0) return true;
	return false;
}

/**
 * Imposta le condizioni di galera ovvero numero di turni fermi 2 e posizione in campo 10
 * @see #setPosizione(int)
 * @see #setN_turni_fermo(int)
 * @see Giocatore
 *
 */
public void VaiInGalera(){
	listagioc.get(p).setPosizione(10);
	listagioc.get(p).setN_turni_fermo(2);
	//gattabuia=true;
	//giocFermo=p;
	//stopTurno=true;
}




/**
 * Imposta la posizione del giocatore a 10
 * @see Giocatore
 * @see #setPosizione(int)
 */
public void setStopped(){
	listagioc.get(p).setPosizione(10);
	position=10;
}


/**
 * Imposta tutte le proprietà sull'ultimo giocatore e cioè la banca(sesto)
 * @param listagioc ArrayList che indica la lista di giocatori partecipanti alla partita
* @see #getProprietà()
* @see #getNome()
* @see #setProprietario(int)
* @see Giocatore
* @see Casella
 */
public void resetProprietà(){
	int z,q,t;
	
	for(t=0;t<listagioc.size();t++){//ciclo sui giocatori
	
	for(z=0;z<listagioc.get(t).getProprietà().size();z++){//ciclo sulle proprietà
		for(q=0;q<tavolo.size();q++){//ciclo sulle caselle
			if(tavolo.get(q).getNome().contentEquals(listagioc.get(t).getProprietà().get(z).getNome())) {
				((Proprietà)tavolo.get(q)).setProprietario(t);
			}
		}
	}
	}
}
}//class





