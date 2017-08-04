package dev.sgp.entite;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Departement")
@NamedQueries({ @NamedQuery(name = "Departement.findAll", query = "select d from Departement d"),
		@NamedQuery(name = "Departement.findDepartById", query = "select d from Departement d where d.id=:iddepart") })
public class Departement {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nom;

	public Departement() {
		super();
	}

	public Departement(String nom) {
		super();
		this.nom = nom;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
