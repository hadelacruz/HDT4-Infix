import java.io.*;
import java.util.Scanner;
import java.util.Stack;

public class Converter {

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

    public static void main(String[] args) {
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

            // Sobreescribir el archivo con las expresiones postfix
            FileWriter writer = new FileWriter(file);
            writer.write(modifiedContent.toString());
            writer.close();

            System.out.println("Se han convertido las expresiones infix a postfix en el archivo datos.txt.");

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo datos.txt");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo datos.txt");
            e.printStackTrace();
        }
    }
}
