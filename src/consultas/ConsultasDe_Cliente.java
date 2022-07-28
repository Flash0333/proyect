package consultas;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.util.ArrayList;

import base.Conexion;
import clases.Cliente;

public class ConsultasDe_Cliente {
	
	private ArrayList<Cliente> listaClientes;
	
	
	private Conexion c= new Conexion();;
	

		
	public static void main(String [] args) throws SQLException{

		ConsultasDe_Cliente cn = new ConsultasDe_Cliente();
		
		String sql=null;
		
		sql =cn.getClientes();
				
		cn.traerCliente(sql);
		
		int id=0; String nombre="",email="",contraseña="",telefono="";
		
		
		//todo funciona correctamente
		 id =2;
		sql= cn.getClientePorId(id);
		cn.traerCliente(sql);
		
		cn.mostrar_listaCliente(); // MUESTRA SOLO CUANDO LA CONSULTA ES EJECUTADA
		
		email="seleneforEver@gmail.com";
		sql= cn.getClientePorEmail(email);
		cn.traerCliente(sql);
		
		telefono="";
		sql= cn.getClientePorTelefono(telefono);
		cn.traerCliente(sql);
		
		nombre= "Selene";
		sql= cn.setNombreCliente(nombre,id);
		cn.c.insertUPDATE_deleteConsulta(sql);
		
		
		String contra="noHay_QuienMe_pare";
		sql= cn.setPass(contra,id);
		cn.c.insertUPDATE_deleteConsulta(sql);
		
		
		telefono="473121";
		sql= cn.setTelefono(telefono,id);
		cn.c.insertUPDATE_deleteConsulta(sql);
		
		
		sql =cn.getClientes();
		
		cn.traerCliente(sql);
		
		id=5;
		sql= cn.eliminarPorId(id);
		cn.c.insertUPDATE_deleteConsulta(sql);
		
		
		telefono="23213123";
		
		
		
		sql= cn.eliminarPorEmail(email);
		cn.c.insertUPDATE_deleteConsulta(sql);
		
		sql= cn.eliminarPorTelefono("1212");		
		cn.c.insertUPDATE_deleteConsulta(sql);
		
		sql = cn.getClientes();
		cn.c.demasConsulta(sql);
		
		
		
		
		nombre="Damian";
		email="ATRperri2000@gmail.com";
		contraseña="";
		telefono="";
		
		sql=cn.insertarCliente(id,nombre,email,contraseña,telefono);
		
		cn.c.insertUPDATE_deleteConsulta(sql);
		
		

	
	
	
	sql = cn.eliminarPORnombreYemail(nombre,email);
	cn.c.insertUPDATE_deleteConsulta(sql);
	
	cn.mostrar_listaCliente();
	cn.eliminarRepetidoENlista();
	
	cn.mostrar_listaCliente();

	
	nombre="maxi";
	email="maxi6y78@gmail.com";
	contraseña="wwdfrtg32e3";
	telefono="121";
	
	sql=cn.insertarCliente(id,nombre,email,contraseña,telefono);
	
	if(sql==null){
		
	}else{
	cn.c.insertUPDATE_deleteConsulta(sql);
	
	}
	
	
	
	}

