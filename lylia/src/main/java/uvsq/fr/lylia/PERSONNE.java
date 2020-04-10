package uvsq.fr.lylia;
import  uvsq.fr.lylia.NumeroTelephone;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
/**
 * <b>"L'implementation de la class imuable personne.</b>
 * une personne a :
 * <ul>
 * <li>nom</li>
 * <li>prenom</li>
 * <li>fonction</li>
 * <li>dateNaissance</li>
 * <li>numerosTelephone:il peut avoir plusieur numerosTelephone</li>
 * </ul>
 * Cette class  du  Pattern build.
 * @author TOUAZI,Lylia
 */

public final class PERSONNE implements ComportementPersonne,
java.io.Serializable {
/**
 * * a default serial version ID.
*/
	private static final long serialVersionUID = 1L;
/**
 * Le nom de la personne.
 *
 * */
	private final String nom;
/**
 * Le prenom de la personne.
 *
 * */
	private final String prenom;
/**
 * la fonction de la personne.
 *
 * */
	private final fonction fonction;
/**
 * La date de naissance de la personne.
 * */
	private final LocalDate dateNaissance;
/**
 * La liste des numéro de telephone de la personne.
 * */
	private final List<NumeroTelephone> numerosTelephone;
/**
 * <b>"L'implementation de la class builder personne.</b>
 **/
	public static class PERSONNEBuilder {
		/**
		 * Le nom de la personne.
		 * */
		private final String nom;
		/**
		 * Le prenom de la personne.
		 * */
		private final String prenom;
		/**
		 * La date de naissance de la personne.
		 * */
		private LocalDate dateNaissance = null;
		/**
		 * La liste des numéro de telephone de la personne.
		 * */
		private List<NumeroTelephone> numerosTelephone = new ArrayList<NumeroTelephone>();
		/**
		 * la fonction de la personne.
		 * */
		private fonction fonction;
	    /**
	     * Constructeur PERSONNEBuilder.
	     * <p>
	     * A la construction builder personne pour le nom et le prenom.
	     * </p>
	     * * @param  nom
	     * Le nom de la PERSONNEBuilder.
	     * @param prenom
	     * Le prenom de la PERSONNEBuilder.
	     */
		public PERSONNEBuilder(String nom, String prenom) {
			this.prenom = prenom;
			this.nom = nom;
			}
	    /**
	     * méthode fonction.
	     * * @param fonction
	     * La fonction de la PERSONNEBuilder.
	     * @return
	     * PERSONNEBuilder.
	     */
		/*CREATE TABLE Personne (
					nom VARCHAR(100) not null,
					prenom VARCHAR(100) NOT NULL,
    				fonction VARCHAR(100) NOT NULL,
    				datenaisssance Date NOT NULL,
    PRIMARY KEY(nom,prenom)
					 )*/
		public PERSONNEBuilder fonction(fonction fonction) {
			this.fonction = fonction;
			return this;
			}
		public PERSONNEBuilder fonction(String s) {
			if(s.contentEquals("directeur")) {
				fonction f=uvsq.fr.lylia.fonction.directeur;
				this.fonction = f;
				
			}
			if(s.contentEquals("charger_de_mission")) {
				fonction f=uvsq.fr.lylia.fonction.charger_de_mission;
				this.fonction = f;
				
			}
			if(s.contentEquals("emplyer")) {
				fonction f=uvsq.fr.lylia.fonction.emplyer;
				this.fonction = f;
				
			}
			if(s.contentEquals("vendeur")) {
				fonction f=uvsq.fr.lylia.fonction.vendeur;
				this.fonction = f;
				
			}
			return this;
		}
	    /**
	     * méthode dateNaissance.
	     * * @param dateNaissance
	     * La date Naissance de la PERSONNEBuilder.
	     * @return
	     * PERSONNEBuilder.
	     */
		public PERSONNEBuilder dateNaissance(LocalDate dateNaissance) {
			this.dateNaissance = dateNaissance;
			return this;
			}
		  /**
	     * méthode addNumeroTelephone.
	     * * @param numeroTelephone
	     * Le numero Telephone de la PERSONNEBuilder.
	     * @return
	     * PERSONNEBuilder.
	     */
		public PERSONNEBuilder addNumeroTelephone(NumeroTelephone numeroTelephone) {
			this.numerosTelephone.add(numeroTelephone);
			return this;
			}
		public PERSONNE build() {
			return new PERSONNE(this);
			}

		}
	/**Constructeur PERSONNE.
	 * cette méthode renvoie un nouvel objet de la classe personne,il copie les valeurs des champs du générateur vers lui-même..
	 * @param builder
	 * c'est l'objet pour le quel on veux crée un nouveau objet.
	 * */
	private PERSONNE(PERSONNEBuilder builder) {
		nom = builder.nom;
		prenom = builder.prenom;
		fonction = builder.fonction;
		dateNaissance = builder.dateNaissance;
		numerosTelephone = builder.numerosTelephone;
		}
	/**La methode getNom.
	 * @return
	 * le getNom de la personne.
	 * */
	public String getNom() {
		return nom;
		}
	/**La methode getPrenom.
	 * @return
	 * le premon de la personne.
	 * */
	public String getPrenom() {
		return prenom;
		}
	/**La methode getFonction.
	 * @return
	 * la fonction de la personne.
	 * */
	public fonction getFonction() {
		return fonction;
		}
	/**La methode getDateNaissance.
	 * @return
	 * la date de naissance de la personne.
	 * */
	public LocalDate getDateNaissance() {
		return dateNaissance;
		}
	/**La methode getNumerosTelephone.
	 * @return
	 * la liste des numéro de télephone de la personne.*/
	public List<NumeroTelephone> getNumerosTelephone() {
		return numerosTelephone;
		}
	/**la methode print.*/
	public void print() {
		// TODO Auto-generated method stub
		NumeroTelephone   n = null ;
		System.out.println("  Je suis "  +  this.nom  + " " + this.prenom + "  née le  "  + 
		this.dateNaissance  +  " et je travaille comme " + this.fonction  );
		System.out.println("J'ai " + this.getNumerosTelephone().size() + " numéro.");
	if( this.getNumerosTelephone().size()>0) {
		List<NumeroTelephone> liste=this.getNumerosTelephone();
		for(Iterator<NumeroTelephone> it=liste.iterator(); it.hasNext();)
			{n= it.next();
            n.print();}}
	}
 

	}