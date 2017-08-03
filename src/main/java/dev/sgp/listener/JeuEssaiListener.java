package dev.sgp.listener;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.Departement;
import dev.sgp.service.CollaborateurService;
import dev.sgp.service.DepartementService;
import dev.sgp.util.Constantes;

@WebListener
public class JeuEssaiListener implements ServletContextListener {

	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;
	private DepartementService departService = Constantes.DEPARTEMENT_SERVICES;

	@Override
	public void contextInitialized(ServletContextEvent sce) {

		departService.sauvegarderDepartement(new Departement(1, "Comptabilité"));
		departService.sauvegarderDepartement(new Departement(2, "Ressources Humaines"));
		departService.sauvegarderDepartement(new Departement(3, "Informatique"));
		departService.sauvegarderDepartement(new Departement(4, "Administratif"));

		List<Departement> listeDepartement = new ArrayList<>();
		listeDepartement.addAll(departService.listerDepartements());


		collabService.sauvegarderCollaborateur(new Collaborateur("frugier", "anthony", LocalDate.of(1993, 2, 4),
				"38 rue de paris 45500 Vitré", "123456789123456", "a1", listeDepartement.get(2)));

		collabService.sauvegarderCollaborateur(new Collaborateur("martin", "pierre-antoine", LocalDate.of(1993, 8, 26),
				"38 rue de paris 36251 saint-herblain", "789456123789456", "a2",
				listeDepartement.get(1)));

		collabService.sauvegarderCollaborateur(new Collaborateur("debuisson", "eddy", LocalDate.of(1993, 5, 15),
				"38 rue de paris 59800 rennes", "789123456789132", "b1", listeDepartement.get(2)));

		collabService.sauvegarderCollaborateur(new Collaborateur("kuntz", "thomas", LocalDate.of(1975, 12, 24),
				"38 rue de paris 49000 angers", "159632478951236", "b2", listeDepartement.get(3)));

		collabService.sauvegarderCollaborateur(new Collaborateur("brocart", "alexandre", LocalDate.of(1990, 12, 4),
				"38 rue de paris 13000 marseille", "789512368745213", "c1", listeDepartement.get(1)));

		collabService.sauvegarderCollaborateur(new Collaborateur("samson", "jerome", LocalDate.of(1993, 9, 4),
				"38 rue de paris 12000 po", "123546987654654", "c2", listeDepartement.get(1)));

		collabService.sauvegarderCollaborateur(new Collaborateur("aymerich", "paula", LocalDate.of(1990, 8, 04),
				"38 rue de paris 85000 strasbourg", "798897546654321", "d1", listeDepartement.get(2)));

		collabService.sauvegarderCollaborateur(new Collaborateur("bourreau", "etienne", LocalDate.of(1995, 1, 8),
				"38 rue de paris 38000 toulon", "519519357357546", "d2", listeDepartement.get(3)));

		collabService.sauvegarderCollaborateur(new Collaborateur("guironnet", "damien", LocalDate.of(1995, 3, 16),
				"38 rue de paris 38500 hyere", "478896236412555", "e1", listeDepartement.get(2)));

		collabService.sauvegarderCollaborateur(new Collaborateur("lam", "tan", LocalDate.of(1993, 02, 04),
				"38 rue de paris 71000 paris", "147852369789632", "e2", listeDepartement.get(2)));

	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {

	}

}
