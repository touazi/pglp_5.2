package uvsq.fr.lylia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

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
    {PERSONNE n=null,mm=null;
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
		  GroupePersonnel gg;
		  GroupePersonnel g=new GroupePersonnel();
		  g.AjouterPersonnel(personne);

   g.AjouterPersonnel(personne2);
   System.out.println(g.getlistepersonnel().size());
  /* if(g.getlistepersonnel().size()>0) {
		List<PERSONNE> liste=g.getlistepersonnel();
		for(Iterator<PERSONNE> it=liste.iterator(); it.hasNext();)
			{n= it.next();
           n.print();}}*/
   GroupeJdbcDaoDerby G=new GroupeJdbcDaoDerby();
  gg=G.create(g);
  if(gg.getlistepersonnel().size()>0) {
		List<PERSONNE> liste=gg.getlistepersonnel();
		for(Iterator<PERSONNE> it=liste.iterator(); it.hasNext();)
			{n= it.next();
         n.print();}}
    }

    }

