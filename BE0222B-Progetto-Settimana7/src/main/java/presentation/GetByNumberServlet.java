package presentation;

import java.io.IOException;
import java.util.List;

import business.SessionBeanLocal;
import data.Contact;
import data.PhoneNumber;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class GetByNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SessionBeanLocal ejb;

	public GetByNumberServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Contact> numbers = (List<Contact>) ejb.getContactByNumber(request.getParameter("phoneNumber"));
		HttpSession session = request.getSession();
		session.setAttribute("contacts", numbers);
		request.getRequestDispatcher("getAllContacts.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}