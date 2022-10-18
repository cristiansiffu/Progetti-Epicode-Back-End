package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.ws.rs.core.Response;

import data.Ewallet;
import data.Financial;

public class EwalletDAOImpl implements EwalletDAO {

	private static final String TRANSACTION_HAS_OCCURRED = "Transaction has occurred";
	private static final String ACCOUNT_NOT_FOUND = "Account not found";
	private static List<Ewallet> bankAccounts = new ArrayList<Ewallet>();

	@Override
	public List<Ewallet> getAllBankAccounts() {
		return bankAccounts.stream().collect(Collectors.toList());
	}

	@Override
	public Ewallet getBankAccountByIban(String iban) {
		Ewallet ba = new Ewallet();
		for (Ewallet bankAccount : bankAccounts) {
			if (bankAccount.getIban().equals(iban)) {
				ba = bankAccount;
			}
		}
		return ba;
	}

	@Override
	public Response postBankAccount(Ewallet ba) {
		String response = "Unable to complete request";
		String date = LocalDate.now().toString();
		ba.setCreationDate(date);
		ba.setFinancials(new ArrayList<Financial>());
		bankAccounts.add(ba);
		response = "Account added";
		return Response.status(201).entity(response).build();
	}

	@Override
	public Response putBankAccount(String iban, String newHolder) {
		String response = ACCOUNT_NOT_FOUND;
		Ewallet updated = getBankAccountByIban(iban);
		if (getBankAccountByIban(iban).getIban().equals(iban)) {
			updated.getCreationDate();
			updated.getIban();
			updated.getBalance();
			updated.setHolder(newHolder);
			updated.getFinancials();
			response = "Account updated";
		}
		return Response.status(201).entity(response).build();
	}

	@Override
	public Response deleteBankAccount(String iban) {
		String response = ACCOUNT_NOT_FOUND;
		if (getBankAccountByIban(iban).getIban().equals(iban)) {
			bankAccounts.remove(getBankAccountByIban(iban));
			response = "Account deleted";
		}
		return Response.status(201).entity(response).build();
	}

	@Override
	public Response withdrawal(String iban, double t) {
		String response = "Wrong IBAN or insufficient funds";
		for (Ewallet bankAccount : bankAccounts) {
			if (bankAccount.getIban().equals(iban)) {
				if (bankAccount.getBalance() >= t) {
					String date = LocalDate.now().toString();
					bankAccount.setBalance(bankAccount.getBalance() - t);
					bankAccount.getFinancials().add(new Financial(date, -t));
					response = TRANSACTION_HAS_OCCURRED;
				}
			}
		}
		return Response.status(201).entity(response).build();
	}

	@Override
	public Response deposit(String iban, double t) {
		String response = ACCOUNT_NOT_FOUND;
		for (Ewallet bankAccount : bankAccounts) {
			if (bankAccount.getIban().equals(iban)) {
				String date = LocalDate.now().toString();
				bankAccount.setBalance(bankAccount.getBalance() + t);
				bankAccount.getFinancials().add(new Financial(date, +t));
				response = TRANSACTION_HAS_OCCURRED;
			}
		}
		return Response.status(201).entity(response).build();
	}

	@Override
	public List<Financial> getFinancials(String iban) {
		List<Financial> financials = new ArrayList<Financial>();
		financials = ((Ewallet) bankAccounts).getFinancials();
		return financials.stream().collect(Collectors.toList());
	}

}
