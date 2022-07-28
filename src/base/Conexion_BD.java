package base;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Conexion_BD {

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
			
		//encontrarTodo(consulta,stmt);  <---descomentar para ver y comentar la de abajp
			
			/*insertamos una consulta por medio de  un metodo
			consulta =insertar(13, "La Rioja");
			stmt.executeUpdate(consulta);//actualizar
						
			*/
			
 		/*	consulta = insertarSinId(12,"Mendoza");
			stmt.executeUpdate(consulta);
 			
	esto puede verse en la base de dato (haciendo un refresh veremos los cambios)
	*/		
		
 			//consulta = traerPorID(2);
 			
 			//realizarConsulta(consulta,stmt);
 			
 		/*	consulta = modificarNombre(13,"Mendoza");
 			stmt.executeUpdate(consulta);*/
 	
 			
 	/*		consulta= eliminarPorID(13);
 			stmt.executeUpdate(consulta);*/
 			
 			
 			consulta = traerPorNombre("Corrientes");
 			
 			realizarConsulta(consulta,stmt);
 			
 			
			conn.close();
			stmt.close();
		} catch (Exception e) {
			System.err.println("Error al conectar");
		}
		System.out.println("SE TERMINO");
	}

	private static String traerPorNombre(String string) {
		// TODO Auto-generated method stub
		return "SELECT * FROM provincia WHERE nombre='"+string+"'";
	}

	private static String eliminarPorID(int i) {
		//se elimira la fila del campo provincia donde el id sea igual a i
		return "DELETE FROM provincia WHERE id="+i;
	}

	private static String modificarNombre(int i, String string) {
		// EDITAR EL NOMBRE DE UN CAMPO POR EL ID
//		UPDATE `provincia` SET `nombre` = 'Mendoz' WHERE `provincia`.`id` = 14

		//AMBOS RETURN FUNCIONAN CORRECTAMENTE
		return "UPDATE provincia SET nombre='"+string+"' WHERE id="+i;
		
//		return "UPDATE `provincia` SET `nombre` = '"+string+ "' WHERE `provincia`.`id` ="+i;
	}

	private static void realizarConsulta(String consulta, Statement stmt) {
		// TODO Auto-generated method stub
		
		try {
			
			ResultSet rs = stmt.executeQuery(consulta);
			
			while(rs.next()){//mientras tenga registro 
	// tipo de dato de la columna  guardado en la columna (accedo a ella por medio de rs.getInt("nombreColumna"))
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");				
				System.out.println("Id: "+id);
				System.out.println("Nombre: "+nombre);
				System.out.println("");
			}
			
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static String traerPorID(int id) {
		// TODO Auto-generated method stub
		return "SELECT * FROM provincia WHERE id="+id;
	}

	private static String insertarSinId(int i, String string) {
// este metodo permitira q el valor de id sea igual a null (no afecta en nada la base de dato ya q esta es auto_increment)
		return "INSERT INTO provincia(id , nombre) VALUES(null ,'"+string +"')";
		}

	private static void encontrarTodo(String consulta2, Statement stmt) {
		
		try {
			// ejecuta la consulta 
						
			ResultSet rs = stmt.executeQuery(consulta2);
			
			while(rs.next()){//mientras tenga registro 
	// tipo de dato de la columna  guardado en la columna (accedo a ella por medio de rs.getInt("nombreColumna"))
				int id = rs.getInt("id");
				String nombre = rs.getString("nombre");
				int id_provincia = rs.getInt("id_provincia");
				System.out.println("Id: "+id);
				System.out.println("Nombre: "+nombre);
//				System.out.println("id Provincia: "+id_provincia);
				System.out.println("");
			}
			
			stmt.close();
			rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}
	public static String insertar(int id , String nombre){
		//ingresando un valor en un campo
		//encerrando el nombre (en comilla simple ) ya q es un String (VARCHAR)
		return "INSERT INTO provincia(id , nombre) VALUES("+id +",'"+nombre +"')";
	}
	
		
	}
