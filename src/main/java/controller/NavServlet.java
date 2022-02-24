package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.guns;
import model.gunInfo;
import controller.dbHelper;
import controller.dbInfoHelper;

/**
 * Servlet implementation class NavServlet
 */
@WebServlet("/NavServlet")
public class NavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NavServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		dbHelper dbH = new dbHelper();
		dbInfoHelper dbIH = new dbInfoHelper();
		String control = request.getParameter("eItem");

		String path = "/ListItemsServlet";

		if (control.equals("delete")) {
			try {
				
				Integer idT = Integer.parseInt(request.getParameter("id"));
				guns delItem = dbH.searchId(idT);
				gunInfo delInfo = dbIH.searchId(idT);
				dbIH.deleteInfo(delInfo);
				dbH.deleteGun(delItem);

			} catch (NumberFormatException ex) {
				System.out.println("Didn't select an item");
			}

		} else if (control.equals("edit")) {
			try {
				
				Integer idT = Integer.parseInt(request.getParameter("id"));
				gunInfo delItem = dbIH.searchId(idT);
				request.setAttribute("editIt", delItem);
				path = "/edit.jsp";
			} catch (NumberFormatException ex) {
				System.out.println("Didn't select an item");
			}

		} 

		getServletContext().getRequestDispatcher(path).forward(request, response);
	}

}
