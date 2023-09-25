package nivell1.entitats;

public class Indexacio {
	private int indexProducte;
	private int indexTicket;
	private int indexLiniaTicket; 
	private int indexCompra;
	private int indexVenda;
	private int indexLiniaCompra;
	private int indexLiniaVenda;
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

	public Indexacio(int indexProducte, int indexCompra, int indexVenda, int indexLiniaCompra, int indexLiniaVenda,
			int indexFloristeria) {
		this.indexProducte = indexProducte;
		this.indexCompra = indexCompra;
		this.indexVenda = indexVenda;
		this.indexLiniaCompra = indexLiniaCompra;
		this.indexLiniaVenda = indexLiniaVenda;
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

	public int getIndexCompra() {
		int index = indexCompra++;
		return index;
	}

	public void setIndexCompra(int indexCompra) {
		this.indexCompra = indexCompra;
	}

	public int getIndexVenda() {
		int index = indexVenda++;
		return index;
	}

	public void setIndexVenda(int indexVenda) {
		this.indexVenda = indexVenda;
	}

	public int getIndexLiniaCompra() {
		int index = indexLiniaCompra++;
		return index;
	}

	public void setIndexLiniaCompra(int indexLiniaCompra) {
		this.indexLiniaCompra = indexLiniaCompra;
	}

	public int getIndexLiniaVenda() {
		int index = indexLiniaVenda++;
		return index;
	}

	public void setIndexLiniaVenda(int indexLiniaVenda) {
		this.indexLiniaVenda = indexLiniaVenda;
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
