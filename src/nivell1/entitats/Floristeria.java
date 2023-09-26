package nivell1.entitats;

import java.util.Objects;

public class Floristeria {

	private int id;
	private String nom;

	public Floristeria() {
	}

	public Floristeria(String nom) {
		this.nom = nom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	

	@Override
	public int hashCode() {
		return Objects.hash(id, nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Floristeria other = (Floristeria) obj;
		return id == other.id ;
	}

	@Override
	public String toString() {
		return id + "\t" + nom;
	}
	
	public Floristeria fromString(String linia) {
		String[] campos = linia.split("\t");
		this.setId(Integer.parseInt(campos[0]));
		this.setNom(campos[1]);
		return this;
	}
	

}
