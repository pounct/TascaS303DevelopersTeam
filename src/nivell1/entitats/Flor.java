package nivell1.entitats;

public class Flor extends Producte {

	//private int id;

	private String color;

	public Flor() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public String toString() {
		return id + "\t" + color;
	}
	
	public Flor fromString(String linia) {
		
		String[] campos = linia.split("\t");
		this.setId(Integer.parseInt(campos[0]));
		this.setColor(campos[1]);
		
		return this;
		
	}
}
