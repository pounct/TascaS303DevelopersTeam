package nivell1.funcionalitats;

import java.util.ArrayList;
import java.util.List;

import nivell1.entitats.Producte;
import nivell1.entitats.Arbre;
import nivell1.entitats.Decoracio;
import nivell1.entitats.Flor;

public class Stock {
	//FloristeriaGestio floristeriaGestio;

	// arbres, flors, decoracions...
	private List<Arbre> arbres = new ArrayList<Arbre>();
	private List<Flor> flors = new ArrayList<Flor>();
	private List<Decoracio> decoracions = new ArrayList<Decoracio>();

	// tots els productes
	private List<Producte> productes = new ArrayList<Producte>();

	public Stock() {
	}

	// productes en stock

	public List<Producte> getProductes() {
		return productes;
	}

	public void setProductes(List<Producte> productes) {
		this.productes = productes;
	}

	public List<Arbre> getArbres() {
		return arbres;
	}

	public void setArbres(List<Arbre> arbres) {
		this.arbres = arbres;
	}

	public List<Flor> getFlors() {
		return flors;
	}

	public void setFlors(List<Flor> flors) {
		this.flors = flors;
	}

	public List<Decoracio> getDecoracions() {
		return decoracions;
	}

	public void setDecoracions(List<Decoracio> decoracions) {
		this.decoracions = decoracions;
	}

	public void addArbre(Arbre arbre) {
		this.arbres.add(arbre);
	}

	public void addFlor(Flor flor) {
		this.flors.add(flor);
	}

	public void addDecoracio(Decoracio decoracio) {
		this.decoracions.add(decoracio);
	}

	public void addProducte(Producte producte) {
		this.productes.add(producte);

	}

}
