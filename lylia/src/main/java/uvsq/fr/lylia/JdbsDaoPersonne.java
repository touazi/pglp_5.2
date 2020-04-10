package uvsq.fr.lylia;
import java.sql.*;
import java.time.LocalDate;
import  uvsq.fr.lylia.PERSONNE.PERSONNEBuilder;
import uvsq.fr.lylia.exeption.PersonneDoncExistException;
public class JdbsDaoPersonne implements DAO<PERSONNE> {
	public static String dburl = "jdbc:mysql://localhost/test" ;

	@Override
	public PERSONNE create(PERSONNE obj) {
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
			System.out.println(e.getMessage());
			
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
			System.out.println(e.getMessage());
		}
		return personne;
	}

	@Override
	public PERSONNE update(PERSONNE obj) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(PERSONNE obj) {
		// TODO Auto-generated method stub
		
	}

}
