package task1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class CommercialistTest {

	private Commercialist instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new Commercialist();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}
	
	@Test
	public void klasa_nasledjivanje() {
		assertTrue("The Commercialist class should extend the class Employee", Employee.class.isInstance(instance));
	}
	
	@Test
	public void metoda_izracunajPlatu() {
		instance.setHourlyRate(100);
		assertEquals("When hourlyRate=100 and the argument passed is 10, the method should return 51000", 51000, instance.computeSalary(10), 0.001);
	}
}
