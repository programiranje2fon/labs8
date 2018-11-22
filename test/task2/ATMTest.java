package task2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;

public class ATMTest {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
	private final PrintStream originalOut = System.out;
	private final PrintStream originalErr = System.err;

	private ATM instance;

	@Before
	public void setUp() throws Exception {
		instance = new ATM();
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
		assertTrue("Klasa ATM ne implementira interfejs ATMInterface", ATMInterface.class.isInstance(instance));
	}

	@Test
	public void atribut_stanje() {
		assertTrue("U klasi nije definisan atribut balance", TestUtil.doesFieldExist(ATM.class, "balance"));
	}
	
	@Test
	public void atribut_stanje_pocetnaVrednost() {
		double stanjeValue = (double) TestUtil.getFieldValue(instance, "balance");
		
		assertEquals("Atribut balance nema pocetnu vrednost 5000", 5000, stanjeValue, 0.001);
	}
	
	@Test
	public void atribut_stanje_vidljivost() {
		assertTrue("Atribut balance nije privatan", TestUtil.hasFieldModifier(ATM.class, "balance", Modifier.PRIVATE));
	}
	
	@Test
	public void metoda_uloziNovac() {
		double stanjeValue1 = (double) TestUtil.getFieldValue(instance, "balance");
		
		instance.depositMoney(100);
		double stanjeValue2 = (double) TestUtil.getFieldValue(instance, "balance");
		assertEquals("Nakon poziva metode depositMoney(double) sa prosledjenim argumentom \"100\", vrednost atributa balance se nije uvecalo za tu vrednost", 100, stanjeValue2 - stanjeValue1, 0.001);
	}
	
	@Test
	public void metoda_uloziNovac_manjeOd0() {
		instance.depositMoney(-100);
		assertTrue("Nakon poziva metode depositMoney(double) sa prosledjenim argumentom \"-100\", metoda nije ispisala tekst 'ERROR'", outContent.toString().trim().equalsIgnoreCase("ERROR"));
	}
	
	@Test
	public void metoda_podigniNovac() {
		double stanjePre = (double) TestUtil.getFieldValue(instance, "balance");
		
		instance.withdrawMoney(100);
		double stanjePosle = (double) TestUtil.getFieldValue(instance, "balance");
		assertEquals("Nakon poziva metode withdrawMoney(double) sa prosledjenim argumentom \"100\", vrednost atributa balance se nije smanjila za tu vrednost", 100, stanjePre - stanjePosle, 0.001);
	}
	
	@Test
	public void metoda_podigniNovac_manjeOd0() {
		instance.withdrawMoney(-100);
		assertTrue("Nakon poziva metode withdrawMoney(double) sa prosledjenim argumentom \"-100\", metoda nije ispisala tekst 'ERROR'", outContent.toString().trim().equalsIgnoreCase("ERROR"));
	}
	
	@Test
	public void metoda_podigniNovac_nemaDovoljnoNovca() {
		instance.withdrawMoney(100000);
		assertTrue("Nakon poziva metode withdrawMoney(double) sa prosledjenim argumentom \"100000\", metoda nije ispisala tekst 'NOT ENOUGH MONEY FOR WITHDRAWL'", outContent.toString().trim().equalsIgnoreCase("NOT ENOUGH MONEY FOR WITHDRAWL"));
	}
}
