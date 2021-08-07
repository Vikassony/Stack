/*Given a pattern containing only I's and D's. I for increasing and D for decreasing.
Devise an algorithm to print the minimum number following that pattern.
Digits from 1-9 and digits can't repeat.
Input:
D
Output:
21
IIDDD
Output:
126543
1 < 2 < 6 > 5 > 4 > 3
  I - I - D - D - D
*/
class Solution{
    static String printMinNumberForPattern(String S){
        Stack<Integer> st = new Stack<>();
        int num=1;
        String res="";
        for(int i=0;i<S.length();i++)
        {
            char ch =S.charAt(i);
            if(ch=='D')
            {
                st.push(num);
                num++;
            }
            else
            {
                st.push(num);
                num++;
                while(st.size()>0)
                {
                    res+=Integer.toString(st.pop());
                }
            }
        }
        st.push(num);
        while(st.size()>0)
        {
            res+=Integer.toString(st.pop());
        }
        return res;
    }
}
