package monopoli;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Definisce tutta l'interfaccia grafica utilizzata dall'utente
 * <p>
 * Questa Classe infatti si occupa di iniziare il gioco lanciando prima una schermata iniziale di presentazione e poi
 * successivamente si occupa della scelta dei giocatori e provvede con opportuni metodi a creare il tabellone di gioco su cui poi si verificano eventi
 * con cui l'utente interagisce
 * <p>
 * Nel dettaglio essa si compone di un frame introduttivo con un'immagine introduttiva inserita in un pannelloche precede lo start game
 * Successivamente un nuovo frame presenta un pannello che ospita i sei pulsanti con la scelta del numero di giocatori e un'altro con relative immagini in base ai personaggi
 * Superata questa fase di selezione si genera il tabellone con un ulteriore frame a 2 pannelli:
 * </ul>
 * <li>il primo presenta inserita in una label l'immagine di gioco con un menubar in altro che fa scorrere un menu azioni
 * <li>il secondo presenta un bottone che effettua il lancio dei dadi e un jtext inferiore che indica le azioni di gioco
 * Il tutto è corredato di pop up e messageDialog che informano sullo stato delle operazioni di gioco
 * @param frame oggetto di tipo frame ossia l'impalcatura per l'interfaccia grafica con il tabellone e i pulsanti per le varie azioni
 * @param inizio oggetto di tipo frame che accoglie i pulsanti per la scelta dei giocatori
 * @param i indice che tiene il conto dei giocatori selezionati
 * @param massimo indice che tiene conti del numero di giocatori della partita
 * @param nomePedine è un ArrayList che memorizza i nomi delle pedine
 * @param frame2 è il frame che ingloba i pulsanti per la scelta del numero dei giocatori
 * @param numeroMax numero massimo di giocatori
 * @param idGioc tiene l'indice del giocatore corrente
 * @param pannello1 pannello che contiene la label con l'immagine del tabellone e la menubar
 * @param pannello2 pannello che contiene il pulsante di azione e il testo delle azioni
 * @param pos posizione dopo il lancio dei dadi
 * @param file oggetto della menubar che consente di compiere diverse azioni di gioco
 * @param dati oggetto della menubar che consente di sapere informazioni dello stato di gioco
 * @param prigione oggetto della menubar che mi consente di verificare lo stato di prigionia di un giocatore
 * @param compra oggetto del munu che mi consente se possibile di acquistare un oggetto di gioco
 * @param casa oggetto di tipo menu che consente di acquistare casa se possibile
 * @param albergo oggetto di tipo menu che definisce l'acquisto di albergo nel rispetto delle condizioni di gioco
 * @param prosegui è un oggetto del menu che consente di passare il turno
 * @param ritirati è un oggetto del menu che permette al giocatore di ritirarsi
 * @param denaro è un oggetto del menu che consente di sapere info riguardanti il denaro di gioco
 * @param prorpietà è un oggetto del menu che viualizza le proprietà del giocatore
 * @param about è un oggetto del menu che definisce le informazioni principali della casella su cui si trova il giocatore
 * @param esci oggetto del menu che serve a compiere qualora si sia in possesso del cartellino degli imprevisti di uscire di prigione
 * @param paga oggetto del menu che serve a uscire di prigione pagando 
 * @param lancia bottone che effettua il lancio dadi
 * @param testo pannello testuale su cui sono riportate le info di gioco
 * @param barra menubar che contiene vari menu che contestualizzano le azioni di gioco
 * @param voci array di booleani che controllano se sia possibile o meno effettuare determinate azioni di gioco nell'interfaccia
 * @param gioc contiene il nome del giocatore
 * @param chisei label che definisce testualmente a chi tocca giocare
 * @param fun oggetto di tipo immagine che serve a rappresentare le pedine di gioco(fungo)
 * @param can oggetto di tipo immagine che serve a rappresentare le pedine di gioco(candela)
 * @param pia oggetto di tipo immagine che serve a rappresentare le pedine di gioco(pianta)
 * @param fia oggetto di tipo immagine che serve a rappresentare le pedine di gioco(fiasco)
 * @param mel oggetto di tipo immagine che serve a rappresentare le pedine di gioco(mela)
 * @param per oggetto di tipo immagine che serve a rappresentare le pedine di gioco(pera)
 * @param fungo label per la pedina fungo
 * @param candela label per la pedina candela
 * @param fiasco label per la pedina fiasco
 * @param mela label per la pedina mela
 * @param pera label per la pedina pera
 * @param pianta label per la pedina pianta
 * @param nlanci indice che conta il numero di lanci doppi (condizione per entrare e uscire di prigione)
 * @param Timer oggetto che serve a scandire il posizionamento delle pedine di gioco
 * @param poz posizione dopo il lancio dei dadi
 * @param rect oggetto di tipo rettangolo che viene ogni volta ridefinito(in un parametro) per essere passato alla setBound che posiziona le pedine
 * @param postemp indice che indica lo spostamento casella per casella delle pedine di gioco
 * @see UserInterfaceConnector
 * @see Game
 * @author La_donatac1

 */


public class GUI {
	
	private Timer timer;
	private int poz;
	private Rectangle rect;
	private int postemp;
	private UserInterfaceConnector Gioco= new Game();
	private JFrame introduzione;
	private JFrame frame;
	private JFrame inizio;
	private int i;
	//private int numeroLanciDoppi=0;
	private int massimo=0;
	//private String control;//controlla se private
	private ArrayList<String> nomePedine=new ArrayList<String>();
	private JFrame frame2;
	private int numeroMax=0;
	private int idGioc=0;//controllla se private
	private JPanel pannello1;
	private JPanel pannello2;
	private int pos;
	
