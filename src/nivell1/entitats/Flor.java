package nivell1.entitats;

public class Flor extends Producte {

	private String color;

	public Flor() {
	}

	public Flor(String color,double preu) {
		this.color = color;
		this.setPreu(preu);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return id + "\t" + color + "\t" + preu;
	}
	
	public Flor fromString(String linia) {
		
		String[] campos = linia.split("\t");
		this.setId(Integer.parseInt(campos[0]));
		this.setColor(campos[1]);
		this.setPreu(Float.parseFloat(campos[2]));
		return this;
		
	}
}
