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
PERSONNE  personne = new PERSONNEBuilder("TOUAZI", "LYLIA")
				.dateNaissance(LocalDate.parse("1997-04-22"))
				.fonction("directeur")
				.build();
        JdbsDaoPersonne p=new JdbsDaoPersonne();


     // pe.print();
    }
}
