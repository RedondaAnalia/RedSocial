package redSocial;

import java.util.ArrayList;

public class Usuario {

				private String nombre;
				private ArrayList<Usuario> amigos;
				private Muro muro;

		
		
///Constructores
		public Usuario(String name){
			this.setNombre(name);
			this.muro= new Muro();
			this.amigos= new ArrayList<Usuario>();
		}
		
		

/// Getters y Setters
		public Muro getMuro(){
			return muro;
		}
		
		public String getNombre() {
			return nombre;
		}

		private void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public ArrayList<Usuario> getAmigos() {
			return amigos;
		}
		

		
		
///Metodos
		public void agregarAmigo(Usuario amigo){
			this.amigos.add(amigo);
			amigo.amigos.add(this);
//			System.out.println("Ahora tengo "+ this.amigos.size() + " amigos.");
		}
		
		public void postear (String msj){
			this.muro.postear(msj,this);
		}
		
		public void verTodoElMuro(){
			this.muro.mostrarTodosLosMsjs();
		}
		
		//solo lo elimina de mi muro, pero sigue existiendo en el de mis amigos.
		public void eliminarPosteo (String msj){
			this.muro.eliminarPublicacion(msj);
		}

		public int cantidadPosteos(){
			return this.muro.cantidadDeMensajes();
		}
		
			
}
