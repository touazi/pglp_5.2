package uvsq.fr.lylia.dao;

import uvsq.fr.lylia.groupe.GroupePersonnel;
import uvsq.fr.lylia.groupe.PERSONNE;

/**
 * interface DaoFactory.
 *
 * @author Lylia touazi
 */
public class DaoFactory {
	/**
	 * getPersonneDAO.
	 *
	 * @return getPersonneDAO.
	 */
	public final DAO<PERSONNE> getPersonneDAO() {
		return new JdbsDaoPersonneDerby();
	}

	/**
	 * getGroupeDAO.
	 *
	 * @return getGroupeDAO.
	 */
	public static DAO<GroupePersonnel> getGroupeDAO() {
		return new GroupeJdbcDaoDerby();
	}

}
