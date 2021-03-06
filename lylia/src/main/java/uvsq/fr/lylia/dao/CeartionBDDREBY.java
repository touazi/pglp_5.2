package uvsq.fr.lylia.dao;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import uvsq.fr.lylia.exeption.TableExisteDeja;

/**. <b>"la classe CeartionBDDREBY."</b>
 * <p>
 * "implementation du patern Dao"
 *
 * @author TOUAZI,Lylia
 */
public class CeartionBDDREBY {
/** user name. */
private static final String USERNAME = "";
/** pssword. */
private static final String PASSWORD = "";
/** nom de la bd. */
private static String dburl = "jdbc:derby:Derby_base;create=true";

/**
 * mthode getDburl.
 *
 * @return name nom de la bd
 */
public static String getDburl() {
	return CeartionBDDREBY.dburl;
}

/**
 * Constructeur de la classee CeartionBDDREBY.
 */
public CeartionBDDREBY() {
	Properties connectionProps = new Properties();
	connectionProps.put("user", USERNAME);
	connectionProps.put("user", PASSWORD);
}

/**
 * méthode createtebale. reation des tablde de la bd.
 * @throws TableExisteDeja lever l'exption si la
 * table existe.
 */
public final void createTables() throws TableExisteDeja {
	try (Connection connect = DriverManager.getConnection(dburl)) {
		Statement state = connect.createStatement();
		DatabaseMetaData databaseMetadata = connect.getMetaData();
		ResultSet resultSet = databaseMetadata.getTables(null,
				null, "PERSONNE", null);

	if (resultSet.next()) {
		throw new TableExisteDeja("TABLE ALREADY EXISTS");
	} else {

		state.addBatch(

				"CREATE TABLE Personne("
				+ "nom VARCHAR(100) not null,"
				+ "prenom VARCHAR(100) NOT NULL,"
				+ "fonction VARCHAR(100) NOT NULL,"
				+ "datenaisssance Date NOT NULL,"
				+ "PRIMARY KEY(nom)" + ")");

	}
	ResultSet result = databaseMetadata.getTables(null,
			null, "GROUPE", null);
	if (result.next()) {
		throw new TableExisteDeja("TABLE ALREADY EXISTS");
	} else {
		state.addBatch("CREATE TABLE groupe ("
	+ "id VARCHAR(100) PRIMARY KEY" + ")");
	}
	ResultSet res = databaseMetadata.getTables(null, null,
			"APPARTENIR", null);
	if (res.next()) {
		throw new TableExisteDeja("TABLE ALREADY EXISTS");
	} else {
		state.addBatch("CREATE TABLE appartenir("
	+ "id VARCHAR(100)," + "nom VARCHAR(100)" + ")");
		}
		state.executeBatch();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}
}
