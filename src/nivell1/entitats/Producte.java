package nivell1.entitats;

public abstract class Producte {
	
	protected int id;
	protected String designacio;

	//public Producte() {
	//}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDesignacio() {
		return designacio;
	}

	public void setDesignacio(String designacio) {
		this.designacio = designacio;
	}
/*
	@Override
	public String toString() {
		return id + "\t" + designacio;
	}
	
	public Producte fromString(String linia) {
		String[] campos = linia.split("\t");
		this.setId(Integer.parseInt(campos[0]));
		this.setDesignacio(campos[1]);
		return this;
	}
	*/

}
