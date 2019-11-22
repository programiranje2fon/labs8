package task1;

public class FactoryWorker extends Employee {

	@Override
	public double computeSalary(int workingHours) {
		return workingHours * hourlyRate;
	}

}
