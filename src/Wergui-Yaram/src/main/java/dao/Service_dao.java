package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Service;

public class Service_dao {
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
	
	
	public static int insertUser(Service service) {
		int status = 0;
		
		try {
			
			Connection con = Service_dao.getconnection();
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
	
	public static void updateUser(Service service) {
		
		try {
			
			Connection con = Service_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" update service set  nom_service=? where id_service = ?" );
			ps.setString(1, service.getNom_service());
			ps.setInt(2, service.getIdservice());
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
		
	}
	
	public static void deleteService(int id) {
		
		
		try {
			
			Connection con = Service_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" delete from service where id_service = ?" );
			ps.setInt(1, id);
			
			ps.executeUpdate();
			
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	
	}
	
	public static Service getServiceById(int id) {
		
		Service service = new Service();
		
		try {
			
			Connection con = Service_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select nom_service from user where id_service = ?" );
			ps.setInt(1, id);
			
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
			
			Connection con = Service_dao.getconnection();
			PreparedStatement ps = con.prepareStatement(" select * from service" );
		
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Service service = new Service();
				service.setIdservice(rs.getInt(1));
				service.setNom_service(rs.getString(2));
				
				liste.add(service);
			}
			con.close();
			
		}catch(Exception e)
		{
			System.out.print("Erreur");
		}
		
	return liste;
		
	}
	
	public static Service getServiceByName(String name) {
	
		Connection con = Service_dao.getconnection();
		Service service = null;
		PreparedStatement ps;
		try {
			
			ps = con.prepareStatement(" select * from service where nom_service = ? " );
			
			ps.setString(1, name);
			
			ResultSet rs = ps.executeQuery();
			Service service2 = new Service();
			if(rs.next()) {
				service.setIdservice(rs.getInt("id_service"));
				service.setNom_service(rs.getString("nom_service"));
				
				service = service2;
				con.close();
				return service2;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return service;
	}
	

}
