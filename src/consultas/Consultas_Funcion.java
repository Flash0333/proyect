package consultas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

import base.Conexion;
import clases.Funcion;
import clases.Pelicula;
import clases.Sala;

public class Consultas_Funcion {
	private Conexion c= new Conexion();
	private ArrayList<Funcion> listaFuncion;
	private Consultas_Pelicula cp=new Consultas_Pelicula();;
	private Consultas_Sala cs=new Consultas_Sala();;
	
	
	public static void main(String[] args) throws SQLException {
		
		
		Consultas_Funcion cf= new Consultas_Funcion();
		
		
		String sql="";
		
		int id_fun=1;int opcionPeli,opcionSala;
		
		cf.cp.TODOdePelicula("SELECT * FROM pelicula ");
		
		
		Scanner sc = new Scanner (System.in);
		System.out.print("Ingrese el id de la Pelicula:");

		opcionPeli=sc.nextInt();		
		Pelicula peli= cf.cp.traerPelicula(opcionPeli);
	
		
		cf.cs.todoDEsalas("SELECT * FROM sala");
		System.out.print("Ingrese el id de la Sala:");
		opcionSala = sc.nextInt();
		Sala sala= cf.cs.traerSala(opcionSala);
		
		
		int año=2022;
//		Date fecha = new Date(año,07,24);
		String hora = "17:00";
		
//		System.out.println(año);
		
		//precio con random
		int min=700;
		int max=1200;
		Random r = new Random();
		
		double precio = r.nextInt(max-min)+min;
		
		//fecha con clendar 
		Calendar calendario = Calendar.getInstance();
		int a = calendario.get(Calendar.YEAR);
		int mes = calendario.get(Calendar.MONTH);
		mes+=1;
		int dia = calendario.get(Calendar.DAY_OF_MONTH);
		
		String fecha = a+"-0"+mes+"-"+dia;
		
		
		
//		sql= cf.getFuncion(peli,sala,fecha,hora,precio);
//		cf.c.insertUPDATE_deleteConsulta(sql);
		
		
//		todas las funciones
		cf.TODOdePeliculaCON_join();
		
	}


	private String getFuncion( Pelicula peli,Sala sala,String fecha,String hora ,double precio) {
		if(!existePelicula(peli.getId_pelicula(),sala.getId_sala(),fecha,hora,precio)){
		System.out.println("ingresando funcion...");
		//INSERT INTO `funcion` (`id_funcion`, `id_pelicula`, `id_sala`, `fecha`, `hora`, `precio`) VALUES (NULL, '1', '1', '2022-07-21', '10:00', '900')
		return "INSERT INTO funcion VALUES(NULL,'"+peli.getId_pelicula()+"','"+sala.getId_sala()+"','"+fecha+"','"+hora+"',"+precio+" );";
	}else{
		return null;
		}
	}
	
	private boolean existePelicula(int id_pelicula, int id_sala, String fecha, String hora, double precio) {
		boolean existe=false;
		try {
			ResultSet rs= c.demasConsulta(joinCon_sala());
			
//			System.out.println("mostrando date..");
			String idi="";
			while (rs.next()) {
				Funcion f=null;			
				
				int id= rs.getInt("id_funcion");
				Pelicula p = new Pelicula();
				p.setId_pelicula(rs.getInt("id_pelicula"));
				
				
				
				Sala sala= new Sala();
				sala.setId_sala(rs.getInt("id_sala"));	;
				
				
				String fech= rs.getString("fecha");					
				String hor= rs.getString("hora");
				double prec= rs.getDouble("precio");
				
								
//				f = new Funcion(id,p,sala,fech,hor,prec);
				
				
				if(p.getId_pelicula()==id_pelicula||sala.getId_sala()==id_sala||fech.equals(fecha)){
					if(hor.equals(hora)){
					existe=true;
					System.out.println("Ya existe una funcion con estos mismo datos");
					return existe;
				}
				}
				}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		return existe;
		
	}
	


	private String getFuncion(){
		
		return "SELECT * FROM funcion";
		}
	
	private String getFuncion(int id){
		
		return "SELECT * FROM funcion WHERE id_funcion="+id;
		}
	

	private void TODOdePeliculaCON_join() {
		
		try{	
			
		Funcion f=null;				
		ResultSet rs= c.demasConsulta(joinCon_peliculaANDsala());
						
		String observacion="";
		while (rs.next()) {
			listaFuncion=new ArrayList<Funcion>();
			int id= rs.getInt("id_funcion");
			
			Pelicula p = new Pelicula();
			p.setId_pelicula(rs.getInt("id_pelicula"));
			p.setNombrePelicula(rs.getString("nombrePelicula"));
			
			
			Sala sala= new Sala();
			sala.setId_sala(rs.getInt("id_sala"));	;
			sala.setNombreSala(rs.getString("nombreSala"));		
			
			String fech= rs.getString("fecha");					
			String hor= rs.getString("hora");
			double prec= rs.getDouble("precio");
			
							
			f = new Funcion(id,p,sala,fech,hor,prec);
			
			listaFuncion.add(f);
			System.out.println(f.toString());
			
							
			}
	}catch (SQLException e) {
	
		e.printStackTrace();
			
	 }}	
private String joinCon_peliculaANDsala() {
	//	 para pelicula --->SELECT funcion.* ,pelicula.* FROM funcion 
//		INNER JOIN pelicula ON funcion.id_funcion=pelicula.id_pelicula;
		return "SELECT funcion.* ,sala.*,pelicula.* FROM funcion INNER JOIN sala ON funcion.id_funcion=sala.id_sala"
				+ " INNER JOIN pelicula ON funcion.id_funcion=pelicula.id_pelicula;";
	}

/*SELECT funcion.* ,pelicula.* ,sala.* FROM funcion
INNER JOIN sala ON funcion.id_funcion=sala.id_sala
INNER JOIN pelicula ON funcion.id_funcion=pelicula.id_pelicula
;*/

//		return existe;
		
	


	public String joinCon_sala(){
		String sql;		
		//todos los campos de ambas tablas
		sql="SELECT funcion.* ,sala.* FROM funcion INNER JOIN sala ON funcion.id_funcion=sala.id_sala;";
	
	//solo algunos
//		sql= "SELECT funcion.id_funcion ,funcion.fecha,funcion.hora,funcion.precio ,sala.* FROM funcion INNER JOIN sala ON funcion.id_funcion=sala.id_sala; ";
		
	return sql;
	}
	
}
