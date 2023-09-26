package nivell1.entitats;

public class Indexacio {
	private int indexProducte;
	private int indexTicket;
	private int indexLiniaTicket; 
	private int indexFloristeria;
	
	
	
	//Persistencia persistencia;
	public Indexacio() {

	}

	

	public Indexacio(int indexProducte, int indexTicket, int indexLiniaTicket, int indexFloristeria) {
		
		this.indexProducte = indexProducte;
		this.indexTicket = indexTicket;
		this.indexLiniaTicket = indexLiniaTicket;
		this.indexFloristeria = indexFloristeria;
	}

	public int getIndexProducte() {
		int index = indexProducte++;
		return index;
	}

	public void setIndexProducte(int indexProducte) {
		this.indexProducte = indexProducte;
	}
	
	public int getIndexTicket() {
		int index = indexTicket++;
		return index;
	}



	public void setIndexTicket(int indexTicket) {
		this.indexTicket = indexTicket;
	}



	public int getIndexLiniaTicket() {
		int index = indexLiniaTicket++;
		return index;
	}



	public void setIndexLiniaTicket(int indexLiniaTicket) {
		this.indexLiniaTicket = indexLiniaTicket;
	}

	public int getIndexFloristeria() {
		int index = indexFloristeria++;
		return index;
	}

	public void setIndexFloristeria(int indexFloristeria) {
		this.indexFloristeria = indexFloristeria;
	}

	@Override
	public String toString() {
		return indexProducte + "\t" + indexTicket + "\t" + indexLiniaTicket + "\t" + indexFloristeria;
	}

	public Indexacio fromString(String linia) {

		String[] campos = linia.split("\t");
		this.setIndexProducte(Integer.parseInt(campos[0]));
		this.setIndexTicket(Integer.parseInt(campos[1]));
		this.setIndexLiniaTicket(Integer.parseInt(campos[2]));
		this.setIndexFloristeria(Integer.parseInt(campos[3]));

		return this;
	}

	public int getIndex(Floristeria floristeria) {
		// TODO Auto-generated method stub
		return 0;
	}

}