	/**
	 * Consente di creare un frame che inizia il gioco delmonopoli attraverso i bottoni indicanti il numero di giocatori
	 * per la partita
	 * @throws InterruptedException 
	 */
public void ShowNumber() {
	
	Gioco.startGame();
	    
	introduzione=new JFrame("                                                                               ------MONOPOLI------");
	introduzione.setLocation(130,0);    
	ImageIcon presentazione=new ImageIcon("./monopoli/monopoly_back_pencil.JPEG");
	    JLabel pres =new JLabel(presentazione);
	    JLabel author=new JLabel("                                                                           De Zorzi & Donatacci Production presents\n");
	    JPanel pannpres1 =new JPanel();
	    pannpres1.setLayout(new BorderLayout());
	    //pannpres1.setLayout(null);
	    //JPanel pannpres2=new JPanel();
	    pannpres1.add(author, BorderLayout.NORTH);
	    pannpres1.add(pres,BorderLayout.SOUTH);
	    //introduzione.setLayout(null);
	   // pannpres2.add(new JButton("START GAME"));
	    introduzione.add(pannpres1);
	    //introduzione.add(pannpres2,BorderLayout.SOUTH);
	    pannpres1.setPreferredSize(new Dimension(700,600));
	    pannpres1.add(pres);
	    introduzione.pack();
	    introduzione.setVisible(true);
	    
	   try{
		   Thread.sleep(4000);
		   }catch(InterruptedException o){}
		   introduzione.dispose();
	   
		inizio=new JFrame("            ------MONOPOLI------");
		inizio.setLocation(300, 320);
	    inizio.setLayout(new BorderLayout());
	    inizio.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    JPanel frase=new JPanel();
	    JPanel bott=new JPanel();
	    JLabel lab=new JLabel("In quanti volete giocare?");
	    
	    JButton b2=new JButton("   2   ");
	    JButton b3=new JButton("   3   ");
	    JButton b4=new JButton("   4   ");
	    JButton b5=new JButton("   5   ");
	    JButton b6=new JButton("   6   ");
	    
	    b2.addActionListener(new MyButtonListener2());
	    b3.addActionListener(new MyButtonListener2());
	    b4.addActionListener(new MyButtonListener2());
	    b5.addActionListener(new MyButtonListener2());
	    b6.addActionListener(new MyButtonListener2());
	    
	    frase.add(lab);
	    
	    bott.setLayout(new FlowLayout());
	    bott.add(b2);
	    bott.add(b3);
	    bott.add(b4);
	    bott.add(b5);
	    bott.add(b6);
	    
	    inizio.add(frase,BorderLayout.NORTH);
	    inizio.add(bott,BorderLayout.SOUTH);
		
	    inizio.pack();
	    inizio.setVisible(true);
	    
	}
	
/**
 * Permette di compiere effettivamente le azioni a partire dall'interfaccia grafica
 * <p>
 * In particolar modo questa classe consente diconfigurare i bottoni iniziali per la scelta del numero dei giocatori
 * @author La_donatac1
 *
 */
	private class MyButtonListener2 implements ActionListener{
/**
 * Determina attraverso la pressione dei bottoni iniziali la scelta del numero dei giocatori
 * @param e evento clic sul pulsante JButton
 * @see #addPlayer(int)
 * @see UserInterfaceConnector
 * @see Game
 */
		public void actionPerformed(ActionEvent e) {
			
			String num;
			
			num=(((JButton)e.getSource()).getText());
			if(num.contentEquals("   2   ")){
				massimo=2;
			}
			if(num.contentEquals("   3   ")){
				massimo=3;
			}
			if(num.contentEquals("   4   ")){
				massimo=4;
			}
			if(num.contentEquals("   5   ")){
				massimo=5;
			}
			if(num.contentEquals("   6   ")){
				massimo=6;
			}
			Gioco.addPlayer(massimo);
			
			GuiSelez(massimo);
			inizio.dispose();
		}
		
		
	}
	
