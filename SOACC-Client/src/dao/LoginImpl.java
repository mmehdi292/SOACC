package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginImpl implements Login {
	private DaoFactory daoFactory;

	LoginImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

	@Override
	public boolean login(String username, String password) {
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            String sql = "SELECT * FROM Garde WHERE username = '"+username+"' AND password = md5('"+password+"');";
            
            resultat = statement.executeQuery(sql);
            return resultat.next();
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
        return false;
	}

}
