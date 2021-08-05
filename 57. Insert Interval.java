/*Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

 

Example 1:

Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]*/
class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int nya[][] = new int[intervals.length+1][2];
        int i=0,j=0;
        for(i=0;i<intervals.length;i++)
        {
            for( j=0;j<2;j++)
            {
                nya[i][j]=intervals[i][j];
            }
        }
        j=0;
        nya[i][0]=newInterval[0];
        nya[i][1]=newInterval[1];
    Pair p[] = new Pair[nya.length];
		for ( i = 0; i < nya.length; i++) {
			p[i] = new Pair(nya[i][0], nya[i][1]);
		}
        i=0;
		Arrays.sort(p);
		Stack<Pair> s = new Stack<>();
		for ( i = 0; i < p.length; i++) {
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
		for ( i = 0; i < res.length; i++) {
			for ( j = 0; j < 2; j++) {
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
