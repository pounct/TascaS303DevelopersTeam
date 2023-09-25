package nivell1.persistencia;

import java.util.ArrayList;

import nivell1.entitats.Arbre;
import nivell1.entitats.Compra;
import nivell1.entitats.Decoracio;
import nivell1.entitats.Flor;
import nivell1.entitats.Floristeria;
import nivell1.entitats.Indexacio;
import nivell1.entitats.LiniaCompra;
import nivell1.entitats.LiniaVenda;
import nivell1.entitats.Producte;
import nivell1.entitats.Ticket;
import nivell1.entitats.Venda;

public class EntitatsData {

	private ArrayList<Arbre> arbres;
	private ArrayList<Compra> compres;
	private ArrayList<Decoracio> decoracions;
	private ArrayList<Flor> flors;
	private ArrayList<Floristeria> floristeries;
	private ArrayList<Indexacio> indexacions;
	private ArrayList<LiniaCompra> liniesCompres;
	private ArrayList<LiniaVenda> liniesVendes;
	private ArrayList<Producte> productes;
	private ArrayList<Venda> vendes;

	private Floristeria floristeria;
	// = "data_txt\\" + floristeria.getNom() + "db\\"
	private String pathFloristeriaDB;
	private String path; // to fitxer

	public EntitatsData() {
	}

	// arbres Arbre

	public ArrayList<Arbre> getArbres() {
		path = pathFloristeriaDB + "Arbre" + "Data.txt";
		this.arbres = liniesToArbres(Persistencia.getLinies(path));
		return arbres;
	}

	public ArrayList<Arbre> liniesToArbres(ArrayList<String> linies) {
		Arbre arbre = new Arbre();
		ArrayList<Arbre> arbres = new ArrayList<>();
		linies.forEach(linia -> arbres.add(arbre.fromString(linia)));
		return arbres;
	}

	public void saveArbres(ArrayList<Arbre> arbres) {
		path = pathFloristeriaDB + "Arbre" + "Data.txt";
		Persistencia.saveLines(arbresToLinies(arbres), path);
	}

	public ArrayList<String> arbresToLinies(ArrayList<Arbre> arbres) {
		ArrayList<String> linies = new ArrayList<>();
		arbres.forEach(arbre -> linies.add(arbre.toString()));
		return linies;
	}

	// compres Compra

	public ArrayList<Compra> getCompres() {
		path = pathFloristeriaDB + "Compra" + "Data.txt";
		compres = liniesTocompres(Persistencia.getLinies(path));
		return compres;
	}

	public ArrayList<Compra> liniesTocompres(ArrayList<String> linies) {
		Compra compra = new Compra();
		ArrayList<Compra> compres = new ArrayList<>();
		linies.forEach(linia -> compres.add(compra.fromString(linia)));
		return compres;
	}

	public void saveCompres(ArrayList<Compra> compres) {
		path = pathFloristeriaDB + "Compra" + "Data.txt";
		Persistencia.saveLines(compresToLinies(compres), path);
	}

	public ArrayList<String> compresToLinies(ArrayList<Compra> compres) {
		ArrayList<String> linies = new ArrayList<>();
		compres.forEach(compra -> linies.add(compra.toString()));
		return linies;
	}

	// decoracions Decoracio

	public ArrayList<Decoracio> getDecoracions() {
		path = pathFloristeriaDB + "Decoracio" + "Data.txt";
		decoracions = liniesToDecoracions(Persistencia.getLinies(path));
		return decoracions;
	}

	public ArrayList<Decoracio> liniesToDecoracions(ArrayList<String> linies) {
		Decoracio decoracio = new Decoracio();
		ArrayList<Decoracio> decoracions = new ArrayList<>();
		linies.forEach(linia -> decoracions.add(decoracio.fromString(linia)));
		return decoracions;
	}

	public void saveDecoracions(ArrayList<Decoracio> decoracions) {
		path = pathFloristeriaDB + "Decoracio" + "Data.txt";
		Persistencia.saveLines(decoracionsToLinies(decoracions), path);
	}

	public ArrayList<String> decoracionsToLinies(ArrayList<Decoracio> decoracions) {
		ArrayList<String> linies = new ArrayList<>();
		decoracions.forEach(decoracio -> linies.add(decoracio.toString()));
		return linies;
	}

//	Flor flors;

