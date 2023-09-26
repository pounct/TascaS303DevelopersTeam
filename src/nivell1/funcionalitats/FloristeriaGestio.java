package nivell1.funcionalitats;

import java.util.ArrayList;
import nivell1.entitats.Arbre;
import nivell1.entitats.Decoracio;
import nivell1.entitats.Decoracio.Material;
import nivell1.persistencia.EntitatsData;
import nivell1.entitats.Flor;
import nivell1.entitats.Floristeria;
import nivell1.entitats.Indexacio;
import nivell1.entitats.LiniaTicket;
import nivell1.entitats.Producte;
import nivell1.entitats.Ticket;

public class FloristeriaGestio {

	// gestion floristeria
	private Floristeria floristeria;
	// private String pathFloristeriaDB;
	private ArrayList<Floristeria> floristeries = new ArrayList<>();
	// map
	private EntitatsData entitatsData = new EntitatsData();
	// gestion indexacio
	private Indexacio indexacio;
	// gestion producte
	private ArrayList<Producte> productes = new ArrayList<>();
	private ArrayList<Arbre> arbres = new ArrayList<>();
	private ArrayList<Flor> flors = new ArrayList<>();
	private ArrayList<Decoracio> decoracions = new ArrayList<>();
	// gestion Stock
	private Stock stock;
	// gestion Compra Venda
	private ArrayList<Ticket> tickets = new ArrayList<>();
	private ArrayList<LiniaTicket> liniesTickets = new ArrayList<>();
	// gestion Indexacio
	private ArrayList<Indexacio> indexacions = new ArrayList<>();
	private int indexFloristeries;
	//////

	public FloristeriaGestio() {
		floristeries = entitatsData.getFloristeries();
		setIndexFloristeries(entitatsData.getIndexFloristeries());
		System.out.println(floristeries);
	}

	public Indexacio getIndexacio() {
		return indexacio;
	}

	////////////////////////// funcionalitats:

	// Crear Floristeria.
	public Floristeria crearFloristeria(String nom) {

		// Crear i initialtzar Indexacio
		indexacio = new Indexacio(0, 0, 0, getIndexFloristeries());
		indexacions.add(indexacio);
		// Crear Floristeria.
		floristeria = new Floristeria();
		floristeria.setId(indexacio.getIndex(floristeria));
		floristeria.setNom(nom);
		// Guardar Floristeria
		floristeries.add(floristeria);
		entitatsData.setFloristeria(floristeria);
		entitatsData.crearDirectoriFloristeria(floristeria);
		System.out.println("guardar la floristeria a la base de dades...");
		entitatsData.saveFloristeries(floristeries);
		entitatsData.saveIndexacions(indexacions);
		entitatsData.saveIndexFloristeries(indexFloristeries);
		System.out.println("floristeria guardada.");
		return floristeria;
	}

	// Afegir Arbre ///////////////////////////////////////
	public void afegirArbre(double preu, float alcada) {
		// Crear Arbre Producte compra i LiniaCompra
		Arbre arbre = new Arbre();
		// indexacio...
		int producteId = indexacio.getIndexProducte();
		// afegir Arbre
		arbre.setId(producteId);
		arbre.setPreu(preu);
		arbre.setAlcada(alcada);
		this.arbres.add(arbre);
		// Guardar modificacions
		entitatsData.saveIndexacions(indexacions);
		entitatsData.saveArbres(arbres);
	}

	// Afegir Flor ///////////////////////////////////////
	public void afegirFlor(double preu, String color) {
		// Crear Flor Producte compra i LiniaCompra
		Flor flor = new Flor();
		// indexacio...
		int producteId = indexacio.getIndexProducte();
		// afegir Flor
		flor.setId(producteId);
		flor.setPreu(preu);
		flor.setColor(color);
		this.flors.add(flor);
		// Guardar modificacions
		entitatsData.saveIndexacions(indexacions);
		entitatsData.saveFlors(flors);
	}

	// Afegir Decoracio ///////////////////////////////////////
	public void afegirDecoracio(double preu, Material material) {
		// Crear Decoracio Producte compra i LiniaCompra
		Decoracio decoracio = new Decoracio();
		// indexacio...
		int producteId = indexacio.getIndexProducte();
		// afegir Decoracio
		decoracio.setId(producteId);
		decoracio.setPreu(preu);
		decoracio.setMaterial(material);
		this.decoracions.add(decoracio);
		// Guardar modificacions
		entitatsData.saveIndexacions(indexacions);
		entitatsData.saveDecoracions(decoracions);
	}

	// Stock
	// Resultat Stock
	public Stock getstock() {
		// actualitzar entitats Stock
		stock.setArbres(entitatsData.getArbres());
		stock.setFlors(entitatsData.getFlors());
		stock.setDecoracions(entitatsData.getDecoracions());
		return stock;
	}

