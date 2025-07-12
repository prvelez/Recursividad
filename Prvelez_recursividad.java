import java.util.Scanner;

/**
 * Programa que calcula el Máximo Común Divisor (MCD) de dos números enteros
 * utilizando el algoritmo de Euclides implementado de forma recursiva.
 * 
 * El algoritmo de Euclides se basa en el principio matemático:
 * MCD(a, b) = MCD(b, a mod b), donde 'a mod b' es el resto de dividir a entre b.
 * 
 * Transformación de iterativo a recursivo:
 * - CASO BASE: Cuando b = 0, el MCD es a (condición de parada)
 * - CASO RECURSIVO: Llamada con parámetros intercambiados MCD(b, a % b)
 * 
 * Ventajas de la versión recursiva:
 * - Código más limpio y legible
 * - Refleja directamente la definición matemática
 * - Menos variables auxiliares
 * 
 * @author Prvelez
 * @version 1.0
 * @since 2025-07-12
 */
public class Prvelez_recursividad {
    
    /**
     * Método principal que controla el flujo del programa.
     * Maneja la entrada de datos, validaciones y muestra resultados.
     * 
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        // Inicializar scanner para lectura de entrada del usuario
        Scanner scanner = new Scanner(System.in);
        
        try {
            // === ENTRADA DE DATOS ===
            // Solicitar el primer número al usuario
            System.out.print("Ingrese el primer número (entero positivo): ");
            int a = scanner.nextInt(); // Lee el primer entero desde consola
            
            // Solicitar el segundo número al usuario
            System.out.print("Ingrese el segundo número (entero positivo): ");
            int b = scanner.nextInt(); // Lee el segundo entero desde consola
            
            // === VALIDACIÓN DE ENTRADA ===
            // Verificar que ambos números sean positivos
            // El algoritmo funciona con números negativos, pero para simplicidad
            // se requieren números positivos en la entrada
            if (a <= 0 || b <= 0) {
                System.out.println("Error: Ambos números deben ser positivos.");
                return; // Terminar ejecución si hay entrada inválida
            }
            
            // === PROCESAMIENTO ===
            // Llamar al método recursivo para calcular el MCD
            int result = calcularMCD(a, b);
            
            // === SALIDA DE RESULTADOS ===
            // Mostrar el resultado final al usuario
            System.out.println("El máximo común divisor de " + a + " y " + b + " es: " + result);
            
        } catch (Exception e) {
            // Manejar errores de entrada (ej: si el usuario ingresa texto en lugar de números)
            System.out.println("Error: Por favor ingrese números enteros válidos.");
        } finally {
            // Cerrar el scanner para liberar recursos del sistema
            // Se ejecuta siempre, haya o no excepción
            scanner.close();
        }
    }

    /**
     * Calcula el Máximo Común Divisor (MCD) de dos números enteros
     * usando el algoritmo de Euclides implementado de forma recursiva.
     * 
     * === ANÁLISIS DEL ALGORITMO ===
     * 
     * PRINCIPIO MATEMÁTICO:
     * El algoritmo se basa en la propiedad: MCD(a, b) = MCD(b, a mod b)
     * donde 'a mod b' es el resto de la división entera de a entre b.
     * 
     * ESTRUCTURA RECURSIVA:
     * 1. CASO BASE: Si b = 0, entonces MCD(a, b) = a
     *    - Esta es la condición de parada que evita la recursión infinita
     *    - Matemáticamente: cualquier número dividido por 0 da como resto el número mismo
     * 
     * 2. CASO RECURSIVO: Si b ≠ 0, entonces MCD(a, b) = MCD(b, a mod b)
     *    - Se intercambian los parámetros: el divisor se convierte en dividendo
     *    - El resto se convierte en el nuevo divisor
     *    - Este proceso reduce progresivamente el tamaño de los números
     * 
     * COMPARACIÓN CON VERSIÓN ITERATIVA:
     * - Iterativa: Usa bucle while y variables auxiliares
     * - Recursiva: Usa llamadas a función y pila de ejecución
     * - Ambas tienen la misma complejidad temporal O(log min(a,b))
     * 
     * @param a Primer número entero (dividendo inicial)
     * @param b Segundo número entero (divisor inicial)
     * @return El MCD de a y b como número entero positivo
     * 
     * @throws StackOverflowError Si los números son demasiado grandes y causan
     *         demasiadas llamadas recursivas
     */
    public static int calcularMCD(int a, int b) {
        // === MANEJO DE NÚMEROS NEGATIVOS ===
        // Convertir a valores absolutos para garantizar resultado positivo
        // Matemáticamente: MCD(-a, b) = MCD(a, -b) = MCD(-a, -b) = MCD(a, b)
        a = Math.abs(a);
        b = Math.abs(b);
        
        // === CASO BASE DE LA RECURSIÓN ===
        // Cuando b es 0, hemos encontrado el MCD
        // Esto ocurre cuando a es divisible exactamente por el último divisor no-cero
        if (b == 0) {
            return a; // El MCD es el último divisor que dio resto 0
        }
        
        // === CASO RECURSIVO ===
        // Aplicar la fórmula: MCD(a, b) = MCD(b, a mod b)
        // - Nuevo dividendo: b (el divisor anterior)
        // - Nuevo divisor: a % b (el resto de la división anterior)
        // La recursión continúa hasta que el divisor sea 0
        return calcularMCD(b, a % b);
    }
}