	public ArrayList<Flor> getFlors() {
		path = pathFloristeriaDB + "Flor" + "Data.txt";
		flors = liniesToFlors(Persistencia.getLinies(path));
		return flors;
	}

	public ArrayList<Flor> liniesToFlors(ArrayList<String> linies) {
		Flor flor = new Flor();
		ArrayList<Flor> flors = new ArrayList<>();
		linies.forEach(linia -> flors.add(flor.fromString(linia)));
		return flors;
	}

	public void saveFlors(ArrayList<Flor> flors) {
		path = pathFloristeriaDB + "Flor" + "Data.txt";
		Persistencia.saveLines(florsToLinies(flors), path);

	}

	private ArrayList<String> florsToLinies(ArrayList<Flor> flors) {
		ArrayList<String> linies = new ArrayList<>();
		flors.forEach(flor -> linies.add(flor.toString()));
		return linies;
	}

//	floristeria Floristeria

	public Floristeria getFloristeria() {
		return floristeria;
	}

	public Floristeria setFloristeria(Floristeria floristeria) {
		// .\\src\\nivell1\\java\\n2exercici1\\treballador.json
		// /TascaS303DevelopersTeam/src/nivell1/EntitatsData.java
		pathFloristeriaDB = ".\\src\\nivell1\\data_txt\\" + floristeria.getNom() + "db\\";
		this.floristeria = floristeria;
		return this.floristeria;
	}

//	floristeries Floristeria

	public ArrayList<Floristeria> getFloristeries() {
		path = ".\\src\\nivell1\\data_txt\\" + "Floristeria" + "Data.txt";
		floristeries = liniesToFloristeries(Persistencia.getLinies(path));
		return floristeries;
	}

	public ArrayList<Floristeria> liniesToFloristeries(ArrayList<String> linies) {
		Floristeria floristeria = new Floristeria();
		ArrayList<Floristeria> floristeries = new ArrayList<>();
		linies.forEach(linia -> floristeries.add(floristeria.fromString(linia)));
		return floristeries;

	}

	public void saveFloristeries(ArrayList<Floristeria> floristeries) {
		path = ".\\src\\nivell1\\data_txt\\" + "Floristeria" + "Data.txt";
		Persistencia.saveLines(floristeriesToLinies(floristeries), path);

	}

	public ArrayList<String> floristeriesToLinies(ArrayList<Floristeria> floristeries) {
		ArrayList<String> linies = new ArrayList<>();
		floristeries.forEach(floristeria -> linies.add(floristeria.toString()));
		return linies;
	}

//	Indexacio indexacions

	public ArrayList<Indexacio> getIndexacions() {
		path = pathFloristeriaDB + "Indexacio" + "Data.txt";
		indexacions = liniesToIndexacions(Persistencia.getLinies(path));
		return indexacions;
	}

	public ArrayList<Indexacio> liniesToIndexacions(ArrayList<String> linies) {
		Indexacio indexacio = new Indexacio();
		ArrayList<Indexacio> indexacions = new ArrayList<>();
		linies.forEach(linia -> indexacions.add(indexacio.fromString(linia)));
		return indexacions;
	}

	public void saveIndexacions(ArrayList<Indexacio> indexacions) {
		path = pathFloristeriaDB + "Indexacio" + "Data.txt";
		Persistencia.saveLines(IndexacionsToLinies(indexacions), path);
	}

	public ArrayList<String> IndexacionsToLinies(ArrayList<Indexacio> indexacions) {
		ArrayList<String> linies = new ArrayList<>();
		indexacions.forEach(indexacio -> linies.add(indexacio.toString()));
		return linies;
	}

//	LiniaCompra liniesCompres

	public ArrayList<LiniaCompra> getLiniesCompres() {
		path = pathFloristeriaDB + "LiniaCompra" + "Data.txt";
		liniesCompres = liniesToLiniesCompres(Persistencia.getLinies(path));
		return liniesCompres;
	}

	public ArrayList<LiniaCompra> liniesToLiniesCompres(ArrayList<String> linies) {
		LiniaCompra liniaCompra = new LiniaCompra();
		ArrayList<LiniaCompra> liniesCompres = new ArrayList<>();
		linies.forEach(linia -> liniesCompres.add(liniaCompra.fromString(linia)));
		return liniesCompres;
	}

	public void saveLiniesCompres(ArrayList<LiniaCompra> liniesCompres) {
		path = pathFloristeriaDB + "LiniaCompra" + "Data.txt";
		Persistencia.saveLines(liniesCompresToLinies(liniesCompres), path);
	}

