package TP1;

import java.sql.*;

import java.util.Scanner;

public class Tache {
	private int ID;
	private String nomTache;
	private String description;
	private String statut;
	private int idmembre;
	String sql;
	
	 String url="jdbc:mysql://localhost/gestiontaches";
	 String user="root";
	 String password="";
	 Connection cn = null;
	 Statement st = null;
	 ResultSet rs = null;
	 Scanner sc = new Scanner(System.in);
	 
	//constructeur
	public Tache( String nom, String description, String statut) {
		super();
		this.nomTache = nom;
		this.description = description;
		this.statut = statut;
	}
	
	//etablir la connextion au serveur et la base de données
	public void connexionDB(){
		
		 try{
			 // Chargement du clavier
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("driver OK");
			 
			 cn = DriverManager.getConnection(url,user,password);
			 st = cn.createStatement();
			 System.out.println("connexion reussi");
		 }catch (Exception e){
			 System.out.println(" error de connexion");
		 }
		
	}
	
	 public Tache() {
			super();
			// TODO Auto-generated constructor stub
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
	public void modifier( ){
		System.out.println("ancienne tache");
		String ancienNomTache=sc.nextLine();
		System.out.println("Nouvelle tache");
		String nouveauNomTache = sc.nextLine();
		System.out.println("ancienne description");
		String ancienDescription = sc.nextLine();
		System.out.println("Nouvelle description");
		String nouvelleDescription = sc.nextLine();
		System.out.println("ancien statut");
		String ancienStatut = sc.nextLine();
		System.out.println("ancienne tache");
		String nouveauStatut=sc.nextLine();
		try{
			//requete pour la mise à jour des taches 
			sql = " UPDATE tache SET  nomtache='"+nouveauNomTache+"',descriptiontache='"+nouvelleDescription+"',statustache='"+nouveauStatut+"' WHERER nomtache ='"+ancienNomTache+"',description='"+ancienDescription+"',status='"+ancienStatut+"'";
			st.executeUpdate(sql);
			System.out.println("modification statut reussi");
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
	}
	//supprimer une information dans la base de données
	public void supprimer(){
		System.out.println("");
		System.out.print("Entrer l'identifiant de la tache à supprimer : ");
		ID=sc.nextInt();
		try{
			sql ="DELETE FROM gestiontachetp1.tache WHERE tache.idtache='"+ID+"'";
			st.executeUpdate(sql);
			System.out.print("tache supprimée");
		}
		catch(Exception e){
			System.out.print("echec de suppression de cette tache");
		}
	}
	
	//ajouter une information dans la base de donnée
	public void ajouter(){
	
		System.out.print("nom de tache : ");
		nomTache = sc.nextLine();//saisie au clavier
		System.out.print("description de tache : ");
		description = sc.nextLine();//saisie au clavier
		System.out.print("Statut de tache : ");
		statut = sc.nextLine();//saisie au clavier
		
		try{
			//requete pour l'enregistrment des taches
			sql = "INSERT INTO gestiontachetp1.tache (`idtache`,`nomtache`,`descriptiontache`,`statustache`) VALUES ('"+ ID +"','"+ nomTache +"','"+ description +"','"+ statut +"')";
			st.executeUpdate(sql);
			System.out.println("tache ajoutée avec succes");
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
		
	}
	
	//recherche un information dans la base de données
	public void selectionner(){
		System.out.println("");
		System.out.println("*****RECHERCHE DE TACHE EN FONCTION DE LEUR TACHE*****");
		System.out.print("Veillez entrer le statut des taches : ");
		statut=sc.nextLine(); //saisie au clavier
		System.out.println("Resultat de la recherche : ");
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
			System.out.println("***FIN DE LA RECHERCHE****");
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
	}

}
