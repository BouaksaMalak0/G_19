package application;

import java.text.ParseException;
import java.io.File;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import application.DBConnection;


public class Main {

  

	public static void main(String[] args){
		Connection connection = DBConnection.getConnection();

		if (connection != null) {
		  System.out.println("Connected to database!");

		  try {
		    // Your database operations here
		    // For example, a simple query:
		    Statement statement = connection.createStatement();
		    ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table_name");

		    // Process the results (assuming you have results)
		    while (resultSet.next()) {
		      // Access data from each row using methods like getInt(), getString(), etc.
		      int id = resultSet.getInt("id");
		      String name = resultSet.getString("name");
		      // ... process data further ...
		    }

		    resultSet.close();
		    statement.close();
		  } catch (SQLException e) {
		    e.printStackTrace();
		    System.out.println("Error performing database operation!");
		  } finally {
		    try {
		      if (connection != null) {
		        connection.close();
		        System.out.println("Connection closed.");
		      }
		    } catch (SQLException e) {
		      e.printStackTrace();
		      System.out.println("Error closing connection!");
		    }
		  }
		} else {
		  System.out.println("Failed to connect to database!");
		}

        Scanner scanner = new Scanner(System.in);
        
     // Liste pour stocker les patients
        List<Patient> patients = new ArrayList<>();
        // Liste pour stocker les rendez-vous
        List<RDV> rdvs = new ArrayList<>();
     // Liste pour stocker les fiches de patients 
        List<Fichepatient> fichespatients = new ArrayList<>();
     // Liste pour stocker les dossiers medicaux
        List<DossierMedical> dossiersmedicaux = new ArrayList<>();
     // Liste pour stocker les ordonances 
        List<Ordonnance> ordonnances = new ArrayList<>();
        // Liste pour stocker les certificats
        List<Certificatmedical> certificats = new ArrayList<>();
     // Objet Finance pour suivre les finances
        Finance finance = new Finance();
        char choixprcpl;
        
        do {
            System.out.println("Bienvenue dans le système de gestion du cabinet médical.");
            System.out.println("Gestion des patients:");
            System.out.println("A.ajouter un nouveau patient et rdv pour ce patient");
            System.out.println("B.creer une fiche patient et un dossier medical pour un patient");
            System.out.println("C.afficher la liste des patients");
            System.out.println("D.generer une ordonance");
            System.out.println("E.generer un certificat medical ");
            System.out.println("F.voir la fiche medical d'un patient");
            System.out.println("G.voir le dossier medical d'un patient");
        
            System.out.println("Gestion des rdvs:");
            System.out.println("H.ajouter un rdv a un patient existant deja");
            System.out.println("I.afficher tous les rdvs d'aujourd'ui");
            System.out.println("J.afficher tous les rdvs a venir");
        	System.out.println("K.confirmer le rdv d'un patient");
        	System.out.println("L.annuler le rdv d'un patient ");
        
            System.out.println("Finance:");
            System.out.println("M.afficher le details financier du jour");
            System.out.println("N.afficher le details financier du mois");
        	System.out.println("O.afficher le details financier de l'annee");
        	System.out.println("P.c'est la fin de la journee transferer le montant du jour vers montant du mois");
        	System.out.println("Q.c'est la fin du mois transferer le montant du mois vers montant de l'annee");
           
            choixprcpl = scanner.nextLine().charAt(0);
            
            switch(choixprcpl) {
                  case 'A':
            	   // Saisie des informations du patient
            	   System.out.println("l'ajout d'un nouveau patient");
                   System.out.println("Entrez le nom du patient : ");
                   String nom = scanner.nextLine();

                   System.out.println("Entrez le prénom du patient : ");
                   String prenom = scanner.nextLine();
                   Date dateNaissance = null;
                   System.out.println("Entrez la date de naissance du patient (format : JJ/MM/AAAA) : ");
                   String dateNaissanceStr = scanner.nextLine();
                   SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                  
       			try {
                       dateNaissance = sdf.parse(dateNaissanceStr);
                   } catch (ParseException e) {
                       System.out.println("Format de date incorrect. Assurez-vous d'utiliser le format JJ/MM/AAAA.");
                   }

                   System.out.println("Entrez l'adresse du patient : ");
                   String adresse = scanner.nextLine();

                   System.out.println("Entrez le numéro de téléphone du patient : ");
                   String telephone = scanner.nextLine();
                   
                   System.out.println("Entrez le mail du patient : ");
                   String mail= scanner.nextLine();


                   // Création du patient et ajout à la liste
                   Patient patient = new Patient(nom, prenom, dateNaissance, adresse, telephone,mail);
                   patients.add(patient);
                   System.out.println("Patient ajouté avec succès.");
               
                  
                   System.out.println("maintenant veillez lui prendre un rdv");
                   System.out.println("Entrez la date du rendez-vous (format : JJ/MM/AAAA) : ");
                   String dateRDVStr = scanner.nextLine();

                   Date dateRDV = null;
                   try {
                       dateRDV = sdf.parse(dateRDVStr);
                   } catch (ParseException e) {
                       System.out.println("Format de date incorrect. Assurez-vous d'utiliser le format JJ/MM/AAAA.");
                   }

                   System.out.println("Entrez l'heure du rendez-vous (format : HH:MM) : ");
                   String heureRDVStr = scanner.nextLine();

                   String[] heureMinutes = heureRDVStr.split(":");
                   int heure = Integer.parseInt(heureMinutes[0]);
                   int minutes = Integer.parseInt(heureMinutes[1]);

                   String status = "en cours";
       			// Création du rendez-vous et ajout à la liste
                   RDV rdv = new RDV(patient.getIdPatient(), dateRDV, heure, minutes, patient, status);
                   rdvs.add(rdv);
                   System.out.println("Rendez-vous ajouté avec succès.");
                   
                   break;
                   
               case 'B' :
                   // Saisie des informations du patient
                       System.out.println("Entrez le nom du patient : ");
                       String nom1 = scanner.nextLine();

                       System.out.println("Entrez le prénom du patient : ");
                       String prenom1 = scanner.nextLine();
                       Date dateNaissance1 = null;
                       System.out.println("Entrez la date de naissance du patient (format : JJ/MM/AAAA) : ");
                       String dateNaissanceStr1 = scanner.nextLine();
                       SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
                       
                       
           			try {
                           dateNaissance1 = sdf1.parse(dateNaissanceStr1);
                       } catch (ParseException e) {
                           System.out.println("Format de date incorrect. Assurez-vous d'utiliser le format JJ/MM/AAAA.");
                       }

                       System.out.println("Entrez l'adresse du patient : ");
                       String adresse1 = scanner.nextLine();

                       System.out.println("Entrez le numéro de téléphone du patient : ");
                       String telephone1 = scanner.nextLine();
                       
                       System.out.println("Entrez le mail du patient : ");
                       String mail1= scanner.nextLine();
                 
                       System.out.println("Entrez le groupage sanguin du patient : ");
                       String groupage = scanner.nextLine();
                       
                       System.out.println("Entrez l'âge du patient : ");
                       int age = Integer.parseInt(scanner.nextLine());
                       
                       System.out.println("Entrez le poids du patient : ");
                       double poids = Double.parseDouble(scanner.nextLine());
                       
                       System.out.println("Entrez la taille du patient : ");
                       double taille = Double.parseDouble(scanner.nextLine());
                       
                       System.out.println("Entrez les antécédents chirurgicaux du patient : ");
                       String antecedentsChirurgicaux = scanner.nextLine();
                       
                       System.out.println("Entrez les antécédents médicaux du patient : ");
                      String antecedentsMedicaux = scanner.nextLine();
                    Fichepatient fichepatient = new Fichepatient(nom1, prenom1, dateNaissance1, adresse1, telephone1, mail1, groupage, age, poids, taille, antecedentsChirurgicaux, antecedentsMedicaux);
                    fichespatients.add(fichepatient);
                    System.out.println("fichier patient cree");
                    
                    System.out.println("lui cree un dossier medical");
                    System.out.println("saisir le diagnostic");
                    String diagnostic = scanner.nextLine();
                    
                    System.out.println("Entrez la date de la consultation (format : JJ/MM/AAAA) : ");
                    String dateConsultationStr = scanner.nextLine();
                    SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy");
                    
                    Date dateConsultation = null;
        			try {
                        dateConsultation = sdf2.parse(dateConsultationStr);
                    } catch (ParseException e) {
                        System.out.println("Format de date incorrect. Assurez-vous d'utiliser le format JJ/MM/AAAA.");
                    }
        			//creation du dossier medical
        			System.out.println("donner l'id du patient a qui vous souhaiter cree un dossier medical");
        			int idPatient = Integer.parseInt(scanner.nextLine()) ; 
        			
                    System.out.println("saisir l'observation :");
                    String observation = scanner.nextLine();
                    
                    System.out.println("saisir l'examen medical :");
                    String examenMed = scanner.nextLine();
                    
                    System.out.println("Entrer le path du fichier radios:");
                    String radiospath = scanner.nextLine();
                    
                    File radios = new File(radiospath);
                    
                    try (BufferedReader br = new BufferedReader(new FileReader(radios))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                    System.out.println("Entrer le path du fichier analyses");
                    String analysespath = scanner.nextLine();
                    
                    File analyses = new File(analysespath);
                    
                    try (BufferedReader br = new BufferedReader(new FileReader(analyses))) {
                        String line;
                        while ((line = br.readLine()) != null) {
                            System.out.println(line);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    
                   DossierMedical dossiermed = new DossierMedical(idPatient, diagnostic, dateConsultation, observation, examenMed, radios, analyses);
                   dossiersmedicaux.add(dossiermed); 
                   System.out.println("dossier medical cree");
                  break;
               
                  case 'C' :
            	   System.out.println("la liste des patients :");
            	   for (Patient patient2 : patients) { 
            		   patient2.afficherInformations();
            	   System.out.println("---------------------");}
            	   
            	  break;
            	     
                  case 'D' : 
            	   System.out.println("donnez le nom et prenom du patient");
            	   String nomprenom = scanner.nextLine();
            	   
            	  System.out.println("donnez tous les mediacaments a prescrire");
            	  String nomMedicament = scanner.nextLine();
            	  
            	  System.out.println("donnez leurs dosage par ordre");
            	  String dosage = scanner.nextLine();
            	  
            	  System.out.println("la duree de traitement");
            	  int dureeTraitement = Integer.parseInt(scanner.nextLine()) ; 
            	  
            	  Ordonnance ordonnance = new Ordonnance (nomprenom, nomMedicament, dosage, dureeTraitement); 
            	 
            	  ordonnance.afficherOrdonnance();
            	  ordonnances.add(ordonnance);
            	  break;
            	  
                  case 'E' :
            	   System.out.println("donnez le type du certificat");
            	   String typeCertificat = scanner.nextLine();
            	   
            	   System.out.println("donnez le nom prenom du patient");
            	   String nomPrenomPatient = scanner.nextLine();
            	  
            	   System.out.println("donnez le nom prenom du medecin ");
            	   String nomMedecin = scanner.nextLine();
            	   
            	   System.out.println("Entrez la date (format : JJ/MM/AAAA) : ");
                   String datecertStr = scanner.nextLine();
                   SimpleDateFormat sdf4= new SimpleDateFormat("dd/MM/yyyy");
                   Date datecert = null;
                   try {
                       datecert = sdf4.parse(datecertStr);
                   } catch (ParseException e) {
                       System.out.println("Format de date incorrect. Assurez-vous d'utiliser le format JJ/MM/AAAA.");
                   }
                   
            	   System.out.println("donnez une discription de la condition ");
            	   String descriptionCondition = scanner.nextLine();
            	   
            	   Certificatmedical certificat = new Certificatmedical(typeCertificat, nomPrenomPatient, nomMedecin, datecert, descriptionCondition);
            	   certificat.afficherCertificat();
            	   certificats.add(certificat);
            	   break;
            	  
                  case 'F' :
            	   System.out.println("Entrez le nom du patient : ");
                   String nom4 = scanner.nextLine();

                   System.out.println("Entrez le prénom du patient : ");
                   String prenom4 = scanner.nextLine();
                   for ( Fichepatient fiche1 : fichespatients) {
                       if (fiche1.getNom().equalsIgnoreCase(nom4) && fiche1.getPrenom().equalsIgnoreCase(prenom4)) {
                    	   fiche1.afficherInformations();
                    	   
                       }}
                   break ;
                   
                  case 'G':
            	   System.out.println("Entrez le nom du patient : ");
                   String nom5 = scanner.nextLine();

                   System.out.println("Entrez le prénom du patient : ");
                   String prenom5 = scanner.nextLine();
            	  
                   boolean patientTrouve = false;

                   for (Patient patient2 : patients) {
                       if (patient2.getNom().equalsIgnoreCase(nom5) && patient2.getPrenom().equalsIgnoreCase(prenom5)) {
                           patientTrouve = true;
                           for (DossierMedical dossiermedic : dossiersmedicaux) {
                               if (patient2.getIdPatient() == dossiermedic.getIdPatient()) {
                                   dossiermedic.afficherDossier();
                                   break; // Quitter la boucle dès que le dossier est trouvé et affiché
                               }
                           }
                       }
                   }

                   if (!patientTrouve) {
                       System.out.println("Patient non trouvé.");
                   }
                   break; 
                
            	 
        	  case 'H' :
           	   System.out.println(" donner le nom du patient");
           	   String nom2 = scanner.nextLine();
           	   
           	   System.out.println(" donner le prenom du patient");
           	   String prenom2 = scanner.nextLine();
           	   
           	   for (Patient patient2 : patients) {
                     if (patient2.getNom().equalsIgnoreCase(nom2) && patient2.getPrenom().equalsIgnoreCase(prenom2)) {
                   	   System.out.println("Entrez la date du rendez-vous (format : JJ/MM/AAAA) : ");
                          String dateRDVStr2 = scanner.nextLine();
                          SimpleDateFormat sdf3 = new SimpleDateFormat("dd/MM/yyyy");

                          Date dateRDV2 = null;
                          try {
                              dateRDV2 = sdf3.parse(dateRDVStr2);
                          } catch (ParseException e) {
                              System.out.println("Format de date incorrect. Assurez-vous d'utiliser le format JJ/MM/AAAA.");
                          }

                          System.out.println("Entrez l'heure du rendez-vous (format : HH:MM) : ");
                          String heureRDVStr2 = scanner.nextLine();

                          String[] heureMinutes2 = heureRDVStr2.split(":");
                          int heure2 = Integer.parseInt(heureMinutes2[0]);
                          int minutes2 = Integer.parseInt(heureMinutes2[1]);

                          String status2 = "en cours";
              			// Création du rendez-vous et ajout à la liste
                          RDV rdv2 = new RDV(patient2.getIdPatient(), dateRDV2, heure2, minutes2, patient2, status2);
                          rdvs.add(rdv2);
                          System.out.println("Rendez-vous ajouté avec succès.");
                   	   
                   	   }
                  else {
                         System.out.println("Patient " + prenom2 + " " + nom2 + " non trouvé.");
                      }}
                      
           	      break;
           	   
               case 'I' : 
           	   Date dateAujourdhui = new Date();
                  SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
                  String dateAujourdhuiStr = formatter.format(dateAujourdhui);

                  for (RDV rdv3 : rdvs) {
                      String dateRDVStr2 = formatter.format(rdv3.getDate());
                      if (dateRDVStr2.equals(dateAujourdhuiStr)) {
                          System.out.println("Rendez-vous pour " + rdv3.getPatient().getNom() + " " + rdv3.getPatient().getPrenom() + " à " + rdv3.getHeure() + " : " + rdv3.getStatut());
           }}
                  break;
                  
                  
               case 'J' :
           	   for (RDV rdv3 : rdvs) { rdv3.afficherRendezVous();}
           	      break;
           	   
           	   
               case 'K' :
           	   System.out.println(" donner le nom du patient");
           	   String nom3 = scanner.nextLine();
           	   
           	   System.out.println(" donner le prenom du patient");
           	   String prenom3 = scanner.nextLine();
           	   
                  System.out.println("prix de la consultation");
                  int prix = Integer.parseInt(scanner.nextLine()) ; 
                  
           	   Date dateAujourdhui2 = new Date();
                  SimpleDateFormat formatter2 = new SimpleDateFormat("dd/MM/yyyy");
                  String dateAujourdhuiStr2 = formatter2.format(dateAujourdhui2);
                  boolean patientTrouve1 = false;
                  boolean rdvConfirme = false;

                  for (Patient patient2 : patients) {
                      if (patient2.getNom().equalsIgnoreCase(nom3) && patient2.getPrenom().equalsIgnoreCase(prenom3)) {
                          patientTrouve1 = true;
                          for (RDV rdv3 : rdvs) {
                              String dateRDVStr3 = formatter2.format(rdv3.getDate());
                              if (dateRDVStr3.equals(dateAujourdhuiStr2) || rdv3.getIdPatient() == patient2.getIdPatient()) {
                                  rdv3.confirmerRDV();
                                  finance.ajouterMontantJour(prix);
                                  rdvConfirme = true;
                                  System.out.println("rdv confirmé");
                                  break; // Quitter la boucle dès que le rendez-vous est trouvé et confirmé
                              }
                          }
                          if (!rdvConfirme) {
                              System.out.println("RDV ne peut être confirmé parce qu'il n'est pas programmé pour aujourd'hui");
                          }
                          break; // Quitter la boucle dès que le patient est trouvé
                      }
                  }
           	      break;
                case 'L' :
            	  System.out.println("Entrez le numero du rendez-vous à annuler : ");
                  int numRDV = Integer.parseInt(scanner.nextLine());
                  RDV rdvASupprimer = null;
                  for (RDV rdv5: rdvs) {
                      if (rdv5.getNumRend() == numRDV) {
                    	  rdv5.annulerRDV();
                    	  rdvASupprimer = rdv5;
                    	  }
                      }
                  
                 if (rdvASupprimer != null) {
                      rdvs.remove(rdvASupprimer);
                      System.out.println("Rendez-vous annulé et supprimé avec succès.");
                  } else {
                      System.out.println("Rendez-vous non trouvé.");
                  }
                 break;
                
        	   
        	   case 'M' :
            	   finance.afficherDetailsFinancejour();
            	   break;
               case 'N':
            	   finance.afficherDetailsFinancemois();
            	   break;
               case 'O' : 
            	   finance.afficherDetailsFinance();
            	   break;
               case 'P' :
            	   finance.transfererMontantJourVersMois();
            	   break;
               case 'Q' :
            	   finance.finDeMois();
            	   break;
         case '0' :
      	   break;
         default:
       	  System.out.println("choix invalide");
       	  
            }}while(choixprcpl != 0);
            	   
        	   
       
        // Fermeture du scanner
        scanner.close();

}}
