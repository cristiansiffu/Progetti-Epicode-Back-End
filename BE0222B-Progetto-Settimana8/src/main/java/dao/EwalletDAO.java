package dao;

import java.util.List;

import javax.ws.rs.core.Response;

import data.Ewallet;
import data.Financial;

public interface EwalletDAO {
	
	public List<Ewallet> getAllBankAccounts();
	
	public Ewallet getBankAccountByIban(String iban);

	public Response postBankAccount(Ewallet ba);

	public Response putBankAccount(String iban, String newHolder);
	
	public Response deleteBankAccount(String iban);

	public Response withdrawal(String iban, double t);

	public Response deposit(String iban, double t);

	public List<Financial> getFinancials(String iban);
}
