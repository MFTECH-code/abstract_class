package entities;

public class Individual extends Payer{
	private Double healthExpenditures;
	
	public Individual() {
		super();
	}
	
	public Individual(String name, Double anualIncome, Double healthExpenditures) {
		super(name, anualIncome);
		this.healthExpenditures = healthExpenditures;
	}

	public Double getHealthExpenditures() {
		return healthExpenditures;
	}

	public void setHealthExpenditures(Double healthExpenditures) {
		this.healthExpenditures = healthExpenditures;
	}

	@Override
	public Double tax() {
		Double tax;
		if (anualIncome < 20000.0) {
			tax = 0.15;
		} else {
			tax = 0.25;
		}
		return (anualIncome * tax) - (healthExpenditures * 0.5);			
	}
	
}
