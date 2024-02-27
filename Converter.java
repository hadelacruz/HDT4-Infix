import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Converter {

    /**
     * Método para determinar la precedencia de un operador.
     *
     * @param c El operador cuya precedencia se desea conocer.
     * @return El nivel de precedencia del operador, o -1 si el operador no es reconocido.
     */
    static int precedence(char c) {
        switch (c) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    /**
     * Lee expresiones infix desde un archivo, las convierte a postfix y devuelve el contenido modificado.
     *
     * @return Una cadena que contiene las expresiones en formato postfix, o una cadena vacía en caso de error.
     */
    static String infixToPostfix(String expresion) {
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            if (Character.isLetterOrDigit(c))
                result.append(c);
            else if (c == '(')
                stack.push(c);
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(')
                    result.append(stack.pop());
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(c) <= precedence(stack.peek()))
                    result.append(stack.pop());
                stack.push(c);
            }
        }

        while (!stack.isEmpty())
            result.append(stack.pop());

        return result.toString();
    }

    /**
     * Lee expresiones infix desde un archivo, las convierte a postfix y devuelve el contenido modificado.
     *
     * @return Una cadena que contiene las expresiones en formato postfix, o una cadena vacía en caso de error.
     */
    public static String converterOperation() {
        try {
            File file = new File("datos.txt");
            Scanner scanner = new Scanner(file);

            StringBuilder modifiedContent = new StringBuilder();

            while (scanner.hasNextLine()) {
                String expresion = scanner.nextLine();
                String postfixExpression = infixToPostfix(expresion);
                modifiedContent.append(postfixExpression).append("\n");
            }

            scanner.close();

            return modifiedContent.toString();

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo datos.txt");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo datos.txt");
            e.printStackTrace();
        }
        return "";
    }
}