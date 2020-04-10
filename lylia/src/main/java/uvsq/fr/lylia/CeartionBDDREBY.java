package uvsq.fr.lylia;


import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import uvsq.fr.lylia.exeption.TableExisteDeja;

public class CeartionBDDREBY {
	private static final String userName = "";
	private static final String password = "";
	
	public static String dburl = "jdbc:derby:pglp_5.2;create=true";
	
	public CeartionBDDREBY() {
		Properties connectionProps = new Properties();
		connectionProps.put("user", userName);
		connectionProps.put("user", password);
	}
	
	public void createTables() throws TableExisteDeja {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			//  Statement statement = getConnection().createStatement();
			  Statement state = connect.createStatement();
			    DatabaseMetaData databaseMetadata = connect.getMetaData();
			    ResultSet resultSet = databaseMetadata.getTables(null, null, "PERSONNE", null);
			    if (resultSet.next()) {
			    	throw new TableExisteDeja("TABLE ALREADY EXISTS");
			    } else {
			
			state.addBatch(
					
					"CREATE TABLE Personne("
							+ "nom VARCHAR(100) not null,"
							+ "prenom VARCHAR(100) NOT NULL,"
		    				+ "fonction VARCHAR(100) NOT NULL,"
		    				+ "datenaisssance Date NOT NULL,"
		    			   + "PRIMARY KEY(nom,prenom)"
					+ ")");
			
			    }
    						

			state.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}
}
