package nivell3.entitats;

import java.sql.Date;

public class Compra {

	private int id;
	private Date date;

	public Compra() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return id + "\t" + date;
	}
	
	public Compra fromString(String linia) {
		
		String[] campos = linia.split("\t");
		this.setId(Integer.parseInt(campos[0]));
		this.setDate(Date.valueOf(campos[1]));
		return this;		
	}

}
