package dev.sgp.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.Statistique;
import dev.sgp.entite.VisiteWeb;
import dev.sgp.service.VisiteWebServices;

@WebServlet("/collaborateurs/stat")
public class StatistiqueController extends HttpServlet {

	private static final long serialVersionUID = 2374135230483662627L;
	@Inject
	private VisiteWebServices vws;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<VisiteWeb> visites = VisiteWebServices.listerVisites();
		Map<String, List<VisiteWeb>> map = visites.stream().collect(Collectors.groupingBy(VisiteWeb::getChemin));

		List<Statistique> listStat = map.keySet().stream().map(chemin -> {
			Statistique stat = new Statistique();
			stat.setChemin(chemin);
			stat.setNbVisites(vws.nbVisite(chemin));
			stat.setTempsMin(vws.trouverMin(chemin));
			stat.setTempsMax(vws.trouverMax(chemin));
			stat.setTempsMoy(vws.trouverMoy(chemin));
			return stat;
		}).collect(Collectors.toList());

		req.setAttribute("listeVisites", listStat);
		req.getRequestDispatcher("/WEB-INF/views/collab/statistiques.jsp").forward(req, resp);
	}
}
