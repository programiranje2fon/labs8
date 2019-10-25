package task1.finances;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import task1.Employee;
import test.TestUtil;

public class AccountingInterfaceTest {

	@Test
	public void method_paySalaries() {
		assertTrue("There is no method paySalaries(Employee[], int) declared", TestUtil.doesMethodExist(AccountingInterface.class, "paySalaries", new Class<?>[]{Employee[].class, int.class}));
	}
	
}