	/**
	 * Inner Class che consente la scelta delle pedine:
	 * </ul>
	 * <li>fungo
	 * <li>fiasco
	 * <li>pianta
	 * <li>pera
	 * <li>mela
	 * <li>candela
	 * <p>
	 * Essa riceve come ingresso il numero di giocatori selezionato col frame precedente e in base a quello effettua la scelta:
	 * <p>
	 * viene creato un nuovo frame che nel pannello contiene come da specifica al massimo sei pulsanti con l'immagine dei sei giocatori.
	 * In base al numero di giocatori scelto si possono scegliere i giocatori fino a che questo numero settato in precedenza non è raggiunto
	 * In seguito viene chiuso il frame con la funzione dispose
	 * @param numero parametro che definisce la scelta del numero massimo di giocatori scelto in precedenza
	 *
	 */
public void GuiSelez(int numero){
		
	    JPanel pan1=new JPanel();
	    JPanel pan2=new JPanel();
	    JLabel l=new JLabel("Scegliete i giocatori");
		numeroMax=numero;
		frame2=new JFrame("------MONOPOLI------");
		frame2.setLocation(80, 280);
		//frame2.setDefaultLookAndFeelDecorated(true);
		frame2.setLayout(new BorderLayout());
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		pan2.setLayout(new FlowLayout());
		////////richiama la funzione di scelta giocatori
		ImageIcon a1=new ImageIcon("./monopoli/fungo.gif");
		ImageIcon a2=new ImageIcon("./monopoli/candela.gif");
		ImageIcon a3=new ImageIcon("./monopoli/fiasco.gif");
		ImageIcon a4=new ImageIcon("./monopoli/mela.gif");
		ImageIcon a5=new ImageIcon("./monopoli/pera.gif");
		ImageIcon a6=new ImageIcon("./monopoli/pianta.gif");
		
		//JLabel intro=new JLabel("");//questa meglio in un altro pannello
		
		JButton Fungo=new JButton("Fungo",a1);
		JButton Candela=new JButton("Candela",a2);
		JButton Fiasco=new JButton("Fiasco",a3);
		JButton Mela=new JButton("Mela",a4);
		JButton Pera=new JButton("Pera",a5);
		JButton Pianta=new JButton("Pianta",a6);
		
		Fungo.addActionListener(new MyButtonListener3());
		Candela.addActionListener(new MyButtonListener3());
		Fiasco.addActionListener(new MyButtonListener3());
		Mela.addActionListener(new MyButtonListener3());
		Pera.addActionListener(new MyButtonListener3());
		Pianta.addActionListener(new MyButtonListener3());
		
		
		i=0;
		
		pan1.add(l);
		
		pan2.add(Fungo);
		pan2.add(Candela);
		pan2.add(Fiasco);
		pan2.add(Mela);
		pan2.add(Pera);
		pan2.add(Pianta);
		
		frame2.add(pan1,BorderLayout.NORTH);
		frame2.add(pan2,BorderLayout.SOUTH);
		
		frame2.pack();
		frame2.setVisible(true);
		
		
	}

	/**
	 * Consente di determinare l'evento di scelta del nomedei giocatori partecipanti alla partita definendoli in base all'avento di pressione del pulsante che sceglie i giocatori
	 * @author La_donatac1
	 */
	private class MyButtonListener3 implements ActionListener{
        
		/**
	 * Consente di inserire il nome dei giocatori per la partita in base ai tasti cliccati e allo stesso tempo di aggiungere i nomi in ordine di turno (con l'indice i)
	 * nell'array che memorizza il nome dei giocatori e l'ordine e un array di appoggio per far poi comparire sul tabellone di gioco le pedine corrispondenti ai giocatori cliccati
	 * <p>
	 * Una volta definita la selezione del numero di giocatori per il gioco viene lanciata la funzione che crea il tabellone di gioco l'interfaccia utente finale che accompagenrà il player durante la partita fino al suo ritiro oppure al termine del suo patrimonio
	 *@param e evento pressione pulsante JButton
	 * @author La_donatac1
	 * @see #CreateAndShowGUI()
	 */
		 
		public void actionPerformed(ActionEvent e) {
	
		    Gioco.addNamePlayer(((JButton)e.getSource()).getText(),i);
		    nomePedine.add(((JButton)e.getSource()).getText());
		    ((JButton)e.getSource()).setEnabled(false);
		   i++;
		   if(i==numeroMax) {
			   frame2.dispose();
			   CreateAndShowGUI();
		   }
		
		}
		
	}
	
	
	   private JMenu file=new JMenu("Azioni");
	   private JMenu dati=new JMenu("I Miei Dati");
	   private JMenu prigione=new JMenu("Menu prigione");
	   private JMenuItem compra=new JMenuItem("Compra terreno");
	   private JMenuItem casa=new JMenuItem("Metti case");
	   private JMenuItem albergo=new JMenuItem("Metti albergo");
	   private JMenuItem prosegui=new JMenuItem("Passa il turno");
	   private JMenuItem ritirati=new JMenuItem("Ritirati");
	   private JMenuItem denaro=new JMenuItem("Info giocatore");
	   private JMenuItem proprietà=new JMenuItem("Mostra Proprietà");
	   private JMenuItem about=new JMenuItem("Info casella");
	   private JMenuItem esci=new JMenuItem("Usa cartellino");
	   private JMenuItem paga=new JMenuItem("Paga per uscire");
	   private JMenuItem tira=new JMenuItem("Tira i dadi");
	   private JButton lancia=new JButton("Lancia i dadi");
	   private JTextPane testo=new JTextPane();
	   private JMenuBar barra=new JMenuBar();
	   private boolean[] voci=new boolean [11];
	   private String gioc;
	   private JLabel chisei=new JLabel();
	   private ImageIcon fun=new ImageIcon("./monopoli/fungo.gif");
	   private ImageIcon pia=new ImageIcon("./monopoli/pianta.gif");
	   private ImageIcon mel=new ImageIcon("./monopoli/mela.gif");
	   private ImageIcon per=new ImageIcon("./monopoli/pera.gif");
	   private ImageIcon can=new ImageIcon("./monopoli/candela.gif");
	   private ImageIcon fia=new ImageIcon("./monopoli/fiasco.gif");
	   private JLabel fungo=new JLabel(fun);
	   private JLabel pianta=new JLabel(pia);
	   private JLabel mela=new JLabel(mel);
	   private JLabel pera=new JLabel(per);
	   private JLabel candela=new JLabel(can);
	   private JLabel fiasco=new JLabel(fia);
	   private int nlanci;
	   
