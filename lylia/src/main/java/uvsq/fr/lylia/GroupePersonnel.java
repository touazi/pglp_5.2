package uvsq.fr.lylia;


import java.util.ArrayList;

public class GroupePersonnel implements 
ComportementPersonne, java.io.Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int  IdGroupe;
	final ArrayList<ComportementPersonne> listepersonnel ;
	public GroupePersonnel() {
		listepersonnel = new ArrayList<ComportementPersonne>();
		IdGroupe = 1 + (int)(Math.random() * ((1000 - 1) + 1));
		}
	public GroupePersonnel(ArrayList<ComportementPersonne> listepersonnel) {
		this.listepersonnel=listepersonnel; 
		}
	public void AjouterPersonnel(ComportementPersonne p) {
		this.listepersonnel.add(p); 
		}
	public void SuprimerPersonnel(ComportementPersonne p) {
		if(this.listepersonnel.contains(p)) {
			this.listepersonnel.remove(p);
			}
		}
	public ArrayList<ComportementPersonne> getlistepersonnel() {
		return this.listepersonnel;
		}
	public String getId() {
		return IdGroupe + " ";
	}
	public void print() {
		// TODO Auto-generated method stub
		for (ComportementPersonne p :listepersonnel) {
			p.print(); 
			}
		}
}