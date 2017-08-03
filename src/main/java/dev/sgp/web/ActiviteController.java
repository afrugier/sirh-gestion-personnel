package dev.sgp.web;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dev.sgp.entite.CollabEvt;
import dev.sgp.service.ActiviteService;

@WebServlet("/collaborateurs/act")
public class ActiviteController extends HttpServlet {

	private static final long serialVersionUID = 2374135230483662627L;
	@Inject
	private ActiviteService act;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CollabEvt> listeAct = act.listerActivitesCollab();

		req.setAttribute("listeActivite", listeAct);
		req.getRequestDispatcher("/WEB-INF/views/collab/activite.jsp").forward(req, resp);
	}
}
