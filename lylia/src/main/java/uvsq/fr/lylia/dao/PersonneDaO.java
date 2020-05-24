package uvsq.fr.lylia.dao;
import java.io.Serializable;

import uvsq.fr.lylia.groupe.PERSONNE;

/**
 * class PersonneDaO.
 *
 * @author lylia touazi
 * @param <T> obj
 */
public class PersonneDaO<T extends Serializable>
extends Serialization<PERSONNE> implements DAO<PERSONNE> {
/**
 * methode create.
 *
 * @param obj personne a créee
 * @return personne crée
 */
@Override
public final PERSONNE create(final PERSONNE obj) {
// TODO Auto-generated method stub
return createFile(obj, obj.getNom());
}

/**
 * methode create.
 *
 * @param id nom de la personne
 * @return personne trouver
 */
@Override
public final PERSONNE read(final String id) {
// TODO Auto-generated method stub
return readFile(id);
}

/**
 * methode update.
 *
 * @param obj la personne à modifier
 * @return personne modifier
 */
@Override
public final PERSONNE update(final PERSONNE obj) {
// TODO Auto-generated method stub
return updateFile(obj, obj.getNom());
}

/**
 * methode delete.
 *
 * @param obj la personne à suprimer
 */
@Override
public final void delete(final PERSONNE obj) {
// TODO Auto-generated method stub
deleteFile(obj.getNom());
}

}
