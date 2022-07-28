package clases;

public class Pelicula {

	
	private int id_pelicula;
	private String nombrePelicula;
	private String duracion;
	private String descripcion;
	private String genero;
	private String clasificacion;	
	private String idioma;
	
	
	
	
	public Pelicula(int id_pelicula, String nombrePelicula, String duracion, String descripcion, String genero,
			String clasificacion, String idioma) {
		
		this.id_pelicula = id_pelicula;
		this.nombrePelicula = nombrePelicula;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.genero = genero;
		this.clasificacion = clasificacion;
		this.idioma = idioma;
	}

	public Pelicula( String nombrePelicula, String duracion, String descripcion, String genero,
			String clasificacion, String idioma) {
		
		
		this.nombrePelicula = nombrePelicula;
		this.duracion = duracion;
		this.descripcion = descripcion;
		this.genero = genero;
		this.clasificacion = clasificacion;
		this.idioma = idioma;
	}

	public Pelicula(){
		
	}


	public int getId_pelicula() {
		return id_pelicula;
	}




	public void setId_pelicula(int id_pelicula) {
		this.id_pelicula = id_pelicula;
	}




	public String getNombrePelicula() {
		return nombrePelicula;
	}




	public void setNombrePelicula(String nombrePelicula) {
		this.nombrePelicula = nombrePelicula;
	}




	public String getDuracion() {
		return duracion;
	}




	public void setDuracion(String duracion) {
		this.duracion = duracion;
	}




	public String getDescripcion() {
		return descripcion;
	}




	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}




	public String getGenero() {
		return genero;
	}




	public void setGenero(String genero) {
		this.genero = genero;
	}




	public String getClasificacion() {
		return clasificacion;
	}




	public void setClasificacion(String clasificacion) {
		this.clasificacion = clasificacion;
	}




	public String getIdioma() {
		return idioma;
	}




	public void setIdioma(String idioma) {
		this.idioma = idioma;
	}




	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public void mostrarPelicula(){
		
		System.out.println("Id: "+getId_pelicula());
		System.out.println("Nombre : "+getNombrePelicula());
		System.out.println("Duracion: "+getDuracion());	
		System.out.println("Genero : "+getGenero());
		System.out.println("Clasificacion : "+getClasificacion());
		
		System.out.println("Idioma : "+getIdioma());
		System.out.println("Descripcion: "+getDescripcion());
		System.out.println("****************");
		
	}
}