	// Retirar Arbre
	public void retirarArbre(int producteId) {
		productes = actualitzarProductes();
		Producte producte = getProducte(producteId);
		if (producte != null) {

			this.arbres.remove(getArbre(producteId));
			// Guardar modificacions
			entitatsData.saveArbres(arbres);
		}
	}

	private ArrayList<Producte> actualitzarProductes() {
		productes.addAll(getArbres());
		productes.addAll(getFlors());
		productes.addAll(getDecoracions());
		return productes;
	}

	// Retirar Flor
	public void retirarFlor(int producteId) {
		productes = actualitzarProductes();
		Producte producte = getProducte(producteId);
		if (producte != null) {

			this.flors.remove(getFlor(producteId));
			// Guardar modificacions
			entitatsData.saveFlors(flors);
		}
	}

	// Retirar Decoracio
	public void retirarDecoracio(int producteId) {
		productes = actualitzarProductes();
		Producte producte = getProducte(producteId);
		if (producte != null) {
			this.decoracions.remove(getDecoracio(producteId));
			// Guardar modificacions
			entitatsData.saveDecoracions(decoracions);
		}
	}

	// Stock Amb Quantitats
	// = getStock -> size() dels arbres, ....

	// Valor Stock
	// Valor Arbres
	public double getValorStockArbres() {
		double valor = 0;
		for (Arbre arb : stock.getArbres()) {
			valor += arb.getPreu();
		}
		return valor;
	}

	// Valor Flors
	public double getValorStockFlors() {
		double valor = 0;
		for (Flor flo : stock.getFlors()) {
			valor += flo.getPreu();
		}
		return valor;
	}

	// Valor Decoracio
	public double getValorStockDecoracions() {
		double valor = 0;
		for (Decoracio dec : stock.getDecoracions()) {
			valor += dec.getPreu();
		}
		return valor;
	}

	//

	public Ticket crearTicket() {
		Ticket ticket = new Ticket();

		int ticketId = indexacio.getIndexTicket();
		ticket.setId(ticketId);

		this.tickets.add(ticket);
		entitatsData.saveTickets(tickets);

		return ticket;
	}

	///////////////// fin funcionalitats.////////////////////
	/////////////////////////////////////////////////////////

	public Producte getProducte(int producteId) {

		Producte producte = null;
		int i = 0;
		int num = productes.size();
		while (producte == null && i < num) {
			int id = productes.get(i).getId();

			if (id == producteId) {
				producte = productes.get(i);
			}
		}
		return producte;
	}

	public Arbre getArbre(int producteId) {

		Arbre producte = null;
		int i = 0;
		int num = arbres.size();
		while (producte == null && i < num) {
			int id = arbres.get(i).getId();

			if (id == producteId) {
				producte = arbres.get(i);
			} else {
				i++;
			}
		}
		return producte;
	}

	public Flor getFlor(int producteId) {

		Flor producte = null;
		int i = 0;
		int num = flors.size();
		while (producte == null && i < num) {
			int id = flors.get(i).getId();

			if (id == producteId) {
				producte = flors.get(i);
			} else {
				i++;
			}
		}
		return producte;
	}

	public Decoracio getDecoracio(int producteId) {

		Decoracio producte = null;
		int i = 0;
		int num = decoracions.size();
		while (producte == null && i < num) {
			int id = decoracions.get(i).getId();

			if (id == producteId) {
				producte = decoracions.get(i);
			} else {
				i++;
			}
		}
		return producte;
	}

	// Afegir Arbre Amb Ticket

	public void afegirArbre(double preu, float alcada, Ticket ticket) {

		// Crear Arbre Producte compra i LiniaCompra
		Arbre arbre = new Arbre();
		LiniaTicket liniaTicket = new LiniaTicket();
		// indexacio...
		int producteId = indexacio.getIndexProducte();
		// int compraId = indexacio.getIndexCompra();
		int liniaId = indexacio.getIndexLiniaTicket();

		// afegir Arbre
		arbre.setId(producteId);
		arbre.setAlcada(alcada);
		this.arbres.add(arbre);

		// afegir depemdencies
		liniaTicket.setId(liniaId);
		liniaTicket.setTicketId(ticket.getId());
		liniaTicket.setProducteId(producteId);
		this.liniesTickets.add(liniaTicket);

		// Guardar modificacions (entitats)
		entitatsData.saveIndexacions(indexacions);
		entitatsData.saveArbres(arbres);
		entitatsData.saveLiniesTickets(liniesTickets);

	}

