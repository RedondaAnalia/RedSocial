package redSocial;

import java.util.*;

public class Muro {
	
			private ArrayList<Mensaje> mensaje;
	
			
//////Constructores
	public Muro(){
		mensaje= new ArrayList<Mensaje>();
	}
	
	

//////Getters y Setters
	public ArrayList<Mensaje> getMensajes() {
		return mensaje;
	}
	
	
	
/////////////Metodos
	private void agregarMsj(Mensaje msj){
		if (this.isFull()){	this.eliminarMsj(0);};
		this.mensaje.add(msj);
	}
	
	
	private boolean isFull(){
		return this.mensaje.size()>9;
	}
	
	
	private void eliminarMsj(int index){
		this.mensaje.remove(index);
	}
	
	
	
	public void postear(String arg, Usuario usuario){
		Mensaje msj= new Mensaje (arg, usuario);
	
		this.agregarMsj(msj);
		this.avisarAmigos (msj,(msj.getAutor()).getAmigos());
	}

	public int cantidadDeMensajes(){
		return this.mensaje.size();
	}
		
	private void avisarAmigos(Mensaje msj, ArrayList<Usuario> amigos){
    	ArrayList<Usuario> aux= amigos;
    	
    	for (Usuario amigo: aux){
    		Muro act= amigo.getMuro();
    		act.agregarMsj(msj);
    	}
    }
    
	//solo elimina el "mas viejo" de mi muro, pero sigue siendo visible para los amigos.
	//para borrar el de mis amigos, deberia mirar tmb el Autor.
    public void eliminarPublicacion(String msj){
    	for (Mensaje aux:mensaje){
    		if(aux.getMensaje()==msj){
    			mensaje.remove(aux);
    			break;
    		}
    	}
    }
    	
    
    public void mostrarTodosLosMsjs(){
    	ArrayList <Mensaje> aux= this.mensaje;
    	
    	for (Mensaje msj:aux){
    		System.out.println(msj.getMensaje()+ "- " + msj.nombreAutor());
    	}
    }
    	
}
