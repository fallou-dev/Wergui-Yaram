package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Medecin;

public class Medecin_dao {

	public static Connection getconnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Wergui-Yaram","root","");
		}catch( Exception e)
		{
			System.out.println(e);
		}
		
		return connection;
	}
	
	
	public static int insertMedecin(Medecin medecin) {
		int status = 0;
		
		try {
			
			Connection con = Medecin_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" insert into medecin (nom_medecin, prenom_medecin,email,telephone,motdepasse,valide_compte,specialite,role,service_serviceid) values (?,?,?,?,?,?,?,?,?)" );
			ps.setString(1,medecin.getNom_medecin());
			ps.setString(2, medecin.getPrenom_medecin());
			ps.setString(3, medecin.getEmail());
			ps.setString(4, medecin.getTelephone());
			ps.setString(5, medecin.getMotdepasse());
			ps.setInt(6, medecin.getValide_compte());
			ps.setString(7, medecin.getSpecialite());
			ps.setString(8, medecin.getRole());
			ps.setInt(9, medecin.getService_serviceid());
			
			status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static void updateUser(Medecin medecin) {
		
		try {
			
			Connection con = Medecin_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update user set nom_medecin=?, prenom_medecin=?,email=?,telephone=?,motdepasse=?,valide_compte=?,specialite=?,role=?,service_serviceid=? where idmedecin = ?" );
			ps.setString(1,medecin.getNom_medecin());
			ps.setString(2, medecin.getPrenom_medecin());
			ps.setString(3, medecin.getEmail());
			ps.setString(4, medecin.getTelephone());
			ps.setString(5, medecin.getMotdepasse());
			ps.setInt(6, medecin.getValide_compte());
			ps.setString(7, medecin.getSpecialite());
			ps.setString(8, medecin.getRole());
			ps.setInt(9, medecin.getService_serviceid());
			
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		
	}
	
	public static void deleteUser(int id) {
		
		
		try {
			
			Connection con = Medecin_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update medecin set valide_compte = 0 where idmedecin = ?" );
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	
	}
	
	public static Medecin getUserById(int id) {
		
		Medecin medecin = new Medecin();
		
		try {
			
			Connection con = Medecin_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select nom_medecin, prenom_medecin,email,telephone,motdepasse,valide_compte,specialite,role,service_serviceid from medecin where idmedecin = ?" );
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				medecin.setNom_medecin(rs.getString(1));
				medecin.setPrenom_medecin(rs.getString(2));
				medecin.setEmail(rs.getString(3));
				medecin.setTelephone(rs.getString(4));
				medecin.setMotdepasse(rs.getString(5));
				medecin.setValide_compte(rs.getInt(6));
				medecin.setSpecialite(rs.getString(7));
				medecin.setRole(rs.getString(8));
				medecin.setService_serviceid(rs.getInt(9));
				
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		return medecin;
		
	}
	
	public static List<Medecin> getAllMedecin(){
		
		List<Medecin> liste = new ArrayList<Medecin>();
		
	try {
			
			Connection con = Medecin_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from medecin" );
		
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Medecin medecin = new Medecin();
				medecin.setNom_medecin(rs.getString(1));
				medecin.setPrenom_medecin(rs.getString(2));
				medecin.setEmail(rs.getString(3));
				medecin.setTelephone(rs.getString(4));
				medecin.setMotdepasse(rs.getString(5));
				medecin.setValide_compte(rs.getInt(6));
				medecin.setSpecialite(rs.getString(7));
				medecin.setRole(rs.getString(8));
				medecin.setService_serviceid(rs.getInt(9));

				liste.add(medecin);
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	return liste;
		
	}
	
	public static Medecin getMedecinBylogin(String login,String password) {
	
		Connection con = Medecin_dao.getconnection();
		Medecin medecin = null;
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(" select * from medecin where telephone = ? and motdepasse = ?" );
			
			ps.setString(1, login);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			Medecin medecin2 = new Medecin();
			if(rs.next()) {
				
				medecin2.setNom_medecin(rs.getString("nom_medecin"));
				medecin2.setPrenom_medecin(rs.getString("prenom_medecin"));
				medecin2.setEmail(rs.getString("email"));
				medecin2.setTelephone(rs.getString("telephone"));
				medecin2.setMotdepasse(rs.getString("motdepasse"));
				medecin2.setValide_compte(rs.getInt("valide_compte"));
				medecin2.setSpecialite(rs.getString("specialite"));
				medecin2.setRole(rs.getString("role"));
				medecin2.setService_serviceid(rs.getInt("service_serviceid"));

				medecin = medecin2;
				con.close();
				return medecin2;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return medecin;
	}
	

}
