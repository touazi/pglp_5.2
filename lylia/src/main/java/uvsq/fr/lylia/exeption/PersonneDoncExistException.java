package uvsq.fr.lylia.exeption;

/**.
 * <b>"l'exeption PersonneDoncExistException."</b>
 * @author TOUAZI,Lylia
 */
public class PersonneDoncExistException extends Exception {
/**
 *
 */
private static final long serialVersionUID = 1L;
/**
 * * @param message message d'erreur.
 */
public PersonneDoncExistException(final String message) {
super(message);
}
}
