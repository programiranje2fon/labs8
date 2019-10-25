package task2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import test.TestUtil;

public class ATMInterfaceTest {
	
	@Test
	public void metoda_uloziNovac() {
		assertTrue("There is no method depositMoney(double) declared", TestUtil.doesMethodExist(ATMInterface.class, "depositMoney", new Class<?>[]{double.class}));
	}

	@Test
	public void metoda_podigniNovac() {
		assertTrue("There is no method withdrawMoney(double) declared", TestUtil.doesMethodExist(ATMInterface.class, "withdrawMoney", new Class<?>[]{double.class}));
	}
}
