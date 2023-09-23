package nivell2.entitats;

import nivell1.persistencia.Persistencia;

public class Indexacio {
	private int indexProducte;
	private int indexCompra;
	private int indexVenda;
	private int indexLiniaCompra;
	private int indexLiniaVenda;
	private int indexFloristeria;
	
	
	//Persistencia persistencia;
	public Indexacio() {

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
		//persistencia = new Persistencia();
		//persistencia.saveIndexacio(this);
		return index;
	}

	public void setIndexProducte(int indexProducte) {
		this.indexProducte = indexProducte;
	}

	public int getIndexCompra() {
		int index = indexCompra++;
		//persistencia.saveIndexacio(this);
		return index;
	}

	public void setIndexCompra(int indexCompra) {
		this.indexCompra = indexCompra;
	}

	public int getIndexVenda() {
		int index = indexVenda++;
		//persistencia.saveIndexacio(this);
		return index;
	}

	public void setIndexVenda(int indexVenda) {
		this.indexVenda = indexVenda;
	}

	public int getIndexLiniaCompra() {
		int index = indexLiniaCompra++;
		//persistencia.saveIndexacio(this);
		return index;
	}

	public void setIndexLiniaCompra(int indexLiniaCompra) {
		this.indexLiniaCompra = indexLiniaCompra;
	}

	public int getIndexLiniaVenda() {
		int index = indexLiniaVenda++;
		//persistencia.saveIndexacio(this);
		return index;
	}

	public void setIndexLiniaVenda(int indexLiniaVenda) {
		this.indexLiniaVenda = indexLiniaVenda;
	}

	public int getIndexFloristeria() {
		int index = indexFloristeria++;
		//persistencia.saveIndexacio(this);
		return index;
	}

	public void setIndexFloristeria(int indexFloristeria) {
		this.indexFloristeria = indexFloristeria;
	}

	@Override
	public String toString() {
		return indexProducte + "\t" + indexCompra + "\t" + indexVenda + "\t" + indexLiniaCompra + "\t" + indexLiniaVenda
				+ "\t" + indexFloristeria;
	}

	public Indexacio fromString(String linia) {

		String[] campos = linia.split("\t");
		this.setIndexProducte(Integer.parseInt(campos[0]));
		this.setIndexCompra(Integer.parseInt(campos[1]));
		this.setIndexVenda(Integer.parseInt(campos[2]));
		this.setIndexLiniaCompra(Integer.parseInt(campos[3]));
		this.setIndexLiniaVenda(Integer.parseInt(campos[4]));
		this.setIndexFloristeria(Integer.parseInt(campos[5]));

		return this;
	}

	public int getIndex(Floristeria floristeria) {
		// TODO Auto-generated method stub
		return 0;
	}

}