	/**
	 * Crea il tabellone di gioco ed allaccia ai vari pulsanti le varie azioni compiute dai giocatori
	 * <p>
	 * Essa è così costituita:
	 * un frame contiene 2 pannelli
	 * uno è atto a contenere l'immagine del tabellone e le pedine di gioco oltreche il menu
	 * l'altro serve a gestire le finestre testuali e i tasti di gioco 
	 *<p>
	 *Attraverso gli actionlistener si è potuto creare un parallelismo attraverso menu e pulsanti e popup informativi
	  *@author La_donatac1
	 *
	 */   
	 public void CreateAndShowGUI(){
		
		  int m;
		  
		  frame=new JFrame("Finestra - di - Gioco");
		  
			//frame.setLayout(null);
			//frame.setSize(1024,768);
		  
		  //Container c=frame.getContentPane();
		pannello1=new JPanel();
		pannello2=new JPanel();
		pannello1.setLayout(null);
		pannello1.setPreferredSize(new Dimension(700,702));
		pannello2.setLayout(null);
		ImageIcon window=new ImageIcon("./monopoli/tabellone.jpg");
		JLabel tabellone=new JLabel(window); 
		
		
		JLabel info=new JLabel("Informazioni");
		
		
		
		
		chisei.setBounds(60, 10, 200, 40);
		chisei.setText(nomePedine.get(0)+": inizia il gioco!");
		lancia.setBounds(70, 60, 140, 40);
		lancia.addActionListener(new MyButtonListener());
		info.setBounds(70, 120, 200, 40);
		testo.setBounds(20, 170, 250, 100);
		
		
		testo.setEditable(false);
		pannello2.add(testo);
		
		fungo.setOpaque(false);
		candela.setOpaque(false);
		pianta.setOpaque(false);
		fiasco.setOpaque(false);
		mela.setOpaque(false);
		pera.setOpaque(false);
		fungo.setBounds(630,620,57,83);
		candela.setBounds(630,620,57,83);
		pianta.setBounds(630,620,57,83);
		fiasco.setBounds(630,620,57,83);
		mela.setBounds(630,620,57,83);
		pera.setBounds(630,620,57,83);
		   
		   
		   for(m=0;m<numeroMax;m++){
		   if(nomePedine.get(m).contentEquals("Fungo")) pannello1.add(fungo);
		   if(nomePedine.get(m).contentEquals("Candela")) pannello1.add(candela);
		   if(nomePedine.get(m).contentEquals("Fiasco")) pannello1.add(fiasco);
		   if(nomePedine.get(m).contentEquals("Mela")) pannello1.add(mela);
		   if(nomePedine.get(m).contentEquals("Pera")) pannello1.add(pera);
		   if(nomePedine.get(m).contentEquals("Pianta")) pannello1.add(pianta);
		   }
		   
		   
		  tabellone.setBounds(0, 0, 700, 702);
		  pannello1.add(tabellone);
		   tabellone.setVisible(true);
		   frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		   pannello2.add(chisei);
		   pannello2.add(lancia);
		   pannello2.add(info);
		      
		   
		   pannello2.setPreferredSize(new Dimension(300,700));
		    
		    
		    frame.getContentPane().setLayout(new FlowLayout());

		    frame.add(pannello1,BorderLayout.WEST) ;
			  
			  frame.add(pannello2,BorderLayout.EAST);
		
			  
	   
	   file.add(prosegui);
	   prosegui.setEnabled(false);
	   file.add(ritirati);
	   dati.add(denaro);
	   dati.add(proprietà);
	   dati.add(about);
       
	   barra.add(file);
	   barra.add(dati);
	   ///////////////////////
	   compra.addActionListener(new MyActionListener());
	   casa.addActionListener(new MyActionListener());
	   albergo.addActionListener(new MyActionListener());
	   prosegui.addActionListener(new MyActionListener());
	   denaro.addActionListener(new MyActionListener());
	   proprietà.addActionListener(new MyActionListener());
	   ritirati.addActionListener(new MyActionListener());
	   about.addActionListener(new MyActionListener());
	   paga.addActionListener(new MyActionListener());
	   tira.addActionListener(new MyActionListener());
	   esci.addActionListener(new MyActionListener());
	   ////////////////////////
	   
	      
	   frame.setJMenuBar(barra);
	   frame.pack();
	   frame.setVisible(true);
		
	    
	   
	  }
	 
	 /**
	  * Serve a definire le azioni che vengono compiute sulla menubar tramite actionlistener 
	  * che percepiscono se un utente clicca il tasto o il menu per compiere delle azioni
	  * @param nomebott memorizza il nome del bottone cliccato
	  * @see UserInterfaceConnector
	  * @see Game
	  * @author La_donatac1
	  *
	  */
		public class MyActionListener implements ActionListener{ 
			
			String nomebott;
			
