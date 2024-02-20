public class Singleton {
    // La única instancia de la clase
    private static Singleton instance;

    // Constructor privado para evitar la creación de instancias desde fuera de la clase
    private Singleton() {
        // Inicialización del objeto singleton
    }

    // Método para obtener la instancia única de la clase
    public static Singleton getInstance() {
        if (instance == null) {
            // Si la instancia aún no ha sido creada, la creamos
            instance = new Singleton();
        }
        return instance;
    }

    // Otros métodos y atributos de la clase singleton
    public void someMethod() {
        System.out.println("Some method of the singleton instance");
    }
}