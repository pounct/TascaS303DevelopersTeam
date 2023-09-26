package nivell1.entitats;



public class Arbre extends Producte {

	//private int id;
	private float alcada; // alçada

	public Arbre() {
	}
	

	public Arbre(float alcada,double preu) {
		this.setPreu(preu);
		this.alcada = alcada;
	}

	public float getAlcada() {
		return alcada; // cm
	}

	public void setAlcada(float alcada) {
		this.alcada = alcada;
	}
	

	@Override
	public String toString() {
		return id + "\t" + alcada + "\t" + preu;
	}

	
	public Arbre fromString(String linia) {

		String[] campos = linia.split("\t");
		this.setId(Integer.parseInt(campos[0]));
		this.setAlcada(Float.parseFloat(campos[1]));
		this.setPreu(Float.parseFloat(campos[2]));

		return this;
	}
	


}
