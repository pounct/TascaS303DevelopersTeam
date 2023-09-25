package nivell1.entitats;

public class Ticket {
	
	private int id;
	

	public Ticket() {
	}
	
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return id+"";
	}

	public Ticket fromString(String linia) {
		
		String[] campos = linia.split("\t");
		this.setId(Integer.parseInt(campos[0]));
		
		return this;
	}

}
