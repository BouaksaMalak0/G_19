package application;


import java.util.Date;
import java.util.List;

public class Fichepatient {
	 private static int nextnumfiche = 1;
	private int numFiche;
	  private String nom;
	  private String prenom;
	  private Date dateNaissance;
	  private String adresse;
	  private String telephone;
	  private String mail;
	  private String groupage; // Blood type
	  private int age;
	  private double poids;
	  private double taille;
	  private String antecedentsChirurgicaux; // Surgical history
	  private String antecedentsMedicaux; // Medical history

	  // Constructor
	  //public Fichepatient( String nom, String prenom, Date dateNaissance, String adresse, 
	                      // String telephone, String mail, String groupage, int age, double poids, double taille, 
	                       //String antecedentsChirurgicaux, String antecedentsMedicaux) {
	    //this.numFiche = nextnumfiche++;
	    //this.nom = nom;
	   // this.prenom = prenom;
	    //this.dateNaissance = dateNaissance;
	    //this.adresse = adresse;
	   // this.telephone = telephone;
	    //this.mail=mail;
	    //this.groupage = groupage;
	    //this.age = age;
	    //this.poids = poids;
	    //this.taille = taille;
	    //this.antecedentsChirurgicaux = antecedentsChirurgicaux;
	    //this.antecedentsMedicaux = antecedentsMedicaux;
	  //}

	 

	public Fichepatient(String nom1, String prenom1, Date dateNaissance1, String adresse1, String telephone1,
			String mail1, String groupage, int age, double poids, double taille, String antecedentsChirurgicaux,
			String antecedentsMedicaux) {
		this.numFiche = nextnumfiche++;
	    this.nom = nom1;
	    this.prenom = prenom1;
	    this.dateNaissance = dateNaissance1;
	    this.adresse = adresse1;
	    this.telephone = telephone1;
	    this.mail=mail1;
	    this.groupage = groupage;
	    this.age = age;
	    this.poids = poids;
	    this.taille = taille;
	    this.antecedentsChirurgicaux = antecedentsChirurgicaux;
	    this.antecedentsMedicaux = antecedentsMedicaux;
		
	}



	// Method to display patient information
	  public void afficherInformations() {
	    System.out.println("Fiche Patient:");
	    System.out.println("Numéro de fiche: " + numFiche);
	    System.out.println("Nom: " + nom + " " + prenom);
	    System.out.println("Date de naissance: " + dateNaissance);
	    System.out.println("Adresse: " + adresse);
	    System.out.println("Téléphone: " + telephone);
	    System.out.println("mail: " + mail);
	    System.out.println("Groupe sanguin: " + groupage);
	    System.out.println("Âge: " + age);
	    System.out.println("Poids: " + poids + " kg");
	    System.out.println("Taille: " + taille + " cm");
	    System.out.println("Antécédents chirurgicaux: " + antecedentsChirurgicaux);
	    System.out.println("Antécédents médicaux: " + antecedentsMedicaux);
	  }

	  // Method to update patient information
	  public void modifierInformations(String nouveauNom, String nouveauPrenom, Date nouvelleDateNaissance, 
	                                    String nouvelleAdresse, String nouveauTelephone, String nouveauGroupage, 
	                                    int nouvelAge, double nouveauPoids, double nouvelleTaille, 
	                                    String nouveauxAntecedentsChirurgicaux, String nouveauxAntecedentsMedicaux) {
	    this.nom = nouveauNom;
	    this.prenom = nouveauPrenom;
	    this.dateNaissance = nouvelleDateNaissance;
	    this.adresse = nouvelleAdresse;
	    this.telephone = nouveauTelephone;
	    this.groupage = nouveauGroupage;
	    this.age = nouvelAge;
	    this.poids = nouveauPoids;
	    this.taille = nouvelleTaille;
	    this.antecedentsChirurgicaux = nouveauxAntecedentsChirurgicaux;
	    this.antecedentsMedicaux = nouveauxAntecedentsMedicaux;
	  }
	  public int getNumFiche() {
		return numFiche;
	}

	public void setNumFiche(int numFiche) {
		this.numFiche = numFiche;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getGroupage() {
		return groupage;
	}

	public void setGroupage(String groupage) {
		this.groupage = groupage;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public double getPoids() {
		return poids;
	}

	public void setPoids(double poids) {
		this.poids = poids;
	}

	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	public String getAntecedentsChirurgicaux() {
		return antecedentsChirurgicaux;
	}

	public void setAntecedentsChirurgicaux(String antecedentsChirurgicaux) {
		this.antecedentsChirurgicaux = antecedentsChirurgicaux;
	}

	public String getAntecedentsMedicaux() {
		return antecedentsMedicaux;
	}

	public void setAntecedentsMedicaux(String antecedentsMedicaux) {
		this.antecedentsMedicaux = antecedentsMedicaux;
	}

	public static Fichepatient rechercherParNom(List<Fichepatient> patients, String nom) {
		    for (Fichepatient patient : patients) {
		        if (patient.getNom().equalsIgnoreCase(nom) || patient.getPrenom().equalsIgnoreCase(nom)) {
		            return patient;
		        }
		    }
		    return null; // Patient not found
		}
	  public static void supprimerPatient(List<Fichepatient> patients, int numFiche) {
		    for (int i = 0; i < patients.size(); i++) {
		        if (patients.get(i).getNumFiche() == numFiche) {
		            patients.remove(i);
		            break;
		        }
		    }
		}
	  public static boolean patientExiste(List<Fichepatient> patients, String nom, String prenom) {
		    for (Fichepatient patient : patients) {
		        if (patient.getNom().equalsIgnoreCase(nom) && patient.getPrenom().equalsIgnoreCase(prenom)) {
		            return true;
		        }
		    }
		    return false;
		}
	

	  
}
