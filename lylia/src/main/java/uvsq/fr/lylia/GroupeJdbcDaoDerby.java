package uvsq.fr.lylia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;
import uvsq.fr.lylia.exeption.PersonneDoncExistException;

public class GroupeJdbcDaoDerby implements DAO<GroupePersonnel> {
private static String dburl = CeartionBDDREBY.dburl;

@Override
public GroupePersonnel create(GroupePersonnel obj) {
	try (Connection connect = DriverManager.getConnection(dburl)) {
		PreparedStatement prepare =
				connect.prepareStatement("INSERT"
+ " INTO groupe (id) VALUES (?)");
prepare.setString(1, obj.getId());
int result = prepare.executeUpdate();
assert result == 1;
List<PERSONNE> lp = obj.getlistepersonnel();
for (Iterator<PERSONNE> it = lp.iterator(); it.hasNext();) {
	PERSONNE n = it.next();
	prepare =
			connect.prepareStatement("INSERT INTO "
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

@Override
public GroupePersonnel read(String id) throws PersonneDoncExistException {
	GroupePersonnel groupe = null;
	try (Connection connect = DriverManager.getConnection(dburl)) {
		System.out.println("Recherche " + id);
	groupe = new GroupePersonnel(id);
	DaoFactory factory = new DaoFactory();
	DAO<PERSONNE> jdbsDaoPersonne = factory.getPersonneDAO();
	Statement st = connect.createStatement();
	st.setFetchSize(0);
	ResultSet result = st.executeQuery("SELECT * FROM APPARTENIR WHERE id = id");
	while (result.next()) {
		groupe.AjouterPersonnel(jdbsDaoPersonne.read(result.getString("nom")));
		}

	} catch (SQLException e) {
		e.printStackTrace();
	}
	return groupe;

}

@Override
public GroupePersonnel update(GroupePersonnel obj) throws PersonneDoncExistException {
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

@Override
public void delete(GroupePersonnel obj) throws PersonneDoncExistException {
	// TODO Auto-generated method stub

try (Connection connect = DriverManager.getConnection(dburl)) {
	String sql1 = "DELETE" + " FROM groupe " + "WHERE id = ?";
	PreparedStatement prepare = connect.prepareStatement(sql1);
	prepare.setString(1, obj.getId());
	int result = prepare.executeUpdate();
	if (result > 0) {
		System.out.println("Le groupe de personne est suprimer avec succes :) !!");
	}
	assert result == 1;
	for (PERSONNE forme : obj.listepersonnel) {
		//System.out.println("ccccccccccccccccccccc");
		String sql = "DELETE FROM" + " appartenir " + "WHERE id = ? " + "and nom = ? ";
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
