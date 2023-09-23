package nivell1.entitats;



public class Arbre extends Producte {

	private int id;
	private float alcada; // alçada

	public Arbre() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public float getAlcada() {
		return alcada; // cm
	}

	public void setAlcada(float alcada) {
		this.alcada = alcada;
	}

	
	public Arbre fromString(String linia) {

		String[] campos = linia.split("\t");
		this.setId(Integer.parseInt(campos[0]));
		this.setAlcada(Float.parseFloat(campos[1]));

		return this;
	}
	

	@Override
	public String toString() {
		return id + "\t" + alcada;
	}

}
