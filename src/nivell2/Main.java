package nivell2;

import nivell2.entitats.Floristeria;
import nivell2.entitats.Arbre;

import java.sql.Date;

import nivell2.entitats.Compra;
import nivell2.entitats.Decoracio;
import nivell2.entitats.Decoracio.Material;
import nivell2.entitats.Flor;
import nivell2.entitats.Producte;

public class Main {

	public static void main(String[] args) {
		
		ServeisORM sorm= new ServeisORM();

		// Crear Floristeria.	
		Floristeria floristeria = new Floristeria();
		
		// Crear Floristeria en la base de datos.
		//sorm.addFloristeria("floristeria 1");
		
		floristeria = sorm.getFloristeriaById(1);
		System.out.println(floristeria.getId()+"  "+floristeria.getNom());
		floristeria = sorm.getFloristeriaByName("floristeria 1");
		System.out.println(floristeria.getId()+"  "+floristeria.getNom());
		
		// Afegir Arbre.
		// Afegir Flor.
		// Afegir Decoració.
		// les entrades provenen de les compres
		Compra compra1= new Compra();
		compra1.setDate(Date.valueOf("2022-10-24"));
		
		// Crear compra1 en la base de datos.
		sorm.addCompra(compra1);
		
		// Afegir Arbre.
		// afegir una línia de compra Arbre 
		Arbre pArbre1=new Arbre();
		pArbre1.setDesignacio("prod Arbre3");
		pArbre1.setAlcada(90);		
		// Crear pArbre1 en la base de datos.
		sorm.addProducte(pArbre1);		
		// Crear una lineaCompra de compra1  en la base de datos.		
		// addLineaCompra(Compra c,Producte p,double preu)
		sorm.addLineaCompra(compra1,pArbre1,21);
		
		// Afegir Flor.
		// afegir una línia de compra Flor
		Flor pFlor1=new Flor();
		pFlor1.setColor("rojo");
		pFlor1.setDesignacio("prodFlor3");
		// Crear pFlor1 en la base de datos.
		sorm.addProducte(pFlor1);
		sorm.addLineaCompra(compra1,pFlor1,12);
		
		// Afegir Decoració.
		// afegir una línia de compra Decoració
		Decoracio pDecoracio1 = new Decoracio();
		pDecoracio1.setDesignacio("prodDecoracio3");
		pDecoracio1.setMaterial(Material.PLASTIC);
		sorm.addProducte(pDecoracio1);
		// Crear una lineaCompra de compra1  en la base de datos.
		sorm.addLineaCompra(compra1,pDecoracio1,28);
		
		//Stock: Imprimeix per pantalla tots els arbres, flors i decoració que té la floristeria.
		

	}

}
