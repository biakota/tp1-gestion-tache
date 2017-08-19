package TP1;

import java.util.Scanner;

public class Menu {
	
	Scanner sc; 
	Membre mbre;
	Tache tach = new Tache();
	Assignation as=new Assignation();
	Sousmenu Smenu = new Sousmenu();
	
	
	public void menu(){
		mbre=new Membre();
		int choixaction = 0;
		
		sc= new Scanner(System.in);
		
		int reponse = 1;
		while (reponse == 1) {
		System.out.println("\t\t\t\t\tBIENVENU SUR LE PROGRAMME DE GESTION DES TACHES");
		System.out.println("\t\t\t\t\t**********CREATION DU JEU DEMINEUR***********");
		System.out.println("\t\t\t\t\t*********************MEMU*********************");
		System.out.println("\t\t\t\t\t---veuillez faire votre choix---");
		System.out.println("\t\t\t\t\t\t\t1 : pour Ajouter ");
		System.out.println("\t\t\t\t\t\t\t2 : pour Modifier");
		System.out.println("\t\t\t\t\t\t\t3 : pour Supprimer");
		System.out.println("\t\t\t\t\t\t\t4 : pour Rechercher");
		System.out.println("\t\t\t\t\t\t\t5 : pour Assigner");
		System.out.print("\t\t\tchoix : ");
		
		//char reponse = 'O';
		
			choixaction = sc.nextInt();
		switch(choixaction){
		case 1:
				Smenu.menuAcceuilAjout();
				break;
		case 2:
				Smenu.menuAcceuilModif();
				break;
		case 3:
				Smenu.menuAcceuilSupp();
				break;
		case 4:
				Smenu.menuAcceuilRecherche();
				break;
		case 5:
				Smenu.menuAcceuilAssigner();
				break;
		default: System.out.println("veuillez respecter les consignes de choix");
		}
		reponse = 2;

           while(reponse != 1 && reponse != 0)

		  {

		    //On demande si la personne veut faire un autre essai

		    System.out.println("Voulez-vous reexecuter le programme ? (1:oui/ 0: non) : " );
		    reponse = sc.nextInt();

		  }
	}
	System.out.println("*******FIN DU PROGRAMME******");
	}

	

}
