package uvsq.fr.lylia;

public class DaoFactory {
	public static DAO<PERSONNE> getPersonneDAO ( ) {
		return new PersonneDaO ( ) ;
		}
	public static DAO<GroupePersonnel> getGroupeDAO ( ) {
		return new GroupeDao ( ) ;
		}

}
