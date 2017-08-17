package TP1;

import java.sql.*;

import java.util.Scanner;

public class ConnexionDB {
	String url="jdbc:mysql://localhost/gestiontachetp1";
	String user="root";
	String password="";
	String sql;
	Connection cn = null;
	Statement st = null;
	ResultSet rs = null;
	ResultSet rsT = null;
	ResultSet rsM = null;
	
	Scanner sc = new Scanner(System.in);
	
	 
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

	 
	 public void afficherM(){
		 System.out.println("");
		 System.out.println("***AFFICHAGE DE LA BASE DE DONNEES****");
		 System.out.println("");
		 
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
		}
	 
				public void afficherT(){
					System.out.println("");
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
				}

}
