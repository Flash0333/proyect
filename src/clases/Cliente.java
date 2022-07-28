package clases;

import java.util.ArrayList;

public class Cliente {
	
	private int idCliente;
	private String nombre;
	private String email;
	private String contraseña;
	private String telefono;
	
	
	
	
	public Cliente(int idCliente, String nombre, String email, String contraseña, String telefono) {
		
		this.idCliente = idCliente;
		this.nombre = nombre;
		this.email = email;
		this.contraseña = contraseña;
		this.telefono = telefono;
	}
	
	public Cliente (){
	}

	public int getIdCliente() {
		return idCliente;
	}





	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}





	public String getNombre() {
		return nombre;
	}





	public void setNombre(String nombre) {
		this.nombre = nombre;
	}





	public String getEmail() {
		return email;
	}





	public void setEmail(String email) {
		this.email = email;
	}





	public String getContraseña() {
		return contraseña;
	}





	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}





	public String getTelefono() {
		return telefono;
	}





	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}





	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public void mostrarDatos(){
		
		System.out.println("Id: "+getIdCliente());
		System.out.println("Nombre: "+getNombre());
		System.out.println("Email: "+getEmail());
		System.out.println("Password: "+getContraseña() );
		
		
		if(getTelefono()!=null){
			System.out.println("Telefono: "+getTelefono());
		}
		
		System.out.println("*********************************");
		
	}
	
	
	
	
}
