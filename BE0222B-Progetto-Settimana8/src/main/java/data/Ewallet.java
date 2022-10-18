package data;

import java.util.List;
import java.util.Objects;

public class Ewallet {

	private String creationDate;
	private String iban;
	private double balance;
	private String holder;
	private List<Financial> financials;

	public Ewallet(String creationDate, String iban, double balance, String holder, List<Financial> financials) {
		super();
		this.creationDate = creationDate;
		this.iban = iban;
		this.balance = balance;
		this.holder = holder;
		this.financials = financials;
	}

	public Ewallet() {
		super();
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public List<Financial> getFinancials() {
		return financials;
	}

	public void setFinancials(List<Financial> financials) {
		this.financials = financials;
	}

	@Override
	public int hashCode() {
		return Objects.hash(balance, creationDate, financials, holder, iban);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Ewallet other = (Ewallet) obj;
		return Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Objects.equals(creationDate, other.creationDate) && Objects.equals(financials, other.financials)
				&& Objects.equals(holder, other.holder) && Objects.equals(iban, other.iban);
	}

}
