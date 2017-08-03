package dev.sgp.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;

import dev.sgp.entite.Departement;

@ApplicationScoped
public class DepartementService {
	List<Departement> listeDepartement = new ArrayList<>();

	public List<Departement> listerDepartements() {
		return listeDepartement;
	}

	public void sauvegarderDepartement(Departement depart) {
		listeDepartement.add(depart);
	}
}
