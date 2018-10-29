package task1;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import test.TestUtil;

public class EmployeeTest {

	private Employee instance;
	
	@Before
	public void setUp() throws Exception {
		instance = new Employee() {
			@Override
			public double computeSalary(int brojSati) {
				return 0;
			}
		};
	}

	@After
	public void tearDown() throws Exception {
		instance = null;
	}
	
	@Test
	public void atribut_slobodno() {
		assertTrue("U klasi nije definisan atribut hourlyRate", TestUtil.doesFieldExist(Employee.class, "hourlyRate"));
	}
	
	@Test
	public void atribut_slobodno_vidljivost() {
		assertTrue("Atribut hourlyRate nije zasticen (protected)", TestUtil.hasFieldModifier(Employee.class, "hourlyRate", Modifier.PROTECTED));
	}
	
	@Test
	public void metoda_setSatnica() {
		instance.setHourlyRate(10);
		double satnicaValue = (double) TestUtil.getFieldValue(instance, "hourlyRate");
		assertEquals("Nakon poziva metode setHourlyRate(double) sa prosledjenim argumentom \"10\", vrednost atributa hourlyRate nema tu vrednost", 10, satnicaValue, 0.001);
	}
	
	@Test
	public void metoda_getSatnica() {
		double satnicaValue = (double) TestUtil.getFieldValue(instance, "hourlyRate");

		assertEquals("Metoda getHourlyRate() ne vraca vrednost atributa hourlyRate", satnicaValue, instance.getHourlyRate(), 0.001);
	}
	
	@Test
	public void metoda_izracunajPlatu() {
		assertTrue("U klasi nije definisana metoda computeSalary(int)", TestUtil.doesMethodExist(Employee.class, "computeSalary", new Class<?>[]{int.class}));
	}
}
