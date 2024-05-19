package application;

import java.util.Date;
import java.util.List;

public class Patient {
	 private static int nextId = 1;
	private int idPatient;
	  private String nom;
	  private String prenom;
	  private Date dateNaissance; // Use LocalDate for date representation
	  private String adresse;
	  private String telephone;
	  
	 

	  // Constructor
	  public Patient( String nom, String prenom, Date dateNaissance, String adresse, 
	                 String telephone, String email) {
	    this.idPatient= nextId++;
	    this.nom = nom;
	    this.prenom = prenom;
	    this.dateNaissance = dateNaissance;
	    this.adresse = adresse;
	    this.telephone = telephone;
	    
	    
	  }

	  // Method to display patient information
	  public void afficherInformations() {
		System.out.println("Id du patient:"+ idPatient);
	    System.out.println("Patient: " + nom + " " + prenom);
	    System.out.println("Date de naissance: " + dateNaissance);
	    System.out.println("Adresse: " + adresse);
	    System.out.println("Téléphone: " + telephone);
	    
	  }

	  // Method to modify patient information
	  public void modifierInformations(String nouveauNom, String nouveauPrenom, Date nouvelleDateNaissance, 
	                                    String nouvelleAdresse, String nouveauTelephone, String nouveauEmail) {
	    this.nom = nouveauNom;
	    this.prenom = nouveauPrenom;
	    this.dateNaissance = nouvelleDateNaissance;
	    this.adresse = nouvelleAdresse;
	    this.telephone = nouveauTelephone;
	    
	  }

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
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

	 // Method to add an appointment
    public static void ajouterRdv(List<RDV> rdvs, RDV nouveauRdv) {
        rdvs.add(nouveauRdv);
        System.out.println("Rendez-vous ajouté pour le patient: " + nouveauRdv.getPatient().getNom() + " " + nouveauRdv.getPatient().getPrenom());
    }

    // Method to delete a patient
    public static void supprimerPatient(List<Patient> patients, int idPatient) {
        for (int i = 0; i < patients.size(); i++) {
            if (patients.get(i).getIdPatient() == idPatient) {
                patients.remove(i);
                System.out.println("Patient supprimé avec ID: " + idPatient);
                break;
            }
        }
    }

   
   
    }

