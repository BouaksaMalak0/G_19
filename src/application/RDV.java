package application;


import java.util.Date;

public class RDV {
	private int numRend;
	  private int idPatient;
	  private Date date;
	  private int heure;
	  private Patient patient; 
	  private String statut;
	private int minutes;
	

	  public RDV(int idPatient, Date date, int heure, int minutes, Patient patient, String statut) {
	        int nextNumRend = 0;
			this.numRend = nextNumRend++;
	        this.idPatient = idPatient;
	        this.date = date;
	        this.heure = heure;
	        this.minutes = minutes;
	        this.patient = patient;
	        this.statut = statut;
	    }
	 

	// Method to display appointment information
	  public void afficherRendezVous() {
	    System.out.println("Rendez-vous: " + numRend);
	    System.out.println("Patient: " + patient.getNom() + " " + patient.getPrenom()); // Access patient info through reference
	    System.out.println("Date: " + date);
	    System.out.println("Heure: " + heure+ ":" +minutes);
	    System.out.println("Statut: " + statut);
	  }

	  public int getNumRend() {
		return numRend;
	}

	public void setNumRend(int numRend) {
		this.numRend = numRend;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getHeure() {
		return heure;
	}

	public int getMinutes() {
		return minutes;
	}


	public void setMinutes(int minutes) {
		this.minutes = minutes;
	}


	public void setHeure(int heure) {
		this.heure = heure;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	// Method to confirm appointment
	 public void confirmerRDV() {
	   if (statut.equals("comfirmé")) {
	      System.out.println("Erreur: Le rendez-vous est déjà confirmé.");
	    } else {
	      statut = "confirmé";
	    }
	  }

	  // Method to cancel appointment
	  public void annulerRDV() {
	    if (statut.equals("annulé")) {
	    	System.out.println("Erreur: Le rendez-vous est déjà annulé .");
	      
	    } else {
	    	 statut = "annulé";
	    	
	    }
	  }
	  
	}

