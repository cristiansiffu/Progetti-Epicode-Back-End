package presentation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import business.SessionBeanLocal;
import data.Contact;
import data.PhoneNumber;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UpdateContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	SessionBeanLocal ejb;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		try {
			Contact contact = ejb.getById(Long.parseLong(request.getParameter("id")));
			if (contact != null) {
				if (request.getParameter("firstName").replaceAll(" ", "") != "") {
					contact.setFirstName(request.getParameter("firstName"));
				}
				if (request.getParameter("lastName").replaceAll(" ", "") != "") {
					contact.setLastName(request.getParameter("lastName"));
				}
				if (request.getParameter("email").replaceAll(" ", "") != "") {
					contact.setEmail(request.getParameter("email"));
				}
				List<PhoneNumber> numbers = contact.getPhoneNumbers();
				if (request.getParameter("phoneNumber1").replaceAll(" ", "") != "") {
					if (numbers.size() > 0) {
						numbers.get(0).setPhoneNumbers(request.getParameter("phoneNumber1"));
					}
				}
				if (request.getParameter("phoneNumber2").replaceAll(" ", "") != "") {
					if (numbers.size() > 1) {
						numbers.get(1).setPhoneNumbers(request.getParameter("phoneNumber2"));
					} else if (numbers.size() == 1) {
						numbers.add(new PhoneNumber(request.getParameter("phoneNumber2"), contact));
					}
				}
				contact.setPhoneNumbers(numbers);
				ejb.updateContact(contact);
				request.getRequestDispatcher("index.html").forward(request, response);
			} else {
				pw.println("<h3>Account not found</h3>");
			}
		} catch (Exception e) {
			pw.println("<h3>An error has occurred</h3>");
			e.printStackTrace();
		}
	}

}
