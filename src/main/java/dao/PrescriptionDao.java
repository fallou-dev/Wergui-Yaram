package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Prescription;

public class PrescriptionDao {

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
	
	
	public static int insertUser(Prescription pres) {
		int status = 0;
		
		try {
			
			Connection con = PrescriptionDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" insert into prescription (date_prescription,note,consultation_idconsultation) values (?,?,?)" );
			ps.setDate(1, (Date) pres.getDate_prescription());
			ps.setString(2, pres.getNote());
			ps.setInt(2, pres.getConsultation_idconsultation());
			
			
			status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static void updatePrescription(Prescription pres) {
		
		try {
			
			Connection con = PrescriptionDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update prescription set  date_prescription=?,note=?,consultation_idconsultation=? where idprescription = ?" );
			ps.setDate(1, (Date) pres.getDate_prescription());
			ps.setString(2, pres.getNote());
			ps.setInt(3, pres.getConsultation_idconsultation());
			
			ps.setInt(4, pres.getIdprescription());
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		
	}
	
	public static void deletePrescription(int id) {
		
		
		try {
			
			Connection con = PrescriptionDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" delete from prescription where idprescription = ?" );
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	
	}
	
	public static Prescription getPrescriptionById(int id) {
		
		Prescription pres = new Prescription();
		
		try {
			
			Connection con = PrescriptionDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from prescription where idprescription = ?" );
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				pres.setIdprescription(rs.getInt(1));
				pres.setDate_prescription(rs.getDate(2));
				pres.setNote(rs.getString(3));
				pres.setConsultation_idconsultation(rs.getInt(4));
				
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		return pres;
		
	}
	
public static Prescription getPrescriptionByIdConsulation(int id) {
		
		Prescription pres = new Prescription();
		
		try {
			
			Connection con = PrescriptionDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from prescription where consultation_idconsultation = ?" );
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				pres.setIdprescription(rs.getInt(0));
				pres.setDate_prescription(rs.getDate(1));
				pres.setNote(rs.getString(2));
				pres.setConsultation_idconsultation(rs.getInt(3));
				
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		return pres;
		
	}
	
	public static List<Prescription> getAllPrescription(){
		
		List<Prescription> liste = new ArrayList<Prescription>();
		
	try {
			
			Connection con = PrescriptionDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from prescription" );
		
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Prescription pres = new Prescription();
				pres.setIdprescription(rs.getInt(1));
				pres.setDate_prescription(rs.getDate(2));
				pres.setNote(rs.getString(3));
				pres.setConsultation_idconsultation(rs.getInt(4));
				
				liste.add(pres);
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	return liste;
		
	}
	

	
}
