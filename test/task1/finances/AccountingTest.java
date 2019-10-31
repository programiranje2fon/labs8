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
	public void class_implementInterface() {
		assertTrue("The class AccountingDepartment does not implement the interface AccountingInterface", AccountingInterface.class.isInstance(instance));
	}

	@Test
	public void attribute_balance() {
		assertTrue("There is no attribute \"balance\" declared", TestUtil.doesFieldExist(AccountingDepartment.class, "balance"));
	}
	
	@Test
	public void attribute_balance_visibility() {
		assertTrue("Attribute \"balance\" is not private", TestUtil.hasFieldModifier(AccountingDepartment.class, "balance", Modifier.PRIVATE));
	}
	
	@Test
	public void method_setBalance() {
		instance.setBalance(100);
		double stanjeValue = (double) TestUtil.getFieldValue(instance, "balance");
		assertEquals("After passing as argument \"100\", the attribute \"balance\" should have this value", 100, stanjeValue, 0.001);
	}
	
	@Test
	public void method_getBalance() {
		double stanjeValue = (double) TestUtil.getFieldValue(instance, "balance");

		assertEquals("The method does not return the value of the attribute \"balance\"", stanjeValue, instance.getBalance(), 0.001);
	}
	
	@Test
	public void method_paySalaries() {
		FactoryWorker pr1 = new FactoryWorker();
		pr1.setHourlyRate(100);
		
		FactoryWorker pr2 = new FactoryWorker();
		pr2.setHourlyRate(150);
		
		Commercialist k1 = new Commercialist();
		k1.setHourlyRate(200);
		
		instance.setBalance(200000);
		instance.paySalaries(new Employee[]{pr1, pr2, k1}, 160);
		
		assertEquals("When an array with three instances is passed (FactoryWorker hourlyRate=100, FactoryWorker hourlyRate=150, and Commercialist hourlyRate=200) and workingHours=160, when the balance=100000, the method paySalaries() should reduce the balance value to 78000.", 78000, instance.getBalance(), 0.001);
	}
	
	@Test
	public void method_paySalaries_noMoney() {
		FactoryWorker pr1 = new FactoryWorker();
		pr1.setHourlyRate(100);
		
		FactoryWorker pr2 = new FactoryWorker();
		pr2.setHourlyRate(150);
		
		Commercialist k1 = new Commercialist();
		k1.setHourlyRate(200);
		
		instance.setBalance(1000);
		instance.paySalaries(new Employee[]{pr1, pr2, k1}, 160);
		
		assertTrue("When an array with three instances is passed (FactoryWorker hourlyRate=100, FactoryWorker hourlyRate=150, and Commercialist hourlyRate=200) and workingHours=160, when the balance=100000, the method paySalaries() should print to the console NOT ENOUGH MONEY FOR SALARIES", outContent.toString().toLowerCase().contains("not enough money for salaries"));
	}

}
