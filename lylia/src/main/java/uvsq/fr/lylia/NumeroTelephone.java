package uvsq.fr.lylia;
/**
 * <b>"L'implementation de la class  NumeroTelephone.</b>
 * Numero Telephone a :
 * <ul>
 * <li>Type</li>
 * <li>telephone</li>
 * </ul>
 * Cette class  implemente Serializable.
 * @author TOUAZI,Lylia
 */
public class NumeroTelephone implements java.io.Serializable {
	/**
	 *.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Le type du numéro de tel.
	 * @see NumeroTelephone#NumeroTelephone(Type,String)
	 */
	private final Type type;
	/**
	 * Le numéro de telephone.
	 * @see NumeroTelephone#NumeroTelephone(Type,String)
	 */
	private final String telephone;
	/**
	 * le constructeur NumeroTelephone .
	 * @param type
	 * Le type du numéro de tel.
	 * @param telephone
	 * Le numéro de telephone.
	 */
	public NumeroTelephone(Type type, String telephone) {
		this.type = type;
		this.telephone = telephone;
	}
/**
 * Méthode getType.
 * @return
 *Le type du numéro de tel.
 **/
	public final Type getType() {
		return type;
	}
	/**
	 * Méthode getTelephone.
	 * @return
	 *Le numéro de tel.
	 **/
	public final String getTelephone() {
		return telephone;
	}
}