			/**
			 * Serve a definire il messaggio che compare nella finestra di dialogo qualora si prema una opzione del menu a tendina
			 * <p>
			 * Invia messaggi di controllo delle seguenti azioni:
			 * </ul>
			 * <li> comprare terreni
			 * <li> comprare case
			 * <li> compare alberghi
			 * <li> passare il turno
			 * <li> informazioni turno
			 * <li> vincita nel caso in cui tutti si ritirano
			 * <li> informazioni giocatore
			 * <li> informazioni  proprietà
			 * <li> vari eventi di gioco
			 *@param e evento clic su oggetto menu JmenuItem
			 *@see UserInterfaceConnector
             *@see Game
             *@see #compraCase (int)
             *@see #compraAlbergo()
             *@see #getGiocatore(int)
             *@see #haiPerso()
             *@see #infoGioc()
             *@see #isGattabuia()
             *@see #endGame()
             *@see #infoCasella()
             *@see #infoProp()
             *@see #usaEsciGratis()
             *@see #pagaPrigione
			 */
			public void actionPerformed(ActionEvent e) {
			
			nomebott=((JMenuItem)e.getSource()).getText();
			
			//Definisco il messaggio da visualizzare nella finestra di dialogo//
			
			if(nomebott.contentEquals("Compra terreno")){
				int c;
				String ris;
				c=JOptionPane.showConfirmDialog(frame, "Vuoi davvero comprare il terreno?","Confermi?",JOptionPane.YES_NO_OPTION);
				if(c==JOptionPane.YES_OPTION) {ris=Gioco.compraCasella();
				JOptionPane.showMessageDialog(frame, ris);
				((JMenuItem)e.getSource()).setEnabled(false);}
				//JOptionPane.showMessageDialog(null,"Hai comprato il terreno!");	
			}
			
	if(nomebott.contentEquals("Metti case")){
		        int nc=0;
				Object[] possibilità={"1","2","3","4"};
		        Object comp;
				String mess;
		        ((JMenuItem)e.getSource()).setEnabled(false);
		        comp=JOptionPane.showInputDialog(frame, "Quante case vuoi comprare?", "Compra case", JOptionPane.QUESTION_MESSAGE, null, possibilità, "1");
				if(comp.equals("1")) nc=1;
				else if(comp.equals("2")) nc=2;
				else if(comp.equals("3")) nc=3;
				else if(comp.equals("4")) nc=4;
				mess=Gioco.compraCase(nc);
				JOptionPane.showMessageDialog(frame, mess);
			}
	if(nomebott.contentEquals("Metti albergo")){
		int c;
		String ris;
		c=JOptionPane.showConfirmDialog(frame, "Vuoi davvero comprare il terreno?","Confermi?",JOptionPane.YES_NO_OPTION);
		if(c==JOptionPane.YES_OPTION) {ris=Gioco.compraAlbergo();
		JOptionPane.showMessageDialog(frame,ris);
		((JMenuItem)e.getSource()).setEnabled(false);}
		//JOptionPane.showMessageDialog(null,"Hai comprato un albergo!");	
	}
			
	if(nomebott.contentEquals("Passa il turno")){
		
		//Gioco.setGattaBuia();/////////////////////
		idGioc=Gioco.getGiocatore(massimo);
		lancia.setEnabled(true);
		compra.setEnabled(true);
		casa.setEnabled(true);
		albergo.setEnabled(true);
		about.setEnabled(false);
		paga.setEnabled(true);
    	tira.setEnabled(true);
    	esci.setEnabled(true);
		JOptionPane.showMessageDialog(frame,"Hai deciso di passare!");
		prosegui.setEnabled(false);
		
		if(Gioco.haiPerso()){
			JOptionPane.showMessageDialog(frame, "Ma il tuo conto è in rosso: hai perso!!","Warning",JOptionPane.ERROR_MESSAGE);
			
		}
		gioc=Gioco.infoGioc()+": tocca a te!";
		//Gioco.isStopped();
		if(Gioco.isGattaBuia()) {
			nlanci=0;
			lancia.setEnabled(false);
			prosegui.setEnabled(true);
			Gioco.setStopped();
			voci=Gioco.getTurno();
			   lancia.setEnabled(false);
			   if(voci[8]) prigione.add(esci);
			   if(voci[9]) {
				   prigione.add(paga);
				   prigione.add(tira);
			   }
			   barra.add(prigione);
			}
		else {barra.remove(prigione);} 
		   chisei.setText(gioc);
		   testo.setText("");
		   
	}
	if(nomebott.contentEquals("Ritirati")){
		int r;
		r=JOptionPane.showConfirmDialog(frame, "Vuoi veramente ritirarti?","Confermi?",JOptionPane.YES_NO_OPTION);
		if(r==JOptionPane.YES_OPTION) {
			JOptionPane.showMessageDialog(frame,"Hai deciso di abbandonare il gioco!");
			Gioco.endGame();
			if(nomePedine.get(idGioc).contentEquals("Fungo")) pannello1.remove(fungo);
			   if(nomePedine.get(idGioc).contentEquals("Candela")) pannello1.remove(candela);
			   if(nomePedine.get(idGioc).contentEquals("Fiasco")) pannello1.remove(fiasco);
			   if(nomePedine.get(idGioc).contentEquals("Mela")) pannello1.remove(mela);
			   if(nomePedine.get(idGioc).contentEquals("Pera")) pannello1.remove(pera);
			   if(nomePedine.get(idGioc).contentEquals("Pianta")) pannello1.remove(pianta);
			   frame.repaint();
			nomePedine.remove(idGioc);
			if(idGioc==nomePedine.size()){idGioc=0;}
			else if (idGioc==0){idGioc=0;}
			else idGioc=idGioc;
			try{
			if(nomePedine.size()==1) {throw new endException();}
			}catch(endException x){
				JOptionPane.showMessageDialog(frame, nomePedine.get(0)+": HAI VINTO!!!");
				frame.dispose();
			}
			Gioco.getRemove();
			massimo=massimo-1;
			lancia.setEnabled(true);
			compra.setEnabled(true);
			casa.setEnabled(true);
			albergo.setEnabled(true);
			prosegui.setEnabled(false);
			paga.setEnabled(true);
        	tira.setEnabled(true);
        	esci.setEnabled(true);
			if(nomePedine.size()>1){gioc=Gioco.infoGioc()+": tocca a te!";
			   chisei.setText(gioc);
			   testo.setText("");}
		}
	}	
    if(nomebott.contentEquals("Info giocatore")){
		String infog=Gioco.infoGioc();
		JOptionPane.showMessageDialog(null,infog);	
	}	
    if(nomebott.contentEquals("Info casella")){
    	ArrayList<String> temp=new ArrayList<String>();
    	String st="";
    	int ind;
    	temp=Gioco.infoCasella();
    	for(ind=0;ind<temp.size();ind++){
    		st=st+temp.get(ind);
    	}
    	JOptionPane.showMessageDialog(null, st);
    }
    if(nomebott.contentEquals("Mostra Proprietà")){
    	ArrayList<String> temp=new ArrayList<String>();
    	String st="";
    	int ind;
    	temp=Gioco.infoProp();
    	for(ind=0;ind<temp.size();ind++){
    		st=st+temp.get(ind)+"\n";    		
    	}
    	JOptionPane.showMessageDialog(null,st);
    }
    if(nomebott.contentEquals("Usa cartellino")){
    	Gioco.usaEsciGratis();
    	lancia.setEnabled(false);
    	JOptionPane.showMessageDialog(frame,"Esci gratis grazie al cartellino");
    	paga.setEnabled(false);
    	tira.setEnabled(false);
    	esci.setEnabled(false);
    }
    if(nomebott.contentEquals("Paga per uscire")){
    	Gioco.pagaPrigione();
    	lancia.setEnabled(false);
    	JOptionPane.showMessageDialog(frame,"Hai pagato 125 € per uscire di prigione");
    	paga.setEnabled(false);
    	tira.setEnabled(false);
    	esci.setEnabled(false);
    }
    if(nomebott.contentEquals("Tira i dadi")){
    	String pr;
    	
    	/*pr=Gioco.tiraPrigione();
    	JOptionPane.showMessageDialog(frame,pr);*/
    	if(!Gioco.uscitaOk() && nlanci<3) {
    		pr=Gioco.tiraPrigione();
        	JOptionPane.showMessageDialog(frame,pr);
        	nlanci++;
    	}
    	if(Gioco.uscitaOk()) {
    		JOptionPane.showMessageDialog(frame,"Hai fatto un doppio! Esci gratis di prigione");
    		paga.setEnabled(false);
        	tira.setEnabled(false);
        	esci.setEnabled(false);
    	}
    	if(nlanci==3) {
    		JOptionPane.showMessageDialog(frame,"Non hai fatto neanche un doppio");
    		paga.setEnabled(false);
        	tira.setEnabled(false);
        	esci.setEnabled(false);
    	}
    }
			
		}
	}
		/**
		 * Rappresenta l'evento connesso col bottone "Lancia i dadi" e tutte
		 * e tutte le sue funzionalità
		 * <p>
		 * In particolar modo permette di definire buttonListener che permette  al tasto di poter essere premuto più volte in relazione 
		 * ai doppi effettuati e correlarli con le relative azioni di gioco come la prigione o il passaggio dal via
		 * @param nome rappresenta il nome del bottone cliccato
		 * @see UserInterfaceConnector
		 * @see Game
		 * @author La_donatac1
		 *
		 */
		public class MyButtonListener implements ActionListener{
			String nome;
			
