package TP1;

import java.sql.*;

import java.util.Scanner;

public class Tache extends Gestion {
	private int ID;
	private String nomTache;
	private String description;
	private String statut;
	private int idmembre;
	String sql;
	
	 String url="jdbc:mysql://localhost/gestiontachetp1";
	 String user="root";
	 String password="";
	 Connection cn = null;
	 Statement st = null;
	 ResultSet rs = null;
	 Scanner sc = new Scanner(System.in);
	 
		@Override
		public void connecterDB() {
			// TODO Auto-generated method stub
			try{
				 // Chargement du clavier
				 Class.forName("com.mysql.jdbc.Driver");
				// System.out.println("driver OK");
				 
				 cn = DriverManager.getConnection(url,user,password);
				 st = cn.createStatement();
				 System.out.println("connexion à la base de données reussie");
			 }catch (Exception e){
				 System.out.println(" error de connexion à la base de données!");
			 }
			
		}


		@Override
		public Boolean afficher() {
			// TODO Auto-generated method stub
			connecterDB();
			try{
				sql= "SELECT * FROM gestiontachetp1.tache ";
				rs= st.executeQuery(sql);
				 System.out.println("LES TACHES : ");
				System.out.println("|ID TACHES|\t|NOM DES TACHES|\t\t| DESCRIPTION|\t\t\t\t\t| STATUT");
					while (rs.next()){
					System.out.print("\t");	
					System.out.print(rs.getInt("idtache")+"\t");
					System.out.print(rs.getString("nomtache")+"\t\t\t");
					System.out.print(rs.getString("descriptiontache")+"\t\t\t\t\t");
					System.out.print(rs.getString("statustache")+"\t\t");
					System.out.println("");
				}
									
			}
			catch (Exception e){
				System.out.println("echec d'affichage");
			}
			return true;
		}

	
	//les getters et setters
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNom() {
		return nomTache;
	}
	public void setNom(String nom) {
		this.nomTache = nom;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
		
	public String getNomTache() {
		return nomTache;
	}

	public void setNomTache(String nomTache) {
		this.nomTache = nomTache;
	}

	public int getIdmembre() {
		return idmembre;
	}

	public void setIdmembre(int idmembre) {
		this.idmembre = idmembre;
	}

	// les methodes 
	//mettre à jour la base de donnée 
	@Override
	public Boolean modifier( ){
		
		int reponse = 1;
		while (reponse == 1) {
		System.out.print("ancienne tache : ");
		String ancienNomTache = sc.nextLine();
		
		System.out.print("ancienne description : ");
		String ancienDescription = sc.nextLine();
		
		System.out.print("ancien statut : ");
		String ancienStatut = sc.nextLine();
		
		System.out.print("Nouvelle tache : ");
		String nouveauNomTache = sc.nextLine();
		
		System.out.print("Nouvelle description : ");
		String nouvelleDescription = sc.nextLine();
		
		System.out.print("nouveau status : ");
		String nouveauStatut=sc.nextLine();
		connecterDB();
		try{
			//requete pour la mise à jour des taches 
			sql = " UPDATE tache SET  nomtache='"+nouveauNomTache+"',descriptiontache='"+nouvelleDescription+"',statustache='"+nouveauStatut+"' WHERE nomtache ='"+ancienNomTache+"' AND descriptiontache='"+ancienDescription+"' AND statustache='"+ancienStatut+"'";
			st.executeUpdate(sql);
			System.out.println("modification statut reussi");
			afficher();
		}catch (Exception e){
			System.out.println("modification statut echoué !");
		}finally{
			try{
				//fermeture de la connextion à la base
				cn.close();
				st.close();
				System.out.println("deconnexion reussie");
			}catch (Exception e){
				System.out.println("deconnexion echouée");
			}
		}
		reponse = 2;

        while(reponse != 1 && reponse != 0)

		  {

		    //On demande si la personne veut faire un autre essai

		    System.out.println("Voulez-vous modifier une autre tache ? (1:oui/ 0: non) : " );
		    reponse = sc.nextInt();

		  }
	}
		return true;
	}
	//supprimer une information dans la base de données
	public void supprimer(){
		int reponse = 1;
		while (reponse == 1) {
		sc = new Scanner(System.in);
		System.out.println("");
		System.out.print("Entrer l'identifiant de la tache à supprimer : ");
		ID=sc.nextInt();
		connecterDB();
		try{
			sql ="DELETE FROM gestiontachetp1.tache WHERE tache.idtache='"+ID+"'";
			st.executeUpdate(sql);
			System.out.print("tache supprimée");
			afficher();
		}
		catch(Exception e){
			System.out.print("echec de suppression de cette tache");
		}finally{
			try{
				//fermeture de la connextion à la base
				cn.close();
				st.close();
				System.out.println("deconnexion reussie");
			}catch (Exception e){
				System.out.println("deconnexion echouée");
			}
		reponse = 2;

        while(reponse != 1 && reponse != 0)

		  {

		    //On demande si la personne veut refaire l'action 

		    System.out.println("Voulez-vous Supprimer une autre tache ? (1:oui/ 0: non) : " );
		    reponse = sc.nextInt();

		  }
		}
		}
	}
	
	//ajouter une information dans la base de donnée
	public Boolean ajouter(){
		int reponse = 1;
		while (reponse == 1) {
		sc = new Scanner(System.in);
	
		System.out.print("nom de tache : ");
		nomTache = sc.nextLine();//saisie au clavier
		System.out.print("description de tache : ");
		description = sc.nextLine();//saisie au clavier
		System.out.print("Statut de tache : ");
		statut = sc.nextLine();//saisie au clavier
		connecterDB();
		try{
			//requete pour l'enregistrment des taches
			sql = "INSERT INTO gestiontachetp1.tache (`idtache`,`nomtache`,`descriptiontache`,`statustache`) VALUES ('"+ ID +"','"+ nomTache +"','"+ description +"','"+ statut +"')";
			st.executeUpdate(sql);
			System.out.println("tache ajoutée avec succes");
			afficher();
		}catch(Exception e){
			System.out.println("erreur ajout tache");
			
		}finally{
			try{
				//fermeture de la connextion à la base
				cn.close();
				st.close();
				System.out.println("deconnexion reussie");
			}catch (Exception e){
				System.out.println("deconnexion echouée");
			}
		}
		reponse = 2;

        while(reponse != 1 && reponse != 0)

		  {

		    //On demande si la personne veut faire un autre essai

		    System.out.println("Voulez-vous Ajouter une autre tache ? (1:oui/ 0: non) : " );
		    reponse = sc.nextInt();

		  }
	}
		return true;
	}
	
	//recherche un information dans la base de données
	public void rechercher(){
		int reponse = 1;
		while (reponse == 1) {
		sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("*****RECHERCHE DE TACHE EN FONCTION DE LEUR TACHE*****");
		System.out.print("Veillez entrer le statut des taches : ");
		statut=sc.nextLine(); //saisie au clavier
		System.out.println("Resultat de la recherche : ");
		connecterDB();
		try{
			
			//requete pour la recherche des taches par leur statuts
			sql= "SELECT `nomtache` ,`statustache` FROM tache WHERE statustache ='"+statut+"' ";
			//execution de la requette
			rs= st.executeQuery(sql);
			System.out.println("|TACHES|\t\t|STATUT|");
			while (rs.next()){
				System.out.println(rs.getString("nomtache")+"\t\t"+ rs.getString("statustache"));
			}
			System.out.println("");
			
			}catch (Exception e){
			System.out.println("taches  introuvables");
		}finally{
			try{
				//fermeture de la connextion à la base 
				cn.close();
				st.close();
				System.out.println("deconnexion reussie");
			}catch (Exception e){
				System.out.println("deconnexion echouée");
			}
		}
	
		reponse = 2;

        while(reponse != 1 && reponse != 0)

		  {

		    //On demande si la personne veut faire un autre essai

		    System.out.println("Voulez-vous effecuer une autre recherche  ? (1:oui/ 0: non) : " );
		    reponse = sc.nextInt();

		  }
	}
	}

	
}
