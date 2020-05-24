package uvsq.fr.lylia.dao;

import java.io.Serializable;

import uvsq.fr.lylia.groupe.GroupePersonnel;

/**
 * class GroupeDao.
 *
 * @author lylia touazi
 * @param <T> object.
 */
public class GroupeDao<T extends Serializable>
extends Serialization<GroupePersonnel>
implements DAO<GroupePersonnel> {
	/**
	 * methode create.
	 *
	 * @param obj groupe a créee
	 * @return groupe crée
	 */
	@Override
	public final GroupePersonnel create(final GroupePersonnel obj) {
		// TODO Auto-generated method stub
		return createFile(obj, obj.getId());
	}

	/**
	 * methode create.
	 *
	 * @param id nom de la le groupe
	 * @return groupe trouver
	 */
	@Override
	public final GroupePersonnel read(final String id) {
		// TODO Auto-generated method stub
		return readFile(id);
	}

	/**
	 * methode update.
	 *
	 * @param obj le groupe à modifier
	 * @return le groupe modifier
	 */
	@Override
	public final GroupePersonnel update(final GroupePersonnel obj) {
		// TODO Auto-generated method stub
		return updateFile(obj, obj.getId());
	}

	/**
	 * methode delete.
	 *
	 * @param obj le groupe à suprimer
	 */
	@Override
	public final void delete(final GroupePersonnel obj) {
		// TODO Auto-generated method stub
		deleteFile(obj.getId());

	}

}
