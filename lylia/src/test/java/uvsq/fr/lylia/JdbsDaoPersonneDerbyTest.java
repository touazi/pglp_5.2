package uvsq.fr.lylia;

import static org.junit.Assert.*;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import uvsq.fr.lylia.PERSONNE.PERSONNEBuilder;
import uvsq.fr.lylia.exeption.PersonneDoncExistException;
import uvsq.fr.lylia.exeption.PersonneExisteDeja;
import uvsq.fr.lylia.exeption.TableExisteDeja;

public class JdbsDaoPersonneDerbyTest {

	private JdbsDaoPersonneDerby p;
	private PERSONNE  pRead,pCreate,personne,personne2,personne3;
	@Before
	public void setUp() throws Exception {
		pCreate=null;
		  pRead=null;
		  personne = new PERSONNEBuilder("TOUAZI", "LYLIA")
						.dateNaissance(LocalDate.parse("1997-04-22"))
						.fonction("directeur")
						.build();
		  personne2 = new PERSONNEBuilder("cc", "cv")
					.dateNaissance(LocalDate.parse("1994-04-22"))
					.fonction("vendeur")
					.build();
		  personne3 = new PERSONNEBuilder("hhhh", "hihi")
					.dateNaissance(LocalDate.parse("1912-12-12"))
					.fonction("directeur")
					.build();
		        p=new JdbsDaoPersonneDerby();
	}


	@Test(expected = TableExisteDeja.class)
	public void CeartionBDDREBYTest() throws TableExisteDeja {
		CeartionBDDREBY b= new CeartionBDDREBY();
    	b.createTables();
	}
	@Test(expected = PersonneDoncExistException.class)
	public void ReadExistpas() throws PersonneDoncExistException {
		p.read("allo");
		}
	@Test 
	public void createTest() throws PersonneExisteDeja {
		pCreate=p.create(personne);
		assertEquals(pCreate.getNom(),personne.getNom());
		assertEquals(pCreate.getDateNaissance(),personne.getDateNaissance());
		assertEquals(pCreate.getPrenom(),personne.getPrenom());
		assertEquals(pCreate.getFonction(),personne.getFonction());
		assertTrue(pCreate.getNumerosTelephone().size()== personne.getNumerosTelephone().size());
	}
	@Test 
	public void createReadTest() throws PersonneDoncExistException, PersonneExisteDeja {	
		pCreate = p.create(personne);
		pRead = p.read("TOUAZI");
		assertEquals(pCreate.getNom(),pRead.getNom());
		assertEquals(pCreate.getDateNaissance(),pRead.getDateNaissance());
		
	}
	@Test(expected = PersonneDoncExistException.class)
	public void createReadTestexption() throws PersonneDoncExistException, PersonneExisteDeja {
		pCreate = p.create(personne);
		pRead = p.read("lylia");
		}

	@Test(expected = PersonneDoncExistException.class)
	public void deleteTestexption() throws PersonneDoncExistException, PersonneExisteDeja {
		pCreate = p.create(personne3);
		pRead = p.read(personne3.getNom());
		p.delete(personne3);
		pRead = p.read(personne3.getNom());
		
		}
	@Test 
	public void updateTest() throws PersonneExisteDeja, PersonneDoncExistException {	
		pCreate = p.create(personne);
		assertEquals(pCreate.getNom(),"TOUAZI");
		personne2 =new PERSONNEBuilder("TOUAZI", "moi")
		.dateNaissance(LocalDate.parse("1994-04-22"))
		.fonction("vendeur")
		.build();
		pCreate = p.update(personne2);
		assertEquals(pCreate.getNom(),"TOUAZI");
		assertEquals(pCreate.getFonction().toString(),"vendeur");
		}
}


