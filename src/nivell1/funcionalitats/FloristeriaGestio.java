package nivell1.funcionalitats;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;

import nivell1.entitats.Arbre;
import nivell1.entitats.Compra;
import nivell1.entitats.Decoracio;
import nivell1.entitats.Decoracio.Material;
import nivell1.persistencia.EntitatsData;
import nivell1.entitats.Flor;
import nivell1.entitats.Floristeria;
import nivell1.entitats.Indexacio;
import nivell1.entitats.LiniaCompra;
import nivell1.entitats.LiniaVenda;
import nivell1.entitats.Producte;
import nivell1.entitats.Venda;

public class FloristeriaGestio {

	// gestion floristeria
	private Floristeria floristeria;
	// private String pathFloristeriaDB;
	private ArrayList<Floristeria> floristeries = new ArrayList<>();
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
	private ArrayList<Compra> compres = new ArrayList<>();
	private ArrayList<Venda> vendes = new ArrayList<>();
	private ArrayList<LiniaCompra> liniesCompres = new ArrayList<>();
	private ArrayList<LiniaVenda> liniesVendes = new ArrayList<>();
	// gestion Indexacio
	private ArrayList<Indexacio> indexacions = new ArrayList<>();
	//////

	public FloristeriaGestio() {
		floristeries = entitatsData.getFloristeries();
		System.out.println(floristeries);
	}

	public Indexacio getIndexacio() {
		return indexacio;
	}

	////////////////////////// funcionalitats:

	// Crear Floristeria.
	public Floristeria crearFloristeria(String nom) {

		// Crear i initialtzar Indexacio
		indexacio = new Indexacio(0, 0, 0, 0, 0, 0);
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
		System.out.println("floristeria guardada.");
		return floristeria;
	}

	// Afegir Arbre ///////////////////////////////////////
	public void afegirArbre(String nom, double preu, float alcada) {
		// Crear Arbre Producte compra i LiniaCompra
		Arbre arbre = new Arbre();
		//Producte producte = new Producte();
		Compra compra = new Compra();
		LiniaCompra liniaCompra = new LiniaCompra();
		// indexacio...
		int producteId = indexacio.getIndexProducte();
		int compraId = indexacio.getIndexCompra();
		int liniaId = indexacio.getIndexLiniaCompra();
		Date dateC = new Date(System.currentTimeMillis());

		// afegir Arbre
		arbre.setId(producteId);
		arbre.setAlcada(alcada);
		this.arbres.add(arbre);

		// afegir depemdencies
		//producte.setId(producteId);
		//producte.setDesignacio(nom);
		//this.productes.add(producte);
		//////////////////////
		compra.setId(compraId);
		compra.setDate(dateC);
		this.compres.add(compra);
		////////////////////////
		liniaCompra.setCompraId(compraId);
		liniaCompra.setId(liniaId);
		liniaCompra.setProducteId(producteId);
		liniaCompra.setPreu(preu);
		this.liniesCompres.add(liniaCompra);
		// Guardar modificacions (entitats)
		entitatsData.saveIndexacions(indexacions);
		entitatsData.saveArbres(arbres);
		entitatsData.saveCompres(compres);
		entitatsData.saveLiniesCompres(liniesCompres);
		//entitatsData.saveProductes(productes);
	}

	// Afegir Flor ///////////////////////////////////////
	public void afegirFlor(String nom, double preu, String color) {
		// Crear Flor Producte compra i LiniaCompra
		Flor flor = new Flor();
		//Producte producte = new Producte();
		Compra compra = new Compra();
		LiniaCompra liniaCompra = new LiniaCompra();
		// indexacio...
		int producteId = indexacio.getIndexProducte();
		int compraId = indexacio.getIndexCompra();
		int liniaId = indexacio.getIndexLiniaCompra();
		Date dateC = new Date(System.currentTimeMillis());

		// afegir Flor
		flor.setId(producteId);
		flor.setColor(color);
		this.flors.add(flor);

		// afegir depemdencies
		//producte.setId(producteId);
		//producte.setDesignacio(nom);
		//this.productes.add(producte);
		//////////////////////
		compra.setId(compraId);
		compra.setDate(dateC);
		this.compres.add(compra);
		////////////////////////
		liniaCompra.setCompraId(compraId);
		liniaCompra.setId(liniaId);
		liniaCompra.setProducteId(producteId);
		liniaCompra.setPreu(preu);
		this.liniesCompres.add(liniaCompra);
		// Guardar entitats
		entitatsData.saveIndexacions(indexacions);
		entitatsData.saveFlors(flors);
		entitatsData.saveCompres(compres);
		entitatsData.saveLiniesCompres(liniesCompres);
		//entitatsData.saveProductes(productes);
	}

