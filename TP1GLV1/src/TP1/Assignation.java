package TP1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Assignation {
	String url="jdbc:mysql://localhost/gestiontaches";
	 String user="root";
	 String password="";
	
	Statement st = null;
	ResultSet rs = null;
	ResultSet rsM = null;
	Connection cn = null;
	int idassign;
	int idT;
	int idM;
	String sql;
	String sqlT;
	String sqlM;
	Scanner sc = new Scanner(System.in);

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
	
	public void affichertachAssign(){
		System.out.println("");
		System.out.println("*****LES TACHES ASSIGNEES A CHAQUE MEMBRE******");
		try{
			sql= "SELECT tache.nomtache , membre.nommembre FROM gestiontachetp1.tache, gestiontachetp1.membre, gestiontachetp1.assignation  WHERE membre.idmembre= assignation.idmembre AND tache.idtache=assignation.idtache ";
			rs= st.executeQuery(sql);
			System.out.println("|TACHES|\t|MEMBRE|");
			while (rs.next()){
				System.out.println(rs.getString("tache.nomtache")+"\t\t"+ rs.getString("membre.nommembre"));
				//System.out.println(rs.getString("tache.nom "));
			}
			System.out.println("");
			System.out.println("***FIN DE LA RECHERCHE****");
			}catch (Exception e){
			System.out.println("taches assignées introuvables");
		}
	}
	
	public void afficherAssign(){
		System.out.println("");
		System.out.println("*****LES TACHES ASSIGNEES A CHAQUE MEMBRE******");
		
		try{
			sql= "SELECT  assignation.idtache, assignation.idmembre FROM gestiontachetp1.assignation ";
			rs= st.executeQuery(sql);
			System.out.println("|TACHES|\t|MEMBRES|");
			while (rs.next()){
				System.out.println(rs.getInt("assignation.idtache")+"\t\t"+ rs.getInt("assignation.idmembre"));
				//System.out.println(rs.getString("tache.nom "));
			}
			System.out.println("");
			System.out.println("***FIN DE LA RECHERCHE****");
			}
			catch (Exception e){
			System.out.println("taches assignées introuvables");
		}
	}
	public void modifier(){
		
		System.out.print("Entrer l'identication du membre à modifier: ");
		idM =sc.nextInt();
		
		System.out.print("Entrer le nouvel identication correspondant du membre à modifier: ");
		int newIdM =sc.nextInt();
		try{
			sql = "UPDATE asignation SET `idmembre` = '"+newIdM+"' WHERE nom ='"+idM+"'";
			st.executeUpdate(sql);
			System.out.println("modification d'assignation effectuée avec succes");
			
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
		
	}
	
public void assigner(){
		
		System.out.print("ENTRER IDENTIFIANT DU MEMBRE : ");
		idM=sc.nextInt();
		System.out.print("ENTRER IDENTIFIANT DU TACHE : ");
		idT=sc.nextInt();
		 try{
			 	sql = "INSERT INTO gestiontachetp1.assignation (idassignation,idmembre,idtache) VALUES ('"+ idassign +"','"+idM+"','"+idT+"')";
			 	st.executeUpdate(sql);
			 	System.out.println("Assignation reussie");
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
		
		
	}
}
