package com;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import dao.EwalletDAOImpl;
import data.Ewallet;
import data.Financial;

@Path("/ewallet")
public class EwalletRest {

	private EwalletDAOImpl dao;

	public EwalletRest() {
		dao = new EwalletDAOImpl();
	}

	@GET
	@Path("/get")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Ewallet> getAllBankAccounts() {
		return dao.getAllBankAccounts();
	}

	@GET
	@Path("/iban")
	@Produces(MediaType.APPLICATION_JSON)
	public Ewallet getBankAccountByIban(@QueryParam("iban") String iban) {
		return dao.getBankAccountByIban(iban);

	}

	@POST
	@Path("/post")
	@Produces(MediaType.APPLICATION_JSON)
	public Response postBankAccount(Ewallet bAccount) {
		return dao.postBankAccount(bAccount);
	}

	@PUT
	@Path("/put")
	@Produces(MediaType.APPLICATION_JSON)
	public Response putBankAccount(@QueryParam("iban") String iban, @QueryParam("name") String newHolder) {
		return dao.putBankAccount(iban, newHolder);
	}

	@DELETE
	@Path("/delete")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteBankAccountByIban(@QueryParam("iban") String iban) {
		return dao.deleteBankAccount(iban);
	}

	@PUT
	@Path("/withdrawal")
	@Produces(MediaType.APPLICATION_JSON)
	public Response withdrawal(@QueryParam("iban") String iban, @QueryParam("value") double t) {
		return dao.withdrawal(iban, t);
	}

	@PUT
	@Path("/deposit")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deposit(@QueryParam("iban") String iban, @QueryParam("value") double t) {
		return dao.deposit(iban, t);
	}

	@GET
	@Path("/financials")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Financial> getFinancials(@QueryParam("iban") String iban) {
		return dao.getBankAccountByIban(iban).getFinancials();
	}

}
