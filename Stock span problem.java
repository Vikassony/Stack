/*The stock span problem is a financial problem where we have a series of n daily price quotes for a stock and we need to calculate the span of stock’s price for all n days. 
The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than or equal to its price on the given day.
For example, if an array of 7 days prices is given as {100, 80, 60, 70, 60, 75, 85}, then the span values for corresponding 7 days are {1, 1, 1, 2, 1, 4, 6}.

Example 1:

Input: 
N = 7, price[] = [100 80 60 70 60 75 85]
Output:
1 1 1 2 1 4 6*/

class Solution
{
    public static int[] calculateSpan(int price[], int n)
    {
        Stack<Integer> st = new Stack<>();
        int a[] = new int[n];
        a[0]=1;
        st.push(0);
        for(int i=1;i<n;i++)
        {
            while(st.size()>0 && price[i]>=price[st.peek()])
            {
                st.pop();
            }
            if(st.isEmpty())
            a[i]=i+1;
            else
            a[i]=i-st.peek();
            st.push(i);
        }
        return a;
    }
    
}
