package task1.finances;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import task1.Commercialist;
import task1.FactoryWorker;
import task1.Employee;
import test.TestUtil;

public class AccountingTest {
	
	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	private AccountingDepartment instance;

	@Before
	public void setUp() throws Exception {
		instance = new AccountingDepartment();
		System.setOut(new PrintStream(outContent));
	    System.setErr(new PrintStream(errContent));
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
		System.setOut(originalOut);
	    System.setErr(originalErr);
	}

	@Test
	public void klasa_implementacijaInterfejsa() {
		assertTrue("Klasa AccountingDepartment ne implementira interfejs AccountingInterface", AccountingInterface.class.isInstance(instance));
	}

	@Test
	public void atribut_stanje() {
		assertTrue("U klasi nije definisan atribut balance", TestUtil.doesFieldExist(AccountingDepartment.class, "balance"));
	}
	
	@Test
	public void atribut_stanje_vidljivost() {
		assertTrue("Atribut balance nije privatan", TestUtil.hasFieldModifier(AccountingDepartment.class, "balance", Modifier.PRIVATE));
	}
	
	@Test
	public void metoda_setStanje() {
		instance.setBalance(100);
		double stanjeValue = (double) TestUtil.getFieldValue(instance, "balance");
		assertEquals("Nakon poziva metode setBalance(double) sa prosledjenim argumentom \"100\", vrednost atributa balance nema tu vrednost", 100, stanjeValue, 0.001);
	}
	
	@Test
	public void metoda_getStanje() {
		double stanjeValue = (double) TestUtil.getFieldValue(instance, "balance");

		assertEquals("Metoda getBalance() ne vraca vrednost atributa balance", stanjeValue, instance.getBalance(), 0.001);
	}
	
	@Test
	public void metoda_isplatiPlate() {
		FactoryWorker pr1 = new FactoryWorker();
		pr1.setHourlyRate(100);
		
		FactoryWorker pr2 = new FactoryWorker();
		pr2.setHourlyRate(150);
		
		Commercialist k1 = new Commercialist();
		k1.setHourlyRate(200);
		
		instance.setBalance(200000);
		instance.paySalaries(new Employee[]{pr1, pr2, k1}, 160);
		
		assertEquals("Za prosledjene niz sa tri zaposlena (FactoryWorker satnica 100 din., FactoryWorker satnica 150 din. i Commercialist satnica 200 din.) i broj radnik sati 160, metoda isplatiPlate() u momentu kada je stanje 100000 dinara, nije umanjilo stanje na 78000.0 dinara.", 78000, instance.getBalance(), 0.001);
	}
	
	@Test
	public void metoda_isplatiPlate_nemaNovca() {
		FactoryWorker pr1 = new FactoryWorker();
		pr1.setHourlyRate(100);
		
		FactoryWorker pr2 = new FactoryWorker();
		pr2.setHourlyRate(150);
		
		Commercialist k1 = new Commercialist();
		k1.setHourlyRate(200);
		
		instance.setBalance(1000);
		instance.paySalaries(new Employee[]{pr1, pr2, k1}, 160);
		
		assertTrue("Za prosledjene niz sa tri zaposlena (FactoryWorker satnica 100 din., FactoryWorker satnica 150 din. i Commercialist satnica 200 din.) i broj radnik sati 160, metoda isplatiPlate() u momentu kada je stanje 1000 dinara, nije ispisan tekst 'NEMA DOVOLJNO NOVCA'", outContent.toString().trim().equalsIgnoreCase("NOT ENOUGH MONEY FOR SALARIES"));
	}

}
