package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.sgp.entite.VisiteWeb;

@ApplicationScoped
public class VisiteWebServices {

	static List<VisiteWeb> listeVisites = new ArrayList<>();

	public static List<VisiteWeb> listerVisites() {
		return listeVisites;
	}

	public void sauvegarderVisite(VisiteWeb visite) {
		listeVisites.add(visite);
	}

	public int nbVisite(String chemin) {
		return (int) listeVisites.stream().filter(p -> p.getChemin().equals(chemin)).count();
	}

	public int trouverMin(String chemin) {
		return listeVisites.stream().filter(p -> p.getChemin().equals(chemin)).mapToInt(VisiteWeb::getTempsExecution)
				.min()
				.getAsInt();
	}

	public int trouverMax(String chemin) {
		return listeVisites.stream().filter(p -> p.getChemin().equals(chemin)).mapToInt(VisiteWeb::getTempsExecution)
				.max()
				.getAsInt();
	}

	public int trouverMoy(String chemin) {
		return (int) Math.round(listeVisites.stream().filter(p -> p.getChemin().equals(chemin))
				.mapToInt(VisiteWeb::getTempsExecution).average().getAsDouble());
	}
}
