/**
 * @author José Ruiz, Gerardo Fernández y Alexander de la Cruz
 * @version 1.0
 *
 */

 /**
 * Clase principal que contiene el método main para ejecutar el programa de sorts.
 */
public class Main {
    public static void main(String[] args) {
        Converter.converterOperation();
        // Por medio del método getInstance nos aseguramos que exista solo una instancia en toda la ejecución del programa y se implementa el patrón Singleton.
        Calculadora calculadora = Calculadora.getInstance();
        calculadora.tipoStack();       
    }
}