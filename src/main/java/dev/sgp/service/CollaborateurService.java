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

	public List<Collaborateur> trouverCollaborateurParDepart(Integer idDepart) {
		return em.createNamedQuery("Collaborateur.findCollabByDepart", Collaborateur.class)
				.setParameter("iddepart", idDepart).getResultList();
	}

	public Collaborateur trouverCollaborateurParMatricule(String matricule) {
		return em.createNamedQuery("Collaborateur.findCollabByMatricule", Collaborateur.class)
				.setParameter("matricule", matricule).getSingleResult();
	}

	public void editerCollaborateur(String mat, Collaborateur collab) {

		String matricule = em
				.createQuery("select c.matricule from Collaborateur c where c.matricule=:mat", String.class)
				.setParameter("mat", mat).getSingleResult();

		if (matricule != null) {
			collab.setMatricule(matricule);
			em.merge(collab);
		}
	}

	public void editerCollaborateur(Collaborateur collaborateur) {
		Collaborateur collab = trouverCollaborateurParMatricule(collaborateur.getMatricule());
		if (collab != null) {
			collab.setActif(collaborateur.isActif());
			collab.setAdresse(collaborateur.getAdresse());
			collab.setBanque(collaborateur.getBanque());
			collab.setBic(collaborateur.getBic());
			collab.setIban(collaborateur.getIban());
			collab.setIntitulePoste(collaborateur.getIntitulePoste());
			collab.setDepartement(collaborateur.getDepartement());
			em.merge(collab);
			collabEvt.fire(new CollabEvt(ZonedDateTime.now(), TypeCollabEvt.MODIFICATION_COLLAB,
					collaborateur.getMatricule()));
		}
	}
}
