package nivell1;

import java.util.Scanner;

import nivell1.entitats.Decoracio.Material;
import nivell1.funcionalitats.FloristeriaGestio;
import nivell1.funcionalitats.Stock;
import nivell1.presentacio.Menus;
import nivell1.entitats.Floristeria;
import nivell1.entitats.Indexacio;
import nivell1.entitats.Ticket;

public class Main {
	/*
	 * Amb gestió de percistància en un fitxer TXT.
	 */
	static Floristeria floristeria;
	static Indexacio indexacio;

	static FloristeriaGestio floristeriaGestio;

	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		floristeriaGestio = new FloristeriaGestio();

		boolean onProgram = true;

		Byte opcion;

		while (onProgram) {

			System.out.println(" Floristeria actiu : " + ((floristeria != null) ? floristeria.getNom() : "cap"));

			Menus.menuPrincipal();
			opcion = sc.nextByte();
			sc.nextLine();
			switch (opcion) {
			case 1:
				// 1.Crear Floristeria.
				crearFloristeria();
				break;
			case 2:
				// 2.Afegir Arbre.
				if (indexacio != null) {
					afegirArbre();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}
				break;
			case 3:
				// 3.Afegir Flor.
				if (indexacio != null) {
					afegirFlor();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}
				break;
			case 4:
				// 4.Afegir Decoració.
				if (indexacio != null) {
					afegirDecoracio();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}
				break;
			case 5:
				// Stock: Imprimeix per pantalla tots els arbres, flors i decoració
				// que té la floristeria.
				// 5.Stock
				if (indexacio != null) {
					imprimirStock();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}
				break;
			case 6:
				// 6.Retirar arbre.
				if (indexacio != null) {
					retirarArbre();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}
				break;
			case 7:
				// 7.Retirar flor.
				if (indexacio != null) {
					retirarFlor();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}
				break;
			case 8:
				// 8.Retirar decoració.
				if (indexacio != null) {
					retirarDecoracio();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}
				break;
			case 9:
				// Printar per pantalla stock amb quantitats.
				// 9.Stock Amb Quantitats
				if (indexacio != null) {
					imprimirStockQuantitats();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}
				break;
			case 10:
				// Printar per pantalla valor total de la floristeria.
				// 10.Valor Stock // Valor Compres // ValorVendes
				if (indexacio != null) {
					imprimirValorStock();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}
				break;
			case 11:
				// Crear tickets de compra amb múltiples objectes.
				// 11.Compra amb múltiples objectes
				if (indexacio != null) {
					crearTicket();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}
				break;
			case 12:
				// Mostrar una llista de compres antigues.
				// 12.Compres Antigues.
				if (indexacio != null) {
					mostrarTickets();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}
				break;
			case 13:
				// Visualitzar el total de diners guanyats amb totes les vendes.*/
				// 13.diners guanyats
				// Vendes
				if (indexacio != null) {
					visualitzarTotalGuanyats();
				} else {
					System.out.println(" no hi ha floristeria!!!");
				}
				break;
			case 14:
				// 14.Obrir Floristeria.
				obrirFloristeria();
				break;
			case 0:
				onProgram = false;
				System.out.println("      Fin de programe.");
				break;

			default:
				break;
			}
		}
	}

	public static void crearFloristeria() {

		System.out.println("Crear Floristeria.\n");
		System.out.println("nom : ");
		String nom = sc.nextLine();
		// Crear i recuperar Floristeria
		floristeria = floristeriaGestio.crearFloristeria(nom);
		indexacio = floristeriaGestio.getIndexacio();
	}

	public static void afegirArbre() {

		System.out.println("preu : ");
		double preu = sc.nextDouble();
		sc.nextLine();
		System.out.println("alcada del arbre : ");
		float alcada = sc.nextFloat();
		sc.nextLine();
		floristeriaGestio.afegirArbre(preu, alcada);
	}

	public static void afegirFlor() {

		System.out.println("preu de compra : ");
		double preu = sc.nextDouble();
		sc.nextLine();
		System.out.println("color del flor : ");
		String color = sc.nextLine();
		floristeriaGestio.afegirFlor(preu, color);
	}

	public static void afegirDecoracio() {

		System.out.println("preu de compra : ");
		double preu = sc.nextDouble();
		sc.nextLine();
		System.out.println("material del arbre : \n" + "1.Plastic" + "2.Fusta\n");
		byte tipoMaterial = sc.nextByte();
		Material material = (tipoMaterial == 1) ? Material.FUSTA : Material.PLASTIC;
		sc.nextLine();
		floristeriaGestio.afegirDecoracio(preu, material);
	}

	public static void imprimirStock() {

		// Stock stock = floristeriaGestio.getstock();
		System.out.println(" Stock Floristeria :");
		System.out.println(" Productes:\n");
		System.out.println("---- Arbres ----------");
		System.out.println(floristeriaGestio.getArbres());
		System.out.println("---- Flors -----------");
		System.out.println(floristeriaGestio.getFlors());
		System.out.println("---- Decoracions -----");
		System.out.println(floristeriaGestio.getDecoracions());
	}

	public static void retirarArbre() {

		System.out.println("id del arbre a retirar :");
		int producteId = sc.nextInt();
		floristeriaGestio.retirarArbre(producteId);

	}

	public static void retirarFlor() {

		System.out.println("id del flor a retirar :");
		int producteId = sc.nextInt();
		floristeriaGestio.retirarFlor(producteId);

	}

	public static void retirarDecoracio() {

		System.out.println("id del decoracio a retirar :");
		int producteId = sc.nextInt();
		floristeriaGestio.retirarDecoracio(producteId);

	}

	public static void imprimirStockQuantitats() {
		Stock stock = floristeriaGestio.getstock();
		System.out.println(" Stock Floristeria Quantitats:");
		System.out.println(" Productes:\n");
		System.out.println("---- Arbres ----------");
		System.out.println(stock.getArbres().size());
		System.out.println("---- Flors -----------");
		System.out.println(stock.getFlors().size());
		System.out.println("---- Decoracions -----");
		System.out.println(stock.getDecoracions().size());
	}

	public static void imprimirValorStock() {
		// Stock stock = floristeriaGestion.getstock();
		System.out.println(" Stock Floristeria Valor :");
		System.out.println(" Productes:\n");
		System.out.println("---- Valor Arbres ----------");
		System.out.println(floristeriaGestio.getValorStockArbres());
		System.out.println("---- Valor Flors -----------");
		System.out.println(floristeriaGestio.getValorStockFlors());
		System.out.println("---- Valor Decoracions -----");
		System.out.println(floristeriaGestio.getValorStockDecoracions());
	}

	public static void crearTicket() {

		Ticket ticket = floristeriaGestio.crearTicket();
		boolean finCompra = false;
		Byte opcion;
		while (!finCompra) {
			menuTicket();
			opcion = sc.nextByte();
			sc.nextLine();
			switch (opcion) {
			case 1:
				afegirArbre(ticket);
				break;
			case 2:
				afegirFlor(ticket);
				break;
			case 3:
				afegirDecoracio(ticket);
				break;
			case 0:
				finCompra = true;
				System.out.println("--------- Fin de ticket ---------");
				break;
			default:
				break;
			}
		}

	}

	public static void menuTicket() {
		System.out.println(" Menu Ticket :\n");
		System.out.println(" 1.Afegir Arbre.");
		System.out.println(" 2.Afegir Flor.");
		System.out.println(" 3.Afegir Decoració.");
		System.out.println(" 0.fin Ticket");
	}

	public static void mostrarTickets() {
		System.out.println(" Tickets :\n");
		System.out.println(floristeriaGestio.mostrarTickets());
	}

	public static void visualitzarTotalGuanyats() {
		System.out.println(" Total Guanyats \n");
		System.out.println("" + floristeriaGestio.getTotalTickets());
	}

	public static void afegirArbre(Ticket ticket) {

		System.out.println("preu : ");
		double preu = sc.nextDouble();
		sc.nextLine();
		System.out.println("alcada del arbre : ");
		float alcada = sc.nextFloat();
		sc.nextLine();
		floristeriaGestio.afegirArbre(preu, alcada, ticket);

	}

	public static void afegirFlor(Ticket ticket) {
		System.out.println("preu : ");
		double preu = sc.nextDouble();
		sc.nextLine();
		System.out.println("color del flor : ");
		String color = sc.nextLine();
		sc.nextLine();
		floristeriaGestio.afegirFlor(preu, color, ticket);

	}

	public static void afegirDecoracio(Ticket ticket) {

		System.out.println("preu : ");
		double preu = sc.nextDouble();
		sc.nextLine();
		System.out.println("material del arbre : \n" + "1.Plastic" + "2.Fusta\n");
		byte tipoMaterial = sc.nextByte();
		Material material = (tipoMaterial == 1) ? Material.FUSTA : Material.PLASTIC;
		sc.nextLine();
		floristeriaGestio.afegirDecoracio(preu, material, ticket);

	}

	//////////////////////////////////////////////////////

	public static void obrirFloristeria() {
		System.out.println("id Floristeria : ");
		int floristeriaId = sc.nextInt();
		sc.nextLine();
		floristeria = floristeriaGestio.getFloristeria(floristeriaId);
		System.out.println(floristeria);
		if (floristeria != null) {
			floristeria = floristeriaGestio.obrirFloristeria(floristeria);
			indexacio = floristeriaGestio.getIndexacio();
		} else {
			System.out.println(" no hi ha cap florista amb aquest identificador!!!");
		}

	}
}
