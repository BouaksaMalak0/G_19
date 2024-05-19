package application;


public class Finance {
    private double montant_jour;
    private double montant_mois;
    private double[] montants_mensuels; // Array to store monthly amounts
    private int current_month; 
    // Constructor
    public Finance()  { 
    	 this.montant_jour = 0;
         this.montant_mois = 0;
    	this.montants_mensuels = new double[12];
        this.current_month = 0;
    }

 // Method to add to the daily amount
    public void ajouterMontantJour(double montant) {
        this.montant_jour += montant;
    }
    public double getMontantJour() {
        return montant_jour;
    }

    public double getMontantMois() {
        return montant_mois;
    }
    public double[] getMontantsMensuels() {
        return montants_mensuels;
    }
  // Method to transfer daily amount to monthly amount
    public void transfererMontantJourVersMois() {
        this.montant_mois += this.montant_jour;
        this.montant_jour = 0; // Reset daily amount after transfer
    }
 // Method to handle end of month processing
    public void finDeMois() {
        this.montants_mensuels[this.current_month] = this.montant_mois;
        this.montant_mois = 0; // Reset monthly amount
        this.current_month = (this.current_month + 1) % 12; // Move to the next month
    }
    
    public void afficherDetailsFinancejour() {
        System.out.println( " Montant Jour: " + montant_jour + "da");}
    
    public void afficherDetailsFinancemois() {
        System.out.println( " Montant Mois: " + montant_mois + "da");
        }
 // Method to display finance details
    public void afficherDetailsFinance() {
        System.out.println( " Montant Jour: " + montant_jour + "da"+
                           ", Montant Mois: " + montant_mois + "da");
        System.out.println("Montants Mensuels: ");
        for (int i = 0; i < montants_mensuels.length; i++) {
            System.out.println("Mois " + (i + 1) + ": " + montants_mensuels[i] +"da");
        }
    }
}