package modele;

import java.util.Date;

public class Etudiant {

	private String matricule;
	private String nom;
	private String prenom;
	private String sexe;
	private Date dateNaissance;
	private String prenomPere;
	private String nomMere;
	private String prenomMere;

	public String getMatricule() {
		return this.matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getSexe() {
		return this.sexe;
	}

	public void setSexe(String sexe) {
		this.sexe = sexe;
	}

	public Date getDateNaissance() {
		return this.dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getPrenomPere() {
		return this.prenomPere;
	}

	public void setPrenomPere(String prenomPere) {
		this.prenomPere = prenomPere;
	}

	public String getNomMere() {
		return this.nomMere;
	}

	public void setNomMere(String nomMere) {
		this.nomMere = nomMere;
	}

	public String getPrenomMere() {
		return this.prenomMere;
	}

	public void setPrenomMere(String prenomMere) {
		this.prenomMere = prenomMere;
	}

}