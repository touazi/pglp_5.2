package uvsq.fr.lylia;

import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import uvsq.fr.lylia.exeption.TableExisteDeja;

public class CeartionBDDREBY {
	private static final String userName = "";
	private static final String password = "";

	public static String dburl = "jdbc:derby:Derby_base;create=true";

	public CeartionBDDREBY() {
		Properties connectionProps = new Properties();
		connectionProps.put("user", userName);
		connectionProps.put("user", password);
	}

	public void createTables() throws TableExisteDeja {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			Statement state = connect.createStatement();
			DatabaseMetaData databaseMetadata = connect.getMetaData();
			ResultSet resultSet = databaseMetadata.getTables(null, null, "PERSONNE", null);

			if (resultSet.next()) {
				throw new TableExisteDeja("TABLE ALREADY EXISTS");
			} else {

				state.addBatch(

						"CREATE TABLE Personne(" + "nom VARCHAR(100) not null," + "prenom VARCHAR(100) NOT NULL,"
								+ "fonction VARCHAR(100) NOT NULL," + "datenaisssance Date NOT NULL,"
								+ "PRIMARY KEY(nom)" + ")");

			}
			ResultSet result = databaseMetadata.getTables(null, null, "GROUPE", null);
			if (result.next()) {
				throw new TableExisteDeja("TABLE ALREADY EXISTS");
			} else {
				state.addBatch("CREATE TABLE groupe (" + "id VARCHAR(100) PRIMARY KEY" + ")");
			}
			ResultSet res = databaseMetadata.getTables(null, null, "APPARTENIR", null);
			if (res.next()) {
				throw new TableExisteDeja("TABLE ALREADY EXISTS");
			} else {
				state.addBatch("CREATE TABLE appartenir(" + "id VARCHAR(100)," + "nom VARCHAR(100)" + ")");
			}
			state.executeBatch();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
