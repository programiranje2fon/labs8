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
	public void class_nasledjivanje() {
		assertTrue("The class FactoryWorker does not extend the class Employee", Employee.class.isInstance(instance));
	}
	
	@Test
	public void method_computeSalary() {
		instance.setHourlyRate(100);
		assertEquals("When hourlyRate=100 and the argument passed is 10, the method should return 1000", 1000, instance.computeSalary(10), 0.001);
	}
}
