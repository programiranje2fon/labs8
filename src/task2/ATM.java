package task2;

public class ATM implements ATMInterface {

	private double balance = 5000;

	public void depositMoney(double amount) {
		if (amount <= 0) {
			System.out.println("ERROR");
		} else {
			balance = balance + amount;
		}
	}

	public void withdrawMoney(double amount) {
		if (amount <= 0) {
			System.out.println("ERROR");
		} else {
			if (balance >= amount) {
				balance = balance - amount;
			} else {
				System.out.println("NOT ENOUGH MONEY FOR WITHDRAWAL");
			}
		}
	}

	public void printBalance() {
		System.out.println("Current ATM balance: " + balance + " RSD");
	}

}
