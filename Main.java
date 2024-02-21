import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Converter.converterOperation();
        // Por medio del método getInstance nos aseguramos que exista solo una instancia en toda la ejecución del programa.
        Calculadora calculadora = Calculadora.getInstance();
        calculadora.tipoStack();       
    }
}