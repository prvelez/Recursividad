import java.util.Scanner;

//Este programa permite relizar la busqueda autómatica de MCD de dos números llamado un metodo recursivo 
 
public class Prvelez_fp_ACDB2 {
	
//Esta línea crea un objeto Scanner que permite al programa leer la entrada del usuario desde la consola.
	
	 public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
// Muestra un mensaje en la consola pidiendo al usuario que ingrese el primer número.
        System.out.print("Ingrese el primer número:  ");
		//Lee el número entero introducido por el usuario y lo almacena en la variable a
        int a = scanner.nextInt();
// Muestra un mensaje en la consola pidiendo al usuario que ingrese el segundo número.
        System.out.print("Ingrese el segundo número:  ");
// Lee el segundo número y lo guarda en la variable b		
        int b = scanner.nextInt();

//Aquí es donde se invoca el método calculateGCD con los dos números ingresados. El valor devuelto (el MCD) se guarda en la variable result.
        int result = calcularMCD(a, b);
        System.out.println("El máximo común divisor de " + a + " y " + b + " es:  " + result);
        scanner.close();
    }

 // Este es el centro del algoritmo y demuestra cómo la recursividad puede simplificar la implementación del Algoritmo de Euclides.
 
  // implementación de caso base que define un método estático llamado calcularMCD que toma dos enteros (a y b) y devuelve un entero (el MCD).
	
    public static int calcularMCD(int a, int b) {
		
//Esta es la condición base o el caso base de la recursión. Según el Algoritmo de Euclides, cuando el segundo número (b) es cero, el MCD es el primer número (a). La recursión se detiene aquí, evitando un bucle infinito de llamadas al método.
		
        if (b == 0) {
            return a;
        }
//Esta es la llamada recursiva. Se basa en la propiedad fundamental del Algoritmo de Euclides: el MCD de a y b es el mismo que el MCD de b y el resto de la división de a por b (a % b). El método se llama a sí mismo con b como el nuevo primer número y a % b como el nuevo segundo número. Este proceso continúa hasta que la condición base (b == 0) se cumple.
        return calcularMCD(b, a % b);
    }
}