			/**
			 * Permette di cliccare il tasto lancia i dadi ogni volta che il giocatore ne ha diritto:
			 * </ul>
			 * <li>ogni volta che fa un doppio 
			 * <li>quando è il suo turno 
			 * <p>
			 * Inoltre svolge diversi compiti che sono principali nello svolgimento del gioco
			 * <p>
			 * Determina infatti la chiamata della funzione col compito di spostare il giocatore direttamente in prigione oltre i 3 doppi e provvede a disabilitare il tasto "Lancia i dadi"
			 * in questa situazione e in tutte quelle in cui il giocatore non ha diritto al tiro
			 * <p>
			 * Si occupa anche di rendere abilitati tutti le scelte che si associano alla possibilià di agire di un giocatore:
			 * </ul>
			 * <li>comprare terreni
			 * <li>comprare case
			 * <li>comprare alberghi
			 *@param e evento pressione pulsante lancio dadi
			  * @see UserInterfaceConnector
		     * @see Game
		     * @see #lancioDadi()
		     * @see #getDoppio()
		     * @see #getPrevPosition()
		     * @see #getPosition()
		     * @see #spostamentoPedine(int)
		     * @see #getObbligo()
		     * @see #is Gattabuia()
		     * @see #getTurno()
		     * 
			 */
			public void actionPerformed(ActionEvent e){
				int risDadi;
				String doppi="";
				nome=((JButton)e.getSource()).getText();
				if(nome.contentEquals("Lancia i dadi")){
					   
					   about.setEnabled(true);
					   barra.remove(prigione);
					   file.remove(compra);
					   file.remove(casa);
					   file.remove(albergo);
					   
					   //numeroLanciDoppi++;
					   risDadi=Gioco.lancioDadi();
					   if(Gioco.getDoppio()) doppi=" Doppio! Puoi Ritirare!";
					   JOptionPane.showMessageDialog(frame,"E' uscito: "+risDadi+doppi);
					   if(risDadi+Gioco.getPrevPosition()>39) JOptionPane.showMessageDialog(frame, "Passi dal Via e ritiri 500 €");
					   pos=Gioco.getPosition();
					   SpostamentoPedine(pos);
					   testo.setText(Gioco.getObbligo());
					   if(Gioco.isGattaBuia()) {
					       JOptionPane.showMessageDialog(frame, "Prigione!!!");
			               VoloPedine();
			               compra.setVisible(false);
			               casa.setVisible(false);
			               albergo.setVisible(false);
					   }
					   voci=Gioco.getTurno();
					   if(voci[3])  {file.add(compra);}
					   if(voci[4])  {file.add(casa);}
					   if(voci[5])  {file.add(albergo);}
					   
					   frame.pack();
					   frame.setVisible(true);
				}
				   
				
				if(Gioco.getDoppio() && !(Gioco.isGattaBuia())){
					prosegui.setEnabled(false);
					ritirati.setEnabled(false);
				}
				else if(!Gioco.getDoppio() || Gioco.isGattaBuia()) {
					((JButton)e.getSource()).setEnabled(false);
					prosegui.setEnabled(true);
					ritirati.setEnabled(true);
					}
				/*if(numeroLanciDoppi==3 && Gioco.getDoppio()) {
					((JButton)e.getSource()).setEnabled(false);
					Gioco.setPrigione();
					JOptionPane.showMessageDialog(frame,"Hai fatto 3 doppi, vai in prigione!");
					
				}*/
				
			}
		}
		
/**
 * Rappresenta la Classe che in determinate circostanze di ritiro o di impossibilità a continuare il gioco(assenza di denaro) pone fine al gioco
 * @author La_donatac1
 *
 */
public class endException extends Exception{
	public endException(){super();}
}	

/**
 * Rappresenza lo spostamento delle pedine sul tabellone di gioco
 * Essa viene richiamata subito dopo il lancio dei dadi e dopo il message dialogbox
 * <p>
 * Si articola con if esterni atti a verificare i giocatori che devono spostarsi e uno switch case più interno per
 * definire le 40 posizioni delle caselle
 * @param posizione intero che indica la posizione da assumere dopo il lancio dadi
 */

public void SpostamentoPedine(int posizione){
	poz=posizione;
	timer=new Timer(350, new TimerListener());
	postemp=Gioco.getPrevPosition();
	
	timer.start();
	
	

}//spost

/**
 * Rappresenta l'azione associata al timer che incrementa le posizioni delle pedine fino a raggiungimento della posizione terminale
 * 
 * @author utente_eg8
 *
 */
private class TimerListener implements ActionListener{

	
	/**
	 * Incrementa passo passo la posizione grafica delle pedine fino a posizione finale ultimato il turno
	 * <p>
	 * Per effettuare lo spostamento si determinano gli incrementi sugli assi e incrementi o decrementi di angoli
	 * per girare in posizione ottimale
	 * <p>
	 * Il meccanismo di movimento si basa sulla setBounds che definisce una nuova posizione
	 * incrementando/decrementando di un certo numero di pixel la posizione riferita a ogni spostamento determinato dal timer  grazie all'oggetto rettangolo
	 * 
	 *@param e evento azionamento timer
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(nomePedine.get(idGioc).contentEquals("Fungo")){
			
			if(postemp>0 && postemp<9) {
				rect=fungo.getBounds();
				rect.x=rect.x-57;
				fungo.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>10 && postemp<19){
				rect=fungo.getBounds();
				rect.y=rect.y-57;
				fungo.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>20 && postemp<29){
				rect=fungo.getBounds();
				rect.x=rect.x+57;
				fungo.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>30 && postemp<39){
				rect=fungo.getBounds();
				rect.y=rect.y+57;
				fungo.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==0 || postemp==9){
				rect=fungo.getBounds();
				rect.x=rect.x-80;
				fungo.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==10 || postemp==19){
				rect=fungo.getBounds();
				rect.y=rect.y-87;
				fungo.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==20 || postemp==29){
				rect=fungo.getBounds();
				rect.x=rect.x+80;
				fungo.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==30 ){
				rect=fungo.getBounds();
				rect.y=rect.y+87;
				fungo.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==39){
				rect=fungo.getBounds();
				rect.y=rect.y+87;
				fungo.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp=0;
			}
			if(postemp==poz) timer.stop();
			}
		if(nomePedine.get(idGioc).contentEquals("Candela")){
			
			if(postemp>0 && postemp<9) {
				rect=candela.getBounds();
				rect.x=rect.x-57;
				candela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>10 && postemp<19){
				rect=candela.getBounds();
				rect.y=rect.y-57;
				candela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>20 && postemp<29){
				rect=candela.getBounds();
				rect.x=rect.x+57;
				candela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>30 && postemp<39){
				rect=candela.getBounds();
				rect.y=rect.y+57;
				candela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==0 || postemp==9){
				rect=candela.getBounds();
				rect.x=rect.x-80;
				candela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==10 || postemp==19){
				rect=candela.getBounds();
				rect.y=rect.y-87;
				candela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==20 || postemp==29){
				rect=candela.getBounds();
				rect.x=rect.x+80;
				candela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==30){
				rect=candela.getBounds();
				rect.y=rect.y+87;
				candela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==39){
				rect=candela.getBounds();
				rect.y=rect.y+87;
				candela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp=0;
			}
			if(postemp==poz) timer.stop();
			}
		if(nomePedine.get(idGioc).contentEquals("Fiasco")){
			
			if(postemp>0 && postemp<9) {
				rect=fiasco.getBounds();
				rect.x=rect.x-57;
				fiasco.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>10 && postemp<19){
				rect=fiasco.getBounds();
				rect.y=rect.y-57;
				fiasco.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>20 && postemp<29){
				rect=fiasco.getBounds();
				rect.x=rect.x+57;
				fiasco.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>30 && postemp<39){
				rect=fiasco.getBounds();
				rect.y=rect.y+57;
				fiasco.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==0 || postemp==9){
				rect=fiasco.getBounds();
				rect.x=rect.x-80;
				fiasco.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==10 || postemp==19){
				rect=fiasco.getBounds();
				rect.y=rect.y-87;
				fiasco.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==20 || postemp==29){
				rect=fiasco.getBounds();
				rect.x=rect.x+80;
				fiasco.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==30){
				rect=fiasco.getBounds();
				rect.y=rect.y+87;
				fiasco.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==39){
				rect=fiasco.getBounds();
				rect.y=rect.y+87;
				fiasco.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp=0;
			}
			if(postemp==poz) timer.stop();
			}
		if(nomePedine.get(idGioc).contentEquals("Mela")){
			
			if(postemp>0 && postemp<9) {
				rect=mela.getBounds();
				rect.x=rect.x-57;
				mela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>10 && postemp<19){
				rect=mela.getBounds();
				rect.y=rect.y-57;
				mela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>20 && postemp<29){
				rect=mela.getBounds();
				rect.x=rect.x+57;
				mela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>30 && postemp<39){
				rect=mela.getBounds();
				rect.y=rect.y+57;
				mela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==0 || postemp==9){
				rect=mela.getBounds();
				rect.x=rect.x-80;
				mela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==10 || postemp==19){
				rect=mela.getBounds();
				rect.y=rect.y-87;
				mela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==20 || postemp==29){
				rect=mela.getBounds();
				rect.x=rect.x+80;
				mela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==30){
				rect=mela.getBounds();
				rect.y=rect.y+87;
				mela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==39){
				rect=mela.getBounds();
				rect.y=rect.y+87;
				mela.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp=0;
			}
			if(postemp==poz) timer.stop();
			}
		if(nomePedine.get(idGioc).contentEquals("Pera")){
			
			if(postemp>0 && postemp<9) {
				rect=pera.getBounds();
				rect.x=rect.x-57;
				pera.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>10 && postemp<19){
				rect=pera.getBounds();
				rect.y=rect.y-57;
				pera.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>20 && postemp<29){
				rect=pera.getBounds();
				rect.x=rect.x+57;
				pera.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>30 && postemp<39){
				rect=pera.getBounds();
				rect.y=rect.y+57;
				pera.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==0 || postemp==9){
				rect=pera.getBounds();
				rect.x=rect.x-80;
				pera.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==10 || postemp==19){
				rect=pera.getBounds();
				rect.y=rect.y-87;
				pera.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==20 || postemp==29){
				rect=pera.getBounds();
				rect.x=rect.x+80;
				pera.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==30){
				rect=pera.getBounds();
				rect.y=rect.y+87;
				pera.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==39){
				rect=pera.getBounds();
				rect.y=rect.y+87;
				pera.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp=0;
			}
			if(postemp==poz) timer.stop();
			}
		if(nomePedine.get(idGioc).contentEquals("Pianta")){
			
			if(postemp>0 && postemp<9) {
				rect=pianta.getBounds();
				rect.x=rect.x-57;
				pianta.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>10 && postemp<19){
				rect=pianta.getBounds();
				rect.y=rect.y-57;
				pianta.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>20 && postemp<29){
				rect=pianta.getBounds();
				rect.x=rect.x+57;
				pianta.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp>30 && postemp<39){
				rect=pianta.getBounds();
				rect.y=rect.y+57;
				pianta.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==0 || postemp==9){
				rect=pianta.getBounds();
				rect.x=rect.x-80;
				pianta.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==10 || postemp==19){
				rect=pianta.getBounds();
				rect.y=rect.y-87;
				pianta.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==20 || postemp==29){
				rect=pianta.getBounds();
				rect.x=rect.x+80;
				pianta.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==30){
				rect=pianta.getBounds();
				rect.y=rect.y+87;
				pianta.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp++;
			}
			else if(postemp==39){
				rect=pianta.getBounds();
				rect.y=rect.y+87;
				pianta.setBounds(rect.x, rect.y, rect.width, rect.height);
				postemp=0;
			}
			if(postemp==poz) timer.stop();
			}



	}
	
}

/**
 * Definisce direttamente con una setBounds la posizione della pedina-riferita al giocatore che va in prigione-direttamente alla posizione 10
 * 
 *
 */
public void VoloPedine(){
	if(nomePedine.get(idGioc).contentEquals("Fungo")) fungo.setBounds(14,620,57,83);
	if(nomePedine.get(idGioc).contentEquals("Candela")) candela.setBounds(14,620,57,83);
	if(nomePedine.get(idGioc).contentEquals("Fiasco")) fiasco.setBounds(14,620,57,83);
	if(nomePedine.get(idGioc).contentEquals("Mela")) mela.setBounds(14,620,57,83);
	if(nomePedine.get(idGioc).contentEquals("Pera")) pera.setBounds(14,620,57,83);
	if(nomePedine.get(idGioc).contentEquals("Pianta")) pianta.setBounds(14,620,57,83);
}
}