	public void traerCliente(String sql) {
		// TODO Auto-generated method stub
		
		try {
			
			String tel=null;
			Cliente cl = null;
			
			listaClientes= new ArrayList<Cliente>();
			ResultSet rs= c.demasConsulta(sql);
			while (rs.next()) {
				int id= rs.getInt("idCliente");
				String nombre =rs.getString("nombre");
				String email= rs.getString("email");
				String contra= rs.getString("contraseña");
				if(rs.getString("telefono")!=null){
				tel= rs.getString("telefono");
			}
				
				cl = new Cliente(id,nombre,email,contra,tel);
				listaClientes.add(cl);
				cl.mostrarDatos();
			}
			
			/*rs.close();
			stmt.close();
			conn.close();*/
		if(cl==null){
			System.out.println("El cliente no existe ");
		}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	public void verificarSiExisteCliente(String sql,String email1,String contraseña){
		
			
			try {
				Cliente cl =null;
				
				String tel=null;
				
				//genera la consulta en mi base de datos
				ResultSet rs= c.demasConsulta(sql);
				while (rs.next()) {
					int id= rs.getInt("idCliente");
					String nombre =rs.getString("nombre");
					
					String email= rs.getString("email");
					String contra= rs.getString("contraseña");
					if(rs.getString("telefono")!=null){
					tel= rs.getString("telefono");
				}
					if(email1.equals(email)){
						if(contraseña.equals(contra)){
							System.out.println("ERROR AL INTENTAR REGISTRARSE"
									+ "!!Este cliente ya existe");
						}
					}else{
						
						cl = new Cliente(id , nombre, email,contra,tel);
						listaClientes.add(cl);
					}
					
				}
			}catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}	
	
	
	public ArrayList<Cliente> getListaClientes() {
		return listaClientes;
	}

	public void setListaClientes(ArrayList<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	public void mostrar_listaCliente(){
		for (Cliente cliente : listaClientes) {
			cliente.mostrarDatos();
		}
	}

	public void eliminarRepetidoENlista() {
		
        listaClientes.clear();
       
		
	}
	
	private String eliminarPORnombreYemail(String nombre, String email) {
		// TODO Auto-generated method stub
		return "Delete from cliente where 'nombre'='"+nombre+"', AND email='"+email+"';";
	}

	private String insertarCliente(int id, String nombre, String email, String contraseña, String telefono) {
		if(!existeCliente(email,contraseña)){
		return "INSERT INTO `cliente` VALUES("
		+  " '"+id+"',"
		+ " '"+nombre+"',"
		+ "'"+email+"', "
		+"'"+contraseña+"',"
		+"'"+telefono+"') ;";
		}else
			return null;
		
	}

	private boolean existeCliente(String email, String contraseña) {
		
		if(email!=null|contraseña!=null)
		{	
			String consulta= getClientes();

		
		verificarSiExisteCliente(consulta, email, contraseña);
		return true;
		}else{
		
		
		return false;
		}
		}

	private String eliminarPorEmail(String email) {
//		
		return "DELETE FROM `cliente` WHERE `email` = '"+email+"';";
	}
	
	private String eliminarPorTelefono(String telefono) {
//		
		return "DELETE FROM `cliente` WHERE `cliente`.`telefono` ='"+telefono+"';";
//		return "DELETE FROM `cliente` WHERE `telefono` ='"+telefono+"';";
	}

	private String eliminarPorId(int id) {
		//se ELIMINA TODO LOS DATOS de acuerdo el id pasado
		return "DELETE FROM `cliente` WHERE `idCliente` = "+id+";";
	}

	private String setTelefono(String string, int id) {
		System.out.println("telefono modificado");
		// se modifica el telefono deacuerdo al id y se coloca el telefono pasado
		return "UPDATE `cliente` SET `telefono` = '"+string+"' WHERE `idCliente` ="+id+";";
	}

	private String setPass(String string, int id) {
		System.out.println("contraseña modificada");
		// se modifica la contraseña deacuerdo al id
		return "UPDATE `cliente` SET `contraseña` = '"+string+"' WHERE `idCliente` ="+id+";";
	}

	private String setNombreCliente(String nombre,int id) {
		System.out.println("usuario modificado");
		// modifica o edita el nombre del campo donde el id sea igual al pasado por parametro
		return "UPDATE `cliente` SET `nombre` = '"+nombre+"' WHERE `cliente`.`idCliente` ="+id+";";
	}

	private String getClientePorTelefono(String telefono) {
		//trae el cliente por el telefono
		return "SELECT * FROM cliente WHERE telefono='"+telefono+"'";
	}

	private String getClientePorEmail(String email) {
		//trae el cliente por el gmail
		return "SELECT * FROM cliente WHERE email='"+email+"'";
	}

	private String getClientePorId(int id) {
		// TODO Auto-generated method stub
		return "SELECT * FROM cliente WHERE idCliente="+id;
	}

	private String getClientes() {
		// traer a todos de la tabla cliente
		return "SELECT * FROM cliente";
	}
	
}
