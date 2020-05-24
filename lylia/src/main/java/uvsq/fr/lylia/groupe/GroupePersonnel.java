package uvsq.fr.lylia.groupe;

import java.util.ArrayList;
/**.
 * class GroupePersonnel.
 *
 * @author lylia touazi
 */
public class GroupePersonnel implements ComportementPersonne,
java.io.Serializable {
	/**constatnte mille.*/
	static final int MILLE = 1;
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	/**l'id du groupe.*/
	private String idGroupe;
	/**listepersonnel.*/
	private ArrayList<PERSONNE> listepersonnel;
	/**Constructeur GroupePersonnel.
	 * */
	public GroupePersonnel() {
		this.listepersonnel = new ArrayList<PERSONNE>();
		this.idGroupe = null;
	}
	/**Constructeur GroupePersonnel.
	 * @param listepersonnell la liste des personne
	 * */
	public GroupePersonnel(final ArrayList<PERSONNE>
	listepersonnell) {
		this.listepersonnel = listepersonnell;
	}
	/**Constructeur GroupePersonnel.
	 * @param idGroupee l'id groupe
	 * */
	public GroupePersonnel(final String idGroupee) {
		listepersonnel = new ArrayList<PERSONNE>();
		this.idGroupe = idGroupee;
	}
	/**methode AjouterPersonnel.
	 * @param p la personne a ajouter.*/
	public final void ajouterPersonnel(final PERSONNE p) {
		this.listepersonnel.add(p);
	}
	/**methode SuprimerPersonnel.
	 * @param p la personne a suprimer.*/
	public final void suprimerPersonnel(final PERSONNE p) {
		if (this.listepersonnel.contains(p)) {
			this.listepersonnel.remove(p);
		}
	}
	/**
	 * La methode getlistepersonnel.
	 *
	 * @return la liste des personne.
	 */
	public final ArrayList<PERSONNE> getlistepersonnel() {
		return this.listepersonnel;
	}
	/**methode getId.
	 * @return id groupe.*/
	public final String getId() {
		return idGroupe + " ";
	}
	/** la methode print. */
	public final void print() {
		// TODO Auto-generated method stub
		if (listepersonnel.size() > 0) {
			for (PERSONNE p : listepersonnel) {
				p.print();
			}
		} else {
			System.out.println("Le groupe est vide !");
		}
	}
}
