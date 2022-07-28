package consultas;

import java.io.ObjectInputStream.GetField;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import base.Conexion;
import clases.Cliente;
import clases.Sala;

public class Consultas_Sala {


	private Conexion c= new Conexion();
	private ArrayList<Sala> listSalas=new ArrayList<Sala>();
	
	
	public ArrayList<Sala> getListSalas() {
		return listSalas;
	}

	public void setListSalas(ArrayList<Sala> listSalas) {
		this.listSalas = listSalas;
	}

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		Consultas_Sala cs= new Consultas_Sala();
		
		
		String consulta="";
//		consulta= cs.getSalas();
//		cs.todoDEsalas(consulta);
			
		
		int id=1,capacidad=0; 
		String nombreSala="",tipoSala="",observacion="";
		
/*		 nombreSala="Sala 4";
		 
			consulta= cs.getSalaPORid(id);
			cs.todoDEsalas(consulta);
		
			
		consulta= cs.buscarSalaPORnombre(nombreSala);	
		cs.todoDEsalas(consulta);
		
		
		consulta= cs.buscarSalaPORnombrePORtipo(tipoSala);
		cs.todoDEsalas(consulta);
		*/
		
		
		//FUNCIONES PARA EL ADMINISTRADOR
		
		id=12;
		nombreSala="Sala 6";
		tipoSala="3D";
		capacidad=200;
		
		//ingresar campos en sala 
		
	/*	consulta = cs.insertarDatosEnSala(id,nombreSala,tipoSala,capacidad,observacion);
		cs.c.insertarModi_deleteConsulta(consulta);
//		

		
//		cs.limpiarListaSala(); //este serviara cuando haya duplicados
		
		
		
		consulta=cs.getSalas();
		cs.todoDEsalas(consulta);
		
		cs.mostrarLISTASalas();
		//modificar
		
		
		consulta= cs.actualizarSala_porID_nombreTIPOcapacidad(id,nombreSala,tipoSala,capacidad);
		cs.c.insertarModi_deleteConsulta(consulta);	
		
		id=4; nombreSala= "Sala 3"; 
		capacidad=160;
		
		consulta= cs.actualizarSala_porID_nombreYcapacidad(id, nombreSala, capacidad);
		cs.c.insertarModi_deleteConsulta(consulta);
		
		nombreSala="Sala 12";
		consulta= cs.actualizarSala_porID_nombreYtipo(id, nombreSala,tipoSala);
		cs.c.insertarModi_deleteConsulta(consulta);
		
		
		id=12;
		capacidad=245;
		consulta= cs.actualizarSala_porID_capacidad(id, capacidad);
		cs.c.insertarModi_deleteConsulta(consulta);
		
		
		tipoSala="2D";
		consulta= cs.actualizarSala_porID_tipo(id, tipoSala);
		cs.c.insertarModi_deleteConsulta(consulta);
		
		nombreSala="Sala Premium";
		consulta= cs.actualizarSala_porID_nombre(id, nombreSala);
		cs.c.insertarModi_deleteConsulta(consulta);*/
		
