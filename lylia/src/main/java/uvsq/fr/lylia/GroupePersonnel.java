package uvsq.fr.lylia;


import java.util.ArrayList;

public class GroupePersonnel implements 
ComportementPersonne, java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int  IdGroupe;
	final ArrayList<PERSONNE> listepersonnel ;
	public GroupePersonnel() {
		listepersonnel = new ArrayList<PERSONNE>();
		IdGroupe = 1 + (int)(Math.random() * ((1000 - 1) + 1));
		}
	public GroupePersonnel(ArrayList<PERSONNE> listepersonnel) {
		this.listepersonnel=listepersonnel; 
		}
	public GroupePersonnel(int  IdGroupe) {
		listepersonnel = new ArrayList<PERSONNE>();
		this.IdGroupe=IdGroupe; 
		}
	public void AjouterPersonnel(PERSONNE p) {
		this.listepersonnel.add(p); 
		}
	public void SuprimerPersonnel(PERSONNE p) {
		if(this.listepersonnel.contains(p)) {
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
		for (PERSONNE p :listepersonnel) {
			p.print(); 
			}
		}
}