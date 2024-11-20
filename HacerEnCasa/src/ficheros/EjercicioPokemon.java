package ficheros;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EjercicioPokemon {
	public static void main(String[] args) throws FileNotFoundException{

			// CONTAR CANTIDAD POKEMONES
			File file = new File("./src/ficheros/pokemons.csv");

			String linea = null;

			// CREAR Y RELLENAR LOS ARRAYS
			String[] nombre = new String[20];
			String[] tipo = new String[20];
			int[] nivel = new int[20];
			int[] ataque = new int[20];
			int[] defensa = new int[20];
			int[] velocidad = new int[20];
			String[] campos = new String[20];

			cargarDatos(nombre, tipo, nivel, ataque, defensa, velocidad, campos, file, linea);
			

			// CAMBIAR NOMBRE DE PIKACHU A PICACHU
			nombre[0] = "PICACHU";
			// AUMENTAR ATAQUE DEL TERCER POKEMON EN 5
			ataque[3] = ataque[3] + 5;

			// GUARDAR CAMBIOS
			guardarDatos (nombre, tipo, nivel, ataque, defensa, velocidad, file);
			
			//MODIFICAR DATOS
			modificarDatos (nombre, tipo, nivel, ataque, defensa, velocidad, file);

		}

	private static void modificarDatos(String[] nombre, String[] tipo, int[] nivel, int[] ataque, int[] defensa,
			int[] velocidad, File file) throws FileNotFoundException {
		
		Scanner sc = new Scanner(System.in);
		int salir = 0;
		int menu = 0;
		
	while(salir==0) {
		System.out.println("¿Que operacion deseas realizar?");
		System.out.println("0- Salir");
		System.out.println("1- Listar");
		System.out.println("2- Guardar");
		System.out.println("3- Consultar pokemon");
		System.out.println("4- Modificar");
		System.out.println("5- Buscar por nombre");
		System.out.println("6- Rapidos");
		System.out.println("7- Por tipo");
		System.out.println("8- Lucha1");
		System.out.println("9- Lucha2");

		menu = sc.nextInt();
		switch (menu) {
		case 0:
			System.out.println("Adios");
			salir++;
			break;
			
		case 1:
			listar (nombre);
			break;
		
		case 2:
			guardarDatos (nombre, tipo, nivel, ataque, defensa, velocidad, file);
			break;
			
		case 3:
			consultarPokemon (nombre, tipo, nivel, ataque, defensa, velocidad, sc);
			break;
			
		case 4:
			modificarPokemon (nombre, tipo, nivel, ataque, defensa, velocidad, sc);
			break;
			
		case 5:
			buscarNombre (nombre, sc);
			break;

		case 6:
			rapidos (velocidad);
			break;

		case 7:
			porTipo (nombre, tipo, sc);
			break;

		case 8:
			lucha1 (nombre, tipo, nivel, ataque, defensa, velocidad, sc);
			break;

		case 9:
			lucha2 (nombre, tipo, nivel, ataque, defensa, velocidad, sc);
			break;

		default:
			System.out.println("El valor introducido no es valido");
			}
		}
	}
	
	// CASE 9
			private static void lucha2(String[] nombre, String[] tipo, int[] nivel, int[] ataque, int[] defensa,
					int[] velocidad, Scanner sc) {

				
				System.out.println("Introduce el pokemon que va a pelear: ");
				String pokemon1 = sc.next();
				String pokemon2 = nombre[(int) (Math.random() * 19)];
				System.out.println("¡Tu " + pokemon1 + " va a pelear contra " + pokemon2 + "!");
				
				int pokemon1Media = 0;
				int pokemon2Media = 0;
				
				// POKEMON 1 MEDIA
				for (int i = 0; i < nombre.length; i++) {
					if(pokemon1.equalsIgnoreCase(nombre[i])) {
						pokemon1Media = nivel[i] + ataque[i] + defensa [i] + velocidad [i];
						pokemon1Media = pokemon1Media/4;
					}
					else {}
				}
				//POKEMON 2 MEDIA
				for (int i = 0; i < nombre.length; i++) {
					if(pokemon2.toUpperCase().equals(nombre[i].toUpperCase())) {
						pokemon2Media = nivel[i] + ataque[i] + defensa [i] + velocidad [i];
						pokemon2Media = pokemon2Media/4;
					}
					else {}
				}

				if(pokemon1Media>pokemon2Media) {
					System.out.println("¡" + pokemon1 + " ha ganado!");
					
					for (int i = 0; i < nombre.length; i++) {

						if(pokemon2.equalsIgnoreCase(nombre[i])) {
						// MOSTRAR ESTADISTICAS ANTIGUAS
							System.out.println("Las antiguas estadisticas del " + pokemon2 +" enemigo eran: ");
							System.out.println("Nivel: " + nivel[i]);
							System.out.println("Ataque: " + ataque[i]);
							System.out.println("Defensa: " + defensa[i]);
							System.out.println("Velocidad: " + velocidad[i]);
							System.out.println("");
							
						//GENERAR ESTADISTICAS ALEATORIAS
							nivel[i] = (int) (Math.random() * 255);
							ataque[i] = (int) (Math.random() * 255);
							defensa [i] = (int) (Math.random() * 255);
							velocidad [i] = (int) (Math.random() * 255);
						
						// MOSTRAR ESTADISTICAS NUEVAS
							System.out.println("Las nuevas estadisticas del " + pokemon2 + " enemigo son: ");
							System.out.println("Nivel: " + nivel[i]);
							System.out.println("Ataque: " + ataque[i]);
							System.out.println("Defensa: " + defensa[i]);
							System.out.println("Velocidad: " + velocidad[i]);
							System.out.println("");
						}
						else {}
					}
				}
				else {
					System.out.println("¡" + pokemon2 + " ha ganado!");
					for (int i = 0; i < nombre.length; i++) {
						if(pokemon1.equalsIgnoreCase(nombre[i])) {
							
						//MOSTRAR ESTADISTICAS ANTIGUAS
							System.out.println("Las antiguas estadisticas de tu " + pokemon1 +" eran: ");
							System.out.println("Nivel: " + nivel[i]);
							System.out.println("Ataque: " + ataque[i]);
							System.out.println("Defensa: " + defensa[i]);
							System.out.println("Velocidad: " + velocidad[i]);
							System.out.println("");
							
						//GENERAR ESTADISTICAS ALEATORIAS
							nivel[i] = (int) (Math.random() * 255);
							ataque[i] = (int) (Math.random() * 255);
							defensa [i] = (int) (Math.random() * 255);
							velocidad [i] = (int) (Math.random() * 255);
							
						// MOSTRAR ESTADISTICAS NUEVAS
							System.out.println("Las nuevas estadisticas de tu " + pokemon1 +" son: ");
							System.out.println("Nivel: " + nivel[i]);
							System.out.println("Ataque: " + ataque[i]);
							System.out.println("Defensa: " + defensa[i]);
							System.out.println("Velocidad: " + velocidad[i]);
							System.out.println("");
							break;
						}
						else {}
					}
				}
			}

	// CASE 8
	private static void lucha1(String[] nombre, String[] tipo, int[] nivel, int[] ataque, int[] defensa,
			int[] velocidad, Scanner sc) {
		
		System.out.println("Introduce el primer pokemon que va a pelear: ");
		String pokemon1 = sc.next();
		System.out.println("Introduce el segundo pokemon que va a pelear: ");
		String pokemon2 = sc.next();
		
		int pokemon1Media = 0;
		int pokemon2Media = 0;
		
		// POKEMON 1 MEDIA
		for (int i = 0; i < nombre[i].length(); i++) {
			if(pokemon1.toUpperCase().equals(nombre[i].toUpperCase())) {
				pokemon1Media = nivel[i] + ataque[i] + defensa [i] + velocidad [i];
				break;
			}
			else {}
		}
		
		// POKEMON 2 MEDIA
		for (int i = 0; i < nombre[i].length(); i++) {
			if(pokemon2.toUpperCase().equals(nombre[i].toUpperCase())) {
				pokemon2Media = nivel[i] + ataque[i] + defensa [i] + velocidad [i];
				break;
			}
			else {}
		}
		
		if(pokemon1Media>pokemon2Media) {
			System.out.println("¡" + pokemon1 + " ha ganado!");
		}
		else {
			System.out.println("¡" + pokemon2 + " ha ganado!");
		}
	}

	// CASE 7
	private static void porTipo(String[] nombre, String[] tipo, Scanner sc) {
		System.out.print("¿Que tipo quieres consultar?");
		String tipoConsultar = sc.next();
		int existe = 0;

			for (int i = 0; i < nombre.length; i++) {
				if(tipoConsultar.toUpperCase().equals(tipo[i].toUpperCase())) {
					System.out.println(nombre[i]);
				}
				else {
					if(existe==19) {
						System.out.println("El tipo introducido no esta en la lista");
						System.out.println();
					}
					existe++;
				}
			}
	}
	
	// CASE 6
	private static void rapidos(int[] velocidad) {
			int velocidadMedia = 0;
			for (int i = 0; i < velocidad.length; i++) {
				velocidadMedia = velocidadMedia + velocidad[i];
			}
			velocidadMedia = velocidadMedia/20;
			System.out.println("La velocidad media es de: " + velocidadMedia);
	}

	// CASE 5 
	private static void buscarNombre(String[] nombre, Scanner sc) {
		System.out.print("¿Que Pokemon quieres consultar?");
		String pokemonConsultar = sc.next();
			
			for (int i = 0; i < nombre.length; i++) {
				if(nombre[i].toUpperCase().contains(pokemonConsultar.toUpperCase())) {
					System.out.println(nombre[i]);
				}
				else {}
			}
	}

	// CASE 4
	private static void modificarPokemon(String[] nombre, String[] tipo, int[] nivel, int[] ataque, int[] defensa,
			int[] velocidad, Scanner sc) {
		System.out.print("¿Que Pokemon quieres consultar?");
		String pokemonConsultar = sc.next();
			
			for (int i = 0; i < nombre.length; i++) {
				if(pokemonConsultar.toUpperCase().equals(nombre[i].toUpperCase())) {
				//MOSTRAR DATOS ACTUALES
					System.out.println("Los datos actuales son: ");
					System.out.println(nombre[i] + ", tipo " + tipo[i] + ":");
					System.out.println("Nivel: " +  nivel[i]);
					System.out.println("Ataque: " +  ataque[i]);
					System.out.println("Defensa: " +  defensa[i]);
					System.out.println("Velocidad: " +  velocidad[i]);
					System.out.println("");
					
				//RELLENAR NUEVOS DATOS
					System.out.println("Introduce el nuevo nivel: ");
					nivel[i] = sc.nextInt();
					System.out.println("Introduce el nuevo ataque:");
					ataque[i] = sc.nextInt();
					System.out.println("Introduce la nueva defensa:");
					defensa[i] = sc.nextInt();
					System.out.println("Introduce la nueva velocidad: ");
					velocidad[i] = sc.nextInt();
			}
				else {}
		}
	}

	// CASE 3
	private static void consultarPokemon(String[] nombre, String[] tipo, int[] nivel, int[] ataque, int[] defensa,
			int[] velocidad, Scanner sc) {
		System.out.print("¿Que Pokemon quieres consultar?");
		String pokemonConsultar = sc.next();
			
			for (int i = 0; i < nombre.length; i++) {
				if(pokemonConsultar.toUpperCase().equals(nombre[i].toUpperCase())) {
					System.out.println("Nombre: " +  nombre[i]);
					System.out.println("Tipo: " +  tipo[i]);
					System.out.println("Nivel: " +  nivel[i]);
					System.out.println("Ataque: " +  ataque[i]);
					System.out.println("Defensa: " +  defensa[i]);
					System.out.println("Velocidad: " +  velocidad[i]);
			}
				else {}
		}
	}

	// CASE 1
	private static void listar(String[] nombre) {

		for (int i = 0; i < nombre.length; i++) {
			System.out.println((i+1) + ".- " + nombre[i]);
		}
	}
	
	// CARGAR DATOS
	private static void cargarDatos(String[] nombre, String[] tipo, int[] nivel, int[] ataque, int[] defensa,
			int[] velocidad, String[] campos, File file, String linea) throws FileNotFoundException {
		
		Scanner scFile = new Scanner(file);
		int rellenar = 0;
		linea = scFile.nextLine();

		while (scFile.hasNext()) {
			linea = scFile.nextLine();
			campos = linea.split(",");
			nombre[rellenar] = campos[0];
			tipo[rellenar] = campos[1];
			nivel[rellenar] = Integer.valueOf(campos[2]);
			ataque[rellenar] = Integer.valueOf(campos[3]);
			defensa[rellenar] = Integer.valueOf(campos[4]);
			velocidad[rellenar] = Integer.valueOf(campos[5]);
			rellenar++;
		}		
	}

	// GUARDAR DATOS
	private static void guardarDatos(String[] nombre, String[] tipo, int[] nivel, int[] ataque, int[] defensa, int[] velocidad, File file) 
			throws FileNotFoundException {
		// Si se quiere añadir registros
		// PrintWriter pw = new PrintWriter(new FileWriter(file, true));
		PrintWriter pw = new PrintWriter(file);
		
		String titulo = "Nombre,Tipo,Nivel,Ataque,Defensa,Velocidad";
		pw.println(titulo);
		
		for (int i = 0; i < nombre.length; i++) {
			pw.println(nombre[i] + "," + tipo[i] + "," + nivel[i] + "," + ataque[i] + "," + defensa[i] + ","+ velocidad[i]);
		}
		
		pw.close();
	}
}
