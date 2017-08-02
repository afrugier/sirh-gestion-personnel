package dev.sgp.web;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

@WebServlet("/collaborateurs/creer")
public class CreerCollaborateurController extends HttpServlet {

	private static final long serialVersionUID = 1671387109034477762L;

	private static final CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/collab/creerCollaborateur.jsp").forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/uuuu");

		collabService.sauvegarderCollaborateur(new Collaborateur(req.getParameter("nom"), req.getParameter("prenom"),
				LocalDate.parse(req.getParameter("dateNaissance"), formatter), req.getParameter("adresse"),
				req.getParameter("NumSecu")));

		resp.sendRedirect("/sgp/collaborateurs/lister");
	}
}
