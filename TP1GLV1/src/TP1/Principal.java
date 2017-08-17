package TP1;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Membre mbre=new Membre();
		Tache tach = new Tache();
		ConnexionDB cnx = new ConnexionDB();
		Scanner sc = new Scanner(System.in);
		Assignation as=new Assignation();
		
		System.out.println("BIENVENU SUR LE PROGRAMME DE GESTION DES TACHES");
		System.out.println("**********CREATION DU JEU DEMINEUR***********");
		System.out.println("*********************MEMU*********************");
		System.out.println("---veuillez faire votre choix---");
		System.out.println("1 : pour Ajouter ");
		System.out.println("2 : pour Modifier");
		System.out.println("3 : pour Supprimer");
		System.out.println("4 : pour Rechercher");
		System.out.println("5 : pour Assigner");
		System.out.print("choix : ");
		int choixaction = sc.nextInt();
		
		if (choixaction==5){
			System.out.println("  ");
			System.out.println("1 : pour Modifier l'assignation  ");
			System.out.println("2 : pour assigner tache à un membre  ");
			System.out.print("choix : ");
			int choixassign = sc.nextInt();
			if (choixassign==1){
				cnx.connectDB();
				cnx.afficherM();
				cnx.afficherT();
				as.connexionDB();
				as.affichertachAssign();
				as.afficherAssign();
				as.modifier();
			}else if (choixassign==2){
				cnx.connectDB();
				cnx.afficherM();
				cnx.afficherT();
				as.connexionDB();
				as.affichertachAssign();
				as.afficherAssign();
				as.assigner();
			}else{
				System.out.println("veuillez respecter les consignes de choix : ");
			}
			
			
		}else{
			
		
		System.out.println("************************");
		System.out.println("---veuillez faire votre choix---");
		System.out.println("1 : pour la tache ");
		System.out.println("2 : pour le Membre");
		System.out.print("choix : ");
		int choix = sc.nextInt();
		
		if (choixaction==1 && choix==1){
			cnx.connectDB();
			cnx.afficherM();
			cnx.afficherT();
			tach.connexionDB();
			tach.ajouter();
			
			}
		else if( choixaction==1 && choix==2){
			cnx.connectDB();
			cnx.afficherM();
			cnx.afficherT();
			mbre.connectDB();
			mbre.ajouter();
			}	
		else if (choixaction==2 && choix==1){
			cnx.connectDB();
			cnx.afficherT();
			cnx.afficherM();
			tach.modifier();
			
		}
		else if (choixaction==2 && choix==2){
			cnx.connectDB();
			//cnx.afficherT();
			cnx.afficherM();
			mbre.modifier();
		}
		else if (choixaction==3 && choix==1){
			cnx.connectDB();
			cnx.afficherT();
			cnx.afficherM();
			tach.connexionDB();
			tach.supprimer();
		}
		else if (choixaction==3 && choix==2){
			cnx.connectDB();
			cnx.afficherT();
			cnx.afficherM();
			mbre.connectDB();;
			mbre.supprimer();
		}
		else if (choixaction==4 && choix==1){
			cnx.connectDB();
			cnx.afficherM();
			cnx.afficherT();
			tach.connexionDB();
			tach.selectionner();
		}
		else if (choixaction==4 && choix==2){
			cnx.connectDB();
			cnx.afficherT();
			cnx.afficherM();
			mbre.connectDB();
			mbre.selectionner();
		}
		else {
			System.out.println("veuillez respecter les consignes de choix");
		}
	}
System.out.println("****fin de programme*****");
  }
}
