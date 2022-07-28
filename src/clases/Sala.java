package clases;

public class Sala {

	private int id_sala;
	private String nombreSala;
	private String tipoSala;
	private int capacidadSala;
	private String observacionSala;
	
	public Sala(){
		
	}
	
	
	public Sala(int id_sala, String nombreSala, String tipoSala, int capacidadSala, String observacionSala) {
		this.id_sala = id_sala;
		this.nombreSala = nombreSala;
		this.tipoSala = tipoSala;
		this.capacidadSala = capacidadSala;
		this.observacionSala = observacionSala;
	}

	public int getId_sala() {
		return id_sala;
	}

	public void setId_sala(int id_sala) {
		this.id_sala = id_sala;
	}

	public String getNombreSala() {
		return nombreSala;
	}

	public void setNombreSala(String nombreSala) {
		this.nombreSala = nombreSala;
	}

	public String getTipoSala() {
		return tipoSala;
	}

	public void setTipoSala(String tipoSala) {
		this.tipoSala = tipoSala;
	}

	public int getCapacidadSala() {
		return capacidadSala;
	}

	public void setCapacidadSala(int capacidadSala) {
		this.capacidadSala = capacidadSala;
	}

	public String getObservacionSala() {
		return observacionSala;
	}

	public void setObservacionSala(String observacionSala) {
		this.observacionSala = observacionSala;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public void mostrarSala(){
		System.out.println("Id Sala: "+getId_sala());
		System.out.println("Nombre Sala: "+getNombreSala());
		System.out.println("Tipo de Sala : "+getTipoSala());
		System.out.println("Capacidad: "+getCapacidadSala());
		
		if(getObservacionSala()!=null){
		System.out.println("Observacion : "+getObservacionSala());
		}
		
		System.out.println("********************");
	}
}