		consulta=cs.getSalas();
		cs.todoDEsalas(consulta);
		
//		cs.mostrarLISTASalas();

		
//		consulta= cs.eliminarPOR_id(id);
//		cs.c.insertarModi_deleteConsulta(consulta);
		
	}

	public String eliminarPOR_id(int id) {
		System.out.println("");
		if(existeSalaPORid(id)){
			
			System.out.println("Eliminando fila...");
			return "DELETE FROM `sala` WHERE `sala`.`id_sala`="+id+" ;";
				
				}else{
				System.out.println("Noo existe esa sala");
				System.out.println("");
				return null;
			}
		
	}

	public String actualizarSala_porID_nombre(int id, String nombreSala) {
		if(existeSalaPORid(id)){
			System.out.println("editando Sala....");
			return "UPDATE `sala` SET  `nombreSala` = '"+nombreSala+"' WHERE `sala`.`id_sala` ="+id+" ;";
				
				}else{

				System.out.println("Noo existe esa sala");
				System.out.println("");
				return null;
			}
	}

	public String actualizarSala_porID_tipo(int id, String tipoSala) {
		if(existeSalaPORid(id)){
			System.out.println("editando Sala....");
			return "UPDATE `sala` SET  `tipoSala` = '"+tipoSala+"' WHERE `sala`.`id_sala` ="+id+" ;";
				
				}else{
				
				System.out.println("Noo existe esa sala");
				System.out.println("");
				return null;
			}
	}

	public String actualizarSala_porID_nombreYtipo(int id, String nombreSala, String tipoSala) {
		if(existeSalaPORid(id)){
			System.out.println("editando Sala....");
			return "UPDATE `sala` SET `nombreSala` = '"+nombreSala+"', `tipoSala` = '"+tipoSala+"' WHERE `sala`.`id_sala` ="+id+" ;";
				
				}else{
				System.out.println("Noo existe esa sala");
				System.out.println("editando Sala....");
				return null;
			}
	}

	public String actualizarSala_porID_capacidad(int id, int capacidad) {
		if(existeSalaPORid(id)){
			System.out.println("editando Sala....");
			System.out.println("");
				return "UPDATE `sala` SET  `capacidadSala` = '"+capacidad+"' WHERE `sala`.`id_sala` ="+id+" ;";
					
					}else{
					System.out.println("Noo existe esa sala");
					System.out.println("");
					return null;
				}
		}	

	public String actualizarSala_porID_nombreYcapacidad(int id, String nombreSala, int capacidad) {
		if(existeSalaPORid(id)){
			System.out.println("editando Sala....");
			System.out.println("");
			return "UPDATE `sala` SET `nombreSala` = '"+nombreSala+"', `capacidadSala` = '"+capacidad+"' WHERE `sala`.`id_sala` ="+id+" ;";
				
				}else{
				System.out.println("Noo existe esa sala");
				System.out.println("");
				return null;
			}
	}

	public String actualizarSala_porID_nombreTIPOcapacidad(int id, String nombreSala, String tipoSala, int capacidad) {
		if(existeSalaPORid(id)){
			System.out.println("editando Sala....");
			System.out.println("");
	return "UPDATE `sala` SET `nombreSala` = '"+nombreSala+"', `tipoSala` = '"+tipoSala+"', `capacidadSala` = '"+capacidad+"' WHERE `sala`.`id_sala` ="+id+" ;";
		
		}else{
		System.out.println("Noo existe esa sala");
		System.out.println("");
		return null;
	}
		
		}
	

	public boolean existeSalaPORid(int id) {
		try {
			ResultSet rs= c.demasConsulta(getSalas());
			
			System.out.println("mostrando date..");
			String observa="";
			while (rs.next()) {
				int ident= rs.getInt("id_sala");
				String nombre =rs.getString("nombreSala");
				
				String tipo= rs.getString("tipoSala");
				int capacidadSala= rs.getInt("capacidadSala");
				observa = rs.getString("observacionSala");
				
				if(rs.getString("observacionSala")!=null){
				observa= rs.getString("observacionSala");
				}
				
				if(ident==id){
					return true;
				}
					
				}
				
					
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	public void limpiarListaSala() {
		try {
			
			System.out.println("limpiando sala....");
			
			
			if(!listSalas.isEmpty()){
			listSalas.clear();
		}else{
			System.out.println("nada q limpiar");
		}
		System.out.println("");
		
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private String insertarDatosEnSala(int id, String nombreSala ,String tipoSala,int capa, String observacion) {
		if(!existeSala(id,nombreSala,tipoSala,capa,observacion)){
			System.out.println("insertando Sala....");
			System.out.println("");
		return "INSERT INTO sala VALUES("+id+", '"+nombreSala+"', '"+tipoSala+"' ,"+capa+", '"+observacion+"');";
	}
		return null;
		}

	private boolean existeSala(int id, String nombreSala, String tipoSala,int capa,String observacion) {
		
		
				
		
		return false;
	}

	private String buscarSalaPORnombrePORtipo(String tipoSala) {
		if(existeSala(tipoSala)){
			
		return "SELECT * FROM `sala` WHERE tipoSala='"+tipoSala+"';";
	}
		return null;
		}

	private boolean existeSala(String tipoSala) {
		try {
			ResultSet rs= c.demasConsulta(getSalas());
			
			System.out.println("mostrando date..");
			String observacion="";
			while (rs.next()) {
				int ident= rs.getInt("id_sala");
				String nombre =rs.getString("nombreSala");
				
				String tipo= rs.getString("tipoSala");
				int capacidadSala= rs.getInt("capacidadSala");
				observacion = rs.getString("observacionSala");
				
				if(rs.getString("observacionSala")!=null){
				observacion= rs.getString("observacionSala");
				}
				if(tipo.equals(tipoSala)){
					return true;
				}
				
				}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	public String buscarSalaPORnombre(String nombreSala) {
//		if(verificarPORnombre(nombreSala)){
		return "SELECT * FROM `sala` WHERE nombreSala='"+nombreSala+"';";
//		}
			
//		return null;
	}
	

	public boolean verificarPORnombre(String nombreSala) {
		try {
			
			Sala s=null;
			
			
			ResultSet rs= c.demasConsulta(getSalas());
			
			System.out.println("mostrando date..");
			String observacion="";
			while (rs.next()) {
				int ident= rs.getInt("id_sala");
				String nombre =rs.getString("nombreSala");
				
				String tipoSala= rs.getString("tipoSala");
				int capacidadSala= rs.getInt("capacidadSala");
				observacion = rs.getString("observacionSala");
				
				if(rs.getString("observacionSala")!=null){
				observacion= rs.getString("observacionSala");
			}
				if(nombre.equals(nombreSala)){	
					System.out.println("Existe!!");
					System.out.println("");
//					s = new Sala(ident , nombreSala, tipoSala,capacidadSala,observacion);
//					s.mostrarSala();
					return true;
				}else{
					System.out.println("No existe usuario con ese id");
					return false;
				}
				
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
	

	public String getSalaPORid(int id) {
		// TODO Auto-generated method stub
		if(verificarSalaPORid(id)){
		return "SELECT * FROM `sala` WHERE id_sala="+id+";";
		}else{
			return null;
		}
		
	}

	public boolean verificarSalaPORid(int id) {
		// TODO Auto-generated method stub
		try {
			
			Sala s=null;
			
			
			ResultSet rs= c.demasConsulta(getSalas());
			
			System.out.println("mostrando date..");
			String observacion="";
			while (rs.next()) {
				int ident= rs.getInt("id_sala");
				String nombreSala =rs.getString("nombreSala");
				
				String tipoSala= rs.getString("tipoSala");
				int capacidadSala= rs.getInt("capacidadSala");
				observacion = rs.getString("observacionSala");
				
				if(rs.getString("observacionSala")!=null){
				observacion= rs.getString("observacionSala");
			}
				if(ident==id){	
					System.out.println("Existe!!");
					System.out.println("");
					s = new Sala(id , nombreSala, tipoSala,capacidadSala,observacion);
//					s.mostrarSala();
					return true;
				}else{
					System.out.println("No existe usuario con ese id");
					return false;
				}
				
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	public void todoDEsalas(String sql) {
//		listSalas= new ArrayList<Sala> ();
		if(sql!=null){
		try {
			
			Sala s=null;
			
			
			ResultSet rs= c.demasConsulta(sql);
			
			System.out.println("mostrando date..");
			String observacion="";
			while (rs.next()) {
				int id= rs.getInt("id_sala");
				String nombreSala =rs.getString("nombreSala");
				
				String tipoSala= rs.getString("tipoSala");
				int capacidadSala= rs.getInt("capacidadSala");
				observacion = rs.getString("observacionSala");
				
				if(rs.getString("observacionSala")!=null){
				observacion= rs.getString("observacionSala");
			}
								
				s = new Sala(id , nombreSala, tipoSala,capacidadSala,observacion);
				
				listSalas.add(s);
				
				s.mostrarSala();
				
			
				}
		}
			
		 catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		
		 }}else{
			System.out.println("No se puede ejecutar una consulta vacia"); 
			System.out.println("");
		 }
	}

	public String getSalas() {
		// TODO Auto-generated method stub
		return "SELECT * FROM `sala`;";
	}

	public void mostrarLISTASalas(){
	
		if(listSalas.isEmpty()){
			System.out.println("LA lista no contiene nada");
		}else{
			System.out.println("");
			
			System.out.println("0-0");
			
			for (int i = 0; i <listSalas.size(); i++) {
				listSalas.get(i).mostrarSala();
			}
			
		}
		System.out.println("");
		
				
	}
	public Sala traerSala(int id){
	
		for (int i = 0; i < listSalas.size(); i++) {
			if(id==listSalas.get(i).getId_sala()){
				return listSalas.get(i);
			}
		}
		return null;
		
	}
}
