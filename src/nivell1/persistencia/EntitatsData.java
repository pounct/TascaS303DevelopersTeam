package nivell1.persistencia;

import java.util.ArrayList;

import nivell1.entitats.Arbre;
import nivell1.entitats.Decoracio;
import nivell1.entitats.Flor;
import nivell1.entitats.Floristeria;
import nivell1.entitats.Indexacio;
import nivell1.entitats.LiniaTicket;
import nivell1.entitats.Producte;
import nivell1.entitats.Ticket;

public class EntitatsData {

	private ArrayList<Floristeria> floristeries;
	private Floristeria floristeria;

	private String pathFloristeriaDB;
	private String path; // to fitxers

	private ArrayList<Indexacio> indexacions;
	private int indexFloristeries;

	private ArrayList<Arbre> arbres;
	private ArrayList<Flor> flors;
	private ArrayList<Decoracio> decoracions;
	private ArrayList<Producte> productes;

	private ArrayList<Ticket> tickets;
	private ArrayList<LiniaTicket> liniesTickets;

	// private ArrayList<Compra> compres;

	// private ArrayList<LiniaCompra> liniesCompres;
	// private ArrayList<LiniaVenda> liniesVendes;

	// private ArrayList<Venda> vendes;

	public EntitatsData() {
	}

	// arbres Arbre

	public ArrayList<Arbre> getArbres() {
		path = pathFloristeriaDB + "Arbre" + "Data.txt";
		this.arbres = liniesToArbres(Persistencia.getLinies(path));
		return arbres;
	}

	public void saveArbres(ArrayList<Arbre> arbres) {
		path = pathFloristeriaDB + "Arbre" + "Data.txt";
		Persistencia.saveLines(arbresToLinies(arbres), path);
	}

	public ArrayList<Arbre> liniesToArbres(ArrayList<String> linies) {
		Arbre arbre = new Arbre();
		ArrayList<Arbre> arbres = new ArrayList<>();
		linies.forEach(linia -> arbres.add(arbre.fromString(linia)));
		return arbres;
	}

	public ArrayList<String> arbresToLinies(ArrayList<Arbre> arbres) {
		ArrayList<String> linies = new ArrayList<>();
		arbres.forEach(arbre -> linies.add(arbre.toString()));
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

	public ArrayList<String> florsToLinies(ArrayList<Flor> flors) {
		ArrayList<String> linies = new ArrayList<>();
		flors.forEach(flor -> linies.add(flor.toString()));
		return linies;
	}

	// compres Compra

//	public ArrayList<Compra> getCompres() {
//		path = pathFloristeriaDB + "Compra" + "Data.txt";
//		compres = liniesTocompres(Persistencia.getLinies(path));
//		return compres;
//	}
//
//	public ArrayList<Compra> liniesTocompres(ArrayList<String> linies) {
//		Compra compra = new Compra();
//		ArrayList<Compra> compres = new ArrayList<>();
//		linies.forEach(linia -> compres.add(compra.fromString(linia)));
//		return compres;
//	}
//
//	public void saveCompres(ArrayList<Compra> compres) {
//		path = pathFloristeriaDB + "Compra" + "Data.txt";
//		Persistencia.saveLines(compresToLinies(compres), path);
//	}
//
//	public ArrayList<String> compresToLinies(ArrayList<Compra> compres) {
//		ArrayList<String> linies = new ArrayList<>();
//		compres.forEach(compra -> linies.add(compra.toString()));
//		return linies;
//	}

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

//	floristeria Floristeria

	public Floristeria getFloristeria() {
		return floristeria;
	}

	public Floristeria setFloristeria(Floristeria floristeria) {
		pathFloristeriaDB = ".\\src\\nivell1\\data_txt\\" + floristeria.getNom() + "db\\";
		this.floristeria = floristeria;
		return this.floristeria;
	}

//	Floristeria floristeries 

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

	// dirctori db

	public void crearDirectoriFloristeria(Floristeria floristeria) {
		ServeisDataBase.crearDirectori(pathFloristeriaDB);
	}

//	Ticket tickets
	public ArrayList<Ticket> getTickets() {
		path = pathFloristeriaDB + "Ticket" + "Data.txt";
		tickets = liniesToTickets(Persistencia.getLinies(path));
		return tickets;
	}

	public void saveTickets(ArrayList<Ticket> tickets) {
		path = pathFloristeriaDB + "Ticket" + "Data.txt";
		Persistencia.saveLines(ticketsToLinies(tickets), path);

	}

	public ArrayList<Ticket> liniesToTickets(ArrayList<String> linies) {
		Ticket ticket = new Ticket();
		ArrayList<Ticket> tickets = new ArrayList<>();
		linies.forEach(linia -> tickets.add(ticket.fromString(linia)));
		return tickets;
	}

	private ArrayList<String> ticketsToLinies(ArrayList<Ticket> tickets) {
		ArrayList<String> linies = new ArrayList<>();
		tickets.forEach(ticket -> linies.add(ticket.toString()));
		return linies;
	}

//	LiniaTicket liniesTickets

	public ArrayList<LiniaTicket> getLiniesTickets() {
		path = pathFloristeriaDB + "LiniaVenda" + "Data.txt";
		liniesTickets = liniesToLiniesTickets(Persistencia.getLinies(path));
		return liniesTickets;
	}

	public ArrayList<LiniaTicket> liniesToLiniesTickets(ArrayList<String> linies) {
		LiniaTicket liniaTicket = new LiniaTicket();
		ArrayList<LiniaTicket> liniesTickets = new ArrayList<>();
		linies.forEach(linia -> liniesTickets.add(liniaTicket.fromString(linia)));
		return liniesTickets;
	}

	public void saveLiniesTickets(ArrayList<LiniaTicket> liniesTickets) {
		path = pathFloristeriaDB + "LiniaVenda" + "Data.txt";
		Persistencia.saveLines(liniesTicketsToLinies(liniesTickets), path);
	}

	public ArrayList<String> liniesTicketsToLinies(ArrayList<LiniaTicket> liniesTickets) {
		ArrayList<String> linies = new ArrayList<>();
		liniesTickets.forEach(liniaTicket -> linies.add(liniaTicket.toString()));
		return linies;
	}

//	indexFloristeries
	public int getIndexFloristeries() {
		path = ".\\src\\nivell1\\data_txt\\" + "IndexFloristeries" + "Data.txt";
		indexFloristeries = liniesToIndexFloristeries(Persistencia.getLinies(path));
		return indexFloristeries;
	}

	private int liniesToIndexFloristeries(ArrayList<String> linies) {
		if (linies.size()==0) {
			indexFloristeries = 0;
		}
		else  {
			indexFloristeries = Integer.parseInt(linies.get(0));
		}
		saveIndexFloristeries(indexFloristeries++);
		return indexFloristeries;
	}

	public void saveIndexFloristeries(int index) {
		path = pathFloristeriaDB + "IndexFloristeries" + "Data.txt";
		Persistencia.saveLines(indexFloristeriesToLinies(index), path);
	}

	public ArrayList<String> indexFloristeriesToLinies(int index) {
		ArrayList<String> linies = new ArrayList<>();
		linies.add("" + index);
		return linies;
	}

}