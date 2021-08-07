/*MinStack() initializes the stack object.
void push(val) pushes the element val onto the stack.
void pop() removes the element on the top of the stack.
int top() gets the top element of the stack.
int getMin() retrieves the minimum element in the stack.
 

Example 1:

Input
["MinStack","push","push","push","getMin","pop","top","getMin"]
[[],[-2],[0],[-3],[],[],[],[]]

Output
[null,null,null,null,-3,null,0,-2]

Explanation
MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.getMin(); // return -3
minStack.pop();
minStack.top();    // return 0
minStack.getMin(); // return -2*/

class MinStack {

	/** initialize your data structure here. */
	Stack<Integer> s;
	Stack<Integer> min;

	public MinStack() {
		s = new Stack<>();
		min = new Stack<>();

	}

	public void push(int val) {
		s.push(val);
		if (min.isEmpty() || val <= min.peek()) {
			min.push(val);
		}
	}

	public void pop() {
		    if(!s.isEmpty()){
			int x = s.pop();
			if (x == min.peek())
				min.pop();
            }
	}

	public int top() {
		if (s.isEmpty())
			return -1;
		return s.peek();
	}

	public int getMin() {
		if (min.size() == 0) {
			return 0;
		}
		return min.peek();
	}
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(val); obj.pop(); int param_3 = obj.top(); int
 * param_4 = obj.getMin();
 */