	// Afegir Decoracio ///////////////////////////////////////
	public void afegirDecoracio(String nom, double preu, Material material) {
		// Crear Decoracio Producte compra i LiniaCompra
		Decoracio decoracio = new Decoracio();
		//Producte producte = new Producte();
		Compra compra = new Compra();
		LiniaCompra liniaCompra = new LiniaCompra();
		// indexacio...
		int producteId = indexacio.getIndexProducte();
		int compraId = indexacio.getIndexCompra();
		int liniaId = indexacio.getIndexLiniaCompra();
		Date dateC = new Date(System.currentTimeMillis());

		// afegir Decoracio
		decoracio.setId(producteId);
		decoracio.setMaterial(material);
		this.decoracions.add(decoracio);

		// afegir depemdencies
		//producte.setId(producteId);
		//producte.setDesignacio(nom);
		//this.productes.add(producte);
		//////////////////////
		compra.setId(compraId);
		compra.setDate(dateC);
		this.compres.add(compra);
		////////////////////////
		liniaCompra.setCompraId(compraId);
		liniaCompra.setId(liniaId);
		liniaCompra.setProducteId(producteId);
		liniaCompra.setPreu(preu);
		this.liniesCompres.add(liniaCompra);
		// Guardar entitats
		entitatsData.saveIndexacions(indexacions);
		entitatsData.saveDecoracions(decoracions);
		entitatsData.saveCompres(compres);
		entitatsData.saveLiniesCompres(liniesCompres);
		//entitatsData.saveProductes(productes);
	}

	// Stock
	// Resultat Stock
	public Stock getstock() {
		calcularStock();
		return stock;
	}

	// Retirar Arbre
	public void retirarArbre(int producteId) {
		Producte producte = getProducte(producteId);
		if (producte != null) {
			this.productes.remove(producte);
			this.arbres.remove(getArbre(producteId));
			LiniaCompra liniaCompra = getLiniaCompraByProducteId(producteId);
			// otre control.....
			this.liniesCompres.remove(liniaCompra);
			LiniaVenda liniaVenda = getLiniaVendaByProducteId(producteId);
			if (liniaVenda != null) {
				this.liniesVendes.remove(liniaVenda);
			}
			entitatsData.saveArbres(arbres);
			//entitatsData.saveProductes(productes);
			entitatsData.saveLiniesCompres(liniesCompres);
			entitatsData.saveLiniesVendes(liniesVendes);
		}
	}

	// Retirar Arbre
	public void retirarFlor(int producteId) {
		Producte producte = getProducte(producteId);
		if (producte != null) {
			this.productes.remove(producte);
			this.flors.remove(getFlor(producteId));
			LiniaCompra liniaCompra = getLiniaCompraByProducteId(producteId);
			// otre control.....
			this.liniesCompres.remove(liniaCompra);
			LiniaVenda liniaVenda = getLiniaVendaByProducteId(producteId);
			if (liniaVenda != null) {
				this.liniesVendes.remove(liniaVenda);
			}
			entitatsData.saveFlors(flors);
			//entitatsData.saveProductes(productes);
			entitatsData.saveLiniesCompres(liniesCompres);
			entitatsData.saveLiniesVendes(liniesVendes);
		}
	}

	// Retirar Decoracio
	public void retirarDecoracio(int producteId) {
		Producte producte = getProducte(producteId);
		if (producte != null) {
			this.productes.remove(producte);
			this.decoracions.remove(getDecoracio(producteId));
			LiniaCompra liniaCompra = getLiniaCompraByProducteId(producteId);
			// otre control.....
			this.liniesCompres.remove(liniaCompra);
			LiniaVenda liniaVenda = getLiniaVendaByProducteId(producteId);
			if (liniaVenda != null) {
				this.liniesVendes.remove(liniaVenda);
			}
			entitatsData.saveDecoracions(decoracions);
			//entitatsData.saveProductes(productes);
			entitatsData.saveLiniesCompres(liniesCompres);
			entitatsData.saveLiniesVendes(liniesVendes);
		}
	}

	// Stock Amb Quantitats
	// =getStock -> size() dels arbres, ....

	// Valor Stock
	// Valor Arbres
	public double getValorStockArbres() {
		double valor = 0;
		for (Arbre arb : stock.getArbres()) {
			valor += getLiniaCompraByProducteId(arb.getId()).getPreu();
		}
		return valor;
	}

	// Valor Flors
	public double getValorStockFlors() {
		double valor = 0;
		for (Flor flo : stock.getFlors()) {
			valor += getLiniaCompraByProducteId(flo.getId()).getPreu();
		}
		return valor;
	}

