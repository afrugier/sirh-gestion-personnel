package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

import dev.sgp.entite.CollabEvt;

@ApplicationScoped
public class ActiviteService {
	List<CollabEvt> listeCollabEvt = new ArrayList<>();

	void recevoirEvenementCollab(@Observes CollabEvt evt) {
		listeCollabEvt.add(evt);
	}

	public List<CollabEvt> listerActivitesCollab() {
		return listeCollabEvt;
	}
}
