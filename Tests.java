import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.Assert.*;

import org.junit.*;

public class Tests {

    private Calculadora<String> calculadora;

    @Before
    public void setUp() {
        // Configura la calculadora
        calculadora = Calculadora.getInstance();
    }

    /**
     * Prueba el resultado de la suma en la calculadora.
     */
    @Test
    public void sumTestResult() {
        // Se crea una instancia de CustomStack con dos operandos
        StackList<String> stack = new StackList<>();
        stack.push("2");
        stack.push("3");

        // Se establece el stack de la calculadora con el stack preparado
        calculadora.setStack(stack);

        // Se llama al método sumar y se verifica el resultado
        int resultado = calculadora.sumar();

        // Verificación de que la suma se realiza correctamente
        assertEquals(5, resultado);
    }

    // Test de la StackArraylist
    @Test
    public void testPushAndPop() {
        // Crear una nueva pila
        StackArrayList<Integer> stack = new StackArrayList<>();

        // Verificar que la pila esté vacía inicialmente
        assertTrue(stack.isEmpty());

        // Empujar algunos elementos a la pila
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Verificar el tamaño de la pila después de empujar elementos
        assertEquals(3, stack.size());

        // Verificar que la pila ya no está vacía
        assertFalse(stack.isEmpty());

        // Verificar el orden correcto al sacar elementos de la pila
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());

        // Verificar que la pila esté vacía después de sacar todos los elementos
        assertTrue(stack.isEmpty());
    }

    // Test de la StackList
    @Test
    public void testSizeEmptyStack() {
        // Crear una nueva pila vacía
        StackList<Double> stack = new StackList<>();

        // Verificar que el tamaño de la pila sea cero inicialmente
        assertEquals(0, stack.size());

        // Empujar un elemento a la pila
        stack.push(3.14);

        // Verificar que el tamaño de la pila sea uno después de empujar un elemento
        assertEquals(1, stack.size());
    }

    // Tets de la StackListDouble
    @Test
    public void pushAndPopTest() {
        // Crear una nueva pila
        StackListDouble<Integer> stack = new StackListDouble<>();

        // Verificar que la pila esté vacía inicialmente
        assertEquals(0, stack.size());

        // Empujar algunos elementos a la pila
        stack.push(1);
        stack.push(2);
        stack.push(3);

        // Verificar el tamaño de la pila después de empujar elementos
        assertEquals(3, stack.size());

        // Verificar el orden correcto al sacar elementos de la pila
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());

        // Verificar que la pila esté vacía después de sacar todos los elementos
        assertEquals(0, stack.size());
    }

    // Test de la StackVector
    @Test
    public void testPopEmptyStack() {
        // Crear una nueva pila vacía
        StackVector<String> stack = new StackVector<>();

        // Verificar que la pila esté vacía inicialmente
        assertTrue(stack.isEmpty());

        // Intentar sacar un elemento de una pila vacía
        assertNull(stack.pop());

        // Verificar que la pila sigue vacía después de intentar sacar un elemento
        assertTrue(stack.isEmpty());
    }
}