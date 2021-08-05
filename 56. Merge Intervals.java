class Solution {
	public int[][] merge(int[][] intervals) {
		Pair p[] = new Pair[intervals.length];
		for (int i = 0; i < intervals.length; i++) {
			p[i] = new Pair(intervals[i][0], intervals[i][1]);
		}
		Arrays.sort(p);
		Stack<Pair> s = new Stack<>();
		for (int i = 0; i < p.length; i++) {
			if (i == 0) {
				s.push(p[i]);
			} else {
				Pair top = s.peek();
				if (p[i].st > top.et) {
					s.push(p[i]);
				} else {
					top.et = Math.max(top.et, p[i].et);
				}
			}
		}
		Stack<Pair> s1 = new Stack<>();
		while (s.size() > 0) {
			s1.push(s.pop());
		}
		int res[][] = new int[s1.size()][2];
		for (int i = 0; i < res.length; i++) {
			for (int j = 0; j < 2; j++) {
				Pair top = s1.peek();
					res[i][0] = (int) top.st;
					res[i][1] = (int) top.et;
			}
            s1.pop();
		}
		return res;
	}

	public class Pair implements Comparable<Pair> {
		int st;
		int et;

		Pair(int st, int et) {
			this.st = st;
			this.et = et;
		}

		public int compareTo(Pair p) {
			if (this.st != p.st)
				return this.st - p.st;
			else
				return this.et - p.et;
		}
	}
}
