package uvsq.fr.lylia;

public class DaoFactory {
	public final DAO<PERSONNE> getPersonneDAO() {
		return new JdbsDaoPersonneDerby();
	}

	public static DAO<GroupePersonnel> getGroupeDAO() {
		return new GroupeJdbcDaoDerby();
	}

}
