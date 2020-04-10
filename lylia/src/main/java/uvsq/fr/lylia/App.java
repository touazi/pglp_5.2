package uvsq.fr.lylia;

import java.time.LocalDate;
import  uvsq.fr.lylia.PERSONNE.PERSONNEBuilder;
import uvsq.fr.lylia.exeption.PersonneDoncExistException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws PersonneDoncExistException
    {PERSONNE  pe=null;
PERSONNE  personne1 = new PERSONNEBuilder("TOUAZI", "LYLIA")
				.dateNaissance(LocalDate.parse("1997-04-22"))
				.fonction("directeur")
				.build();
        JdbsDaoPersonne p=new JdbsDaoPersonne();
        PERSONNE      personne = new PERSONNEBuilder("TOUAZI", "mylissa")
				.dateNaissance(LocalDate.parse("1997-04-22"))
				.fonction("directeur")
				.build();
    //  pe= p.create(personne);
      p.delete(personne);
      pe = p.create(personne);
      pe.print();
  	personne1 =new PERSONNEBuilder("TOUAZI", "moi")
  			.dateNaissance(LocalDate.parse("1994-04-22"))
  			.fonction("vendeur")
  			.build();
	pe = p.update(personne1);
      pe.print();
    }
}
