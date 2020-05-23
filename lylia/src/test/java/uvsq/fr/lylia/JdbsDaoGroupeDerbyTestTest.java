package uvsq.fr.lylia;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import uvsq.fr.lylia.PERSONNE.PERSONNEBuilder;
import uvsq.fr.lylia.exeption.PersonneExisteDeja;

public class JdbsDaoGroupeDerbyTestTest {
	private GroupePersonnel g, creategroupe;
	private GroupeJdbcDaoDerby groupeder;
	private PERSONNE pRead, pCreate, personne, personne2, personne3;

	@Before
	public void setUp() throws Exception {
		g = new GroupePersonnel();
		creategroupe = null;
		pRead = null;
		personne = new PERSONNEBuilder("TOUAZI", "LYLIA").dateNaissance(LocalDate.parse("1997-04-22"))
				.fonction("directeur").build();
		personne2 = new PERSONNEBuilder("cc", "cv").dateNaissance(LocalDate.parse("1994-04-22")).fonction("vendeur")
				.build();
		groupeder = new GroupeJdbcDaoDerby();
	}

	@Test
	public void createTest() throws PersonneExisteDeja {
		g.AjouterPersonnel(personne);
		g.AjouterPersonnel(personne2);
		creategroupe = groupeder.create(g);
		assertEquals(creategroupe.getId(), g.getId());
		assertTrue(creategroupe.getlistepersonnel().size() == creategroupe.getlistepersonnel().size());
	}

}
