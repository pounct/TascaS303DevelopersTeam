package nivell1.entitats;

public abstract class Producte {
	
	protected int id;
	protected double preu;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPreu() {
		return preu;
	}

	public void setPreu(double preu) {
		this.preu = preu;
	}
}
