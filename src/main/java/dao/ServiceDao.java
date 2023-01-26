package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Model.Service;

public class ServiceDao {

	
	public static Connection getconnection() {
		Connection connection = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/wergui-yaram","root","");
		}catch( Exception e)
		{
			System.out.println(e);
		}
		
		return connection;
	}
	
	
	public static int insertService(Service service) {
		int status = 0;
		
		try {
			
			Connection con = ServiceDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" insert into service (nom_service) values (?)" );
			ps.setString(1, service.getNom_service());
			
			status = ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return status;
	}
	
	public static void updateService(Service service) {
		
		try {
			
			Connection con = ServiceDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update service set  nom_service=? where nom_service=? " );
			ps.setString(1, service.getNom_service());

			ps.setString(2, service.getNom_service());
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		
	}
	
	public static void deleteService(String nom_service) {
		
		
		try {
			
			Connection con = ServiceDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" delete from service where nom_service = ?" );
			ps.setString(1, nom_service);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	
	}
	
	public static 	Service getServiceByName(String nom_service) {
		
		Service service = new Service();
		
		try {
			
			Connection con = ServiceDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select nom_service from service where nom_service = ?" );
			ps.setString(1, nom_service);
			
			ResultSet rs = ps.executeQuery();
			
			if(rs.next()) {
				service.setNom_service(rs.getString(1));
			
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		return service;
		
	}
	
	public static List<Service> getAllService(){
		
		List<Service> liste = new ArrayList<Service>();
		
	try {
			
			Connection con = ServiceDao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from service" );
		
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Service service = new Service();
				service.setNom_service(rs.getString(1));
				liste.add(service);
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	return liste;
		
	}
	
}
