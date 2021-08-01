class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
		st.push(nums2[nums2.length - 1]);
		HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(nums2[nums2.length - 1], -1);
		for (int i = nums2.length - 2; i >= 0; i--) {
			while (st.size() > 0 && nums2[i] > st.peek()) {
				st.pop();
			}
			if (st.size() == 0) {
				hm.put(nums2[i], -1);
			} else
				hm.put(nums2[i], st.peek());
			st.push(nums2[i]);
		}
		int res[] = new int[nums1.length];
		int k = 0;
		for (int i : nums1) {
			res[k++] = hm.get(i);
		}
		return res;
    }
}
