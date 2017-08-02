package dev.sgp.listener;

import java.time.LocalDate;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import dev.sgp.entite.Collaborateur;
import dev.sgp.service.CollaborateurService;
import dev.sgp.util.Constantes;

@WebListener
public class JeuEssaiListener implements HttpSessionListener {

	private CollaborateurService collabService = Constantes.COLLAB_SERVICE;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		collabService.sauvegarderCollaborateur(new Collaborateur("frugier", "anthony", LocalDate.of(1993, 2, 4),
				"38 rue de paris 45500 Vitré", "123456789123456"));
		collabService.sauvegarderCollaborateur(new Collaborateur("martin", "pierre-antoine", LocalDate.of(1993, 8, 26),
				"38 rue de paris 36251 saint-herblain", "789456123789456"));
		collabService.sauvegarderCollaborateur(new Collaborateur("debuisson", "eddy", LocalDate.of(1993, 5, 15),
				"38 rue de paris 59800 rennes", "789123456789132"));
		collabService.sauvegarderCollaborateur(new Collaborateur("kuntz", "thomas", LocalDate.of(1975, 12, 24),
				"38 rue de paris 49000 angers", "159632478951236"));
		collabService.sauvegarderCollaborateur(new Collaborateur("brocart", "alexandre", LocalDate.of(1990, 12, 4),
				"38 rue de paris 13000 marseille", "789512368745213"));
		collabService.sauvegarderCollaborateur(new Collaborateur("samson", "jerome", LocalDate.of(1993, 9, 4),
				"38 rue de paris 12000 po", "123546987654654"));
		collabService.sauvegarderCollaborateur(new Collaborateur("aymerich", "paula", LocalDate.of(1990, 8, 04),
				"38 rue de paris 85000 strasbourg", "798897546654321"));
		collabService.sauvegarderCollaborateur(new Collaborateur("bourreau", "etienne", LocalDate.of(1995, 1, 8),
				"38 rue de paris 38000 toulon", "519519357357546"));
		collabService.sauvegarderCollaborateur(new Collaborateur("guironnet", "damien", LocalDate.of(1995, 3, 16),
				"38 rue de paris 38500 hyere", "478896236412555"));
		collabService.sauvegarderCollaborateur(new Collaborateur("lam", "tan", LocalDate.of(1993, 02, 04),
				"38 rue de paris 71000 paris", "147852369789632"));
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {

	}

}
