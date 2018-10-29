package task1.finances;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import task1.Employee;
import test.TestUtil;

public class AccountingInterfaceTest {

	@Test
	public void metoda_isplatiPlate() {
		assertTrue("U klasi nije definisana metoda paySalaries(Employee[], int)", TestUtil.doesMethodExist(AccountingInterface.class, "paySalaries", new Class<?>[]{Employee[].class, int.class}));
	}
	
}
