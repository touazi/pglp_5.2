package uvsq.fr.lylia.exeption;

/**.
 * <b>"l'exeption PersonneExisteDeja."</b>
 * @author TOUAZI,Lylia
 */
public class PersonneExisteDeja extends Exception {
/**.
*
*/
private static final long serialVersionUID = 1L;
/**
 * * @param message message d'erreur.
 */
public PersonneExisteDeja(final String message) {
super(message);
}
}
