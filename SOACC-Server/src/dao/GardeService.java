package dao;

import java.util.ArrayList;

import modele.Inscription;

public class GardeService {

	public Inscription getEtudiantParMatricule(String matricule) {
		DaoFactory daoFactory = DaoFactory.getInstance();
		EspaceGardesDao espaceGardesDao = daoFactory.getGradesEDao();
		return espaceGardesDao.getEtudiantParMatricule(matricule);
	}
	public ArrayList<Inscription> getEtudiantParNom(String nom){
		DaoFactory daoFactory = DaoFactory.getInstance();
		EspaceGardesDao espaceGardesDao = daoFactory.getGradesEDao();
		return espaceGardesDao.getEtudiantParNom(nom);
	}
	public ArrayList<Inscription> getEtudiantParNomEtPrenom(String nom,String prenom){
		DaoFactory daoFactory = DaoFactory.getInstance();
		EspaceGardesDao espaceGardesDao = daoFactory.getGradesEDao();
		return espaceGardesDao.getEtudiantParNomEtPrenom(nom, prenom);
	}
	
}
