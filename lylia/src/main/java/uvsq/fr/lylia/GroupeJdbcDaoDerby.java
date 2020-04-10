package uvsq.fr.lylia;

import java.sql.*;
import java.util.List;

import uvsq.fr.lylia.exeption.PersonneDoncExistException;

public class GroupeJdbcDaoDerby implements DAO<GroupePersonnel>{
	private static String dburl = CeartionBDDREBY.dburl;
	@Override
	public GroupePersonnel create(GroupePersonnel obj)  {
		try (Connection connect = DriverManager.getConnection(dburl)) {

		   
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT INTO groupe (id)" +
					"VALUES (?)");
			prepare.setString(1, obj.getId());
			int result = prepare.executeUpdate();
			assert result == 1;
			List<PERSONNE> lp = obj.getlistepersonnel();
			for (PERSONNE p : lp) {
				prepare = connect.prepareStatement(
						"INSERT INTO APPARTENIR "
						+ "VALUES (?, ?)");
				prepare.setString(1, obj.getId());
				prepare.setString(2, p.getNom());
				prepare.addBatch();
			}
			prepare.executeBatch();
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
		return obj;
	}

	@Override
	public GroupePersonnel read(String id) throws PersonneDoncExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GroupePersonnel update(GroupePersonnel obj) throws PersonneDoncExistException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(GroupePersonnel obj) throws PersonneDoncExistException {
		// TODO Auto-generated method stub
		
	}

}
