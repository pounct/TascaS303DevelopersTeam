package nivell2.entitats;



public class Decoracio extends Producte {

	//private int id;

	public enum Material {
		FUSTA, PLASTIC
	}

	private Material material;

	public Decoracio() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Material getMaterial() {
		return material;
	}

	public void setMaterial(Material material) {
		this.material = material;
	}

	@Override
	public String toString() {
		return id + "\t" + material;
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
		
		return this;		
	}
}
