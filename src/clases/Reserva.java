package clases;

import java.sql.Date;

public class Reserva {

	private int id_reserva;
	private Cliente cliente;
	private Date fechaReserva;
	private String horaReserva;
	private int cantidadEntrada;
	private Descuento descuento;
	private Funcion funcion;
	private String observacionReserva;
	
	
	
	public Reserva(int id_reserva, Cliente cliente, Date fechaReserva, String horaReserva, int cantidadEntrada,
			Descuento descuento, Funcion funcion, String observacionReserva) {
		this.id_reserva = id_reserva;
		this.cliente = cliente;
		this.fechaReserva = fechaReserva;
		this.horaReserva = horaReserva;
		this.cantidadEntrada = cantidadEntrada;
		this.descuento = descuento;
		this.funcion = funcion;
		this.observacionReserva = observacionReserva;
	}



	public int getId_reserva() {
		return id_reserva;
	}



	public void setId_reserva(int id_reserva) {
		this.id_reserva = id_reserva;
	}



	public Cliente getCliente() {
		return cliente;
	}



	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}



	public Date getFechaReserva() {
		return fechaReserva;
	}



	public void setFechaReserva(Date fechaReserva) {
		this.fechaReserva = fechaReserva;
	}



	public String getHoraReserva() {
		return horaReserva;
	}



	public void setHoraReserva(String horaReserva) {
		this.horaReserva = horaReserva;
	}



	public int getCantidadEntrada() {
		return cantidadEntrada;
	}



	public void setCantidadEntrada(int cantidadEntrada) {
		this.cantidadEntrada = cantidadEntrada;
	}



	public Descuento getDescuento() {
		return descuento;
	}



	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}



	public Funcion getFuncion() {
		return funcion;
	}



	public void setFuncion(Funcion funcion) {
		this.funcion = funcion;
	}



	public String getObservacionReserva() {
		return observacionReserva;
	}



	public void setObservacionReserva(String observacionReserva) {
		this.observacionReserva = observacionReserva;
	}



	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
