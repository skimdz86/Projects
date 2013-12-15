package monopoli;

import java.util.ArrayList;
import java.util.Random;
/**
 * Rappresenta la creazione del tabellone del gioco con tutte le caselle inserite in un ArrayList di caselle
 * in cui vengono inseriti tutti i tipi di caselle:
 * </ul>
 * <li>terreni
 * <li>probabilità
 * <li>imprevisti
 * <li>stazioni
 * <li>società
 * <li>transito
 * <li>prigione
 * <li>Tasse e partenza
 * <p>
 * Queste caselle vengono caratterizzate in base al loro nome e alla tipologia che offre la possibilità per alcune di esse (che rientrano nei tipi Stazioni-Terreni-Società) 
 * di poterle acquistare e ottenerne profitti al transito di altri giocatori non proprietari
 * Inoltre per le caselle di tipo Terreno è possibile svolgere una azione complementare di costruzione di case e alberghi
 * solo nei casi in cui si abbiano tutti i terreni dello stesso colore
 * <p>
 * A tal proposito nella classe Tabellone vengono scandite le proprietà inizialmente di proprietà della banca () (successivamente distribuzione random)
 * per distinguere i gruppi  di terreni dello stesso colore a due sole caselle e quelli a tre caselle 
 * Viene inoltre controllato se si possiedono tutti i terreni dello stesso colore tutte le stazioni e le società
 * @param listaCaselle contiene tutte le caselle di gioco
 * @author La_donatac1
 *
 */
public class Tabellone {

	private ArrayList<Casella> listaCaselle= new ArrayList<Casella>();	
	
	/**
	 * Crea il tabellone di gioco inserendo in una lista di caselle tutte le 40
	 * caselle di tipologia diversa:
	 * </ul>
	 * <li>Terreni
	 * <li>Imprevisti
	 * <li>Probabilità
	 * <li>Stazioni
	 * <li>Società
	 * <li>Transito
	 * <li>Prigione
	 * <li>Via più Tasse
	 * Vengono generati tutti gli oggetti corrispondenti alle caselle
	 * e vengono inizializzati i parametri in ingresso
	 * </ul>
	 * <li>Via
	 * <li>Terreno
	 * <li>Probabilità
	 * <li>Stazione
	 * <li>Imprevisti
	 * <li>Transiti
	 * <li>Società
	 * <li>VaiPrigione
	 * <li>Tasse
	 * @return listaCaselle la lista che contiene le 40 caselle del tabellone di gioco
	 */
	public ArrayList<Casella> creaTabellone(){
	
		///proprietario 6 è la banca
	listaCaselle.add(0,new Via("Via","Via",false));
	listaCaselle.add(1,new Terreno("Vicolo Corto","Terreno a 2",150,"Rosa",true,5,10,6,0,0));
	listaCaselle.add(2,new Probabilità("Probabilità","Probabilità",false));
	listaCaselle.add(3,new Terreno("Vicolo Stretto","Terreno a 2",150,"Rosa",true,10,20,6,0,0));
	listaCaselle.add(4,new Tasse("Tassa Patrimoniale","Tasse",500,false));
	listaCaselle.add(5,new Stazione("Stazione Sud","Stazione",480,true,60,120,6));
	listaCaselle.add(6,new Terreno("Bastioni Gran Sasso","Terreno",250,"Blu",true,15,30,6,0,0));                            
	listaCaselle.add(7,new Imprevisti("Imprevisti","Imprevisti",false));
	listaCaselle.add(8,new Terreno("Viale Monterosa","Terreno",250,"Blu",true,15,30,6,0,0));         	              
	listaCaselle.add(9,new Terreno("Viale Vesuvio","Terreno",300,"Blu",true,20,40,6,0,0));
	listaCaselle.add(10,new Transiti("Prigione/transito","Prigione",false));
	listaCaselle.add(11,new Terreno("Via Accademia","Terreno",350,"Arancione",true,25,50,6,0,0));
	listaCaselle.add(12,new Società("Società Elettrica","Società",380,true,50,100,6));
	listaCaselle.add(13,new Terreno("Corso Ateneo","Terreno",350,"Arancione",true,25,50,6,0,0));
	listaCaselle.add(14,new Terreno("Piazza Università","Terreno",400,"Arancione",true,30,60,6,0,0));                            
	listaCaselle.add(15,new Stazione("Stazione Ovest","Stazione",480,true,60,120,6));
	listaCaselle.add(16,new Terreno("Via Verdi","Terreno",450,"Marrone",true,35,70,6,0,0));
	listaCaselle.add(17,new Probabilità("Probabilità","Probabilità",false));
	listaCaselle.add(18,new Terreno("Corso Raffaello","Terreno",450,"Marrone",true,35,70,6,0,0));                            
	listaCaselle.add(19,new Terreno("Piazza Dante","Terreno",500,"Marrone",true,40,80,6,0,0));
	listaCaselle.add(20,new Transiti("Parcheggio libero","Transiti",false));         	              
    listaCaselle.add(21,new Terreno("Via Marco Polo","Terreno",550,"Rosso",true,45,90,6,0,0));
    listaCaselle.add(22,new Imprevisti("Imprevisti","Imprevisti",false));
	listaCaselle.add(23,new Terreno("Corso Magellano","Terreno",550,"Rosso",true,45,90,6,0,0));
	listaCaselle.add(24,new Terreno("Largo Colombo","Terreno",600,"Rosso",true,50,100,6,0,0));
	listaCaselle.add(25,new Stazione("Stazione Nord","Stazione",480,true,60,120,6));
	listaCaselle.add(26,new Terreno("Viale Costantino","Terreno",650,"Giallo",true,55,110,6,0,0));                            
	listaCaselle.add(27,new Terreno("Viale Traiano","Terreno",650,"Giallo",true,55,110,6,0,0));
	listaCaselle.add(28,new Società("Società Acqua Potabile","Società",380,true,50,100,6));
	listaCaselle.add(29,new Terreno("Piazza Giulio Cesare","Terreno",700,"Giallo",true,60,120,6,0,0));
	listaCaselle.add(30,new VaiPrigione("Vai in prigione","VaiPrigione",false));                            
	listaCaselle.add(31,new Terreno("Via Roma","Terreno",750,"Verde",true,65,130,6,0,0));
	listaCaselle.add(32,new Terreno("Corso Impero","Terreno",750,"Verde",true,65,130,6,0,0));         	              
	listaCaselle.add(33,new Probabilità("Probabilità","Probabilità",false));
	listaCaselle.add(34,new Terreno("Largo Augusto","Terreno",800,"Verde",true,70,140,6,0,0));
	listaCaselle.add(35,new Stazione("Stazione Est","Stazione",480,true,60,120,6));
	listaCaselle.add(36,new Imprevisti("Imprevisti","Imprevisti",false));
	listaCaselle.add(37,new Terreno("Viale Dei Giardini","Terreno a 2",900,"Viola",true,160,320,6,0,0));
	listaCaselle.add(38,new Tasse("Tassa Di Lusso","Tasse",250,false));                            
	listaCaselle.add(39,new Terreno("Parco Della Vittoria","Terreno a 2",1000,"Viola",true,250,500,6,0,0));
	   
	   return listaCaselle;
	}
	
