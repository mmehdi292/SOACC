package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import modele.Departement;
import modele.Etudiant;
import modele.Faculte;
import modele.Formation;
import modele.Inscription;
import modele.Specialite;

public class EspaceGardesDaoImpl implements EspaceGardesDao {

	private DaoFactory daoFactory;

	EspaceGardesDaoImpl(DaoFactory daoFactory) {
		this.daoFactory = daoFactory;
	}
	@Override
	public Inscription getEtudiantParMatricule(String matricule) {
    	Inscription inscriptions = new Inscription();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            int moin = java.time.LocalDate.now().getMonthValue();
            int annee = java.time.LocalDate.now().getYear();
            String anneeUniversitaire = "";
            if(moin > 8 )
            	anneeUniversitaire = annee +"/"+(annee+1);
            else
            	anneeUniversitaire = (annee-1) +"/"+annee;
            System.out.println("-------------------"+anneeUniversitaire);
            String sql = "SELECT *\r\n" + 
            		"FROM Inscription i, etudiant e, Formation f, Specialite s, Departement d,Faculte fa\r\n" + 
            		"WHERE i.matricule = e.matricule AND i.idFormation = f.idFormation \r\n" + 
            		"AND f.idSpecialite = s.idSpecialite AND s.idDepartement = d.idDepartement \r\n" + 
            		"AND d.idFaculte = fa.idFaculte AND i.matricule = '"+matricule+"' AND i.anneederniereinscription = '"+anneeUniversitaire+"' ;";
            
            resultat = statement.executeQuery(sql);
            while (resultat.next()) {
            	
            	//String matricule = resultat.getString("matricule");
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
                
                
                //Inscription inscription = new Inscription();
                inscriptions.setEtudiant(etudiant);
                inscriptions.setAnneeDerniereInscription(anneeDerniereInscription);
                inscriptions.setFormation(formation);
                
                
                
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
        return inscriptions;
    }

	

	@Override
	public ArrayList<Inscription> getEtudiantParNom(String nom) {
		ArrayList<Inscription> inscriptions = new ArrayList<Inscription>();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            int moin = java.time.LocalDate.now().getMonthValue();
            int annee = java.time.LocalDate.now().getYear();
            String anneeUniversitaire = "";
            if(moin > 8 )
            	anneeUniversitaire = annee +"/"+(annee+1);
            else
            	anneeUniversitaire = (annee-1) +"/"+annee;
            String sql = "SeLeCT *\r\n" + 
            		"FROM Inscription i, etudiant e, Formation f, Specialite s, Departement d,Faculte fa\r\n" + 
            		"WHeRe i.matricule = e.matricule AND i.idFormation = f.idFormation \r\n" + 
            		"AND f.idSpecialite = s.idSpecialite AND s.idDepartement = d.idDepartement \r\n" + 
            		"AND d.idFaculte = fa.idFaculte AND e.nom = '"+nom+"' AND i.anneederniereinscription = '"+anneeUniversitaire+"';";
            
            resultat = statement.executeQuery(sql);
            while (resultat.next()) {
            	
            	String matricule = resultat.getString("matricule");
                //String nom = resultat.getString("nom");
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
        return inscriptions;
	}

	@Override
	public ArrayList<Inscription> getEtudiantParNomEtPrenom(String nom, String prenom) {
		ArrayList<Inscription> inscriptions = new ArrayList<Inscription>();
		Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            int moin = java.time.LocalDate.now().getMonthValue();
            int annee = java.time.LocalDate.now().getYear();
            String anneeUniversitaire = "";
            if(moin > 8 )
            	anneeUniversitaire = annee +"/"+(annee+1);
            else
            	anneeUniversitaire = (annee-1) +"/"+annee;
            String sql = "SeLeCT *\r\n" + 
            		"FROM Inscription i, etudiant e, Formation f, Specialite s, Departement d,Faculte fa\r\n" + 
            		"WHeRe i.matricule = e.matricule AND i.idFormation = f.idFormation \r\n" + 
            		"AND f.idSpecialite = s.idSpecialite AND s.idDepartement = d.idDepartement \r\n" + 
            		"AND d.idFaculte = fa.idFaculte AND e.nom ='"+nom+"' AND e.prenom = '"+prenom+"' AND i.anneederniereinscription = '"+anneeUniversitaire+"' ;";
            
            resultat = statement.executeQuery(sql);
            while (resultat.next()) {
            	
            	String matricule = resultat.getString("matricule");
                //String nom = resultat.getString("nom");
                //String prenom = resultat.getString("prenom");
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
        return inscriptions;
	}
	
	
}
