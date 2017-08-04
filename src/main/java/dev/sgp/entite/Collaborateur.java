package dev.sgp.entite;

import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Collaborateur")
@NamedQueries({ @NamedQuery(name = "Collaborateur.findAll", query = "select c from Collaborateur c"),
		@NamedQuery(name = "Collaborateur.findCollabByDepart", query = "select c from Collaborateur c where c.departement.id=:iddepart"),
		@NamedQuery(name = "Collaborateur.findCollabByMatricule", query = "select c from Collaborateur c where c.matricule=:matricule"),
		@NamedQuery(name = "Collaborateur.findCoorBanqCollabByMatricule", query = "select c from Collaborateur c where c.matricule=:matricule") })
public class Collaborateur {

	@Id
	private String matricule;
	private String nom;
	private String prenom;
	private LocalDate dateDeNaissance;
	private String adresse;
	private String numSecuSoc;
	private String emailPro;
	private String photo;
	private String dateHeureCreation;
	private boolean actif;
	private String intitulePoste;
	@ManyToOne
	@JoinColumn(name = "id_Departement")
	private Departement departement;
	private String banque;
	private String iban;
	private String bic;

	public Collaborateur() {
		super();
	}

	public Collaborateur(String matricule, String nom, String prenom, LocalDate dateDeNaissance, String adresse,
			String numSecuSoc, ZonedDateTime zonedDateTime, boolean inactif, String intitulePoste,
			Departement departement, String banque, String iban, String bic) {
		super();

		this.matricule = nom.substring(0, 1) + prenom;

		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.numSecuSoc = numSecuSoc;

		this.emailPro = nom + "." + prenom + "@societe.com";
		this.photo = "http://eshop.angelchef.gr/wp-content/uploads/2014/10/ANONYMOUS-276x328.png";
		this.dateHeureCreation = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm:ss").format(ZonedDateTime.now());
		this.actif = true;
		this.intitulePoste = intitulePoste;
		this.departement = departement;
		this.banque = banque;
		this.iban = iban;
		this.bic = bic;

	}

	public Collaborateur(String nom, String prenom, LocalDate dateDeNaissance, String adresse, String numSecuSoc) {
		super();

		this.matricule = nom.substring(0, 1) + prenom;

		this.nom = nom;
		this.prenom = prenom;
		this.dateDeNaissance = dateDeNaissance;
		this.adresse = adresse;
		this.numSecuSoc = numSecuSoc;

		this.emailPro = nom + "." + prenom + "@societe.com";
		this.photo = "http://eshop.angelchef.gr/wp-content/uploads/2014/10/ANONYMOUS-276x328.png";
		this.dateHeureCreation = DateTimeFormatter.ofPattern("dd/MM/yyyy - hh:mm:ss").format(ZonedDateTime.now());
		this.actif = true;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public LocalDate getDateDeNaissance() {
		return dateDeNaissance;
	}

	public void setDateDeNaissance(LocalDate dateDeNaissance) {
		this.dateDeNaissance = dateDeNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getNumSecuSoc() {
		return numSecuSoc;
	}

	public void setNumSecuSoc(String numSecuSoc) {
		this.numSecuSoc = numSecuSoc;
	}

	public String getEmailPro() {
		return emailPro;
	}

	public void setEmailPro(String emailPro) {
		this.emailPro = emailPro;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getDateHeureCreation() {
		return dateHeureCreation;
	}

	public void setDateHeureCreation(String dateHeureCreation) {
		this.dateHeureCreation = dateHeureCreation;
	}

	public boolean isActif() {
		return actif;
	}

	public void setActif(boolean actif) {
		this.actif = actif;
	}

	public String getIntitulePoste() {
		return intitulePoste;
	}

	public void setIntitulePoste(String intitulePoste) {
		this.intitulePoste = intitulePoste;
	}

	public Departement getDepartement() {
		return departement;
	}

	public void setDepartement(Departement departement) {
		this.departement = departement;
	}

	public String getBanque() {
		return banque;
	}

	public void setBanque(String banque) {
		this.banque = banque;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBic() {
		return bic;
	}

	public void setBic(String bic) {
		this.bic = bic;
	}

}
