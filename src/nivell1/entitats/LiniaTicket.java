package nivell1.entitats;

public class LiniaTicket {

	private int id;
	private int ticketId;
	private int producteId;
	

	public LiniaTicket() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getTicketId() {
		return ticketId;
	}

	public void setTicketId(int vendaId) {
		this.ticketId = vendaId;
	}

	public int getProducteId() {
		return producteId;
	}

	public void setProducteId(int producteId) {
		this.producteId = producteId;
	}

	@Override
	public String toString() {
		return id + "\t" + ticketId + "\t" + producteId;
	}

	public LiniaTicket fromString(String linia) {
		String[] campos = linia.split("\t");
		this.setId(Integer.parseInt(campos[0]));
		this.setTicketId(Integer.parseInt(campos[1]));
		this.setProducteId(Integer.parseInt(campos[2]));
		return this;
		
	}
}
