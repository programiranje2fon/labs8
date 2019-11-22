package task2;

public class TestATM {
	
	public static void main(String[] args) {
		
		ATMInterface a = new ATM();
		
		a.depositMoney(430);
		a.withdrawMoney(222.34);
		
		ATM an = (ATM) (a);
		an.depositMoney(500);
		an.printBalance();
	}
}
