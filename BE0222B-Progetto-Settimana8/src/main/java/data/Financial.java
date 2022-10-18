package data;

public class Financial {
	private String creationDate;
	private double transaction;

	public Financial(String date, double transaction) {
		this.creationDate = date;
		this.transaction = transaction;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public double getTransaction() {
		return transaction;
	}

	public void setTransaction(double transaction) {
		this.transaction = transaction;
	}
}
