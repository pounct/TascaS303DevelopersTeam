package nivell2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Date;
//import java.sql.ResultSetMetaData;
//import java.util.Date;
import java.util.List;

//import com.mysql.cj.jdbc.result.ResultSetMetaData;

import nivell2.entitats.Arbre;
import nivell2.entitats.Compra;
import nivell2.entitats.Decoracio;
import nivell2.entitats.Flor;
import nivell2.entitats.Floristeria;
import nivell2.entitats.Producte;

public class ServeisORM {

	public Connection connexio() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/floristeríadb";
			String dbuser = "root";
			String dbpw = "";
			return DriverManager.getConnection(dburl, dbuser, dbpw);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	public Floristeria getFloristeriaById(int f) {

		Connection conn = connexio();
		Floristeria floristeria = new Floristeria();
		String peticio = "SELECT * FROM floristeria WHERE nom = ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(peticio);
			ps.setInt(1, f);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				floristeria.setId(rs.getInt(1));
				floristeria.setNom(rs.getString(2));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return floristeria;
	}

	public Floristeria getFloristeriaByName(String f) {

		Connection conn = connexio();
		Floristeria floristeria = new Floristeria();
		String peticio = "SELECT * FROM floristeria WHERE nom like ?;";
		try {
			PreparedStatement ps = conn.prepareStatement(peticio);
			ps.setString(1, f);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {

				floristeria.setId(rs.getInt(1));
				floristeria.setNom(rs.getString(2));

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return floristeria;
	}

	public void addFloristeria(String f) {

		Connection conn = connexio();
		String peticio = "INSERT INTO `floristeria` (`nom`) VALUES (?);";
		try {
			PreparedStatement ps = conn.prepareStatement(peticio);
			ps.setString(1, f);
			int rs = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void addCompra(Compra c) {

		Connection conn = connexio();
		String peticio = "INSERT INTO compra (dateC) VALUES (?);DECLARE @Id INT = SCOPE_IDENTITY();";
		try {
			PreparedStatement ps = conn.prepareStatement("INSERT INTO compra (dateC) VALUES (?);",
					Statement.RETURN_GENERATED_KEYS);

			ps.setDate(1, c.getDate());
			int rs = ps.executeUpdate();

			if (rs == 0) {
				throw new SQLException("Creating compra failed, no rows affected.");
			} else {
				try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
					if (generatedKeys.next()) {
						c.setId(generatedKeys.getInt(1));
					} else {
						throw new SQLException("Creating user failed, no ID obtained.");
					}
				}

			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void addProducte(Producte p) {

		Connection conn = connexio();

		String peticioArbre = "INSERT INTO arbre (id, alcada) VALUES (?,?);";
		String peticioFlor = "INSERT INTO flor (id, color) VALUES (?,?);";
		String peticioDecoracio = "INSERT INTO decoracio (id, designacio) VALUES (?,?);";

		// String peticio = "INSERT INTO producte (designacio) VALUES (?);";

		if (p.getClass().getName().equals("nivell2.entitats.Arbre")) {

			try {
				System.out.println("Producte");
				PreparedStatement ps = conn.prepareStatement("INSERT INTO producte (designacio) VALUES (?);",
						Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, p.getDesignacio());
				int rs = ps.executeUpdate();

				if (rs == 0) {
					throw new SQLException("Creating compra failed, no rows affected.");
				} else {
					try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
						if (generatedKeys.next()) {
							p.setId(generatedKeys.getInt(1));
						} else {
							throw new SQLException("Creating user failed, no ID obtained.");
						}
					}

				}
				System.out.println("Arbre");
				PreparedStatement ps3 = conn.prepareStatement("INSERT  INTO arbre (id, alcada) VALUES (?,?);");
				ps3.setInt(1, p.getId());
				ps3.setDouble(2, ((Arbre) p).getAlcada());
				ps3.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}

		} else if (p.getClass().getName().equals("nivell2.entitats.Flor")) {
			System.out.println("Flor");
			try {
				System.out.println("Producte");
				PreparedStatement ps = conn.prepareStatement("INSERT INTO producte (designacio) VALUES (?);");
				ps.setString(1, p.getDesignacio());
				ps.executeUpdate();
				PreparedStatement ps2 = conn.prepareStatement("SELECT * FROM producte WHERE designacio like ?;");
				ps2.setString(1, p.getDesignacio());
				ResultSet rs = ps2.executeQuery();
				while (rs.next()) {
					p.setId(rs.getInt(1));
				}
				System.out.println("Flor");
				PreparedStatement ps3 = conn.prepareStatement("INSERT INTO flor (id, color) VALUES (?,?);");
				ps3.setInt(1, p.getId());
				ps3.setString(2, ((Flor) p).getColor());
				ps3.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		} else if (p.getClass().getName().equals("nivell2.entitats.Decoracio")) {
			System.out.println("Decoracio");
			try {
				System.out.println("Producte");
				PreparedStatement ps = conn.prepareStatement("INSERT INTO producte (designacio) VALUES (?);",
						Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, p.getDesignacio());
				int rs = ps.executeUpdate();

				if (rs == 0) {
					throw new SQLException("Creating compra failed, no rows affected.");
				} else {
					try (ResultSet generatedKey = ps.getGeneratedKeys()) {
						if (generatedKey.next()) {
							p.setId(generatedKey.getInt(1));
						} else {
							throw new SQLException("Creating user failed, no ID obtained.");
						}
					}

				}
				System.out.println("Decoracio");
				PreparedStatement ps3 = conn.prepareStatement("INSERT  INTO decoracio (id, material) VALUES (?,?);");
				ps3.setInt(1, p.getId());
				ps3.setString(2, ((Decoracio) p).getMaterial().toString());
				ps3.executeUpdate();
			} catch (SQLException e) {

				e.printStackTrace();
			}
		} else {
			System.out.println("Nada" + p.getClass().getName());
		}
	}

	public void addLineaCompra(Compra c, Producte p, double preu) {

		Connection conn = connexio();
		String peticio = "INSERT INTO liniacompra (preu,floresteriaId,producteId, compraId) VALUES (?,1,?,?);";
		try {
			PreparedStatement ps = conn.prepareStatement(peticio);
			ps.setDouble(1, preu);
			ps.setInt(2, p.getId());
			ps.setInt(3, c.getId());
			int rs = ps.executeUpdate();

		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public List<Producte> findByDesignacio(String paraula) {

		List<Producte> productes = new ArrayList<Producte>();
		try {

			// Connexió a MySQL mitjançant la interfície JDBC DriverManager
			// el nom d'aquesta classe és com.mysql.cj.jdbc.Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			String dburl = "jdbc:mysql://localhost:3306/dbfloristeria";
			String dbuser = "root";
			String dbpw = "";
			Connection connexio = DriverManager.getConnection(dburl, dbuser, dbpw);

			String consulta = "SELECT * FROM productes WHERE designacio like ?";
			PreparedStatement ps = connexio.prepareStatement(consulta);
			ps.setString(1, paraula);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Producte p = new Arbre();
				/*
				 * navegar pel resultat "rs" p.setId p.setDesi p.setPreu p.setPreuC
				 */
				// afegir p a productes
				productes.add(p);
			}

		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

		return productes;

	}

	/*
	 * public Compra(Date date, List<Producte> productes) {
	 * 
	 * this.date = date; this.productes = productes; }
	 */

}

/*
 * //private List<Producte> productes=new ArrayList<Producte>();
 * 
 * private List<Arbre> arbres = new ArrayList<Arbre>();
 * 
 * private List<Flor> flors = new ArrayList<Flor>();
 * 
 * private List<Decoracio> decoracio = new ArrayList<Decoracio>();
 * 
 * public Stock() {
 * 
 * }
 * 
 * public Stock(List<Arbre> arbres, List<Flor> flors, List<Decoracio> decoracio)
 * {
 * 
 * this.arbres = arbres; this.flors = flors; this.decoracio = decoracio; }
 * 
 * public List<Arbre> getArbres() { return arbres; }
 * 
 * public void setArbres(List<Arbre> arbres) { this.arbres = arbres; }
 * 
 * public List<Flor> getFlors() { return flors; }
 * 
 * public void setFlors(List<Flor> flors) { this.flors = flors; }
 * 
 * public List<Decoracio> getDecoracio() { return decoracio; }
 * 
 * public void setDecoracio(List<Decoracio> decoracio) { this.decoracio =
 * decoracio; }
 * 
 * 
 * public List<Producte> getProductes() { List<Producte> productes=new
 * ArrayList<Producte>(); productes.addAll(arbres); productes.addAll(flors);
 * productes.addAll(decoracio); return productes; }
 */
