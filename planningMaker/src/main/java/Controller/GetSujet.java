package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.SujetDaoImpl;
import model.Sujet;

/**
 * Servlet implementation class GetSujet
 */
public class GetSujet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*String specialite= "informatique";
		Sujet sujet = new Sujet() ;
		sujet.setSpecialite(specialite);
		
		SujetDaoImpl sujetdao = new SujetDaoImpl();
		List<Sujet> sujets = sujetdao.findBySpecialite(sujet);
		request.setAttribute("sujets", sujets);*/
		
		this.getServletContext().getRequestDispatcher("/sujetDesSpecialite.jsp").forward(request, response);
	}
     
	public static int c;
	public static List<Sujet> sujets = new ArrayList<Sujet>();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String specialite = request.getParameter("spec");
		System.out.println(specialite);
		Sujet sujet = new Sujet() ;
		sujet.setSpecialite(specialite);
		c = 1;
		SujetDaoImpl sujetdao = new SujetDaoImpl();
		sujets = sujetdao.findBySpecialite(sujet);
		request.setAttribute("sujets", sujets);
		request.setAttribute("c", c);
		c++;
		this.getServletContext().getRequestDispatcher("/sujetDesSpecialite.jsp").forward(request, response);

	}

}
