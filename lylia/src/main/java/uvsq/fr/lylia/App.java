package uvsq.fr.lylia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import  uvsq.fr.lylia.PERSONNE.PERSONNEBuilder;
import uvsq.fr.lylia.exeption.PersonneDoncExistException;
import uvsq.fr.lylia.exeption.PersonneExisteDeja;
import uvsq.fr.lylia.exeption.TableExisteDeja;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws PersonneDoncExistException, SQLException, TableExisteDeja, PersonneExisteDeja
    {PERSONNE mm=null;
		  PERSONNE personne = new PERSONNEBuilder("TOUAZI", "LYLIA")
					.dateNaissance(LocalDate.parse("1997-04-22"))
					.fonction("directeur")
					.build();
		  PERSONNE  personne2 = new PERSONNEBuilder("cc", "cv")
				.dateNaissance(LocalDate.parse("1994-04-22"))
				.fonction("vendeur")
				.build();
		  PERSONNE   personne3 = new PERSONNEBuilder("hhhh", "hihi")
				.dateNaissance(LocalDate.parse("1912-12-12"))
				.fonction("directeur")
				.build();
		  JdbsDaoPersonneDerby p=new JdbsDaoPersonneDerby();
		  
   mm= p.create(personne);
   mm.print();
   
    }
}
