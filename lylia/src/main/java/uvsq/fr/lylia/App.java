package uvsq.fr.lylia;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;

import uvsq.fr.lylia.dao.CeartionBDDREBY;
import uvsq.fr.lylia.dao.GroupeJdbcDaoDerby;
import uvsq.fr.lylia.dao.JdbsDaoPersonneDerby;
import uvsq.fr.lylia.exeption.PersonneDoncExistException;
import uvsq.fr.lylia.exeption.PersonneExisteDeja;
import uvsq.fr.lylia.exeption.TableExisteDeja;
import uvsq.fr.lylia.groupe.GroupePersonnel;
import uvsq.fr.lylia.groupe.PERSONNE;
import uvsq.fr.lylia.groupe.PERSONNE.PERSONNEBuilder;

/**
 * Hello world!
 *
 */
public class App {
	/**le main exmaple de creation de personne et groupe.
	 * de personne.
	 * @param args args.
	 * @throws PersonneDoncExistException lever
	 * PersonneDoncExistException
	 * @throws SQLException lever SQLException
	 * @throws TableExisteDeja lever TableExisteDeja.
	 * @throws PersonneExisteDeja lever une
	 *PersonneExisteDeja
	 * */
	public static void main(final String[] args)
			throws PersonneDoncExistException, SQLException,
			TableExisteDeja, PersonneExisteDeja {
		PERSONNE n = null, mm = null;
		PERSONNE personne = new PERSONNEBuilder("TOUAZI", "LYLIA")
				.dateNaissance(LocalDate.parse("1997-04-22"))
				.fonction("directeur").build();
		PERSONNE personne2 = new PERSONNEBuilder("cc", "cv")
				.dateNaissance(LocalDate.parse("1994-04-22"))
				.fonction("vendeur").build();
		PERSONNE personne3 = new PERSONNEBuilder("hhhh", "hihi")
				.dateNaissance(LocalDate.parse("1912-12-12"))
				.fonction("directeur").build();
		GroupePersonnel gg, ggg;
		GroupePersonnel g2 = new GroupePersonnel("kkkkk");
		JdbsDaoPersonneDerby p = new JdbsDaoPersonneDerby();
		CeartionBDDREBY nlk = new CeartionBDDREBY();
		nlk.createTables();
		PERSONNE pCreate;
		System.out.println("####### Céartion de Trois personne"
				+ " ############");
		pCreate = p.create(personne);
		pCreate = p.create(personne3);
		pCreate = p.create(personne2);
		pCreate = p.read("TOUAZI");
		pCreate.print();
		pCreate = p.read("cc");
		pCreate.print();
		pCreate = p.read("hhhh");
		pCreate.print();
		System.out.println("####### fin de Ceartion de 2 personne"
				+ " ############");

		System.out.println("####### Céartion d'un groupe de Trois"
				+ " personne ############");
		g2.ajouterPersonnel(personne2);
		g2.ajouterPersonnel(personne3);
		GroupeJdbcDaoDerby gro = new GroupeJdbcDaoDerby();
		gg = gro.create(g2);
		gg = gro.read(g2.getId());
		if (gg.getlistepersonnel().size() > 0) {
			List<PERSONNE> liste = gg.getlistepersonnel();
			for (Iterator<PERSONNE> it = liste.iterator();
					it.hasNext();) {
				n = it.next();
				n.print();
			}
		}
		System.out.println("####### fin Céartion d'un groupe"
				+ " de 2 personne ############");

		gg.ajouterPersonnel(personne);
		System.out.println(
				"########################   update  ajouter"
				+ " une nouvelle personne au groupe"
				+ "  ###################");
		gg = gro.update(gg);
		gg = gro.read(g2.getId());

		gg.print();
		System.out.println("================== fin update"
				+ "===========================");

		System.out.println("============ Delete groupe ==="
				+ "===========");
		gro.delete(gg);
		ggg = gro.read(gg.getId());
		ggg.print();
		System.out.println("============ Delete groupe ====="
				+ "=========");
	}

}
