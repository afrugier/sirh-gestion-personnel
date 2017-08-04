package dev.sgp.listener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;

@WebListener
public class JeuEssaiListener implements ServletContextListener {



	@Inject
	private CollaborateurService collabService;
	@Inject
	private DepartementService departService;

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		departService.sauvegarderDepartement(new Departement("Comptabilité"));
		departService.sauvegarderDepartement(new Departement("Ressources Humaines"));
		departService.sauvegarderDepartement(new Departement("Informatique"));
		departService.sauvegarderDepartement(new Departement("Administratif"));

		List<Departement> listeDepartement = new ArrayList<>();
		listeDepartement.addAll(departService.listerDepartements());

		collabService.sauvegarderCollaborateur(new Collaborateur(null, "frugier", "anthony", LocalDate.of(1993, 2, 4),
				"38 rue de paris 45500 Vitré", "123456789123456", null, false, "a1", listeDepartement.get(2),
				"caisse d'epargne", "0123", "FR74"));

		collabService
				.sauvegarderCollaborateur(new Collaborateur(null, "martin", "pierre-antoine", LocalDate.of(1993, 8, 26),
						"38 rue de paris 36251 saint-herblain", "789456123789456", null, false, "a2",
						listeDepartement.get(1), "caisse d'epargne", "0123", "FR74"));

		collabService.sauvegarderCollaborateur(new Collaborateur(null, "debuisson", "eddy", LocalDate.of(1993, 5, 15),
				"38 rue de paris 59800 rennes", "789123456789132", null, false, "b1", listeDepartement.get(0),
				"caisse d'epargne", "0123", "FR74"));

		collabService.sauvegarderCollaborateur(new Collaborateur(null, "kuntz", "thomas", LocalDate.of(1975, 12, 24),
				"38 rue de paris 49000 angers", "159632478951236", null, false, "b2", listeDepartement.get(3),
				"caisse d'epargne", "0123", "FR74"));

		collabService.sauvegarderCollaborateur(new Collaborateur(null, "brocart", "alexandre",
				LocalDate.of(1990, 12, 4), "38 rue de paris 13000 marseille", "789512368745213", null, false, "c1",
				listeDepartement.get(1), "caisse d'epargne", "0123", "FR74"));

		collabService.sauvegarderCollaborateur(new Collaborateur(null, "samson", "jerome", LocalDate.of(1993, 9, 4),
				"38 rue de paris 12000 po", "123546987654654", null, false, "c2", listeDepartement.get(0),
				"caisse d'epargne", "0123", "FR74"));

		collabService.sauvegarderCollaborateur(new Collaborateur(null, "aymerich", "paula", LocalDate.of(1990, 8, 04),
				"38 rue de paris 85000 strasbourg", "798897546654321", null, false, "d1", listeDepartement.get(2),
				"caisse d'epargne", "0123", "FR74"));

		collabService.sauvegarderCollaborateur(new Collaborateur(null, "bourreau", "etienne", LocalDate.of(1995, 1, 8),
				"38 rue de paris 38000 toulon", "519519357357546", null, false, "d2", listeDepartement.get(3),
				"caisse d'epargne", "0123", "FR74"));

		collabService.sauvegarderCollaborateur(new Collaborateur(null, "guironnet", "damien", LocalDate.of(1995, 3, 16),
				"38 rue de paris 38500 hyere", "478896236412555", null, false, "e1", listeDepartement.get(0),
				"caisse d'epargne", "0123", "FR74"));

		collabService.sauvegarderCollaborateur(new Collaborateur(null, "lam", "tan", LocalDate.of(1993, 02, 04),
				"38 rue de paris 71000 paris", "147852369789632", null, false, "e2", listeDepartement.get(2),
				"caisse d'epargne", "0123", "FR74"));

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