	// Valor Decoracio
	public double getValorStockDecoracions() {
		double valor = 0;
		for (Decoracio dec : stock.getDecoracions()) {
			valor += getLiniaCompraByProducteId(dec.getId()).getPreu();
		}
		return valor;
	}

	//
	public Compra crearCompra() {
		Compra compra = new Compra();

		int compraId = indexacio.getIndexCompra();
		Date dateC = new Date(System.currentTimeMillis());

		compra.setId(compraId);
		compra.setDate(dateC);

		this.compres.add(compra);
		entitatsData.saveCompres(compres);

		return compra;
	}

	///////////////// fin funcionalitats.////////////////////
	/////////////////////////////////////////////////////////

	public void calcularStock() {
		// inicialitzar entitats Stock
		liniesCompres = entitatsData.getLiniesCompres();
		liniesVendes = entitatsData.getLiniesVendes();
		productes = entitatsData.getProductes();
		arbres = entitatsData.getArbres();
		flors = entitatsData.getFlors();
		decoracions = entitatsData.getDecoracions();
		// ini stock
		stock = new Stock();
		// productes en stock = liniesCompres - liniesVendes
		Iterator<LiniaCompra> it = liniesCompres.iterator();
		ArrayList<Integer> productesIds = new ArrayList<>();
		// productes en stock by id
		while (it.hasNext()) {
			LiniaCompra lc = it.next();
			boolean vemdido = false;
			for (LiniaVenda lv : liniesVendes) {
				if (lv.getProducteId() == lc.getProducteId()) {
					vemdido = true;
				}
			}
			if (!vemdido)
				productesIds.add(lc.getProducteId());
		}
		productes.forEach(producte -> {
			if (productesIds.contains(producte.getId())) {
				stock.addProducte(producte);
			}
		});

		arbres.forEach(arbre -> {
			if (productesIds.contains(arbre.getId())) {
				stock.addArbre(arbre);
			}
		});

		flors.forEach(flor -> {
			if (productesIds.contains(flor.getId())) {
				stock.addFlor(flor);
			}
		});

		decoracions.forEach(decoracio -> {
			if (productesIds.contains(decoracio.getId())) {
				stock.addDecoracio(decoracio);
			}
		});

	}

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

	public LiniaCompra getLiniaCompraByProducteId(int producteId) {

		LiniaCompra producteLiniaCompra = null;
		int i = 0;
		int num = liniesCompres.size();
		while (producteLiniaCompra == null && i < num) {
			int id = liniesCompres.get(i).getProducteId();

			if (id == producteId) {
				producteLiniaCompra = liniesCompres.get(i);
			} else {
				i++;
			}
		}
		return producteLiniaCompra;
	}

	public LiniaVenda getLiniaVendaByProducteId(int producteId) {

		LiniaVenda producteLiniaVenda = null;
		int i = 0;
		int num = liniesVendes.size();
		while (producteLiniaVenda == null && i < num) {
			int id = liniesVendes.get(i).getProducteId();

			if (id == producteId) {
				producteLiniaVenda = liniesVendes.get(i);
			} else {
				i++;
			}
		}
		return producteLiniaVenda;
	}

	// Afegir Arbre Amb Compra

	public void afegirArbre(String nom, double preu, float alcada, Compra compra) {

		// Crear Arbre Producte compra i LiniaCompra
		Arbre arbre = new Arbre();
		//Producte producte = new Producte();
		// Compra compra = new Compra();
		LiniaCompra liniaCompra = new LiniaCompra();
		// indexacio...
		int producteId = indexacio.getIndexProducte();
		// int compraId = indexacio.getIndexCompra();
		int liniaId = indexacio.getIndexLiniaCompra();
		// Date dateC = new Date(System.currentTimeMillis());

		// afegir Arbre
		arbre.setId(producteId);
		arbre.setAlcada(alcada);
		this.arbres.add(arbre);

		// afegir depemdencies
		//producte.setId(producteId);
		//producte.setDesignacio(nom);
		//this.productes.add(producte);
		//////////////////////
		// compra.setId(compraId);
		// compra.setDate(dateC);
		// this.compres.add(compra);
		////////////////////////
		liniaCompra.setCompraId(compra.getId());
		liniaCompra.setId(liniaId);
		liniaCompra.setProducteId(producteId);
		liniaCompra.setPreu(preu);
		this.liniesCompres.add(liniaCompra);
		// Guardar modificacions (entitats)
		entitatsData.saveIndexacions(indexacions);
		entitatsData.saveArbres(arbres);
		// entitatsData.saveCompres(compres);
		entitatsData.saveLiniesCompres(liniesCompres);
		//entitatsData.saveProductes(productes);

	}

