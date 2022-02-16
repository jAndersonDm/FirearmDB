package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.PrintWriter;
import model.guns;
import controller.dbHelper;

/**
 * Servlet implementation class AddItemServlet
 */
@WebServlet("/AddItemServlet")
public class AddItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String company = request.getParameter("company");
		String type = request.getParameter("type");
		if (company.isEmpty() || type.isEmpty() || company == null || type == null) {
			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		} else {
			guns gun = new guns(company, type);
			dbHelper dbH = new dbHelper();
			dbH.enterGun(gun);

			getServletContext().getRequestDispatcher("/index.html").forward(request, response);
		}
		
	}

	
}
