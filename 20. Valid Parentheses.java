class Solution {
    public boolean isValid(String s) {
        if (s.charAt(0) == ')' || s.charAt(0) == '}' || s.charAt(0) == ']')
			return false;
		Stack<Character> st = new Stack<Character>();
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
				st.push(s.charAt(i));
			} else if (st.empty() == false && check1(st, s.charAt(i)))
				st.pop();
			else
				return false;
		}

		if (st.empty() == true)
			return true;
		return false;
    }
    public  boolean check1(Stack<Character> s, char c) {
		if (c == ')' && s.peek() == '(')
			return true;
		else if (c == ']' && s.peek() == '[')
			return true;
		else if (c == '}' && s.peek() == '{')
			return true;
		return false;
	}
}
