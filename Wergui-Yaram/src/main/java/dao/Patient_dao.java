package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Patient;


public class Patient_dao {

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
	
	
	public static int insertUser(Patient patient) {
		int status = 0;
		
		try {
			
			Connection con = Patient_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" insert into patient (nom_patient,prenom_patient,email,telephone,motdepasse,Date_de_naissance,Sexe,adresse,situation_familliale,Personne_a_prevenir,tel_Personne_a_prevenir,valide_compte) values (?,?,?,?,?,?,?,?,?,?,?,?)" );
			ps.setString(1, patient.getNom_patient());
			ps.setString(2, patient.getPrenom_patient());
			ps.setString(3, patient.getEmail());
			ps.setString(4, patient.getTelephone());
			ps.setString(5, patient.getMotdepasse());
			ps.setString(6, patient.getDate_de_naissance());
			ps.setString(7, patient.getSexe());
			ps.setString(8, patient.getAdresse());
			ps.setString(9, patient.getSituation_familliale());
			ps.setString(10, patient.getPersonne_a_prevenir());
			ps.setString(11, patient.getTel_Personne_a_prevenir());
			ps.setInt(12, patient.getValide_compte());
						
			status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static void updateUser(Patient patient) {
		
		try {
			
			Connection con = Patient_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update user set  nom_patient=?,prenom_patient=?,email=?,telephone=?,motdepasse=?,Date_de_naissance=?,Sexe=?,adresse=?,situation_familliale=?,Personne_a_prevenir=?,tel_Personne_a_prevenir=? where id = ?" );
			
			ps.setString(1, patient.getNom_patient());
			ps.setString(2, patient.getPrenom_patient());
			ps.setString(3, patient.getEmail());
			ps.setString(4, patient.getTelephone());
			ps.setString(5, patient.getMotdepasse());
			ps.setString(6, patient.getDate_de_naissance());
			ps.setString(7, patient.getSexe());
			ps.setString(8, patient.getAdresse());
			ps.setString(9, patient.getSituation_familliale());
			ps.setString(10, patient.getPersonne_a_prevenir());
			ps.setString(11, patient.getTel_Personne_a_prevenir());
			
			
			ps.setInt(12, patient.getIdpatient());
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		
	}
	
	public static void deletePatient(int id) {
		
		
		try {
			
			Connection con = Patient_dao.getconnection();
			PreparedStatement ps = con.prepareStatement("update patient set compte_valide = 0 where id = ?" );
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	
	}
	
	public static Patient getPatientById(int id) {
		
		Patient patient = new Patient();
		
		try {
			
			Connection con = Patient_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select nom_patient,prenom_patient,email,telephone,motdepasse,Date_de_naissance,Sexe,adresse,situation_familliale,Personne_a_prevenir,tel_Personne_a_prevenir,valide_compte from patient where id = ?" );
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				patient.setNom_patient(rs.getString(1));
				patient.setPrenom_patient(rs.getString(2));
				patient.setEmail(rs.getString(3));
				patient.setTelephone(rs.getString(4));
				patient.setMotdepasse(rs.getString(5));
				patient.setDate_de_naissance(rs.getString(6));
				patient.setSexe(rs.getString(7));
				patient.setAdresse(rs.getString(8));
				patient.setSituation_familliale(rs.getString(9));
				patient.setPersonne_a_prevenir(rs.getString(10));
				patient.setTel_Personne_a_prevenir(rs.getString(11));
				patient.setValide_compte(rs.getInt(12));
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		return patient;
		
	}
	
	public static List<Patient> getAllUser(){
		
		List<Patient> liste = new ArrayList<Patient>();
		
	try {
			
			Connection con = Patient_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from patient" );
		
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Patient patient = new Patient();
				
				patient.setNom_patient(rs.getString(1));
				patient.setPrenom_patient(rs.getString(2));
				patient.setEmail(rs.getString(3));
				patient.setTelephone(rs.getString(4));
				patient.setMotdepasse(rs.getString(5));
				patient.setDate_de_naissance(rs.getString(6));
				patient.setSexe(rs.getString(7));
				patient.setAdresse(rs.getString(8));
				patient.setSituation_familliale(rs.getString(9));
				patient.setPersonne_a_prevenir(rs.getString(10));
				patient.setTel_Personne_a_prevenir(rs.getString(11));
				patient.setValide_compte(rs.getInt(12));
				
				liste.add(patient);
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	return liste;
		
	}
	
	public static Patient getUserBylogin(String login,String password) {
	
		Connection con = 	Patient_dao.getconnection();
		Patient patient = null;
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(" select * from patient where telephone = ? and motdepasse = ?" );
			
			ps.setString(1, login);
			ps.setString(2, password);
			
			ResultSet rs = ps.executeQuery();
			Patient patient2 = new Patient();
			if(rs.next()) {
				patient2.setIdpatient(rs.getInt("idpatient"));
				patient2.setNom_patient(rs.getString("nom_patient"));
				patient2.setPrenom_patient(rs.getString("prenom_patient"));
				patient2.setEmail(rs.getString("email"));
				patient2.setTelephone(rs.getString("telephone"));
				patient2.setMotdepasse(rs.getString("motdepasse"));
				patient2.setDate_de_naissance(rs.getString("date_de_naissance"));
				patient2.setSexe(rs.getString("sexe"));
				patient2.setAdresse(rs.getString("adresse"));
				patient2.setSituation_familliale(rs.getString("situation_familliale"));
				patient2.setPersonne_a_prevenir(rs.getString("personne_a_prevenir"));
				patient2.setTel_Personne_a_prevenir(rs.getString("tel_personne_a_prevenir"));
				patient2.setValide_compte(rs.getInt("valide_compte"));
			
				
				patient = patient2;
				con.close();
				return patient2;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return patient;
	}
	
}
