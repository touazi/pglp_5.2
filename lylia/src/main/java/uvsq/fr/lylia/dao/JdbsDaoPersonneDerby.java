package uvsq.fr.lylia.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import uvsq.fr.lylia.exeption.PersonneDoncExistException;
import uvsq.fr.lylia.exeption.PersonneExisteDeja;
import uvsq.fr.lylia.groupe.PERSONNE;
import uvsq.fr.lylia.groupe.PERSONNE.PERSONNEBuilder;

/**
 * . <b>"la classe JdbsDaoPersonneDerby."</b>
 * <p>
 * "implementation du patern Dao"
 *
 * @author TOUAZI,Lylia
 */
public class JdbsDaoPersonneDerby implements DAO<PERSONNE> {
/** constante un. */
static final int UN = 1;
/** constante deux. */
static final int DEUX = 2;
/** constante trois. */
static final int TROIS = 3;
/** constante quatre. */
static final int QUATRE = 4;
/** constante cinq. */
static final int CINQ = 5;
/** constante six. */
static final int SIX = 6;
/** constante sept. */
static final int SEPT = 7;
/** nom de la bd. */
private static String dburl = CeartionBDDREBY.getDburl();

/**
 * methode create PERSONNE. insertion d'un PERSONNE.
 *
 * @param obj le PERSONNE à sauvgarder dans la base de donnée.
 * @return PERSONNE créee
 */
@Override
public final PERSONNE create(final PERSONNE obj)
		throws PersonneExisteDeja {
	try (Connection connect = DriverManager.getConnection(dburl)) {
		PreparedStatement prepare = connect.prepareStatement(
				"INSERT  INTO Personne (nom, prenom,"
		+ " fonction, datenaisssance)" + "VALUES (?, ?, ?, ?)");
		prepare.setString(UN, obj.getNom());
		prepare.setString(DEUX, obj.getPrenom());
		prepare.setString(TROIS, obj.getFonction().toString());
		prepare.setDate(QUATRE, Date.valueOf(obj.getDateNaissance()));
		int result = prepare.executeUpdate();
		assert result == 1;
	} catch (SQLException e) {
		e.getMessage();

	}
	return obj;
}

/**
 * methode read PERSONNE. recuperer d'un PERSONNE dans la bd.
 *
 * @param id le nom du PERSONNE à lire dans la base de donnée.
 * @return PERSONNE lu
 */
@Override
public final PERSONNE read(final String id)
		throws PersonneDoncExistException {
// TODO Auto-generated method stub
PERSONNE personne = null;
try (Connection connect = DriverManager.getConnection(dburl)) {
	PreparedStatement prepare = connect.prepareStatement("SELECT"
			+ " * FROM personne WHERE nom = ?  ");
	prepare.setString(UN, id);
	ResultSet result = prepare.executeQuery();

	if (result.next()) {
		personne = new PERSONNEBuilder(result.getString("nom"),
				result.getString("prenom"))
				.dateNaissance(LocalDate.parse("1997-04-22")).
				fonction(result.getString("fonction")).build();
		result.close();
	} else {
		throw new PersonneDoncExistException("La personne"
				+ " que vous chercher n'éxiste pas :( !");
	}
} catch (SQLException e) {
	e.getMessage();
}
return personne;
}

/**
 * methode update PERSONNE. modification d'un PERSONNE dans la bd.
 *
 * @param obj le PERSONNE à modifier dans la base de donnée.
 * @return PERSONNE modifier
 */
@Override
public final PERSONNE update(final PERSONNE obj)
		throws PersonneDoncExistException {
// TODO Auto-generated method stub
try (Connection connect = DriverManager.getConnection(dburl)) {
	PreparedStatement prepareFind = connect.prepareStatement(""
			+ "SELECT * FROM personne WHERE nom = ?  ");
	prepareFind.setString(UN, obj.getNom());
	ResultSet res = prepareFind.executeQuery();

	if (!res.next()) {
		throw new PersonneDoncExistException(
				"" + "La personne que vous voulez modifier"
		+ " n'éxiste pas :( !");
	} else {
		PreparedStatement prepare = connect.prepareStatement(
				"UPDATE personne SET prenom = ?, "
		+ "fonction = ?, "
		+ "datenaisssance = ?"
		+ " WHERE nom = ?");
		prepare.setString(UN, obj.getPrenom());
		prepare.setString(DEUX, obj.getFonction().toString());
		prepare.setDate(TROIS, Date.valueOf(obj.getDateNaissance()));
		prepare.setString(QUATRE, obj.getNom());
		int result = prepare.executeUpdate();
		assert result == 1;
	}
} catch (SQLException e) {
	e.getMessage();
}
return obj;
}

/**
 * methode delete delete. supression d'un delete dans la bd.
 *
 * @param obj le delete à suprimer dans la base de donnée.
 */
@Override
public final void delete(final PERSONNE obj)
		throws PersonneDoncExistException {
	// TODO Auto-generated method stub
	read(obj.getNom());
	try (Connection connect = DriverManager.getConnection(dburl)) {
		PreparedStatement prepareFind = connect.prepareStatement(""
				+ "SELECT * FROM personne WHERE nom = ?  ");
		prepareFind.setString(1, obj.getNom());
		ResultSet res = prepareFind.executeQuery();

		if (!res.next()) {
			throw new PersonneDoncExistException(
					"" + "La personne que"
					+ " vous voulez modifier"
			+ " n'éxiste pas :( !");
		} else {
			PreparedStatement prepare = connect.prepareStatement(""
					+ "DELETE FROM personne "
					+ "WHERE nom = ?");
			prepare.setString(1, obj.getNom());
			int result = prepare.executeUpdate();
			assert result == 1;
		}
	} catch (SQLException e) {
		e.getMessage();
	}

}
}
