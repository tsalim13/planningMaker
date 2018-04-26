package Controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.EtudiantDaoImpl;
import dao.FicheDeVoeuxDaoImpl;
import dao.SujetDaoImpl;
import model.FicheDeVoeux;
import model.Sujet;

/**
 * Servlet implementation class AjouterFicheDeVoeux
 */
public class AjouterFicheDeVoeux extends HttpServlet {
	private static final long serialVersionUID = 1L;
	boolean remplie = false;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		if (session.getAttribute("idEtudiant") == null) {

			response.sendRedirect("Login");
			
		} else {
			int idEtudiant = (Integer) session.getAttribute("idEtudiant");
			FicheDeVoeuxDaoImpl ficheDao = new FicheDeVoeuxDaoImpl();

			if (ficheDao.nbrSujeuts(idEtudiant) != 5) {

				
				List<Sujet> sujets = new ArrayList<Sujet>();

				remplie = false;
				String specialite =(String) session.getAttribute("specEtudiant");
				Sujet sujet = new Sujet() ;
				sujet.setSpecialite(specialite);
				
				SujetDaoImpl sujetdao = new SujetDaoImpl();
				sujets = sujetdao.findBySpecialite(sujet);
				
				request.setAttribute("sujets", sujets);
				request.setAttribute("remplie", remplie);
				this.getServletContext().getRequestDispatcher("/fiche-de-voeux.jsp").forward(request, response);

			} else {
				FicheDeVoeuxDaoImpl fichedao = new FicheDeVoeuxDaoImpl();

				remplie = true;
				request.setAttribute("remplie", remplie);
				request.setAttribute("sujetsChoisi", fichedao.listSujets(idEtudiant));
				this.getServletContext().getRequestDispatcher("/fiche-de-voeux.jsp").forward(request, response);

			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		EtudiantDaoImpl addFiche = new EtudiantDaoImpl();
		HttpSession session = request.getSession();
		int idEtudiant = (Integer) session.getAttribute("idEtudiant");

		int idSujet1 = Integer.parseInt(request.getParameter("sujet1"));
		int idSujet2 = Integer.parseInt(request.getParameter("sujet2"));
		int idSujet3 = Integer.parseInt(request.getParameter("sujet3"));
		int idSujet4 = Integer.parseInt(request.getParameter("sujet4"));
		int idSujet5 = Integer.parseInt(request.getParameter("sujet5"));

		FicheDeVoeux fiche1 = new FicheDeVoeux(idEtudiant, idSujet1,1);
		FicheDeVoeux fiche2 = new FicheDeVoeux(idEtudiant, idSujet2,2);
		FicheDeVoeux fiche3 = new FicheDeVoeux(idEtudiant, idSujet3,3);
		FicheDeVoeux fiche4 = new FicheDeVoeux(idEtudiant, idSujet4,4);
		FicheDeVoeux fiche5 = new FicheDeVoeux(idEtudiant, idSujet5,5);

		FicheDeVoeuxDaoImpl ficheDao1 = new FicheDeVoeuxDaoImpl();
	

		ficheDao1.create(fiche1);
		ficheDao1.create(fiche2);
		ficheDao1.create(fiche3);
		ficheDao1.create(fiche4);
		ficheDao1.create(fiche5);

		addFiche.addFicheDeVoeux(idEtudiant, idEtudiant); //comme ca si id fiche de voeux seras generer avec random par ex nehtajou 2 param 									
		
		this.doGet(request, response);

	}

}
