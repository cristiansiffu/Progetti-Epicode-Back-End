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

public class AddContactServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@EJB
	SessionBeanLocal ejb;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		try {
			Contact contact = new Contact();
			contact.setFirstName(request.getParameter("firstName"));
			contact.setLastName(request.getParameter("lastName"));
			contact.setEmail(request.getParameter("email"));
			List<PhoneNumber> numbers = new ArrayList<PhoneNumber>();
			PhoneNumber number1 = new PhoneNumber(request.getParameter("phoneNumber1"), contact);
			PhoneNumber number2 = new PhoneNumber(request.getParameter("phoneNumber2"), contact);
			numbers.add(number1);
			if (number2.getPhoneNumbers().replaceAll(" ", "") != "") {
				numbers.add(number2);
			}
			contact.setPhoneNumbers(numbers);
			ejb.addContact(contact);
			request.getRequestDispatcher("index.html").forward(request, response);
		} catch (Exception e) {
			pw.println("<h3>An error has occurred</h3>");
			e.printStackTrace();
		}
	}
}
