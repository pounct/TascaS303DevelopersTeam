package nivell1.persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ServeisDataBase {

	// creacio de directori
	// nomDirectori de la base de dades = nomFloristeria + "db"
	public static void crearDirectori(String path) {

		// Crear una instancia de la classe File
		File f1 = new File(path);
		// Creació de carpeta amb el mètode mkdir().
		boolean bool = f1.mkdirs();
		if (bool) {
			System.out.println("La carpeta s'ha creat correctament");
		} else {
			System.out.println("S'ha trobat un error de creació de carpetes!");
		}
	}

	// lectura de fitxer
	public static ArrayList<String> readLinies(String fitxer) {

		ArrayList<String> linies = new ArrayList<>();

		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(fitxer));
			try {
				String linia;
				while ((linia = reader.readLine()) != null) {
					linies.add(linia);
				}
			} catch (IOException e) {
				System.out.println("error en la lectura de fitxer");
				// e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			System.out.println("Fitxer no trobat excepció");
			// e.printStackTrace();
		}
		return linies;
	}

	// escriptura del fitxer
	public static void writeLinies(ArrayList<String> Linies, String fitxer) {

		BufferedWriter writer;
		try {
			writer = new BufferedWriter(new FileWriter(fitxer));
			Linies.forEach(Linia -> {
				try {
					writer.write(Linia + "\n");
				} catch (IOException e) {
					System.out.println("error d'escriptura del fitxer");
					// e.printStackTrace();
				}
			});
			;
			writer.close();
		} catch (IOException e) {
			System.out.println("error d'escriptura del fitxer");
			// e.printStackTrace();
		}
	}
}
