package redSocial;

public class Mensaje {
	private Usuario autor;
	private String msj;

	
///Constructores
	public Mensaje(String a, Usuario usuario){
		this.autor= usuario;
		this.msj= a;
	}

	
///Getters y Setters
	public Usuario getAutor(){
		return this.autor;
	}
	
	public String getMensaje(){
		return this.msj;
	}
	
	public String nombreAutor(){
		return this.autor.getNombre();
	}
	

}
