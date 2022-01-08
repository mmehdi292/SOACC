package modele;

public class Departement {

	private String nomDepartement;
	private int idDepartement;
	private Faculte faculte;

	public String getNomDepartement() {
		return nomDepartement;
	}

	public void setNomDepartement(String nomDepartement) {
		this.nomDepartement = nomDepartement;
	}

	public int getIdDepartement() {
		return idDepartement;
	}

	public void setIdDepartement(int idDepartement) {
		this.idDepartement = idDepartement;
	}

	public Faculte getFaculte() {
		return faculte;
	}

	public void setFaculte(Faculte faculte) {
		this.faculte = faculte;
	}

}