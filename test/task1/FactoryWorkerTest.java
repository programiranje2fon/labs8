package task1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FactoryWorkerTest {

	private FactoryWorker instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new FactoryWorker();
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}
	
	@Test
	public void klasa_nasledjivanje() {
		assertTrue("Klasa FactoryWorker ne nasledjuje klasu Employee", Employee.class.isInstance(instance));
	}
	
	@Test
	public void metoda_izracunajPlatu() {
		instance.setHourlyRate(100);
		assertEquals("Za satnicu od 100 dinara i broj sati 10, metoda computeSalary(int) ne vraca vrednost 1000", 1000, instance.computeSalary(10), 0.001);
	}
}
