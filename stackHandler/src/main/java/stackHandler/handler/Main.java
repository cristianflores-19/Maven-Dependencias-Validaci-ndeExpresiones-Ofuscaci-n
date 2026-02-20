package stackHandler.handler;

import umg.edu.gt.data_structure.stack.impl.SymbolValidator;
import umg.edu.gt.data_structure.stack.manual.StackLinked;

public class Main {
	
	public static void main(String[] args) {
        StackLinked stack = new StackLinked();

        
        stack.initStack('A');
        stack.push('B');
        stack.push('C');

        System.out.println("Tamanio? " + stack.size());
        System.out.println("ultimo? " + stack.nodeinit());
        System.out.println("Peek: " + stack.peek()); // C
        System.out.println("Pop: " + stack.pop());   // C
        System.out.println("Peek: " + stack.peek());
        System.out.println("Pop: " + stack.pop());   // B
        System.out.println("Vacia? " + stack.isEmpty()); // false
        System.out.println("Pop: " + stack.pop());   // A
        System.out.println("Vacia? " + stack.isEmpty()); // true
        System.out.println("Pop: " + stack.pop());   // A
        
        SymbolValidator symbolValidator = new SymbolValidator();
		System.out.println(symbolValidator.isBalanced("(3+s) * [s/2]")); // true
        System.out.println(symbolValidator.isBalanced("([)]")); // false
     		System.out.println("\n--- PRUEBA DE REGRESION (CONSOLA) ---");
     		if (args.length > 0) {
     			String expresionConsola = args[0];
     			System.out.println("Expresion recibida: " + expresionConsola);
     			System.out.println("Es valida?: " + symbolValidator.isBalanced(expresionConsola));
     		} else {
     			System.out.println("No se envio ninguna expresion por consola.");
     		}
        
    }
}
