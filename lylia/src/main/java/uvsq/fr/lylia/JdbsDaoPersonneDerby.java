package uvsq.fr.lylia;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import uvsq.fr.lylia.PERSONNE.PERSONNEBuilder;
import uvsq.fr.lylia.exeption.PersonneDoncExistException;
import uvsq.fr.lylia.exeption.PersonneExisteDeja;

public class JdbsDaoPersonneDerby implements DAO<PERSONNE> {
	private static String dburl = CeartionBDDREBY.dburl;
	@Override
	public PERSONNE create(PERSONNE obj) throws PersonneExisteDeja {
		try (Connection connect = DriverManager.getConnection(dburl)) {
			PreparedStatement prepare = connect.prepareStatement(
					"INSERT  INTO Personne (nom, prenom, fonction, datenaisssance)" +
					"VALUES (?, ?, ?, ?)");
			prepare.setString(1, obj.getNom());
			prepare.setString(2, obj.getPrenom());
			prepare.setString(3, obj.getFonction().toString());
			prepare.setDate(4, Date.valueOf(obj.getDateNaissance()));
			int result = prepare.executeUpdate();
			assert result == 1;
		}
		catch (SQLException e) {
			e.getMessage();
			
		}
		return obj;
	}

	@Override
	public PERSONNE read(String id) throws PersonneDoncExistException {
		// TODO Auto-generated method stub
					PERSONNE personne = null;
					try (Connection connect = DriverManager.getConnection(dburl)) {
						PreparedStatement prepare = connect.prepareStatement(
								"SELECT * FROM personne WHERE nom = ?  ");
						prepare.setString(1, id);
						ResultSet result = prepare.executeQuery();
						
						if(result.next()) {
							personne =  new PERSONNEBuilder(result.getString("nom"),result.getString("prenom"))
									.dateNaissance(LocalDate.parse("1997-04-22"))
									.fonction(result.getString("fonction"))
									.build();
							result.close();
							}
						else { 
					        throw new PersonneDoncExistException("La personne que vous chercher n'éxiste pas :( !");}
					}
					catch (SQLException e) {
						e.getMessage();
					}
					return personne;
					}

	@Override
	public PERSONNE update(PERSONNE obj) throws PersonneDoncExistException {
		// TODO Auto-generated method stub
		
				try (Connection connect = DriverManager.getConnection(dburl)) {
					PreparedStatement prepareFind = connect.prepareStatement(
							"SELECT * FROM personne WHERE nom = ?  ");
					prepareFind.setString(1, obj.getNom());
					ResultSet res = prepareFind.executeQuery();
					
					if(!res.next()) { throw new PersonneDoncExistException(""
							+ "La personne que vous voulez modifier"
							+ " n'éxiste pas :( !");}
					else {
					PreparedStatement prepare = connect.prepareStatement(
							"UPDATE personne SET prenom = ?, "
							+ "fonction = ?, "
							+ "datenaisssance = ? WHERE nom = ?");
					prepare.setString(1, obj.getPrenom());
					prepare.setString(2, obj.getFonction().toString());
					prepare.setDate(3, Date.valueOf(obj.getDateNaissance()));
					prepare.setString(4, obj.getNom());
					int result = prepare.executeUpdate();
					assert result == 1;}
				}
				catch (SQLException e) {
					e.getMessage();
				}
				return obj;	
	}

	@Override
	public void delete(PERSONNE obj) throws PersonneDoncExistException {
		// TODO Auto-generated method stub
				read(obj.getNom());
				try (Connection connect = DriverManager.getConnection(dburl)) {
					PreparedStatement prepareFind = connect.prepareStatement(
							"SELECT * FROM personne WHERE nom = ?  ");
					prepareFind.setString(1, obj.getNom());
					ResultSet res = prepareFind.executeQuery();
					
					if(!res.next()) { throw new PersonneDoncExistException(""
							+ "La personne que vous voulez modifier"
							+ " n'éxiste pas :( !");}
					else {
					PreparedStatement prepare = connect.prepareStatement(
							"DELETE FROM personne "
							+ "WHERE nom = ?");
					prepare.setString(1, obj.getNom());
					int result = prepare.executeUpdate();
					assert result == 1;
				}}
				catch (SQLException e) {
					e.getMessage();
				}
			
			}
}
