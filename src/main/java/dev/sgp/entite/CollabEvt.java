package dev.sgp.entite;

import java.time.ZonedDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "CollabEvt")
@NamedQueries({ @NamedQuery(name = "CollabEvt.findAll", query = "select ce from CollabEvt ce") })
public class CollabEvt {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private ZonedDateTime dateHeure;
	@Enumerated(EnumType.STRING)
	private TypeCollabEvt type;
	private String matricule;

	public CollabEvt() {
		super();
	}

	public CollabEvt(ZonedDateTime dateHeure, TypeCollabEvt type, String matricule) {
		super();
		this.dateHeure = dateHeure;
		this.type = type;
		this.matricule = matricule;
	}

	public ZonedDateTime getDateHeure() {
		return dateHeure;
	}

	public void setDateHeure(ZonedDateTime dateHeure) {
		this.dateHeure = dateHeure;
	}

	public TypeCollabEvt getType() {
		return type;
	}

	public void setType(TypeCollabEvt type) {
		this.type = type;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

}
