public class Stack {
	static int a[] = new int[5];
	static int top = -1;

	public static void main(String[] args) {
		Stack.push(10);
		Stack.push(20);
		Stack.peek();
		Stack.pop();
		Stack.peek();
	}

	public static void push(int x) {
		if (top == a.length - 1) {
			System.out.println("The stack is full");
			return;
		} else {
			a[++top] = x;
		}
	}

	public static void pop() {
		if (top == -1) {
			System.out.println("The Stack is empty");
			return;
		} else
			top--;
	}

	public static void peek() {
		if (top == -1) {
			System.out.println("The Stack is empty");
			return;
		} else
			System.out.println(a[top]);
	}
}
