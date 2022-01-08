package modele;

public class Inscription {
	
	private Etudiant etudiant;
	private Formation formation;
	private String anneeDerniereInscription;
	public Etudiant getEtudiant() {
		return etudiant;
	}
	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	public Formation getFormation() {
		return formation;
	}
	public void setFormation(Formation formation) {
		this.formation = formation;
	}
	public String getAnneeDerniereInscription() {
		return anneeDerniereInscription;
	}
	public void setAnneeDerniereInscription(String anneeDerniereInscription) {
		this.anneeDerniereInscription = anneeDerniereInscription;
	}
	
	
}