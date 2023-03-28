package dao;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Medecin;

public class MedecinDao {

	public static Connection getconnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/Wergui-Yaram?characterEncoding=utf8","root","");
		}catch( Exception e)
		{
			System.out.println(e);
		}
		
		return connection;
	}
	
	
	public static int insertMedecin(Medecin medecin) {
		int status = 0;
		
		try {
			
			Connection con = MedecinDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" insert into medecin (nom_medecin, prenom_medecin,email,telephone,motdepasse,valide_compte,specialite,role,service_nom_service) values (?,?,?,?,?,?,?,?,?)" );
			ps.setString(1,medecin.getNom_medecin());
			ps.setString(2, medecin.getPrenom_medecin());
			ps.setString(3, medecin.getEmail());
			ps.setString(4, medecin.getTelephone());
			ps.setString(5, medecin.getMotdepasse());
			int val = medecin.getValide_compte();
			val = 1;
			ps.setInt(6, val);
			ps.setString(7, medecin.getSpecialite());
			
			String role = medecin.getRole();
			role = "USER";
			
			ps.setString(8, role);
			ps.setString(9, medecin.getService_nom_service());
			
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
			
			Connection con = MedecinDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update medecin set nom_medecin=?, prenom_medecin=?,email=?,telephone=?,motdepasse=?,specialite=?,service_nom_service=? where idmedecin = ?" );
			ps.setString(1,medecin.getNom_medecin());
			ps.setString(2, medecin.getPrenom_medecin());
			ps.setString(3, medecin.getEmail());
			ps.setString(4, medecin.getTelephone());
			ps.setString(5, medecin.getMotdepasse());
			ps.setString(6, medecin.getSpecialite());
			ps.setString(7, medecin.getService_nom_service());
			ps.setInt(8, medecin.getIdmedecin());
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur de mise à jour ");
		}
		
		
	}
	
	public static void deleteUser(int id) {
		
		
		try {
			
			Connection con = MedecinDao.getconnection();
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
			
			Connection con = MedecinDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select nom_medecin, prenom_medecin,email,telephone,motdepasse,specialite,role,service_nom_service from medecin where idmedecin = ?" );
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				medecin.setNom_medecin(rs.getString(1));
				medecin.setPrenom_medecin(rs.getString(2));
				medecin.setEmail(rs.getString(3));
				medecin.setTelephone(rs.getString(4));
				medecin.setMotdepasse(rs.getString(5));
				medecin.setSpecialite(rs.getString(6));
				medecin.setRole(rs.getString(7));
				medecin.setService_nom_service(rs.getString(8));
				
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur By id");
		}
		
		return medecin;
		
	}
	
	public static List<Medecin> getAllMedecin(){
		
		List<Medecin> liste = new ArrayList<Medecin>();
		
	try {
			
			Connection con = MedecinDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select idmedecin,nom_medecin,prenom_medecin,specialite,service_nom_service from medecin where valide_compte = 1" );
		
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Medecin medecin = new Medecin();
				
				medecin.setIdmedecin(rs.getInt(1));
				medecin.setNom_medecin(rs.getString(2));
				medecin.setPrenom_medecin(rs.getString(3));
				medecin.setSpecialite(rs.getString(4));
				medecin.setService_nom_service(rs.getString(5));
				
				
				liste.add(medecin);
			}
			con.close();
			
		}catch(Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.print("Erreur view");
		}
		
	return liste;
		
	}
	
	public static Medecin getMedecinBylogin(String login,String password) {
	
		Connection con = MedecinDao.getconnection();
		Medecin medecin = null;
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(" select * from medecin where email = ?  and motdepasse = ? and valide_compte= ?" );
			
			ps.setString(1, login);
			ps.setString(2, password);
			int val = 1;
			ps.setInt(3, val);
			
			ResultSet rs = ps.executeQuery();
			Medecin medecin2 = new Medecin();
			if(rs.next()) {
				
				medecin2.setNom_medecin(rs.getString("nom_medecin"));
				medecin2.setPrenom_medecin(rs.getString("prenom_medecin"));
				medecin2.setEmail(rs.getString("email"));
				medecin2.setTelephone(rs.getString("telephone"));
				medecin2.setMotdepasse(rs.getString("motdepasse"));
				medecin2.setSpecialite(rs.getString("specialite"));
				medecin2.setRole(rs.getString("role"));
				medecin2.setService_nom_service(rs.getString("service_nom_service"));

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
	
public static Medecin getUserByLogin(String id) {
		
		Medecin medecin = new Medecin();
		
		try {
			
			Connection con = MedecinDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select idmedecin, nom_medecin, prenom_medecin,email,telephone,motdepasse,specialite,role from medecin where service_nom_service = ?" );
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				medecin.setNom_medecin(rs.getString(1));
				medecin.setPrenom_medecin(rs.getString(2));
				medecin.setEmail(rs.getString(3));
				medecin.setTelephone(rs.getString(4));
				medecin.setMotdepasse(rs.getString(5));
				medecin.setSpecialite(rs.getString(6));
				medecin.setRole(rs.getString(7));
				medecin.setService_nom_service(rs.getString(8));
				
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur By id");
		}
		
		return medecin;
		
	}
	

}
