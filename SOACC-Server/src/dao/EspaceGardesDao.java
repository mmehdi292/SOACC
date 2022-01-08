package dao;

import java.util.ArrayList;

import modele.Inscription;

public interface EspaceGardesDao {
	
	public Inscription getEtudiantParMatricule(String matricule);
	public ArrayList<Inscription> getEtudiantParNom(String nom);
	public ArrayList<Inscription> getEtudiantParNomEtPrenom(String nom,String prenom);

}
