package redSocial;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class UsuarioTestCase {
	
	Usuario analia;
	Usuario juan;
	Usuario tota;
	
	@Before
	public void setUp() throws Exception {
		
		analia= new Usuario("Analia");
		juan= new Usuario ("Juan");
		tota= new Usuario ("Tota");
		
	
	}

	@Test
	public void testDecirNombre() {
		assertEquals(analia.getNombre(),"Analia");
	}
	
	@Test
	public void testAgregarAmigo() {
		System.out.println("TEST AGREGAR AMIGO");
		System.out.println("Empiezo con "+ analia.getAmigos().size() + " amigos.");
		analia.agregarAmigo(juan);
		System.out.println("Agrego a Juan y tengo "+ analia.getAmigos().size() + " amigos.");
		analia.agregarAmigo(tota);
		System.out.println("Agrego a Tota y tengo "+ analia.getAmigos().size() + " amigos.");
	}
	
	@Test
	public void testPostear() {
		analia.agregarAmigo(tota);
		analia.postear("Hola");
		System.out.println("TEST POSTEAR");
		System.out.println("Analia tiene " + analia.cantidadPosteos() + " posteos");
		System.out.println("Tota tiene " + tota.cantidadPosteos() + " posteos");
		System.out.println("Juan tiene " + juan.cantidadPosteos() + " posteos");
		
	}
	
	@Test
	public void testVerMuro() {
		analia.agregarAmigo(tota);
		analia.postear("Hola");
		System.out.println("TEST VER MUROS");
		System.out.println("Muro de Analia:");
		analia.verTodoElMuro();
		tota.postear("Soy Tota");
		System.out.println("Muro de Analia despues de posteo Tota:");
		analia.verTodoElMuro();
		System.out.println("Muro de Tota despues de su posteo:");
		tota.verTodoElMuro();
	}
	
	@Test 
	public void testEliminarPosteo(){
		System.out.println("TEST ELIMINAR POSTEO");
		System.out.println("MURO ANALIA:");
		analia.verTodoElMuro();
		analia.agregarAmigo(tota);
		analia.postear("Soy Analia");
		analia.postear("Hola");
		tota.postear("Soy Tota");
		System.out.println("Muro de Analia despues de posteo Tota:");
		analia.verTodoElMuro();
		System.out.println("Muro de Tota despues de su posteo:");
		tota.verTodoElMuro();
		analia.eliminarPosteo("Soy Analia");
		System.out.println("Muro de Analia despues de eliminar posteo SOY ANALIA");
		analia.verTodoElMuro();
		System.out.println("Muro de Tota despues que analia elimine su posteo");
		tota.verTodoElMuro();
		}
	
		@Test
		public void testCantidadDePosteosNoSupera10(){
			assertEquals(analia.cantidadPosteos(),0);
			analia.postear("1");
			analia.postear("2");
			analia.postear("3");
			analia.postear("4");
			analia.postear("5");
			assertEquals(analia.cantidadPosteos(),5);
			analia.postear("6");
			analia.postear("7");
			analia.postear("8");
			analia.postear("9");
			analia.postear("10");
			analia.postear("11");
			analia.postear("12");
			assertEquals(analia.cantidadPosteos(),10);
			analia.eliminarPosteo("1");
			assertEquals(analia.cantidadPosteos(),10);
			analia.eliminarPosteo("12");
			assertEquals(analia.cantidadPosteos(),9);
			analia.verTodoElMuro();
		}
}
