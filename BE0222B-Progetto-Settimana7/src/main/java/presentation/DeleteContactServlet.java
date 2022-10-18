package presentation;

import java.io.IOException;

import business.SessionBeanLocal;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteContactServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	SessionBeanLocal ejb;

	public DeleteContactServlet() {
		super();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ejb.deleteContact(Long.parseLong(request.getParameter("id")));
		request.getRequestDispatcher("index.html").forward(request, response);
	}

}
