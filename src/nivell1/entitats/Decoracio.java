package nivell1.entitats;



public class Decoracio extends Producte {

	public enum Material {
		FUSTA, PLASTIC
	}

	private Material material;

	public Decoracio() {
	}
	

	public Decoracio(Material material,double preu) {
		this.material = material;
		this.setPreu(preu);
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return id + "\t" + material + "\t" + preu;
	}
	
	public Decoracio fromString(String linia) {
		
		String[] campos = linia.split("\t");
		Material material;
		if (campos[1].toLowerCase().equals("plastic"))
			material = Material.PLASTIC;
		else
			material = Material.FUSTA;

		this.setId(Integer.parseInt(campos[0]));
		this.setMaterial(material);
		this.setPreu(Float.parseFloat(campos[2]));		
		return this;		
	}
}
