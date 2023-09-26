package nivell1.presentacio;

public interface Menus {
	
	public static void menuInitial() {
		System.out.println("-----------------\n");
		System.out.println(" 1.Crear Floristeria."); // obrir floristeria
		System.out.println(" 14.Obrir Floristeria.");
		System.out.println(" 0.fin");		
	}
	public static void menuPrincipal() {
		//System.out.println(" Floristeria actiu : " + ((floristeria != null) ? floristeria.getNom() : ""));
		System.out.println("-----------------\n");
		System.out.println(" 1.Crear Floristeria."); // obrir floristeria
		System.out.println(" 14.Obrir Floristeria.");
		System.out.println(" 2.Afegir Arbre.");
		System.out.println(" 3.Afegir Flor.");
		System.out.println(" 4.Afegir Decoració.");
		System.out.println(" 5.Stock");
		System.out.println(" 6.Retirar arbre.");
		System.out.println(" 7.Retirar flor.");
		System.out.println(" 8.Retirar decoració.");
		System.out.println(" 9.Stock Amb Quantitats");
		System.out.println(" 10.Valor Stock");
		System.out.println(" 11.Compra amb múltiples objectes");
		System.out.println(" 12.Compres Antigues.");
		System.out.println(" 13.diners guanyats");
		System.out.println(" 0.fin");
	}
	/*public static String menuCrearFloristeria(Scanner sc) {
		System.out.println("Crear Floristeria.\n");
		System.out.println("nom : ");
		String nom = sc.nextLine();
		return nom;
	}*/

}
