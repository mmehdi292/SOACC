package dao;

import java.sql.*;
import java.util.ArrayList;

import modele.Departement;
import modele.Etudiant;
import modele.Faculte;
import modele.Formation;
import modele.Inscription;
import modele.Specialite;

public class GestionEtudiantsDaoImpl implements GestionEtudiantsDao {
    private DaoFactory daoFactory;

    GestionEtudiantsDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

   

    @Override
    public ArrayList<Inscription> lister() {
    	ArrayList<Inscription> inscriptions = new ArrayList<Inscription>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            String sql = "SELECT * " + 
            		"FROM Inscription i, Etudiant e, Formation f, Specialite s, Departement d,Faculte fa " + 
            		"WHERE i.matricule = e.matricule AND i.idFormation = f.idFormation " + 
            		"AND f.idSpecialite = s.idSpecialite AND s.idDepartement = d.idDepartement " + 
            		"AND d.idFaculte = fa.idFaculte;";
            
            resultat = statement.executeQuery(sql);
            while (resultat.next()) {
            	
            	String matricule = resultat.getString("matricule");
                String nom = resultat.getString("nom");
                String prenom = resultat.getString("prenom");
                String sexe = resultat.getString("sexe");
                Date dateNaissance = resultat.getDate("dateNaissance");
                String prenomPere = resultat.getString("prenomPere");
                String nomMere = resultat.getString("nomMere");
                String prenomMere = resultat.getString("prenomMere");
                
                int idFaculte = resultat.getInt("idFaculte");
                String nomFaculte = resultat.getString("nomFaculte");
                
                int idDepartement = resultat.getInt("idDepartement");
                String nomDepartement = resultat.getString("nomDepartement");
                
                
                int idSpecialite = resultat.getInt("idSpecialite");
                String nomSpecialite = resultat.getString("nomSpecialite");
                
                int idFormation = resultat.getInt("idFormation");
                String nomFormation = resultat.getString("nomFormation");
                String niveau = resultat.getString("niveau");
                
                String anneeDerniereInscription = resultat.getString("anneeDerniereInscription");
                
             
                Etudiant etudiant = new Etudiant();
                
                etudiant.setMatricule(matricule);
                etudiant.setNom(nom);
                etudiant.setPrenom(prenom);
                etudiant.setSexe(sexe);
                etudiant.setDateNaissance(dateNaissance);
                etudiant.setPrenomPere(prenomPere);
                etudiant.setNomMere(nomMere);
                etudiant.setPrenomMere(prenomMere);
                
                Faculte faculte = new Faculte();
                
                faculte.setIdFaculte(idFaculte);
                faculte.setNomFaculte(nomFaculte);
                
                Departement departement = new Departement();
                
                departement.setIdDepartement(idDepartement);
                departement.setNomDepartement(nomDepartement);
                departement.setFaculte(faculte);
                
                Specialite specialite = new Specialite();
                
                specialite.setIdSpecialite(idSpecialite);
                specialite.setNomSpecialite(nomSpecialite);
                specialite.setDepartement(departement);
                
                
                Formation formation = new Formation();
                
                formation.setIdFormation(idFormation);
                formation.setNomFormation(nomFormation);
                formation.setNiveau(niveau);
                formation.setSpecialite(specialite);
                
                
                Inscription inscription = new Inscription();
                inscription.setEtudiant(etudiant);
                inscription.setAnneeDerniereInscription(anneeDerniereInscription);
                inscription.setFormation(formation);
                
                inscriptions.add(inscription);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
        	
        	try {
				resultat.close();
				statement.close();
	        	connexion.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        	
        	
        }
        System.out.println("La taille est: "+inscriptions.size());
        return inscriptions;
    }

}