	/**
	 * Individua inserendo in un Array temporaneo tutti i gruppi di terreni a tre dello stesso colore di proprietà di un giocatore
	 * e se un giocatore possiede un gruppo intero di tre terreni restituisce il booleano per l'affitto raddoppiato e la possibilità di costruire una casa 
	 * @param c casella di tipo terreno di cui si prende il colore di riferimento per vedere quanti sono i terreni di quel colore in possesso del giocatore 
	 * @param g giocatore su cui si analizzano le proprietà
	 * @see #getProprietà
	 * @see #getTipo
	 * @return true se sono presenti tre terreni dello stesso colore false se due o uno solo o nessuno
	 */
	public boolean scanColorex3(Casella c,Giocatore g){
		
		String s=((Terreno)c).getColore();
		int i,j;
		int count=0;
		ArrayList<Casella> temp=new ArrayList<Casella>();
		
		for(j=0;j<g.getProprietà().size();j++){
			if(g.getProprietà().get(j).getTipo().contentEquals("Terreno")) temp.add(g.getProprietà().get(j));	
		}
		
		
		for(i=0;i<temp.size();i++){
			
			if(((Terreno)temp.get(i)).getColore().contentEquals(s)) count++;
		}
		if(count==3)return true;
		else return false;
	}
	
	/**
	 * Individua inserendo in un Array temporaneo tutti i gruppi di terreni a 2 dello stesso colore di proprietà di un giocatore
	 * e se un giocatore possiede un gruppo intero di 2 terreni restituisce il booleano per l'affitto raddoppiato e la possibilità di costruire una casa 
	 * @param c casella di tipo terreno di cui si prende il colore di riferimento per vedere quanti sono i terreni di quel colore in possesso del giocatore 
	 * @param g giocatore su cui si analizzano le proprietà
	 * @see #getProprietà
	 * @see #getTipo
	 * @return true se sono presenti 2 terreni dello stesso colore false se due o uno solo o nessuno
	 */
public boolean scanColorex2(Casella c,Giocatore g){
		
	String s=((Terreno)c).getColore();
	int i,j;
	int count=0;
	ArrayList<Casella> temp=new ArrayList<Casella>();
	
	for(j=0;j<g.getProprietà().size();j++){
		if(g.getProprietà().get(j).getTipo().contentEquals("Terreno a 2")) temp.add(g.getProprietà().get(j));	
	}
	
	
	for(i=0;i<temp.size();i++){
		
		if(((Terreno)temp.get(i)).getColore().contentEquals(s)) count++;
	}
	if(count==2)return true;
	else return false;
	}
	
/**
 * Verifica le società di proprietà dei giocatori
 * se tali società sono complete ossia sono entrambe di un giocatore allora si raddoppia il pagamento di transito 
 * @param g giocatore di cui si verificano le proprietà di tipo società
 * @see #getProprietà
 * @see #getTipo
 * @return true se si possiedono tutte le società
 * 
 */
public boolean allSoc(Giocatore g){
	int j;
	int count=0;
	for(j=0;j<g.getProprietà().size();j++){
		if(g.getProprietà().get(j).getTipo().contentEquals("Società")) count++;
	}
	if(count==2) return true;
	else return false;
}

/**
 * Controlla che tra le proprietà di un giocatore ci siano delle stazioni
 * @param g giocatore su cui si verifica il possesso di stazioni
 * @see #getProprietà
 * @see #getTipo
 * @return
 */
public boolean allStaz(Giocatore g){
	int j;
	int count=0;
	for(j=0;j<g.getProprietà().size();j++){
		if(g.getProprietà().get(j).getTipo().contentEquals("Stazione")) count++;
	}
	if(count==4) return true;
	else return false;
}







}
