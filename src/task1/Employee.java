package task1;

public abstract class Employee {

	protected double hourlyRate;

	public double getHourlyRate() {
		return hourlyRate;
	}

	public void setHourlyRate(double hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	public abstract double computeSalary(int workingHours);
}
