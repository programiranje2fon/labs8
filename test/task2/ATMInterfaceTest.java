package task2;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import test.TestUtil;

public class ATMInterfaceTest {
	
	@Test
	public void metoda_uloziNovac() {
		assertTrue("U klasi nije definisana metoda depositMoney(double)", TestUtil.doesMethodExist(ATMInterface.class, "depositMoney", new Class<?>[]{double.class}));
	}

	@Test
	public void metoda_podigniNovac() {
		assertTrue("U klasi nije definisana metoda withdrawMoney(double)", TestUtil.doesMethodExist(ATMInterface.class, "withdrawMoney", new Class<?>[]{double.class}));
	}
}
