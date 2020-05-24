package uvsq.fr.lylia.dao;

import uvsq.fr.lylia.exeption.PersonneDoncExistException;
import uvsq.fr.lylia.exeption.PersonneExisteDeja;

/**
 * interface DAO.
 *
 * @author Lylia touazi
 * @param <T> une personne ou un groupe
 */
public interface DAO<T> {
	/**
	 * *methode create. @param obj l'object qui sera crée.
	 *  @return un objet de type
	 * @throws PersonneExisteDeja lever PersonneExisteDeja
	 */
	T create(T obj) throws PersonneExisteDeja;

	/**
	 * methode read.
	 *
	 * @param id le nom du fichier qui sera lu.
	 * @return un objet de type T
	 * @throws PersonneDoncExistException lever
	 * PersonneDoncExistException
	 */
	T read(String id) throws PersonneDoncExistException;

	/**
	 * methode update.
	 *
	 * @param obj l'object qui sera modifier.
	 * @return un objet de type T
	 * @throws PersonneDoncExistException lever
	 * PersonneDoncExistException
	 */
	T update(T obj) throws PersonneDoncExistException;

	/**
	 * methode delete.
	 *
	 * @param obj l'object qui sera suprimer.
	 * @throws PersonneDoncExistException lever une exption
	 * PersonneDoncExistException
	 */
	void delete(T obj) throws PersonneDoncExistException;
}
