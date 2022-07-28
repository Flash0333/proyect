package consultas;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import base.Conexion;
import clases.Descuento;
import clases.Pelicula;

public class Consultas_Descuento {
	
	private Conexion c= new Conexion();
	private ArrayList<Descuento> listaDescuento=new ArrayList<Descuento>();

	public static void main(String[] args) throws SQLException {
		
		
		Consultas_Descuento cd= new Consultas_Descuento();
		
		String sql="";
		int id=0;
		String dia_descuento="Martes";
		String porcentajeDescuento="15%";
		
		
		sql = cd.insertDescuento(dia_descuento,porcentajeDescuento);
		cd.c.insertUPDATE_deleteConsulta(sql);
		
		
		id=0;
		sql = cd.updateDescuento(id,dia_descuento,porcentajeDescuento);
		cd.c.insertUPDATE_deleteConsulta(sql);
			
		id=2; dia_descuento="Miercoles";
		sql = cd.updateDescuentoPORdia(id,dia_descuento);
		cd.c.insertUPDATE_deleteConsulta(sql);
		
		porcentajeDescuento="20%";
		sql = cd.updateDescuentoPORcentaje(id,porcentajeDescuento);
		cd.c.insertUPDATE_deleteConsulta(sql);
		
		
		sql= cd.getDescuentos();
		cd.TODOde_Descuento(sql);
		
		cd.mostrarLista();
		
		sql= cd.deleteDescuento(id);
		cd.c.insertUPDATE_deleteConsulta(sql);
	}

	private String deleteDescuento(int id) {
		if(existeDescuento(id)){
			System.out.println("eliminando descuento...");
			return "DELETE FROM descuento WHERE id_descuento= "+id+";";	
		}else{
			System.out.println("id invalido");
			return null;
		}
	}

	private void TODOde_Descuento(String sql) {
		if(sql!=null){
			try {
				
				Descuento d=null;				
				ResultSet rs= c.demasConsulta(sql);
								
				String observacion="";
				while (rs.next()) {
					int id_descuento= rs.getInt("id_descuento");					
					String diaDescuento= rs.getString("diaDescuento");
					String porcentajeDescuento= rs.getString("porcentajeDescuento");					
					
									
					d = new Descuento(id_descuento,diaDescuento,porcentajeDescuento);
					
					listaDescuento.add(d);
//					d.mostrarDescuento();
//					System.out.println("");
									
					}
			}catch (SQLException e) {
			
				e.printStackTrace();
					
			 }}else{
				System.out.println("No se puede ejecutar una consulta vacia"); 
				System.out.println("");
			 }
	}

	private String updateDescuentoPORcentaje(int id, String porcentajeDescuento) {
		if(existeDescuento(id)){
			System.out.println("editando descuento...");
			return "UPDATE descuento SET porcentajeDescuento='"+porcentajeDescuento+"' WHERE id_descuento= "+id+";";	
		}else{
			System.out.println("id invalido");
			return null;
		}
	}

	private String updateDescuentoPORdia(int id, String dia_descuento) {
		if(existeDescuento(id)){
			System.out.println("editando descuento...");
			return "UPDATE descuento SET diaDescuento='"+dia_descuento+"' WHERE id_descuento= "+id+";";	
		}else{
			System.out.println("id invalido");
			return null;
		}
	}

	private String updateDescuento(int id,String dia_descuento, String porcentajeDescuento) {
		if(existeDescuento(id)){
			System.out.println("editando descuento...");
			return "UPDATE descuento SET diaDescuento='"+dia_descuento+"',porcentajeDescuento='"+porcentajeDescuento+"' WHERE id_descuento= "+id+";";	
		}else{
			System.out.println("id invalido");
			return null;
		}
		
	}

	private boolean existeDescuento(int id) {
		boolean existe=false;
		
		try {
			ResultSet rs= c.demasConsulta(getDescuentos());			
			
			while (rs.next()) {
				
				int id_des= rs.getInt("id_descuento");
				String diaDescuento =rs.getString("diaDescuento");				
				String porcentajeDescuento= rs.getString("porcentajeDescuento");
				
				
				if(id_des==id){
					existe=true;
					return existe;
				}else{
					
				}
				}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return existe;
	}

	private String insertDescuento(String dia_descuento, String porcentajeDescuento) {
		if(!existeDescuento(dia_descuento,porcentajeDescuento)){
		System.out.println("insertando Descuento...");
		System.out.println("");
		
		return "INSERT INTO descuento VALUES(NULL,'"+dia_descuento+"', '"+porcentajeDescuento+"');";
	}
	else{
		return null;
	}
	}

	private boolean existeDescuento(String dia_descuento, String porcenDescuento) {
		boolean existe=false;
			
		try {
			ResultSet rs= c.demasConsulta(getDescuentos());			
			
			while (rs.next()) {
				
				int id= rs.getInt("id_descuento");
				String diaDescuento =rs.getString("diaDescuento");				
				String porcentajeDescuento= rs.getString("porcentajeDescuento");
				
				
				if(dia_descuento.equals(diaDescuento)|porcenDescuento.equals(porcentajeDescuento)){
					existe=true;
					System.out.println("Existe un descuento con este dia y porcentaje");
					System.out.println("");	
					return existe;
				}
				}	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return existe;
	}

	private String getDescuentos() {
		// TODO Auto-generated method stub
		return "SELECT * FROM descuento";
	}
	
	private void limpiarLista(){
		
		listaDescuento.clear();
		
		
	}
	
	
	private void mostrarLista(){
		
		for (Descuento descuento : listaDescuento) {
			descuento.mostrarDescuento();
		}
		
	}
	
}
