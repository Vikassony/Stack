class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int nge[] = new int[nums.length];
        Stack<Integer> s = new Stack<>();
        s.push(nums.length-1);
        nge[nums.length-1]=nums.length;
        for(int i=nums.length-2;i>=0;i--)
        {
            while(s.size()>0 && nums[i]>=nums[s.peek()])
            {
                s.pop();
            }
            if(s.isEmpty())
            {
                nge[i]=nums.length;
            }
            else
                nge[i]=s.peek();
            s.push(i);
        }
        ArrayList<Integer> al = new ArrayList<>();
        int j=0;
        for(int i=0;i<=nums.length-k;i++)
        {
            if(j<i)
            {
                j=i;
            }
            while(nge[j]<i+k)
            {
                j=nge[j];
            }
            al.add(nums[j]);
        }
        int a[] = new int[al.size()];
        for(int i=0;i<a.length;i++)
        {
            a[i]=al.get(i);
        }
        return a;
    }
}
