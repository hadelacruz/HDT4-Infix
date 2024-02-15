import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int opcion;
        do {
            System.out.println("\n-------+ Bienvenido +-------");
            System.out.println("Como desea manejar las pilas?");
            System.out.println("1. Listas");
            System.out.println("2. Array List");
            System.out.println("3. Vector");
            System.out.println("0. Salir");
            System.out.print("Ingrese su opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    int subopcion;
                    do {
                        System.out.println("\nQue tipo de lista desea?");
                        System.out.println("1. Lista encadenada");
                        System.out.println("2. Doblemente encadenada");
                        System.out.println("0. Volver al menú principal");
                        System.out.print("Ingrese su opción: ");
                        subopcion = scanner.nextInt();

                        switch (subopcion) {
                            case 1:
                                System.out.println("\nHa seleccionado Lista encadenada");

                                break;
                            case 2:
                                System.out.println("\nHa seleccionado Doblemente encadenada");

                                break;
                            case 0:
                                System.out.println("\nVolviendo al menú principal...");
                                break;
                            default:
                                System.out.println("\nOpción no válida");
                        }
                    } while (subopcion != 0);
                    break;

                case 2:
                    System.out.println("\nHa seleccionado Array List");

                    break;
                case 3:
                    System.out.println("\nHa seleccionado Vector");

                    break;
                case 0:
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("\nOpción no válida");
            }
        } while (opcion != 0);
    
        scanner.close();
    }
}