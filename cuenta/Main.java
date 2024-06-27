import java.util.Locale;
import java.util.Scanner;
import java.text.NumberFormat;
public class Main {
	//esto es necesario para la notacion europea
	Locale spanish = new Locale ("es", "ES");
	NumberFormat nf = NumberFormat.getInstance(spanish);

	
	//metodo principal desde el que arranca el programa
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//CREACION USUARIO
		//se crea un objeto para leer
		Scanner sc = new Scanner (System.in);
		
		Usuario usuario = new Usuario();
		
		System.out.println("Introduce nombre de usuario: ");
		usuario.setNombre(sc.nextLine());
		
		System.out.println("Introduce la edad del usuario: ");
		usuario.setEdad(sc.nextInt());
		sc.nextLine();
		
		
		boolean DNIValido=false;
		//se comprueba el dni mediante el bucle
		do {
			System.out.println("Introduce el DNI del usuario: ");
			
			if(usuario.setDNI(sc.nextLine())) {
					DNIValido=true;
			}else {
				System.out.println("DNI incorrecto");
			}
			
		}while (!DNIValido);
		
		System.out.println(usuario.toString() + "\n" +"\nSe ha creado correctamente.");
		
		
		if(DNIValido) {			
			//CREACION CUENTA
			Cuenta cuenta = new Cuenta(usuario);	
		
			elegirAccion(cuenta);
		}
		
		sc.close();
		sc.close();
		
	}
	
		
			
		
		private static void elegirAccion (Cuenta cuenta) {
			int accion = -1;
			
			Scanner scAccion = new Scanner (System.in);
		
	
		
			do {
				
				System.out.println("\n~~*~*~*~*~*~*~*~*~*~*~*~*~*~*~~\nRealiza una nueva acción:\n" 
						+ "1 Introduce un nuevo gasto \n" 
						+ "2 Introduce un nuevo ingreso \n" 
						+ "3 Mostrar gastos \n"
						+ "4 Mostrar ingresos \n"
						+ "5 Mostrar saldo \n"
						+ "0 Salir \n~~*~*~*~*~*~*~*~*~*~*~*~*~*~*~~\n");
				
				accion =scAccion.nextInt();
				scAccion.nextLine();
				
				
			//para elegir las opciones	
			switch (accion) {
				
				case 1: 
					descontar(cuenta, scAccion);
					break; 
				
				case 2:
					
					ingresar(cuenta, scAccion);
					break;
					
				case 3:
					mostrarGastos(cuenta);
					break;
				
				case 4:
					mostrarIngresos(cuenta);
					break;
				
				case 5: 
					mostrarSaldo(cuenta);
					break;
				
				case 0:
					System.out.println("Fin del programa.\n" + "Gracias por utilizar la aplicación.");
					
				}
						
			} while (accion !=0); 
			
			scAccion.close();
		}
		
		//metodos
			private static void descontar (Cuenta cuenta, Scanner sc) {
				System.out.println("Concepto: ");
				String concepto = sc.next();
				System.out.println("Cantidad");
				Double gasto = sc.nextDouble();
								
					try {
						//se mete aqui el trozo de codigo susceptible de dar error
						System.out.println(cuenta.addGastos(concepto, gasto));
					} catch (GastoException e) {						
						e.printStackTrace();
					}				
				
			
			}
			
			private static void ingresar (Cuenta cuenta, Scanner sc) {
				System.out.println("Concepto: ");
				String concepto = sc.next();
				System.out.println("Cantidad");
				Double ingreso = sc.nextDouble();
								
				System.out.println(cuenta.addIngresos(concepto, ingreso));
				}

			private static void mostrarGastos (Cuenta cuenta) {
										
				for(Gasto g : cuenta.getGastos()) {					
					System.out.println(g.toString());
				}					
			}
			
			private static void mostrarIngresos (Cuenta cuenta) {
				
				for(Ingreso y : cuenta.getIngresos()) {					
					System.out.println(y.toString());
				}					
			}
			
			private static void mostrarSaldo (Cuenta cuenta) {
												
				System.out.println("El saldo del usuario " + cuenta.getUsuario().getNombre() + " es " + cuenta.getSaldo() + " €");
								
			}
							


}
		
		
	
	
