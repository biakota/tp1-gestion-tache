package TP1;

import java.sql.*;
import java.util.Scanner;

public class Membre extends Assignation{
	
	private int ID;
	private String nomMembre;
	private String sql;
	
	String url="jdbc:mysql://localhost/gestiontachetp1";
	String user="root";
	String password="";
	Statement st = null;
	ResultSet rs = null;
	Connection cn = null;
	 
	Scanner sc ;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getNom() {
		return nomMembre;
	}
	public void setNom(String nom) {
		this.nomMembre = nom;
	}
	
	@Override
	public void connecterDB() {
		// TODO Auto-generated method stub
		try{
			 // Chargement du clavier
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("driver OK");
			 
			 cn = DriverManager.getConnection(url,user,password);
			 st = cn.createStatement();
			 System.out.println("connexion à la base de données reussie");
		 }catch (Exception e){
			 System.out.println(" error de connexion à la base de données!");
		 }
		
	}

	
	@Override
	public Boolean modifier(){
		int reponse = 1;
		while (reponse == 1) {
		sc = new Scanner(System.in);
		System.out.print("Entre le nom du membre à modifier: ");
		nomMembre=sc.nextLine();
		System.out.print("Entre le nouveau nom du membre à modifier: ");
		String nouveauNomMembre=sc.nextLine();
		connecterDB();
		try{
			sql = "UPDATE membre SET `nommembre` = '"+nouveauNomMembre +"' WHERE nommembre ='"+nomMembre+"'";
			st.executeUpdate(sql);
			System.out.println("modification effectuée avec succes");
			afficher();
		}catch(Exception e){
			System.out.println("echec de modification");
		}finally{
			try{
				cn.close();
				st.close();
			}catch (Exception e){
				System.out.println("deconnexion echouée");
			}
		}
		reponse = 2;

        while(reponse != 1 && reponse != 0)

		  {

		    //On demande si la personne veut faire un autre essai

		    System.out.println("Voulez-vous modifier un autre membre ? (1:oui/ 0: non) : " );
		    reponse = sc.nextInt();

		  }
	}
		return true;
	}
	
	@Override
	public Boolean afficher() {
		System.out.println("");
		 System.out.println("***AFFICHAGE DE LA BASE DE DONNEES****");
		 System.out.println("");
		 connecterDB();
			try{
				sql= "SELECT * FROM gestiontachetp1.membre";
				rs= st.executeQuery(sql);
				System.out.println("MEMBRES : ");
				System.out.println("|IDENTIFIANT DES MEMBRES|\t|NOM DES MEMBRE|");
					while (rs.next()){
					System.out.print("\t");
					System.out.print(rs.getInt("idmembre")+"\t");
					System.out.print("\t\t\t");
					System.out.print(rs.getString("nommembre")+"\t");
					System.out.println("");
				}
				
				}
				catch (Exception e){
				System.out.println("echec d'affichage");
			}
			return true;
	}
	
	
	@Override
	public void supprimer(){
		
		sc = new Scanner(System.in);
		System.out.println("");
		System.out.print("Entrer l'identifiant du membre à supprimer : ");
		ID=sc.nextInt();
		connecterDB();
		try{
			sql ="DELETE FROM gestiontachetp1.membre  WHERE membre.idmembre='"+ID+"'";
			st.executeUpdate(sql);
			System.out.print("membre supprumé");
			afficher();
		}
		catch(Exception e){
			System.out.print("echec de suppression de ce membre");
		}
		
	}
	
	@Override
	public Boolean ajouter(){
		int reponse = 1;
		while (reponse == 1) {
		sc = new Scanner(System.in);
		System.out.print("Entrer le nom du membre : ");
		nomMembre=sc.nextLine();
		 try{
			 	sql = "INSERT INTO gestiontachetp1.membre(`idmembre`,`nommembre`) VALUES ('"+ ID +"','"+nomMembre+"')";
			 	st.executeUpdate(sql);
			 	System.out.println("ajout reussi");
			 	 //connecterDB();
				 afficher();
		 }catch (Exception e){
			 System.out.println("error d'ajout de membre");
			
		 }
		
		 reponse = 2;

         while(reponse != 1 && reponse != 0)

		  {

		    //On demande si la personne veut faire un autre essai

		    System.out.println("Voulez-vous enregister un autre membre ? (1:oui/ 0: non) : " );
		    reponse = sc.nextInt();

		  }
	}
		return true;
	}
	
	
	@Override
	public void rechercher(){
		int reponse = 1;
		while (reponse == 1) {
		sc = new Scanner(System.in);
		System.out.println("");
		System.out.println("Recherche de toutes les tache assigné à un membre : ");
		System.out.print("Entrer l'identifiant : ");
		ID=sc.nextInt();
		System.out.println("Resultat de la recherche : ");
		connecterDB();
		try{
			sql= "SELECT tache.nomtache, membre.nommembre FROM gestiontachetp1.tache, gestiontachetp1.membre, gestiontachetp1.assignation  WHERE assignation.idmembre = membre.idmembre AND assignation.idtache = tache.idtache AND assignation.idmembre='"+ID+"'";
			rs= st.executeQuery(sql);
			System.out.println("|TACHES|\t\t|MEMBRE|");
			while (rs.next()){
				System.out.println(rs.getString("tache.nomtache")+"\t\t"+ rs.getString("membre.nommembre"));
				//System.out.print(rs.getString("membre.nommembre")+"\t");
				//System.out.print(rs.getString("gestiontachetp1.tache.nomtache ")+"\t");
				//System.out.println("");
			}
			
			System.out.println("");
			}catch (Exception e){
			System.out.println("taches assignées introuvables");
		}finally{
			try{
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

		    System.out.println("Voulez-vous enregister une autre recherche ? (1:oui/ 0: non) : " );
		    reponse = sc.nextInt();

		  }
	}
	}

}
