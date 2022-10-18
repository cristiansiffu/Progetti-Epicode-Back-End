package presentation;

import java.io.IOException;
import java.util.List;

import business.SessionBeanLocal;
import data.Contact;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class GetAllContacts
 */
public class GetAllContactsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SessionBeanLocal ejb;

	public GetAllContactsServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Contact> contacts = ejb.getAllContacts();
		HttpSession session = request.getSession();
		session.setAttribute("contacts", contacts);
		request.getRequestDispatcher("getAllContacts.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
