package model;

public class StatsTracker {
	private int totalBirths;
	private int totalDeaths;

	public StatsTracker() {
		this.totalBirths = 0;
		this.totalDeaths = 0;
	}

	public void recordBirth() {
		totalBirths++;
	}

	public void recordDeath() {
		totalDeaths++;
	}

	public void printStepSummary(int step, int currentPopulation) {
		System.out.println("=== Stats at Step " + step + " ===");
		System.out.println("Total Births: " + totalBirths);
		System.out.println("Total Deaths: " + totalDeaths);
		System.out.println("Current Population: " + currentPopulation);
		System.out.println();
	}

	public int getTotalBirths() {
		return totalBirths;
	}

	public int getTotalDeaths() {
		return totalDeaths;
	}
}
