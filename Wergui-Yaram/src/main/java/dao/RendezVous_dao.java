package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.RendezVous;

public class RendezVous_dao {

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
	
	
	public static int insertRv(RendezVous rdv) {
		int status = 0;
		
		try {
			
			Connection con = RendezVous_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" insert into rendez-vous (date_rv,medecin_idmedecin,patient_idpatient) values (?,?,?)" );
			ps.setDate(1,(Date) rdv.getDate_rv() );
			ps.setInt(2, rdv.getMedecin_idmedecin());
			ps.setInt(3, rdv.getPatient_idpatient());
			
			status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static void updateRv(RendezVous rdv) {
		
		try {
			
			Connection con = RendezVous_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update Rendez-Vous set  date_rv=? where idRendez-Vous = ?" );
			ps.setDate(1, (Date) rdv.getDate_rv());
						
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		
	}
	
	public static void deleteRv(int id) {
		
		
		try {
			
			Connection con = RendezVous_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" delete from Rendez-Vous where idRendez-Vous = ?" );
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	
	}
	
	public static RendezVous getRvById(int id) {
		
		RendezVous rv = new RendezVous();
		
		try {
			
			Connection con = RendezVous_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select date_rv,medecin_idmedecin,patient_idpatient from user where idRendezVous = ?" );
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				rv.setDate_rv(rs.getDate(1));
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		return rv;
		
	}
	
   
	public static RendezVous getRvByIdpatient(int id) {
		
		RendezVous rv = new RendezVous();
		
		try {
			
			Connection con = RendezVous_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select date_rv,medecin_idmedecin,patient_idpatient from rendez-vous where idRendVous = ?" );
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				rv.setDate_rv(rs.getDate(1));
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		return rv;
		
	}
	
	public static List<RendezVous> getAllUser(){
		
		List<RendezVous> liste = new ArrayList<RendezVous>();
		
	try {
			
			Connection con = RendezVous_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from rendez-vous" );
		
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				RendezVous rv = new RendezVous();
				rv.setDate_rv(rs.getDate(1));
				rv.setMedecin_idmedecin(rs.getInt(2));
				rv.setPatient_idpatient(rs.getInt(3));
				
				liste.add(rv);
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	return liste;
		
	}
	
}
