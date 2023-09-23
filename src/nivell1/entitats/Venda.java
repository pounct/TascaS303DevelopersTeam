package nivell1.entitats;

import java.sql.Date;

public class Venda {

	private int id;
	private Date date;

	public Venda() {
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

	public Venda fromString(String linia) {
		
		String[] campos = linia.split("\t");
		this.setId(Integer.parseInt(campos[0]));
		this.setDate(Date.valueOf(campos[1]));
		
		return this;
	}
}
