package TP1;

import java.util.Scanner;

public class Sousmenu {
	
	
	Scanner sc = new Scanner(System.in);
	Membre mbre;
	Tache tach = new Tache();
	
	Assignation as=new Assignation();
	
	public void menuAcceuilAjout(){
		
		mbre=new Membre();
		System.out.println("\t\t\t\t\t\t\t************************");
		System.out.println("\t\t\t\t\t\t\t---veuillez faire votre choix---");
		System.out.println("\t\t\t\t\t\t\t1 : pour la tache ");
		System.out.println("\t\t\t\t\t\t\t2 : pour le Membre");
		System.out.print("\t\t\tchoix : ");
		int choixM = sc.nextInt();
		if (choixM==1){
			//tach.connecterDB();
			tach.afficher();
			tach.ajouter();
		} else if (choixM==2){
			mbre.connecterDB();
			mbre.afficher();
			mbre.ajouter();
		}
		else {
			
		}
		
	}
	public void menuAcceuilModif(){
		sc= new Scanner(System.in);
		mbre=new Membre();
		System.out.println("\t\t\t\t\t\t\t************************");
		System.out.println("\t\t\t\t\t\t\t---veuillez faire votre choix---");
		System.out.println("\t\t\t\t\t\t\t1 : pour la tache ");
		System.out.println("\t\t\t\t\t\t\t2 : pour le Membre");
		System.out.print("\t\t\tchoix : ");
		int choixM = sc.nextInt();
		if (choixM==1){
			//tach.connecterDB();
			tach.afficher();
			tach.modifier();
		} 
		else if (choixM==2){
			//mbre.connecterDB();
			mbre.afficher();
			mbre.modifier();
		}
		else {
				
		}
	}
		

	public void menuAcceuilSupp(){
		mbre=new Membre();
		
		System.out.println("\t\t\t\t\t\t\t************************");
		System.out.println("\t\t\t\t\t\t\t---veuillez faire votre choix---");
		System.out.println("\t\t\t\t\t\t\t1 : pour la tache ");
		System.out.println("\t\t\t\t\t\t\t2 : pour le Membre");
		System.out.print("\t\t\tchoix : ");
		int choixM = sc.nextInt();
		if (choixM==1){
			
			tach.afficher();
			tach.supprimer();
			
		} 
		else if (choixM==2){
			
			mbre.afficher();
			mbre.supprimer();
			
		}
		else {
				
		}
	}
		

	public void menuAcceuilRecherche(){
		
		mbre=new Membre();
		System.out.println("\t\t\t\t\t\t\t************************");
		System.out.println("\t\t\t\t\t\t\t---veuillez faire votre choix---");
		System.out.println("\t\t\t\t\t\t\t1 : pour la tache ");
		System.out.println("\t\t\t\t\t\t\t2 : pour le Membre");
		System.out.print("\t\t\tchoix : ");
		int choixM = sc.nextInt();
		if (choixM==1){
			tach.afficher();
			tach.rechercher();;
		} 
		else if (choixM==2){
			mbre.afficher();
			mbre.rechercher();
		}
		else {
				
		}
	}
		
	public void menuAcceuilAssigner(){
		mbre=new Membre();
		
		System.out.println("\t\t\t\t\t\t\t************************");
		System.out.println("\t\t\t\t\t\t\t---veuillez faire votre choix---");
		System.out.println("\t\t\t\t\t\t\t 1  : pour Modifier l'assignation  ");
		System.out.println("\t\t\t\t\t\t\t 2 : pour assigner tache à un membre  ");
		System.out.print("\t\t\tchoix : ");
		
		int choixM = sc.nextInt();
		if (choixM==1){
			mbre.afficher();
			tach.afficher();
			as.afficherIdM_T();
			as.affichertachAssign();
			as.modifier();
								
		}else if (choixM==2){
			
			mbre.afficher();
			tach.afficher();
			as.affichertachAssign();
			as.afficherIdM_T();
			as.assignerT();
			
		}else{
			System.out.println("veuillez respecter les consignes de choix : ");
		}
		
		}
	

}
