package application;


public class Ordonnance {
	 private static int nextIdord = 1;
	private int idOrdonnance; 
	  private String nomPrenomPatient; // String to store patient's full name
	  private String nomMedicament;
	  private String dosage;
	  private int dureeTraitement;

	  // Constructor
	  public Ordonnance( String nomPrenomPatient, String nomMedicament, 
	                     String dosage, int dureeTraitement) {
	    this.idOrdonnance = nextIdord++;
	    this.nomPrenomPatient = nomPrenomPatient;
	    this.nomMedicament = nomMedicament;
	    this.dosage = dosage;
	    this.dureeTraitement = dureeTraitement;
	  }

	  // Method to display prescription information
	  public void afficherOrdonnance() {
	    System.out.println("Ordonnance: " + idOrdonnance);
	    System.out.println("Patient: " + nomPrenomPatient);
	    System.out.println( nomMedicament + dosage);
	    System.out.println("Durée du traitement: " + dureeTraitement + " jours");
	  }

	public int getIdOrdonnance() {
		return idOrdonnance;
	}

	public void setIdOrdonnance(int idOrdonnance) {
		this.idOrdonnance = idOrdonnance;
	}

	public String getNomPrenomPatient() {
		return nomPrenomPatient;
	}

	public void setNomPrenomPatient(String nomPrenomPatient) {
		this.nomPrenomPatient = nomPrenomPatient;
	}

	public String getNomMedicament() {
		return nomMedicament;
	}

	public void setNomMedicament(String nomMedicament) {
		this.nomMedicament = nomMedicament;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public int getDureeTraitement() {
		return dureeTraitement;
	}

	public void setDureeTraitement(int dureeTraitement) {
		this.dureeTraitement = dureeTraitement;
	}
	
}
