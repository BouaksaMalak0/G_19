package application;
import java.util.Date;

public class Certificatmedical {
	 private String typeCertificat; // "Absence", "Aptitude", etc.
	  private String nomPrenomPatient; // String to store patient's full name
	  private String nomMedecin;
	  private Date datecert ;
	  private String descriptionCondition;
	 

	  // Constructor
	  public Certificatmedical(String typeCertificat, String nomPrenomPatient, String nomMedecin, Date datecert, 
	                           String descriptionCondition) {
	    this.typeCertificat = typeCertificat;
	    this.nomPrenomPatient = nomPrenomPatient;
	    this.nomMedecin = nomMedecin;
	    this.datecert = datecert;
	    this.descriptionCondition = descriptionCondition;
	   
	  }

	  public String getTypeCertificat() {
		return typeCertificat;
	}

	public void setTypeCertificat(String typeCertificat) {
		this.typeCertificat = typeCertificat;
	}

	public String getNomPrenomPatient() {
		return nomPrenomPatient;
	}

	public void setNomPrenomPatient(String nomPrenomPatient) {
		this.nomPrenomPatient = nomPrenomPatient;
	}

	public String getNomMedecin() {
		return nomMedecin;
	}

	public void setNomMedecin(String nomMedecin) {
		this.nomMedecin = nomMedecin;
	}

	public Date getDate() {
		return datecert;
	}

	public void setDate(Date datecert) {
		this.datecert = datecert;
	}

	public String getDescriptionCondition() {
		return descriptionCondition;
	}

	public void setDescriptionCondition(String descriptionCondition) {
		this.descriptionCondition = descriptionCondition;
	}

	
	// Method to display medical certificate information
	  public void afficherCertificat() {
	    System.out.println("Certificat médical: " + typeCertificat);
	    System.out.println("Patient: " + nomPrenomPatient);
	    System.out.println("Médecin: " + nomMedecin);
	    System.out.println("Date: " + datecert);
	    System.out.println("Description de la condition: " + descriptionCondition);
	    
	  }
	}


