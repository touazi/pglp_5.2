package uvsq.fr.lylia.groupe;

/**
 * <b>"L'implementation de la class NumeroTelephone.</b>
 *  Numero Telephone a :
 * <ul>
 * <li>Type</li>
 * <li>telephone</li>
 * </ul>
 * Cette class implemente Serializable.
 *
 * @author TOUAZI,Lylia
 */
public class NumeroTelephone implements
java.io.Serializable, ComportementPersonne {
/**
 * CREATE TABLE NumeroTelephone (. type VARCHAR(100) NOT NULL,
 *  telephone
 * VARCHAR(100) PRIMARY KEY ));
 */
private static final long serialVersionUID = 1L;
/**
 * Le type du numéro de tel.
 *
 * @see NumeroTelephone#NumeroTelephone(Type,String)
 */
private final Type type;
/**
 * Le numéro de telephone.
 *
 * @see NumeroTelephone#NumeroTelephone(Type,String)
 */
private final String telephone;

/**
 * le constructeur NumeroTelephone .
 *
 * @param typee       Le type du numéro de tel.
 * @param telephonee Le numéro de telephone.
 */
public NumeroTelephone(final Type typee,
		final String telephonee) {
	this.type = typee;
	this.telephone = telephonee;
}

/**NumeroTelephone.
 * @param s type numéro.
 * @param telephonee le numero telephonee.*/
public NumeroTelephone(final String s,
		final String telephonee) {
	Type f = null;
	if (s.contentEquals("fixperso")) {
		f = Type.fixperso;
	}
	if (s.contentEquals("fixpro")) {
		f = Type.fixpro;

	}
	if (s.contentEquals("portable")) {
		f = Type.portable;

	}
	this.type = f;
	this.telephone = telephonee;
}

/**
 * Méthode getType.
 *
 * @return Le type du numéro de tel.
 **/
public final Type getType() {
	return type;
}

/**
 * Méthode getTelephone.
 *
 * @return Le numéro de tel.
 **/
public final String getTelephone() {
	return telephone;
}

@Override
public final void print() {
	System.out.println("Mon numéro de  "
+ this.type + " est  " + this.telephone);

}
}
