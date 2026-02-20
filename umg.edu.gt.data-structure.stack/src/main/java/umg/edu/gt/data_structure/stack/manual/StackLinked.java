package umg.edu.gt.data_structure.stack.manual;

public class StackLinked {

	private Node top; // tope de la pila

	public boolean isEmpty() {
		return top == null;
	}
	
	public void initStack(char value) {
		top = new Node(value, top, 0); 
	}

	public void push(char value) {
		top = new Node(value, top, top.count); // el nuevo nodo apunta al anterior
	}
	
	public int size() {
		return top.count;
	}

	public char pop() {
		if (isEmpty()) {
			//throw new IllegalStateException("Stack is empty");
			return '0';
		}
		char value = top.value;
		top = top.next;
		return value;
	}

	public char peek() {
		if (isEmpty()) {
			throw new IllegalStateException("Stack underflow");
		}
		return top.value;
	}
	
	public char nodeinit() {
			if(isEmpty()) {
				return '0';
			}
			Node current = top;
			
			while(current.next != null) {
				current = current.next;
			}
			
			return current.value;
			
		
	}

}
