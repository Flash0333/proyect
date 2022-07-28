package consultas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.Conexion;
import clases.Pelicula;
import clases.Sala;

public class Consultas_Pelicula {

	private Conexion c= new Conexion();
	private ArrayList<Pelicula> listaPelicula=new ArrayList<Pelicula>();	
	
	public static void main(String[] args) throws SQLException {
		
		Consultas_Pelicula cp = new Consultas_Pelicula();
		
		String sql="",nombre="One piece pt 2",duracion="2h 20m",descripcion="Continuacion de One piece pt 1",genero="Aventura,Comedia,Historia";
		String clasificacion="Apto para todo público",idioma="Español Latino";
		
		
		
		sql = cp.insertPelicula(nombre,descripcion,duracion,genero,clasificacion,idioma);
		cp.c.insertUPDATE_deleteConsulta(sql);
		
		
		cp.limpiarLista();
//		cp.mostrarLista();
		
		sql= cp.getPeliculaPORnameOgen(nombre,genero);
		cp.TODOdePelicula(sql);
		
		
		nombre="Animales Fantasticos";
		sql= cp.getPeliculaPORname(nombre);
		cp.TODOdePelicula(sql);
		
//		cp.mostrarLista();
		
		int id=0;id=2;
		clasificacion="Apto para todo público";
		descripcion="";
		
		sql= cp.updatePelicula_clasifDESCRIdioma(id,clasificacion,idioma,descripcion);
		cp.c.insertUPDATE_deleteConsulta(sql);
		
		nombre="Campanita";
		genero= "Fantasia";
		sql= cp.updatePelicula_nameGENidioma(id,nombre,genero,idioma);
		cp.c.insertUPDATE_deleteConsulta(sql);
		
		sql= cp.deletePelicula(id);
		cp.c.insertUPDATE_deleteConsulta(sql);
	}

	public String deletePelicula(int id) {
		// TODO Auto-generated method stub
		System.out.println("borrando pelicula...");
		System.out.println("");
		return "DELETE FROM pelicula WHERE id_pelicula="+id;
	}

	public String updatePelicula_nameGENidioma(int id, String nombre, String genero,String idioma) {
		System.out.println("editando...");
		System.out.println("");
		return "UPDATE `pelicula` SET `nombrePelicula` = '"+nombre+"',genero='"+genero+"',idioma='"+idioma+"' WHERE id_pelicula ="+id+";";
	}

	public String updatePelicula_clasifDESCRIdioma(int id, String clasificacion, String idioma,String descri) {
		System.out.println("editando...");
		System.out.println("");
		return "UPDATE `pelicula` SET `clasificacion` = '"+clasificacion+"',idioma='"+idioma+"',descripcion='"+descri+"' WHERE id_pelicula ="+id+";";
	}

	public String getPeliculaPORname(String nombre) {
		// TODO Auto-generated method stub
		return "SELECT * FROM pelicula WHERE nombrePelicula='"+nombre+"';";
	}

	public void TODOdePelicula(String sql) {
		if(sql!=null){
			try {
				
				Pelicula p=null;				
				ResultSet rs= c.demasConsulta(sql);
								
				String observacion="";
				while (rs.next()) {
					int id= rs.getInt("id_pelicula");
					String nombrePelicula =rs.getString("nombrePelicula");
					String duracion= rs.getString("duracion");
					String descripcion= rs.getString("descripcion");					
					String genero= rs.getString("genero");
					String clasificacion= rs.getString("clasificacion");
					String idioma= rs.getString("idioma");
									
					p = new Pelicula(id,nombrePelicula,duracion,descripcion,genero,clasificacion,idioma);
					
					listaPelicula.add(p);
					p.mostrarPelicula();
					
									
					}
			}catch (SQLException e) {
			
				e.printStackTrace();
					
			 }}else{
				System.out.println("No se puede ejecutar una consulta vacia"); 
				System.out.println("");
			 }
	}

	public String getPeliculaPORnameOgen(String nombre, String genero) {
		// TODO Auto-generated method stub
		return "SELECT * FROM pelicula WHERE nombrePelicula='"+nombre+"' OR genero='"+genero+"';";
	}

	public String insertPelicula(String nombre, String duracion, String descripcion, String genero,
			String clasificacion, String idioma) {
	if(!existePelicula(nombre,duracion,descripcion,clasificacion,idioma,genero)){
		System.out.println("insertando pelicula....");
		System.out.println("");
		return "INSERT INTO `pelicula` VALUES (NULL, '"+nombre+"','"+descripcion+"', '"+duracion+"', '"+genero+"', '"+clasificacion+"', '"+idioma+"');";
	}else{
		return null;
	}
	}

	public boolean existePelicula(String nombre, String duracion, String descripcion, String clasificacion,
			String idioma, String genero) {
		try {
			ResultSet rs= c.demasConsulta(getPeliculas());
			
//			System.out.println("mostrando date..");
			String idi="";
			while (rs.next()) {
				
				int id= rs.getInt("id_pelicula");
				String nombrePeli =rs.getString("nombrePelicula");				
				String descri= rs.getString("descripcion");
				String dura= rs.getString("duracion");
				String gene= rs.getString("genero");
				String clasifi= rs.getString("clasificacion");
				idi = rs.getString("idioma");
				
				
				if(nombre.equals(nombrePeli)|descri.equals(descripcion)|dura.equals(duracion)){
					if(gene.equals(genero)|clasifi.equals(clasificacion)|idi.equals(idioma)){
					return true;
				}
				}
				}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
		
	}

	public String getPeliculas() {
		
		return "SELECT * FROM `pelicula`";
	}

	public void mostrarLista(){
		for (Pelicula pelicula : listaPelicula) {
			pelicula.mostrarPelicula();
		}
		
	}
	public void limpiarLista(){
		
		listaPelicula.clear();
	}
	
	public Pelicula traerPelicula(int opcion){
		for (int i = 0; i < listaPelicula.size(); i++) {
			if(opcion==listaPelicula.get(i).getId_pelicula()){
				return listaPelicula.get(i);
			}
			
			
		}
		return null;
	}
}
