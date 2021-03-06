package monopoli;


import java.util.ArrayList;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;



import junit.framework.*;



public class TestUnit extends TestCase{

	private Tabellone tab2;
	private monopoli.Giocatore g2;
	private ArrayList<Casella> lista;
	//private ArrayList<Proprietā> prop;
	
	public TestUnit(String name){super(name);}
	@Before
	protected void setUp() throws Exception {
		//int rand,n=0;
		//Random r=new Random();
		tab2=new monopoli.Tabellone();
		lista=tab2.creaTabellone();
		g2=new monopoli.Giocatore(0, "Fungo", 8750, 0, false, 0, 0);
		/*do{
			rand=r.nextInt(40);
			if(lista.get(rand).isAcquistabile() && ((Proprietā)lista.get(rand)).getProprietario()==6) {
				g2.setProprietā(lista.get(rand));
		        ((Proprietā)lista.get(rand)).setProprietario(g2.getNumero());
				
				n++;
			}
			
		}while(n<10);*/
		g2.setProprietā(lista.get(13));//arancio
		((Proprietā)lista.get(13)).setProprietario(0);
		g2.setProprietā(lista.get(14));//arancio
		((Proprietā)lista.get(14)).setProprietario(0);
		g2.setProprietā(lista.get(11));//arancio
		((Proprietā)lista.get(11)).setProprietario(0);
		g2.setProprietā(lista.get(5));//staz
		((Proprietā)lista.get(5)).setProprietario(0);
		g2.setProprietā(lista.get(1));//fucsia
		((Proprietā)lista.get(1)).setProprietario(0);
		g2.setProprietā(lista.get(39));//viola
		((Proprietā)lista.get(39)).setProprietario(0);
		g2.setProprietā(lista.get(37));//viola
		((Proprietā)lista.get(37)).setProprietario(0);
		g2.setProprietā(lista.get(12));//soc
		((Proprietā)lista.get(12)).setProprietario(0);
		g2.setProprietā(lista.get(28));//soc
		((Proprietā)lista.get(28)).setProprietario(0);
		g2.setProprietā(lista.get(29));//giallo
		((Proprietā)lista.get(29)).setProprietario(0);
	}

	@After
	protected void tearDown() throws Exception {
		tab2=null;
		lista=null;
		g2=null;
		//prop=null;
	}

	@Test
	public void testScanColorex3() {
		assertEquals(true,tab2.scanColorex3(lista.get(11),g2));
		assertFalse(tab2.scanColorex3(lista.get(29),g2));
		assertFalse(tab2.scanColorex3(lista.get(31),g2));
		
	}

	@Test
	public void testScanColorex2() {
		assertFalse(tab2.scanColorex2(lista.get(1),g2));
		assertTrue(tab2.scanColorex2(lista.get(39),g2));
		 
	}

	@Test
	public void testAllSoc() {
		assertTrue(tab2.allSoc(g2));
		 
	}

	@Test
	public void testAllStaz() {
		assertFalse(tab2.allStaz(g2));
		
	}

	public static void main(String args[]){
		junit.textui.TestRunner.run(TestUnit.class);
	}
}
