package clases;

import java.sql.Date;

public class Funcion {

	private int idFuncion;
	private Pelicula peli;
	private Sala sala;
	private String fecha;
	private String hora; //A QUE HORA COMIENZA (COMO UNA CARTELERA)
	private double precio;
	
	
	
	public Funcion(int idFuncion, Pelicula peli, Sala sala, String fecha, String hora, double precio) {
		this.idFuncion = idFuncion;
		this.peli = peli;
		this.sala = sala;
		this.fecha = fecha;
		this.hora = hora;
		this.precio = precio;
	}
	
	public Funcion(){
		
	}
	public Funcion(int id, int id_pelicula, int id_sala, String fech, String hor, double prec) {
		// TODO Auto-generated constructor stub
		
	}

	public int getIdFuncion() {
		return idFuncion;
	}
	public void setIdFuncion(int idFuncion) {
		this.idFuncion = idFuncion;
	}
	public Pelicula getPeli() {
		return peli;
	}
	public void setPeli(Pelicula peli) {
		this.peli = peli;
	}
	public Sala getSala() {
		return sala;
	}
	public void setSala(Sala sala) {
		this.sala = sala;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Funcion [idFuncion=" + idFuncion + ", peli=" + peli.getNombrePelicula() + ", sala=" + sala.getNombreSala() + ", fecha=" + fecha + ", hora="
				+ hora + ", precio=" + precio + "]";
	}
	
	
	
}
