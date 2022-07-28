package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class INNER_JOIN {

	//nombre del jdbc en mysql (driver)
		public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
		
		
		public static final String DB_URL ="jdbc:mysql://localhost:3306/universidad";
		
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
				System.out.println("conectando....");
				conn= DriverManager.getConnection(DB_URL, USER, PASS);
				
				//4 ejecutar consulta sql
				System.out.println("*** creando statement (consulta)***");
				stmt = conn.createStatement();//
				
				String consulta;
				//5 probar consultas
				
				//actualizar-editar en el atributo dirección de la tabla persona solo en tal id
				consulta = "UPDATE `persona` SET `dirección` = 'Santa Rosa' WHERE `persona`.`id` = 2";
				stmt.executeUpdate(consulta);
				
			//CONSULTA CON INNER JOIN
				consulta="SELECT nombre,apellido,grado FROM persona t1 INNER JOIN curso t2 ON t1.id_curso = t2.id";
				
				
//				consulta="SELECT * from persona";
				
			
	 			ResultSet rs =stmt.executeQuery(consulta);
	 			
	 			while (rs.next()) {
					//ingresamos a los campos por el nombre de la columna
	 				//int id = rs.getInt("id");
	 				String nom = rs.getString("nombre");
	 				String ape = rs.getString("apellido");
	 				//String dire= rs.getString("dirección");
	 				String grado = rs.getString("grado");
	 				
	 				System.out.print(nom+" "+ape+"  --> "+grado+" ");
	 				System.out.println("");
	 				
				}
	 			
	 			rs.close();
				conn.close();
				stmt.close();
			} catch (Exception e) {
				System.err.println("Error al conectar");
			}
			System.out.println("SE TERMINO");
		}

}
