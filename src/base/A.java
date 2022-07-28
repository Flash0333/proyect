package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class A {

	//nombre del jdbc en mysql (driver)
		public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		
		static //direccion de la base de datos (maquina local)
		String base= "probando";
		
		public static final String DB_URL ="jdbc:mysql://localhost:3306/"+base;
		
		//nombre del usuario y contraseña
		public static String USER ="root";
		public static String PASS ="";

		
		
		public static void main(String[] args) {
			//GOOGLEAR  --> conectar con mysql

			Connection conn = null;
			Statement stmt = null;
			
			try {
				//2 registrar el driver
				Class.forName(JDBC_DRIVER);
				
				//3 abrir conexion
				System.out.println("conectando");
				conn= DriverManager.getConnection(DB_URL, USER, PASS);
				
				//4 ejecutar consulta sql
				System.out.println("*** creando statement (consulta)***");
				stmt = conn.createStatement();//
				
				String consulta;
				//5 probar consultas
				
				String campo ="provincia";
	 			consulta = "SELECT * FROM "+campo;
				
			ResultSet rs = stmt.executeQuery(consulta);
			
			while(rs.next()){//mientras tenga registro(campo-atributo) se ejecutara
				// tipo de dato de la columna  guardado en la columna (accedo a ella por medio de rs.getInt("nombreColumna"))
							int id = rs.getInt("id");
							String nombre = rs.getString("nombre");				
							System.out.println("Id: "+id);
							System.out.println("Nombre: "+nombre);
							System.out.println("");
						}
	 			
				conn.close();
				stmt.close();
			} catch (Exception e) {
				System.err.println("Error al conectar");
			}
			System.out.println("SE TERMINO");
		}
}
