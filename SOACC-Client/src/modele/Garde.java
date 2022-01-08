package modele;

public class Garde {
	
	private String username;
	private String password;
	private String nom;
	private String prenom;
	
	public Garde(String username, String password, String nom, String prenom) {
		super();
		this.username = username;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
	}

	public Garde(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public Garde() {
		super();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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
		

}