	public ArrayList<String> liniesCompresToLinies(ArrayList<LiniaCompra> liniesCompres) {
		ArrayList<String> linies = new ArrayList<>();
		liniesCompres.forEach(liniaCompra -> linies.add(liniaCompra.toString()));
		return linies;
	}

//	LiniaVenda liniesVendes

	public ArrayList<LiniaVenda> getLiniesVendes() {
		path = pathFloristeriaDB + "LiniaVenda" + "Data.txt";
		liniesVendes = liniesToLiniesVendes(Persistencia.getLinies(path));
		return liniesVendes;
	}

	public ArrayList<LiniaVenda> liniesToLiniesVendes(ArrayList<String> linies) {
		LiniaVenda liniaVenda = new LiniaVenda();
		ArrayList<LiniaVenda> liniesVendes = new ArrayList<>();
		linies.forEach(linia -> liniesVendes.add(liniaVenda.fromString(linia)));
		return liniesVendes;
	}

	public void saveLiniesVendes(ArrayList<LiniaVenda> liniesVendes) {
		path = pathFloristeriaDB + "LiniaVenda" + "Data.txt";
		Persistencia.saveLines(liniesVendesToLinies(liniesVendes), path);
	}

	public ArrayList<String> liniesVendesToLinies(ArrayList<LiniaVenda> liniesVendes) {
		ArrayList<String> linies = new ArrayList<>();
		liniesVendes.forEach(liniaVenda -> linies.add(liniaVenda.toString()));
		return linies;
	}

//	Producte productes

	public ArrayList<Producte> getProductes() {

		// path = pathFloristeriaDB + "Producte" + "Data.txt";
		productes = new ArrayList<>();
		arbres.forEach(a -> productes.add(a));
		flors.forEach(f -> productes.add(f));
		decoracions.forEach(d -> productes.add(d));
		return productes;
	}

	/*
	 * private ArrayList<Producte> liniesToProductes(ArrayList<String> linies) {
	 * Producte producte; ArrayList<Producte> productes = new ArrayList<>();
	 * linies.forEach(linia -> productes.add(producte.fromString(linia))); return
	 * productes; }
	 * 
	 * public void saveProductes(ArrayList<Producte> productes) { // save arbres
	 * flors decoracions //path = pathFloristeriaDB + "Producte" + "Data.txt";
	 * //Persistencia.saveLines(productesToLinies(productes), path); }
	 * 
	 * private ArrayList<String> productesToLinies(ArrayList<Producte> productes) {
	 * ArrayList<String> linies = new ArrayList<>(); productes.forEach(producte ->
	 * linies.add(producte.toString())); return linies; }
	 */

//	Venda vendes

	public ArrayList<Venda> getVendes() {
		path = pathFloristeriaDB + "Venda" + "Data.txt";
		vendes = liniesToVendes(Persistencia.getLinies(path));
		return vendes;
	}

	public ArrayList<Venda> liniesToVendes(ArrayList<String> linies) {
		Venda venda = new Venda();
		ArrayList<Venda> vendes = new ArrayList<>();
		linies.forEach(linia -> vendes.add(venda.fromString(linia)));
		return vendes;
	}

	public void saveVendes(ArrayList<Venda> vendes) {
		path = pathFloristeriaDB + "Venda" + "Data.txt";
		Persistencia.saveLines(vendesToLinies(vendes), path);
	}

	public ArrayList<String> vendesToLinies(ArrayList<Venda> vendes) {
		ArrayList<String> linies = new ArrayList<>();
		vendes.forEach(venda -> linies.add(venda.toString()));
		return linies;
	}

	// dirctori db

	public void crearDirectoriFloristeria(Floristeria floristeria) {
		ServeisDataBase.crearDirectori(pathFloristeriaDB);
	}

//	Ticket tickets
	public void saveTickets(ArrayList<Ticket> tickets) {
		path = pathFloristeriaDB + "Ticket" + "Data.txt";
		Persistencia.saveLines(ticketsToLinies(tickets), path);

	}

	private ArrayList<String> ticketsToLinies(ArrayList<Ticket> tickets) {
		ArrayList<String> linies = new ArrayList<>();
		tickets.forEach(ticket -> linies.add(ticket.toString()));
		return linies;
	}

}