package task1;

public class Commercialist extends Employee {

	@Override
	public double computeSalary(int workingHours) {
		return workingHours * hourlyRate + 50000;
	}

}
