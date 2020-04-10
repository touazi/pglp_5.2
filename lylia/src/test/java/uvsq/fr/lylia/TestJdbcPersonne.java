package uvsq.fr.lylia;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import uvsq.fr.lylia.PERSONNE.PERSONNEBuilder;
import uvsq.fr.lylia.exeption.PersonneDoncExistException;
import uvsq.fr.lylia.exeption.PersonneExisteDeja;

public class TestJdbcPersonne {

	private JdbsDaoPersonne p;
	private PERSONNE  pRead,pCreate,personne;
	@Before
	public void setUp() throws Exception {
		pCreate=null;
		  pRead=null;
		  personne = new PERSONNEBuilder("TOUAZI", "LYLIA")
						.dateNaissance(LocalDate.parse("1997-04-22"))
						.fonction("directeur")
						.build();
		        p=new JdbsDaoPersonne();
	}



	@Test(expected = PersonneDoncExistException.class)
	public void ReadExistpas() throws PersonneDoncExistException {
		p.read("allo");
		}
	@Test 
	public void createTest() {
		pCreate=p.create(personne);
		assertEquals(pCreate.getNom(),personne.getNom());
		assertEquals(pCreate.getDateNaissance(),personne.getDateNaissance());
		assertEquals(pCreate.getPrenom(),personne.getPrenom());
		assertEquals(pCreate.getFonction(),personne.getFonction());
		assertTrue(pCreate.getNumerosTelephone().size()== personne.getNumerosTelephone().size());
	}
	@Test 
	public void createReadTest() throws PersonneDoncExistException {	
		pCreate = p.create(personne);
		pRead = p.read("TOUAZI");
		assertEquals(pCreate.getNom(),pRead.getNom());
		assertEquals(pCreate.getDateNaissance(),pRead.getDateNaissance());
		
	}
	@Test(expected = PersonneDoncExistException.class)
	public void createReadTestexption() throws PersonneDoncExistException {
		pCreate = p.create(personne);
		pRead = p.read("lylia");
		}
}
