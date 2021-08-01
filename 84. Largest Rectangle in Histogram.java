class Solution {
    public int largestRectangleArea(int[] heights) {
        int r[] = new int[heights.length];
		int l[] = new int[heights.length];
		Stack<Integer> sr = new Stack<>();
		r[r.length - 1] = heights.length;
		sr.push(heights.length - 1);
		for (int i = heights.length - 2; i >= 0; i--) {
			while (sr.size() > 0 && heights[i] <= heights[sr.peek()]) {
				sr.pop();
			}
			if (sr.isEmpty()) {
				r[i] = heights.length;
			} else {
				r[i] = sr.peek();
			}
			sr.push(i);
		}

		Stack<Integer> sl = new Stack<>();
		l[0] = -1;
		sl.push(0);
		for (int i = 1; i < heights.length; i++) {
			while (sl.size() > 0 && heights[i] <= heights[sl.peek()]) {
				sl.pop();
			}
			if (sl.isEmpty()) {
				l[i] = -1;
			} else {
				l[i] = sl.peek();
			}
			sl.push(i);
		}
		int max = 0;
		for (int i = 0; i < heights.length; i++) {
			int w = r[i] - l[i] - 1;
			int ar = heights[i] * w;
			if (ar > max)
				max = ar;
		}
		return max;
    }
}
