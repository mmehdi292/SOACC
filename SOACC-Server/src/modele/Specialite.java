package modele;

public class Specialite {

	private String nomSpecialite;
	private int idSpecialite;
	private Departement departement;
	
	public String getNomSpecialite() {
		return nomSpecialite;
	}
	public void setNomSpecialite(String nomSpecialite) {
		this.nomSpecialite = nomSpecialite;
	}
	public int getIdSpecialite() {
		return idSpecialite;
	}
	public void setIdSpecialite(int idSpecialite) {
		this.idSpecialite = idSpecialite;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	
}