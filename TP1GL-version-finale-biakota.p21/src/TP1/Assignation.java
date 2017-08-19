package TP1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Assignation extends Tache {
	String url="jdbc:mysql://localhost/gestiontachetp1";
	 String user="root";
	 String password="";
	
	Statement st = null;
	ResultSet rs = null;
	ResultSet rsM = null;
	Connection cn = null;
	int idassign;
	
	String sql;
	
	Scanner sc = new Scanner(System.in); 
	
	public void connecterDB() {
		// TODO Auto-generated method stub
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
	
	
	public void affichertachAssign(){
		System.out.println("");
		System.out.println("*****LES TACHES ASSIGNEES A CHAQUE MEMBRE******");
		connecterDB();
		try{
			sql= "SELECT tache.nomtache , membre.nommembre FROM gestiontachetp1.tache, gestiontachetp1.membre, gestiontachetp1.assignation  WHERE membre.idmembre= assignation.idmembre AND tache.idtache=assignation.idtache ";
			rs= st.executeQuery(sql);
			System.out.println("\t\t\t|TACHES|\t\t\t|MEMBRE|");
			while (rs.next()){
				System.out.println("\t\t\t"+rs.getString("tache.nomtache")+"\t\t\t\t"+ rs.getString("membre.nommembre"));
				//System.out.println(rs.getString("tache.nom "));
			}
			System.out.println("");
			
			}catch (Exception e){
			System.out.println("taches assignées introuvables");
		}
	}
	
	public void afficherIdM_T(){
		System.out.println("");
		System.out.println("*****LES TACHES ASSIGNEES A CHAQUE MEMBRE******");
		connecterDB();
		try{
			sql= "SELECT  assignation.idtache, assignation.idmembre FROM gestiontachetp1.assignation ";
			rs= st.executeQuery(sql);
			System.out.println("\t\t\t|ID TACHES|\t\t\t|ID MEMBRES|");
			while (rs.next()){
				System.out.println("\t\t\t"+rs.getInt("assignation.idtache")+"\t\t\t\t"+ rs.getInt("assignation.idmembre"));
				//System.out.println(rs.getString("tache.nom "));
			}
			System.out.println("");
			
			}
			catch (Exception e){
			System.out.println("taches assignées introuvables");
		}
	}
	
	public Boolean modifier(){
		
		int reponse = 1;
		while (reponse == 1) {
			sc =new Scanner(System.in);
			System.out.print("Entrer l'identifiant du membre à modifier: ");
			int idMA =sc.nextInt();
			System.out.print("Entrer l'identifiant de sa tache : ");
			int idT =sc.nextInt();
			System.out.print("Entrer le nouvel identifiant correspondant du membre à modifier: ");
			int newIdM =sc.nextInt();
			
		connecterDB();
		try{
			
			sql = "UPDATE assignation SET assignation.idmembre ='"+newIdM+"' WHERE assignation.idtache = '"+idT+"' AND assignation.idmembre='"+idMA+"'" ;
			st.executeUpdate(sql);
			System.out.println("modification d'assignation effectuée avec succes");
			System.out.println("");
			System.out.println("resultat de la modification ");
			affichertachAssign();
			afficherIdM_T();
		}catch(Exception e){
			System.out.println("echec de modification d'assignation");
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

		    System.out.println("Voulez-vous une autre modification d'assignation de tache ? (1:oui/ 0: non) : " );
		    reponse = sc.nextInt();

		  }
	}
		return true;
	}
	
public void assignerT(){
		
	int reponse = 1;
	while (reponse == 1) {
		System.out.print("ENTRER L'IDENTIFIANT DU MEMBRE : ");
		int idM= sc.nextInt();
		System.out.print("ENTRER L'IDENTIFIANT DU TACHE : ");
		int idT=sc.nextInt();
		connecterDB();
		 try{
			 	sql = "INSERT INTO gestiontachetp1.assignation (idassignation,idmembre,idtache) VALUES ('"+ idassign +"','"+idM+"','"+idT+"')";
			 	st.executeUpdate(sql);
			 	System.out.println("Assignation reussie");
			 	System.out.println(" ");
			 	System.out.println("resultat de l'assignation ");
			 	affichertachAssign();
				afficherIdM_T();
		 }catch (Exception e){
			 System.out.println("Echec d'assignation");
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

	    System.out.println("Voulez-vous faire une autre assignation ? (1:oui/ 0: non) : " );
	    reponse = sc.nextInt();

	  }
	}
  }
}
