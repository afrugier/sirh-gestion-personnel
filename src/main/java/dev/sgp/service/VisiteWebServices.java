package dev.sgp.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.sgp.entite.VisiteWeb;

@Stateless
public class VisiteWebServices {
	@PersistenceContext(unitName = "sgp-pu")
	private EntityManager em;


	public List<VisiteWeb> listerVisites() {
		return em.createNamedQuery("VisiteWeb.findAll", VisiteWeb.class).getResultList();
	}

	public void sauvegarderVisite(VisiteWeb visite) {
		em.persist(visite);
	}

	public int nbVisite(String chemin) {
		return (int) listerVisites().stream().filter(p -> p.getChemin().equals(chemin)).count();
	}

	public int trouverMin(String chemin) {
		return listerVisites().stream().filter(p -> p.getChemin().equals(chemin)).mapToInt(VisiteWeb::getTempsExecution)
				.min()
				.getAsInt();
	}

	public int trouverMax(String chemin) {
		return listerVisites().stream().filter(p -> p.getChemin().equals(chemin)).mapToInt(VisiteWeb::getTempsExecution)
				.max()
				.getAsInt();
	}

	public int trouverMoy(String chemin) {
		return (int) Math.round(listerVisites().stream().filter(p -> p.getChemin().equals(chemin))
				.mapToInt(VisiteWeb::getTempsExecution).average().getAsDouble());
	}
}
