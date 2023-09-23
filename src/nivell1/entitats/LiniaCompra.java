package nivell1.entitats;

public class LiniaCompra {

	private int id;
	private int compraId;
	private int producteId;
	private double preu;

	public LiniaCompra() {
	}

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

	public int getCompraId() {
		return compraId;
	}

	public void setCompraId(int compraId) {
		this.compraId = compraId;
	}

	public int getProducteId() {
		return producteId;
	}

	public void setProducteId(int producteId) {
		this.producteId = producteId;
	}

	@Override
	public String toString() {
		return id + "\t" + compraId + "\t" + producteId + "\t" + preu;
	}

	public LiniaCompra fromString(String linia) {
		String[] campos = linia.split("\t");
		this.setId(Integer.parseInt(campos[0]));
		this.setCompraId(Integer.parseInt(campos[1]));
		this.setProducteId(Integer.parseInt(campos[2]));
		this.setPreu(Double.parseDouble(campos[3]));
		return this;
	}
}
