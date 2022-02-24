package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.gunInfo;
import model.guns;
import controller.dbHelper;
import controller.dbInfoHelper;

/**
 * Servlet implementation class EditItemServlet
 */
@WebServlet("/EditItemServlet")
public class EditItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditItemServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
				dbHelper dbH = new dbHelper();
				dbInfoHelper dbIH = new dbInfoHelper();
				
				String company = request.getParameter("company");
				String type = request.getParameter("type");
				String ammo = request.getParameter("ammo");
				Integer idT = Integer.parseInt(request.getParameter("id"));
						
				guns updater = dbH.searchId(idT);
				gunInfo updateIt = dbIH.searchId(idT);
				updater.setCompany(company);
				updater.setType(type);
				updateIt.setGun(updater);
				updateIt.setAmmo(ammo);
						
				dbH.editGun(updater);
				dbIH.editInfo(updateIt);

				getServletContext().getRequestDispatcher("/ListItemsServlet").forward(request, response);
	}

	

}
