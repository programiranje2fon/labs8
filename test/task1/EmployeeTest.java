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
	public void attribute_hourlyRate() {
		assertTrue("There is no attribute \"hourlyRate\" declared", TestUtil.doesFieldExist(Employee.class, "hourlyRate"));
	}
	
	@Test
	public void attribute_hourlyRate_visibility() {
		assertTrue("The attribute \"hourlyRate\" is not protected", TestUtil.hasFieldModifier(Employee.class, "hourlyRate", Modifier.PROTECTED));
	}
	
	@Test
	public void method_setHourlyRate() {
		instance.setHourlyRate(10);
		double satnicaValue = (double) TestUtil.getFieldValue(instance, "hourlyRate");
		assertEquals("After passing as argument \"10\", the attribute \"hourlyRate\" should have this value", 10, satnicaValue, 0.001);
	}
	
	@Test
	public void method_getHourlyRate() {
		double satnicaValue = (double) TestUtil.getFieldValue(instance, "hourlyRate");

		assertEquals("The method does not return the value of the attribute \"hourlyRate\"", satnicaValue, instance.getHourlyRate(), 0.001);
	}
	
	@Test
	public void method_computeSalary() {
		assertTrue("There is no method computeSalary(int) defined", TestUtil.doesMethodExist(Employee.class, "computeSalary", new Class<?>[]{int.class}));
	}
}
