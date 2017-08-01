package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditerCollaborateurController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String matricule = req.getParameter("matricule");
		resp.setContentType("text/html");

		if (matricule != null) {
			resp.getWriter().write("<h1>Editions des collaboratuer</h1><p>Matricule : " + matricule + "</p>");
		} else {
			resp.setStatus(400);
			resp.getWriter().write("Un matricule est attendu");
		}
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<String> info = Stream.of("matricule", "titre", "nom", "prenom").filter(p -> req.getParameter(p) == null)
				.collect(Collectors.toList());
		resp.setContentType("text/html");
		resp.getWriter().write("");
		if (info.isEmpty()) {
			resp.setStatus(HttpServletResponse.SC_CREATED);
			resp.getWriter()
					.write("Création d`un collaborateur avec les informations suivantes : " + "matricule="
							+ req.getParameter("matricule") + ",titre=" + req.getParameter("titre") + ",nom="
							+ req.getParameter("nom") + ",prenom=" + req.getParameter("prenom"));

		} else {
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			resp.getWriter().write("Les paramètres suivants sont incorrects : " + String.join(", ", info));
		}
	}
}
