package dev.sgp.service;

import java.time.ZonedDateTime;
import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import dev.sgp.entite.CollabEvt;
import dev.sgp.entite.Collaborateur;
import dev.sgp.entite.TypeCollabEvt;

@Stateless
public class CollaborateurService {
	@PersistenceContext(unitName = "sgp-pu")
	private EntityManager em;

	@Inject
	Event<CollabEvt> collabEvt;

	public List<Collaborateur> listerCollaborateurs() {
		return em.createNamedQuery("Collaborateur.findAll", Collaborateur.class).getResultList();
	}

	public void sauvegarderCollaborateur(Collaborateur collab) {
		em.persist(collab);
		collabEvt.fire(new CollabEvt(ZonedDateTime.now(), TypeCollabEvt.CREATION_COLLAB, collab.getMatricule()));
	}
}
