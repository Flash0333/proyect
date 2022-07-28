package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import clases.Cliente;

public class Conexion {

	
	
	Connection conn=null;
	Statement stmt =null;
	
	public Conexion() {
		
		final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver";
		final String DB_URL="jdbc:mysql://localhost:3306/cine";
		final String USER="root";
		final String PASS="";

		try {
			Class.forName(JDBC_DRIVER);
			System.out.println("Conectando a la bdd..");
			conn=DriverManager.getConnection(DB_URL,USER,PASS);

         }catch(Exception e) {
        	 System.out.println("ERROR DE CONEXION");
		}
		
	}
	
	public ResultSet demasConsulta(String sql) throws SQLException {
		
		System.out.println("");
		stmt=conn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		
		System.out.println("Consulta realizada");

		
		System.out.println("");
		return rs;
	}
	
	public void insertUPDATE_deleteConsulta(String sql) throws SQLException {
		
			
//		System.out.println("Creando Consulta");
		
		
		if(sql!=null){
		stmt=conn.createStatement();
		stmt.executeUpdate(sql);
		
		
		String emoticon="\b ^o^ /";
//		System.out.println("Dato modificado/borrado o eliminado "+emoticon);
		
		System.out.println("");
	}else{
		System.out.println("Consulta vacia");
		System.out.println("");
	}

	}
	}
