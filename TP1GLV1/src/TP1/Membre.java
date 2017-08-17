package TP1;

import java.sql.*;
import java.util.Scanner;

public class Membre {
	
	private int ID;
	private String nomMembre;
	private String sql;
	
	String url="jdbc:mysql://localhost/gestiontaches";
	String user="root";
	String password="";
	Statement st = null;
	ResultSet rs = null;
	Connection cn = null;
	 
	Scanner sc = new Scanner(System.in);
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
	
	 public void connectDB(){
			
		 try{
			 //etape 1: Chargement du clavier
			 Class.forName("com.mysql.jdbc.Driver");
			 System.out.println("driver OK");
			 
			 //etape 2: connexion à la base de donnée
			 cn = DriverManager.getConnection(url,user,password);
			 st = cn.createStatement();
			 System.out.println("connexion reussi");
		 }catch (Exception e){
			 System.out.println("error de connexion");
	 }
 }
	
	public void modifier(){
		System.out.print("Entre le nom du membre à modifier: ");
		nomMembre=sc.nextLine();
		System.out.print("Entre le nouveau nom du membre à modifier: ");
		String nouveauNomMembre=sc.nextLine();
		try{
			sql = "UPDATE membre SET `nommembre` = '"+nouveauNomMembre +"' WHERE nommembre ='"+nomMembre+"'";
			st.executeUpdate(sql);
			System.out.println("modification effectuée avec succes");
			
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
		
	}
	
	public void supprimer(){
		System.out.println("");
		System.out.print("Entrer l'identifiant du membre à supprimer : ");
		ID=sc.nextInt();
		try{
			sql ="DELETE FROM gestiontachetp1.membre WHERE membre.idmembre='"+ID+"'";
			st.executeUpdate(sql);
			System.out.print("membre supprumé");
		}
		catch(Exception e){
			System.out.print("echec de suppression de ce membre");
		}
		
	}
	public void ajouter(){
		
		System.out.print("Entrer le nom du membre : ");
		nomMembre=sc.nextLine();
		 try{
			 	sql = "INSERT INTO gestiontachetp1.membre(`idmembre`,`nommembre`) VALUES ('"+ ID +"','"+nomMembre+"')";
			 	st.executeUpdate(sql);
			 	System.out.println("ajout reussi");
		 }catch (Exception e){
			 System.out.println("error d'ajout de membre");
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
	public void selectionner(){
		
		System.out.println("");
		System.out.println("Recherche de toutes les tache assigné à un membre : ");
		System.out.print("Entrer l'identifiant : ");
		ID=sc.nextInt();
		System.out.println("Resultat de la recherche : ");
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
			
			System.out.println("***FIN DE LA RECHERCHE****");
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
		
		
	}

}