	public void afegirFlor(String nom, double preu, String color, Compra compra) {
		// Crear Flor Producte compra i LiniaCompra
		Flor flor = new Flor();
		//Producte producte = new Producte();
		// Compra compra = new Compra();
		LiniaCompra liniaCompra = new LiniaCompra();
		// indexacio...
		int producteId = indexacio.getIndexProducte();
		// int compraId = indexacio.getIndexCompra();
		int liniaId = indexacio.getIndexLiniaCompra();
		// Date dateC = new Date(System.currentTimeMillis());

		// afegir Flor
		flor.setId(producteId);
		flor.setColor(color);
		this.flors.add(flor);

		// afegir depemdencies
		//producte.setId(producteId);
		//producte.setDesignacio(nom);
		//this.productes.add(producte);
		//////////////////////
		// compra.setId(compraId);
		// compra.setDate(dateC);
		// this.compres.add(compra);
		////////////////////////
		liniaCompra.setCompraId(compra.getId());
		liniaCompra.setId(liniaId);
		liniaCompra.setProducteId(producteId);
		liniaCompra.setPreu(preu);
		this.liniesCompres.add(liniaCompra);
		// Guardar entitats
		entitatsData.saveIndexacions(indexacions);
		entitatsData.saveFlors(flors);
		// entitatsData.saveCompres(compres);
		entitatsData.saveLiniesCompres(liniesCompres);
		//entitatsData.saveProductes(productes);

	}

	public void afegirDecoracio(String nom, double preu, Material material, Compra compra) {

		// Crear Decoracio Producte compra i LiniaCompra
		Decoracio decoracio = new Decoracio();
		//Producte producte = new Producte();
		// Compra compra = new Compra();
		LiniaCompra liniaCompra = new LiniaCompra();
		// indexacio...
		int producteId = indexacio.getIndexProducte();
		// int compraId = indexacio.getIndexCompra();
		int liniaId = indexacio.getIndexLiniaCompra();
		// Date dateC = new Date(System.currentTimeMillis());

		// afegir Decoracio
		decoracio.setId(producteId);
		decoracio.setMaterial(material);
		this.decoracions.add(decoracio);

		// afegir depemdencies
		//producte.setId(producteId);
		//producte.setDesignacio(nom);
		//this.productes.add(producte);
		//////////////////////
		// compra.setId(compraId);
		// compra.setDate(dateC);
		// this.compres.add(compra);
		////////////////////////
		liniaCompra.setCompraId(compra.getId());
		liniaCompra.setId(liniaId);
		liniaCompra.setProducteId(producteId);
		liniaCompra.setPreu(preu);
		this.liniesCompres.add(liniaCompra);
		// Guardar entitats
		entitatsData.saveIndexacions(indexacions);
		entitatsData.saveDecoracions(decoracions);
		// entitatsData.saveCompres(compres);
		entitatsData.saveLiniesCompres(liniesCompres);
		//entitatsData.saveProductes(productes);

	}

	// Compres Antigues.
	public String mostrarCompres() {
		String resultat = "";
		double totalCompra = 0;
		double totalCompres = 0;

		for (Compra compra : compres) {
			resultat += "--------------------------------------------\n";
			resultat += compra.getId() + compra.getDate().toString() + "\n";
			resultat += "--------------------------------------------\n";
			resultat += "\n";
			for (LiniaCompra liniaCompra : liniesCompres) {
				totalCompra = 0;
				if (liniaCompra.getCompraId() == compra.getId()) {
					resultat += "" + liniaCompra.getId() + getProducte(liniaCompra.getProducteId()).getDesignacio()
							+ liniaCompra.getPreu();
					resultat += "\n";
					totalCompra += liniaCompra.getPreu();
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

	public double getTotalCompres() {
		double totalCompres = 0;
		for (LiniaCompra liniaCompra : liniesCompres) {
			totalCompres += liniaCompra.getPreu();
		}
		return totalCompres;
	}

	public double getTotalVendes() {
		double totalVendes = 0;
		for (LiniaCompra liniaCompra : liniesCompres) {
			totalVendes += liniaCompra.getPreu();
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
		//  carregar dades
		arbres = entitatsData.getArbres();
		compres= entitatsData.getCompres();
		decoracions= entitatsData.getDecoracions();
		flors= entitatsData.getFlors();
		liniesCompres= entitatsData.getLiniesCompres();
		liniesVendes= entitatsData.getLiniesVendes();
		productes= entitatsData.getProductes();
		vendes= entitatsData.getVendes();
		System.out.println("Floristeria obert...");
		return floristeria;
	}

}