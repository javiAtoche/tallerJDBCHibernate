package org.springframework.samples.petclinic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCApplication {

	public static void main(String[] args) {
		System.out.println("-------- Test de conexión con MySQL ------------");

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver en el Classpath");
			e.printStackTrace();
			return;
		}

		System.out.println("Driver instalado y funcionando");
		Connection connection = null;
		Statement statement = null;
		try {
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/petclinic","root", "root");
			if (connection != null)
				System.out.println("Conexión establecida");
			
			// 1- Todos los clientes de la clinica	y mostrar sus datos por pantalla
//			ejercicio1(connection,statement);
			
			
			// 2 - Insertar un Owner
//			ejercicio2(connection,statement);
			
			// 3 - Modificar la ciudad del Owner insertado
//			ejercicio3(connection,statement);
			
			// 4 - por query parametrizada, encontrar a todos los dueños que coincidan O por NOMBRE O por APELLIDOS
			ejercicio4(connection,"Pepe","Escobito");
			
		    
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		} finally {
			try {
				if(statement != null)
					connection.close();
			} catch (SQLException se) {
		    	  
		    }
		    try {
		        if(connection != null)
		            connection.close();
		    } catch (SQLException se) {
		         	se.printStackTrace();
		    }
		}
	}
	
	public static void ejercicio1(Connection conn, Statement st) {
		// 1- Todos los clientes de la clinica	y mostrar sus datos por pantalla
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "SELECT * FROM petclinic.owners";
		ResultSet rs;
		try {
			rs = st.executeQuery(sql);
			// cabecera de campos
			System.out.print("id\t\t");
			System.out.print("first_name\t\t");
			System.out.print("last_name\t\t");
			System.out.print("address\t\t");
			System.out.print("city\t\t");
			System.out.println("telephone\t\t");
			
			while(rs.next()) { // ejecuto next para traer la primera fila, y las sucesivas, hasta que no haya mas rows...
				
				// recupera el valor del campo, con el nombre del campo y el tipo
				System.out.print(rs.getInt("id") + "\t\t");
				System.out.print(rs.getString("first_name") + "\t\t");
				System.out.print(rs.getString("last_name") + "\t\t");
				System.out.print(rs.getString("address") + "\t\t");
				System.out.print(rs.getString("city") + "\t\t");
				System.out.println(rs.getString("telephone") + "\t\t");
			}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
	}
	
	// 2 - Insertar un Owner
	public static void ejercicio2(Connection conn, Statement st) {
	
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "INSERT INTO petclinic.owners VALUES (11,\"Pepe\",\"García\",\"Calle Americo Vespucio 5\", \"Málaga\", \"666 333 444\")";
		
		ResultSet rs;
		try {
			int insertResult  = st.executeUpdate(sql);
			
			sql = "SELECT * FROM petclinic.owners";
			
			rs = st.executeQuery(sql);
			// cabecera de campos
			System.out.print("id\t\t");
			System.out.print("first_name\t\t");
			System.out.print("last_name\t\t");
			System.out.print("address\t\t");
			System.out.print("city\t\t");
			System.out.println("telephone\t\t");
			
			while(rs.next()) { // ejecuto next para traer la primera fila, y las sucesivas, hasta que no haya mas rows...
				
				// recupera el valor del campo, con el nombre del campo y el tipo
				System.out.print(rs.getInt("id") + "\t\t");
				System.out.print(rs.getString("first_name") + "\t\t");
				System.out.print(rs.getString("last_name") + "\t\t");
				System.out.print(rs.getString("address") + "\t\t");
				System.out.print(rs.getString("city") + "\t\t");
				System.out.println(rs.getString("telephone") + "\t\t");
			}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
	}
	
	// 3 - Modificar la ciudad del Owner insertado
	public static void ejercicio3(Connection conn, Statement st) {
		
		try {
			st = conn.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql = "UPDATE petclinic.owners SET city=\"Sevilla\" where petclinic.owners.id = 11";
		
		ResultSet rs;
		try {
			int updateResult  = st.executeUpdate(sql);
			
			sql = "SELECT * FROM petclinic.owners";
			
			rs = st.executeQuery(sql);
			// cabecera de campos
			System.out.print("id\t\t");
			System.out.print("first_name\t\t");
			System.out.print("last_name\t\t");
			System.out.print("address\t\t");
			System.out.print("city\t\t");
			System.out.println("telephone\t\t");
			
			while(rs.next()) { // ejecuto next para traer la primera fila, y las sucesivas, hasta que no haya mas rows...
				
				// recupera el valor del campo, con el nombre del campo y el tipo
				System.out.print(rs.getInt("id") + "\t\t");
				System.out.print(rs.getString("first_name") + "\t\t");
				System.out.print(rs.getString("last_name") + "\t\t");
				System.out.print(rs.getString("address") + "\t\t");
				System.out.print(rs.getString("city") + "\t\t");
				System.out.println(rs.getString("telephone") + "\t\t");
			}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
	}
	
	// 4 - por query parametrizada, encontrar a todos los dueños que coincidan O por NOMBRE O por APELLIDOS
public static void ejercicio4(Connection conn,String nombre, String apellido ) {
		
	
	String sql; // = "INSERT INTO petclinic.owners VALUES (11,\"Pepe\",\"García\",\"Calle Americo Vespucio 5\", \"Málaga\", \"666 333 444\")";
	sql = "SELECT * FROM petclinic.owners WHERE first_name = ? OR last_name = ?";
	
	ResultSet rs;
	
		try {
			
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, nombre);
			st.setString(2, apellido);
			
			rs = st.executeQuery();
			
			// cabecera de campos
			System.out.print("id\t\t");
			System.out.print("first_name\t\t");
			System.out.print("last_name\t\t");
			System.out.print("address\t\t");
			System.out.print("city\t\t");
			System.out.println("telephone\t\t");
			
			while(rs.next()) { // ejecuto next para traer la primera fila, y las sucesivas, hasta que no haya mas rows...
				
				// recupera el valor del campo, con el nombre del campo y el tipo
				System.out.print(rs.getInt("id") + "\t\t");
				System.out.print(rs.getString("first_name") + "\t\t");
				System.out.print(rs.getString("last_name") + "\t\t");
				System.out.print(rs.getString("address") + "\t\t");
				System.out.print(rs.getString("city") + "\t\t");
				System.out.println(rs.getString("telephone") + "\t\t");
			
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
					
					
	}

	
	
}
