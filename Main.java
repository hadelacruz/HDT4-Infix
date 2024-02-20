public class Main {
    public static void main(String[] args) {
        // Por medio del método getInstance nos aseguramos que exista solo una instancia en toda la ejecución del programa.
        Calculadora calculadora = Calculadora.getInstance();
        calculadora.tipoStack();
    }
}