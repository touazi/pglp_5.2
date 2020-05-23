package uvsq.fr.lylia;

import java.util.ArrayList;

public class GroupePersonnel implements ComportementPersonne, java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String IdGroupe;
	final ArrayList<PERSONNE> listepersonnel;

	public GroupePersonnel() {
		listepersonnel = new ArrayList<PERSONNE>();
		IdGroupe = null;
	}

	public GroupePersonnel(ArrayList<PERSONNE> listepersonnel) {
		this.listepersonnel = listepersonnel;
	}

	public GroupePersonnel(String IdGroupe) {
		listepersonnel = new ArrayList<PERSONNE>();
		this.IdGroupe = IdGroupe;
	}

	public void AjouterPersonnel(PERSONNE p) {
		this.listepersonnel.add(p);
	}

	public void SuprimerPersonnel(PERSONNE p) {
		if (this.listepersonnel.contains(p)) {
			this.listepersonnel.remove(p);
		}
	}

	public ArrayList<PERSONNE> getlistepersonnel() {
		return this.listepersonnel;
	}

	public String getId() {
		return IdGroupe + " ";
	}

	public void print() {
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