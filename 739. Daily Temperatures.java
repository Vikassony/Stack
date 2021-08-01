class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int res[] = new int[temperatures.length];
		Stack<Integer> s = new Stack<>();
		res[0] = 0;
		s.push(temperatures.length - 1);
		for (int i = temperatures.length - 2; i >= 0; i--) {
			while (s.size() > 0 && temperatures[i] >= temperatures[s.peek()]) {
				s.pop();
			}
			if (s.isEmpty()) {
				res[i] = 0;
			} else {
				res[i] = s.peek() - i;
			}
			s.push(i);

		}
		return res;
    }
}
