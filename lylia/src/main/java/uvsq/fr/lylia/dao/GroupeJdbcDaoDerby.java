package uvsq.fr.lylia.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import uvsq.fr.lylia.exeption.PersonneDoncExistException;
import uvsq.fr.lylia.groupe.GroupePersonnel;
import uvsq.fr.lylia.groupe.PERSONNE;

/**. <b>"la classe GroupeJdbcDaoDerby."</b>
 * <p>
 * "implementation du patern Dao"
 *
 * @author TOUAZI,Lylia
 */
public class GroupeJdbcDaoDerby implements DAO<GroupePersonnel> {
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
 * methode create GroupePersonnel. insertion d'un GroupePersonnel.
 *
 * @param obj le GroupePersonnel à sauvgarder dans la base de donnée.
 * @return GroupePersonnel créee
 */
@Override
public final GroupePersonnel create(final GroupePersonnel obj) {
	try (Connection connect = DriverManager.getConnection(dburl)) {
		PreparedStatement prepare = connect.prepareStatement("INSERT"
	+ " INTO groupe (id) VALUES (?)");
		prepare.setString(1, obj.getId());
		int result = prepare.executeUpdate();
		assert result == 1;
		List<PERSONNE> lp = obj.getlistepersonnel();
		for (Iterator<PERSONNE> it = lp.iterator(); it.hasNext();) {
			PERSONNE n = it.next();
			prepare = connect.prepareStatement("INSERT INTO "
			+ "appartenir " + "VALUES (?, ?)");
			prepare.setString(1, obj.getId());
			prepare.setString(2, n.getNom());
			prepare.executeUpdate();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return obj;
}

/**
 * methode read GroupePersonnel.
 *  recuperer d'un GroupePersonnel dans la bd.
 *
 * @param id le nom du GroupePersonnel
 *  à lire dans la base de donnée.
 * @return GroupePersonnel lu
 */
@Override
public final GroupePersonnel read(final String id)
		throws PersonneDoncExistException {
	GroupePersonnel groupe = null;
	try (Connection connect = DriverManager.getConnection(dburl)) {
		System.out.println("Recherche " + id);
		groupe = new GroupePersonnel(id);
		DaoFactory factory = new DaoFactory();
		DAO<PERSONNE> jdbsDaoPersonne = factory.getPersonneDAO();
		Statement st = connect.createStatement();
		st.setFetchSize(0);
		ResultSet result = st.executeQuery("SELECT * FROM"
		+ " APPARTENIR WHERE id = id");
		while (result.next()) {
			groupe.ajouterPersonnel(jdbsDaoPersonne.read(
					result.getString("nom")));
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return groupe;

}

/**
 * methode update GroupePersonnel.
 * modification d'un GroupePersonnel dans la bd.
 *
 * @param obj le GroupePersonnel à modifier
 * dans la base de donnée.
 * @return GroupePersonnel modifier
 */
@Override
public final GroupePersonnel update(final GroupePersonnel obj)
		throws PersonneDoncExistException {
// TODO Auto-generated method stub
	try (Connection connect = DriverManager.getConnection(dburl)) {
		String sql1 = "DELETE" + " FROM appartenir " + "WHERE id = ?";
		PreparedStatement prepare = connect.prepareStatement(sql1);
		prepare.setString(1, obj.getId());
		int result = prepare.executeUpdate();
		assert result == 1;
		List<PERSONNE> lp = obj.getlistepersonnel();
		for (Iterator<PERSONNE> it = lp.iterator(); it.hasNext();) {
			PERSONNE n = it.next();
			prepare = connect.prepareStatement("INSERT INTO "
			+ "appartenir " + "VALUES (?, ?)");
			prepare.setString(1, obj.getId());
			prepare.setString(2, n.getNom());
			prepare.executeUpdate();
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	return obj;
}

/**
 * methode delete GroupePersonnel.
 * supression d'un GroupePersonnel dans la bd.
 *
 * @param obj le GroupePersonnel à
 * suprimer dans la base de donnée.
 */
@Override
public final void delete(final GroupePersonnel obj)
		throws PersonneDoncExistException {
	// TODO Auto-generated method stub

	try (Connection connect = DriverManager.getConnection(dburl)) {
		String sql1 = "DELETE" + " FROM groupe " + "WHERE id = ?";
		PreparedStatement prepare = connect.prepareStatement(sql1);
		prepare.setString(1, obj.getId());
		int result = prepare.executeUpdate();
		if (result > 0) {
			System.out.println("Le groupe de personne est"
		+ " suprimer avec succes :) !!");
		}
		assert result == 1;
		for (PERSONNE forme : obj.getlistepersonnel()) {
			String sql = "DELETE FROM" + " appartenir "
		+ "WHERE" + " id = ? " + "and nom = ? ";
			prepare = connect.prepareStatement(sql);
			String nomObjet = obj.getId();
			String nomForme = forme.getNom();
			prepare.setString(1, nomObjet);
			prepare.setString(2, nomForme);
			int result1 = prepare.executeUpdate();
			assert result1 == 1;
		}

	} catch (SQLException e) {
		e.getMessage();
	}
}

}
