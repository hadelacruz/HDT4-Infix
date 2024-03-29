import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 * Implementación de una calculadora básica usando una pila personalizada.
 * 
 * @param <T> el tipo de elementos en la calculadora.
 */
public class Calculadora<T> {

    // Atributos
    /**
     * Instancia única de la Calculadora (patrón Singleton).
     */
    private static Calculadora calculadora;

    /**
     * Pila de operaciones utilizada por la calculadora.
     */
    private AbstractStack stack;

    /**
     * Variable que indica si ha ocurrido un error durante las operaciones de la calculadora.
     */
    private boolean error = false;

    // Constructor
    public Calculadora() {
    }

    // Método para obtener la instancia única de la calculadora
    public static Calculadora getInstance() {
        if (calculadora == null) {
            // Si la instancia aún no ha sido creada, la creamos
            calculadora = new Calculadora();
        }
        return calculadora;
    }

    /*
     * Ménú que se encarga de gestionar el flujo del programa.
     */
    public void tipoStack() {

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
                                stack = new StackList<>();
                                calculate();
                                break;
                            case 2:
                                System.out.println("\nHa seleccionado Doblemente encadenada");
                                stack = new StackListDouble<>();
                                calculate();
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
                    stack = new StackArrayList<>();
                    calculate();
                    break;
                case 3:
                    System.out.println("\nHa seleccionado Vector");
                    stack = new StackVector<>();
                    calculate();
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

    /**
     * Lee el contenido de un archivo de texto y devuelve la primera línea.
     *
     * @return La primera línea del archivo de texto, o una cadena vacía si hay un error.
     */
    public String readTXT() {
        try (FileReader fr = new FileReader("./datos.txt")) {
            BufferedReader br = new BufferedReader(fr);
            // Lectura del fichero
            String linea;
            while ((linea = br.readLine()) != null)
                return linea;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }
    
    /*
     * Método encargado de gestionar cada una de las operaciones.
     */
    public void calculate() {
        // Leera expresión Postfix
        String expresion = Converter.converterOperation();


        // Elimina los espacios en blanco
        expresion = expresion.replaceAll("\\s", "");

        // Se recorre la expresión
        for (int i = 0; i < expresion.length(); i++) {
            char caracter = expresion.charAt(i);
            String valornode = String.valueOf(caracter);
            if (isNumeric(valornode)) {
                stack.push(valornode);

            } else if (valornode.equals("+")) {
                sumar();

            } else if (valornode.equals("-")) {
                resta();

            } else if (valornode.equals("*")) {
                multiplicacion();

            } else if (valornode.equals("/")) {
                if (division() == false) {
                    error = true;
                    break;
                }

            } else {
                System.out.println("Este caracter no puede ser interpretado.");
                break;
            }

        }
        if (!error) {
            if (stack instanceof StackList) {
                StackList stackList = (StackList) stack;
                System.out.println("Resultado: " + stackList.lastNode.getValue());
            } else if (stack instanceof StackListDouble) {

                StackListDouble stackListDouble = (StackListDouble) stack;
                System.out.println("Resultado: " + stackListDouble.lastNode.getValue());
            }
            else if (stack instanceof StackVector){
                StackVector stackVector = (StackVector) stack;
                System.out.println("Resultado: " + stackVector.pop());
            }
            else if (stack instanceof StackArrayList){
                StackArrayList stackArrayList = (StackArrayList) stack;
                System.out.println("Resultado: " + stackArrayList.pop());
            }

        } else {
            System.out.println("Error, No es posible dentro de CERO");
        }
    }

    /**
     * Realiza la operación de suma con los dos elementos superiores de la pila.
     *
     * @return El resultado de la suma, o 0 en caso de error.
     */
    public int sumar() {
        if (stack.size() >= 2) {

            T operandoA = (T) stack.pop();
            T operandoB = (T) stack.pop();
            int resultado = Integer.parseInt(String.valueOf(operandoA)) + Integer.parseInt(String.valueOf(operandoB));
            stack.push(resultado);
            return resultado;

        } else {
            System.out.println("Error: Insuficientes operandos para la suma.");
            error = true;
        }
        return 0;

    }

    /**
     * Realiza la operación de resta con los dos elementos superiores de la pila.
     *
     * @return El resultado de la resta, o 0 en caso de error.
     */    
    public int resta() {
        if (stack.size() >= 2) {
            T operandoA = (T) stack.pop();
            T operandoB = (T) stack.pop();
            int resultado = Integer.parseInt(String.valueOf(operandoA)) - Integer.parseInt(String.valueOf(operandoB));
            stack.push(resultado);
            return resultado;
        } else {
            System.out.println("Error: Insuficientes operandos para la resta.");
            error = true;
        }
        return 0;
    }

    /**
    * Realiza la operación de multiplicación con los dos elementos superiores de la pila.
    *
    * @return El resultado de la multiplicación, o 0 en caso de error.
    */
    public int multiplicacion() {
        if (stack.size() >= 2) {
            T operandoA = (T) stack.pop();
            T operandoB = (T) stack.pop();
            int resultado = Integer.parseInt(String.valueOf(operandoA)) * Integer.parseInt(String.valueOf(operandoB));
            stack.push(resultado);
            return resultado;
        } else {
            System.out.println("Error: Insuficientes operandos para la multiplicación.");
            error = true;
        }
        return 0;
    }

    /**
    * Realiza la operación de división con los dos elementos superiores de la pila.
    * 
    *
    * @return true si la división se realiza con éxito, false en caso contrario.
    */
    public boolean division() {
        if (stack.size() >= 2) {
            try {
                T operandoA = (T) stack.pop();
                T operandoB = (T) stack.pop();

                int resultado = Integer.parseInt(String.valueOf(operandoB))
                        / Integer.parseInt(String.valueOf(operandoA));
                stack.push(resultado);
                return true;

            } catch (Exception e) {
                System.out.println("Error: No es posible dividir dentro de cero.");
                error = true;
                return false;
            }
        } else {
            System.out.println("Error: Insuficientes operandos para la división.");
            error = true;
            return false;
        }
    }

    /* Verifica si un string es numérico.
    *
    * @param value El string que se va a verificar.
    * @return true si el string es un valor numérico, false en caso contrario.
    */
    public boolean isNumeric(String value) {
        try {
            // Intenta convertir el string a un número
            Integer.parseInt(value);
            return true; // Si no hay excepción, el string es un valor numérico
        } catch (NumberFormatException e) {
            return false; // Si hay excepción, el string no es un valor numérico
        }
    }

    /**
     * Establece la instancia de AbstractStack que se utilizará.
     *
     * @param stack La instancia de AbstractStack que se establecerá.
     */
    public void setStack(AbstractStack stack) {
        this.stack = stack;
    }
}