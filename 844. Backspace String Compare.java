class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st1 = new Stack<>();
		Stack<Character> st2 = new Stack<>();
		String s11 = "", s22 = "";
        String s1=s,s2=t;
		for (int i = 0; i < s1.length(); i++) {
			if (s1.charAt(i) >= 'a' && s1.charAt(i) <= 'z') {
				st1.push(s1.charAt(i));
				s11 += st1.peek();
			} else if (!st1.isEmpty()) {

				st1.pop();
			}

		}
		for (int i = 0; i < s2.length(); i++) {
			if (s2.charAt(i) >= 'a' && s2.charAt(i) <= 'z') {
				st2.push(s2.charAt(i));
			} else if (!st2.isEmpty()) {
				st2.pop();
			}
		}
		if (st1.size() != st2.size())
			return false;
		while (!st1.isEmpty()) {
			if (st1.peek() == st2.peek()) {
				st1.pop();
				st2.pop();
			} else
				return false;
		}
		return true;
    }
}
