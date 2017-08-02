package dev.sgp.entite;

public class Statistique {

	private String chemin;
	private Integer nbVisites;
	private Integer tempsMin;
	private Integer tempsMax;
	private Integer tempsMoy;

	public Statistique() {
		super();
	}

	public String getChemin() {
		return chemin;
	}

	public void setChemin(String chemin) {
		this.chemin = chemin;
	}

	public Integer getNbVisites() {
		return nbVisites;
	}

	public void setNbVisites(Integer nbVisites) {
		this.nbVisites = nbVisites;
	}

	public Integer getTempsMin() {
		return tempsMin;
	}

	public void setTempsMin(Integer tempsMin) {
		this.tempsMin = tempsMin;
	}

	public Integer getTempsMax() {
		return tempsMax;
	}

	public void setTempsMax(Integer tempsMax) {
		this.tempsMax = tempsMax;
	}

	public Integer getTempsMoy() {
		return tempsMoy;
	}

	public void setTempsMoy(Integer tempsMoy) {
		this.tempsMoy = tempsMoy;
	}

}