	public void afegirFlor(double preu, String color, Ticket ticket) {
		// Crear Flor Producte compra i LiniaCompra
		Flor flor = new Flor();
		LiniaTicket liniaTicket = new LiniaTicket();
		// indexacio...
		int producteId = indexacio.getIndexProducte();
		// int compraId = indexacio.getIndexCompra();
		int liniaId = indexacio.getIndexLiniaTicket();

		// afegir Flor
		flor.setId(producteId);
		flor.setColor(color);
		this.flors.add(flor);

		// afegir depemdencies
		liniaTicket.setId(liniaId);
		liniaTicket.setTicketId(ticket.getId());
		liniaTicket.setProducteId(producteId);
		this.liniesTickets.add(liniaTicket);

		// Guardar entitats
		entitatsData.saveIndexacions(indexacions);
		entitatsData.saveFlors(flors);
		entitatsData.saveLiniesTickets(liniesTickets);

	}

	public void afegirDecoracio(double preu, Material material, Ticket ticket) {

		// Crear Decoracio ticket i LiniaTicket
		Decoracio decoracio = new Decoracio();
		// Producte producte = new Producte();
		// Compra compra = new Compra();
		LiniaTicket liniaTicket = new LiniaTicket();
		// indexacio...
		int producteId = indexacio.getIndexProducte();
		// int compraId = indexacio.getIndexCompra();
		int liniaId = indexacio.getIndexLiniaTicket();

		// afegir Decoracio
		decoracio.setId(producteId);
		decoracio.setMaterial(material);
		this.decoracions.add(decoracio);

		// afegir depemdencies
		liniaTicket.setId(liniaId);
		liniaTicket.setTicketId(ticket.getId());
		liniaTicket.setProducteId(producteId);
		this.liniesTickets.add(liniaTicket);

		// Guardar entitats
		entitatsData.saveIndexacions(indexacions);
		entitatsData.saveDecoracions(decoracions);
		entitatsData.saveLiniesTickets(liniesTickets);
	}

	// Compres Antigues.
	public String mostrarTickets() {
		String resultat = "";
		double totalCompra = 0;
		double totalCompres = 0;

		for (Ticket ticket : tickets) {
			resultat += "--------------------------------------------\n";
			resultat += ticket.getId() + "\n";
			resultat += "--------------------------------------------\n";
			resultat += "\n";
			for (LiniaTicket liniaTicket : liniesTickets) {
				totalCompra = 0;
				if (liniaTicket.getTicketId() == ticket.getId()) {
					double preu = getProducte(liniaTicket.getProducteId()).getPreu();
					resultat += "" + liniaTicket.getId() + "\t" + preu;
					resultat += "\n";
					totalCompra += preu;
				}

			}
			resultat += "--------------------------------------------\n";
			resultat += "\t\t\t\t\t\t total Compra :" + totalCompra + "\n";
			resultat += "--------------------------------------------\n\n";
			totalCompres += totalCompra;

		}
		resultat += "--------------------------------------------\n";
		resultat += "--------------------------------------------\n";
		resultat += "\t\t\t\t\t\t total Compres :" + totalCompres + "\n";
		resultat += "--------------------------------------------\n";
		return resultat;
	}

	public double getTotalTickets() {
		double totalVendes = 0;
		for (LiniaTicket liniaTicket : liniesTickets) {
			double preu = getProducte(liniaTicket.getProducteId()).getPreu();
			totalVendes += preu;
		}
		return totalVendes;
	}

	public Floristeria getFloristeria(int floristeriaId) {
		Floristeria floristeria = null;
		int i = 0;
		int num = floristeries.size();
		while (floristeria == null && i < num) {
			int id = floristeries.get(i).getId();

			if (id == floristeriaId) {
				floristeria = floristeries.get(i);
			} else {
				i++;
			}
		}
		return floristeria;
	}

	public Floristeria obrirFloristeria(Floristeria floristeria) {
		// Initialtzar Floristeria.
		this.floristeria = entitatsData.setFloristeria(floristeria);
		// Initialtzar Indexacio
		indexacions = entitatsData.getIndexacions();
		indexacio = indexacions.get(0);
		// carregar dades
		arbres = entitatsData.getArbres();
		flors = entitatsData.getFlors();
		decoracions = entitatsData.getDecoracions();

		tickets = entitatsData.getTickets();
		liniesTickets = entitatsData.getLiniesTickets();

		// liniesCompres= entitatsData.getLiniesCompres();

		// productes= entitatsData.getProductes();
		// vendes= entitatsData.getVendes();
		System.out.println("Floristeria obert...");
		return floristeria;
	}

	public ArrayList<Arbre> getArbres() {
		arbres = entitatsData.getArbres();
		return arbres;
	}

	public ArrayList<Flor> getFlors() {
		flors = entitatsData.getFlors();
		return flors;
	}

	public ArrayList<Decoracio> getDecoracions() {
		decoracions = entitatsData.getDecoracions();
		return null;
	}

	public int getIndexFloristeries() {
		return indexFloristeries;
	}

	public int  setIndexFloristeries(int indexFloristeries) {
		this.indexFloristeries = indexFloristeries;
		return this.indexFloristeries;
	}
}
