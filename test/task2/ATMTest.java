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
	public void class_implement_interfaces() {
		assertTrue("The class ATM does not implement the interface ATMInterface", ATMInterface.class.isInstance(instance));
	}

	@Test
	public void attribute_balance() {
		assertTrue("There is no attribute \"balance\" declared", TestUtil.doesFieldExist(ATM.class, "balance"));
	}
	
	@Test
	public void attribute_balance_defaultValue() {
		double stanjeValue = (double) TestUtil.getFieldValue(instance, "balance");
		
		assertEquals("The attribute \"balance\" doe not have the default value of 5000", 5000, stanjeValue, 0.001);
	}
	
	@Test
	public void attribute_balance_visibility() {
		assertTrue("The attribute \"balance\" is not private", TestUtil.hasFieldModifier(ATM.class, "balance", Modifier.PRIVATE));
	}
	
	@Test
	public void method_depositMoney() {
		double stanjeValue1 = (double) TestUtil.getFieldValue(instance, "balance");
		
		instance.depositMoney(100);
		double stanjeValue2 = (double) TestUtil.getFieldValue(instance, "balance");
		assertEquals("After passing as argument \"100\", the attribute \"balance\" should have this value", 100, stanjeValue2 - stanjeValue1, 0.001);
	}
	
	@Test
	public void method_depositMoney_lessThan0() {
		instance.depositMoney(-100);
		assertTrue("After passing as argument \"-100\", the method should print 'ERROR' to the output", outContent.toString().trim().equalsIgnoreCase("ERROR"));
	}
	
	@Test
	public void method_withdrawMoney() {
		double stanjePre = (double) TestUtil.getFieldValue(instance, "balance");
		
		instance.withdrawMoney(100);
		double stanjePosle = (double) TestUtil.getFieldValue(instance, "balance");
		assertEquals("After passing as argument \"100\", the value of the attribute \"balance\" did not decrease for 100", 100, stanjePre - stanjePosle, 0.001);
	}
	
	@Test
	public void method_withdrawMoney_lessThen0() {
		instance.withdrawMoney(-100);
		assertTrue("After passing as argument \"-100\", the method should print 'ERROR' to the output", outContent.toString().trim().equalsIgnoreCase("ERROR"));
	}
	
	@Test
	public void method_withdrawMoney_notEnoughMoney() {
		instance.withdrawMoney(100000);
		assertTrue("After passing as argument \"100000\", and there is not that much money on the ballance, the method should print 'NOT ENOUGH MONEY FOR WITHDRAWL' to the output", outContent.toString().trim().equalsIgnoreCase("NOT ENOUGH MONEY FOR WITHDRAWL"));
	}
}
