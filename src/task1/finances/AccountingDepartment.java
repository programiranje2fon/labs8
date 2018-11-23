package task1.finances;

import task1.Employee;

public class AccountingDepartment implements AccountingInterface {

	private double balance;

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public void paySalaries(Employee[] employees, int workingHours) {
		double salariesTotal = 0;
		
		for (Employee z : employees) {
			salariesTotal += z.computeSalary(workingHours);
		}
		
		if (salariesTotal <= balance) {
			balance -= salariesTotal;
		} else {
			System.out.println("NOT ENOUGH MONEY FOR SALARIES");
		}
	}

}
