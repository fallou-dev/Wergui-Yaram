package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.RendezVous;

public class RendezVousDao {
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
			
			Connection con = RendezVousDao.getconnection();
			PreparedStatement ps = con.prepareStatement("insert into rendez-vous (date_rv,patient_idpatient,service_nom_service) values (?,?,?)" );
			ps.setDate(1,(Date) rdv.getDate_rv() );
			ps.setInt(2, rdv.getPatient_idpatient());
			ps.setString(3,rdv.getService_nom_service());
			
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
			
			Connection con = RendezVousDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update RendezVous set  date_rv=? where idRendezVous = ?" );
			ps.setDate(1, (Date) rdv.getDate_rv());
			ps.setInt(2, rdv.getIdRendezvous());
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		
	}
	
	public static void deleteRv(int id) {
		
		
		try {
			
			Connection con = RendezVousDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" delete from rendezvous where idRendezVous = ?" );
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
			
			Connection con = RendezVousDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select date_rv,patient_idpatient,service_nom_service from rendezvous where idRendezVous = ?" );
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				rv.setDate_rv(rs.getDate(1));
				rv.setPatient_idpatient(rs.getInt(2));
				rv.setService_nom_service(rs.getString(3));
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
			
			Connection con = RendezVousDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select date_rv,service_nom_service from rendezvous where patient_idpatient = ?" );
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				rv.setDate_rv(rs.getDate(1));
				rv.setService_nom_service(rs.getString(2));
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		return rv;
	}
	
	public static RendezVous getRvByService(String id) {
		
		RendezVous rv = new RendezVous();
		
		try {
			
			Connection con = RendezVousDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select date_rv,  patient_idpatient from rendezvous where service_nom_service = ?" );
			ps.setString(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				rv.setDate_rv(rs.getDate(1));
				rv.setPatient_idpatient(rs.getInt(2));
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		return rv;
	}
	
	
	public static List<RendezVous> getAllRendezVous(){
		
		List<RendezVous> liste = new ArrayList<RendezVous>();

	try {
		
			Connection con = RendezVousDao.getconnection();
			
			PreparedStatement ps = con.prepareStatement(" SELECT * FROM rendezvous ");
			
			ResultSet rs = ps.executeQuery();
			
			System.out.println("Connection OK");
			
			
			while(rs.next()) {
				RendezVous rv = new RendezVous();
				rv.setIdRendezvous(rs.getInt(1));
				rv.setDate_rv(rs.getDate(2));
				rv.setPatient_idpatient(rs.getInt(3));
				rv.setService_nom_service(rs.getString(4));
				
				liste.add(rv);
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur de listage");
		}
		
	return liste;
		
	}
	
}
