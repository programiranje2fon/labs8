package task1;

import task1.finances.AccountingInterface;
import task1.finances.AccountingDepartment;

public class TestEmployee {

	public static void main(String[] args) {
		
		FactoryWorker employee1 = new FactoryWorker();
		employee1.setHourlyRate(170);
		System.out.println(employee1.computeSalary(176));
		
		Commercialist employee2 = new Commercialist();
		employee2.setHourlyRate(450);
		System.out.println(employee2.computeSalary(176));
		
		AccountingInterface accounting = new AccountingDepartment();
		accounting.paySalaries(new Employee[]{employee1, employee2}, 176);
		
		AccountingDepartment accountingDept = (AccountingDepartment) accounting;
		accountingDept.setBalance(1000000);

		accountingDept.paySalaries(new Employee[]{employee1, employee2}, 176);
		System.out.println("Account balace is: " + accountingDept.getBalance());
	}

}
