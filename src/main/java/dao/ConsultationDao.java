package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Consultation;

public class ConsultationDao {
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
	
	
	public static int insertConsultation(Consultation consultation) {
		int status = 0;
		
		try {
			
			Connection con = ConsultationDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" insert into consultation (Date_consultation,synthese,medecin_idmedecin,patient_idpatient,service_nom_service) values (?,?,?,?,?)" );
			ps.setDate(1, (Date) consultation.getDate_consultation());
			ps.setString(2, consultation.getSynthese());
			ps.setInt(3, consultation.getMedecin_idmedecin());
			ps.setInt(4, consultation.getPatient_idpatient());
			ps.setString(5, consultation.getService_nomservice());
		
			
			status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static void updateConsultation(Consultation consultation) {
		
		try {
			
			Connection con = ConsultationDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update consultation set Date_consultation= ?,synthese = ?,medecin_idmedecin = ?,patient_idpatient = ?,service_nom_service = ? where idconsultation = ?" );
			ps.setDate(1, (Date) consultation.getDate_consultation());
			ps.setString(2, consultation.getSynthese());
			ps.setInt(3, consultation.getMedecin_idmedecin());
			ps.setInt(4, consultation.getPatient_idpatient());
			ps.setString(5, consultation.getService_nomservice());
			
			ps.setInt(6, consultation.getIdconsultation());
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur de mis a jour");
		}
		
		
	}
	
	public static void deleteConsultation(int id) {
		
		
		try {
			
			Connection con = ConsultationDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" delete from consultation where idconsultation = ?" );
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	
	}
	
	public static Consultation getConsultationById(int id) {
		
		Consultation cons = new Consultation();
		
		try {
			
			Connection con = ConsultationDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from consultation where idconsultation = ?" );
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				cons.setIdconsultation(rs.getInt(1));
				cons.setDate_consultation(rs.getDate(2));
				cons.setSynthese(rs.getString(3));
				cons.setMedecin_idmedecin(rs.getInt(4));
				cons.setPatient_idpatient(rs.getInt(5));
				cons.setService_nomservice(rs.getString(6));
				
					
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur search Id");
		}
		
		return cons;
		
	}
	
    
	public static Consultation getConsultationByIdPatient(int id) {
		
		Consultation cons = new Consultation();
		
		try {
			
			Connection con = ConsultationDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from consultation where patient_idpatient = ?" );
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				cons.setIdconsultation(rs.getInt(1));
				cons.setDate_consultation(rs.getDate(2));
				cons.setSynthese(rs.getString(3));
				cons.setMedecin_idmedecin(rs.getInt(3));
				cons.setPatient_idpatient(rs.getInt(4));
				cons.setService_nomservice(rs.getString(5));
				
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		return cons;
		
	}
	
	public static Consultation getConsultationByIdMedecin(int id) {
		
		Consultation cons = new Consultation();
		
		try {
			
			Connection con = ConsultationDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from consultation where medecin_idmedecin = ?" );
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				cons.setIdconsultation(rs.getInt(1));
				cons.setDate_consultation(rs.getDate(2));
				cons.setSynthese(rs.getString(3));
				cons.setMedecin_idmedecin(rs.getInt(3));
				cons.setPatient_idpatient(rs.getInt(4));
				cons.setService_nomservice(rs.getString(5));
				
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		return cons;
		
	}
	
public static Consultation getConsultationByService(String service) {
		
		Consultation cons = new Consultation();
		
		try {
			
			Connection con = ConsultationDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from consultation where service_nom_service = ?" );
			ps.setString(1, service);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				cons.setIdconsultation(rs.getInt(1));
				cons.setDate_consultation(rs.getDate(2));
				cons.setSynthese(rs.getString(3));
				cons.setMedecin_idmedecin(rs.getInt(3));
				cons.setPatient_idpatient(rs.getInt(4));
				cons.setService_nomservice(rs.getString(5));
				
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		return cons;
		
	}
	
	public static List<Consultation> getAllConsultation(){
		
		List<Consultation> liste = new ArrayList<Consultation>();
		
	try {
			
			Connection con = ConsultationDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from consultation" );
		
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Consultation cons = new Consultation();
				cons.setIdconsultation(rs.getInt(1));
				cons.setDate_consultation(rs.getDate(2));
				cons.setSynthese(rs.getString(3));
				cons.setMedecin_idmedecin(rs.getInt(4));
				cons.setPatient_idpatient(rs.getInt(5));
				cons.setService_nomservice(rs.getString(6));
				liste.add(cons);
			}
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	return liste;
		
	}
	
public static List<Consultation> getAllConsultationPatient(int id){
		
		List<Consultation> liste = new ArrayList<Consultation>();
		
	try {
			
			Connection con = ConsultationDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from consultation where patient_idpatient = ?" );
			ps.setInt(1, id);
		
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Consultation cons = new Consultation();
				cons.setIdconsultation(rs.getInt(1));
				cons.setDate_consultation(rs.getDate(2));
				cons.setSynthese(rs.getString(3));
				cons.setMedecin_idmedecin(rs.getInt(4));
				cons.setPatient_idpatient(rs.getInt(5));
				cons.setService_nomservice(rs.getString(6));
				liste.add(cons);
			}
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	return liste;
		
	}
	

}
