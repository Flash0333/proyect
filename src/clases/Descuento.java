package clases;

public class Descuento {

	
	private int id_descuento;
	private String dia_descuento;
	private String porcentajeDescuento;
	
	
	
	public Descuento(int id_descuento, String dia_descuento, String porcentajeDescuento) {
		this.id_descuento = id_descuento;
		this.dia_descuento = dia_descuento;
		this.porcentajeDescuento = porcentajeDescuento;
	}



	public int getId_descuento() {
		return id_descuento;
	}



	public void setId_descuento(int id_descuento) {
		this.id_descuento = id_descuento;
	}



	public String getDia_descuento() {
		return dia_descuento;
	}



	public void setDia_descuento(String dia_descuento) {
		this.dia_descuento = dia_descuento;
	}



	public String getPorcentajeDescuento() {
		return porcentajeDescuento;
	}



	public void setPorcentajeDescuento(String porcentajeDescuento) {
		this.porcentajeDescuento = porcentajeDescuento;
	}


	public void mostrarDescuento(){
		
		System.out.println("Id: "+getId_descuento());
		System.out.println("dia:"+getDia_descuento());
		System.out.println("porcentaje: "+getPorcentajeDescuento());
		System.out.println("*************************");
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
