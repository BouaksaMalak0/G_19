package application;


import java.io.File;
import java.util.Date;

public class DossierMedical {
	 private static int nextnum = 1;
	private int numDossier;
	  private int idPatient;
	  private String diagnostic;
	  private Date dateConsultation;
	  private String observation;
	  private String examenMed;
	 // private Patient fichePatient; // Reference to Patient object
	  private File radios;
	    private File analyses;

	  // Constructor
	  public DossierMedical( int idPatient, String diagnostic, Date dateConsultation, 
	                        String observation, String examenMed, File radios, File analyses) {
	    this.numDossier = nextnum++;
	    this.idPatient = idPatient;
	    this.diagnostic = diagnostic;
	    this.dateConsultation = dateConsultation;
	    this.observation = observation;
	    this.examenMed = examenMed;
	    this.radios = radios;
	    this.analyses = analyses;
	  }

	  public int getNumDossier() {
		return numDossier;
	}

	public void setNumDossier(int munDossier) {
		this.numDossier = munDossier;
	}

	public int getIdPatient() {
		return idPatient;
	}

	public void setIdPatient(int idPatient) {
		this.idPatient = idPatient;
	}

	public String getDiagnostic() {
		return diagnostic;
	}

	public void setDiagnostic(String diagnostic) {
		this.diagnostic = diagnostic;
	}

	public Date getDateConsultation() {
		return dateConsultation;
	}

	public void setDateConsultation(Date dateConsultation) {
		this.dateConsultation = dateConsultation;
	}

	public String getObservation() {
		return observation;
	}

	public void setObservation(String observation) {
		this.observation = observation;
	}

	public String getExamenMed() {
		return examenMed;
	}

	public void setExamenMed(String examenMed) {
		this.examenMed = examenMed;
	}

	public File getRadios() {
		return radios;
	}

	public void setRadios(File radios) {
		this.radios = radios;
	}

	public File getAnalyses() {
		return analyses;
	}

	public void setAnalyses(File analyses) {
		this.analyses = analyses;
	}

	// Method to display medical record
	  public void afficherDossier() {
	    System.out.println("Dossier médical: " + numDossier);
	    //System.out.println("Patient: " + fichePatient.getNom() + " " + fichePatient.getPrenom()); // Access patient info through reference
	    System.out.println("Diagnostic: " + diagnostic);
	    System.out.println("Date de consultation: " + dateConsultation);
	    System.out.println("Observation: " + observation);
	    System.out.println("Examen médical: " + examenMed);
	    System.out.println("Radios: " + radios);
	    System.out.println("Analyses: " + analyses);
	  }

	  // Method to add note to observation
	  public void ajouterNote(String nouvelleNote) {
	    observation += "\n" + nouvelleNote;
	  }
	}

