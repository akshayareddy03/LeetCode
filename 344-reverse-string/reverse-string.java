class Solution {
    public void reverseString(char[] s) {
        int lb=0;
        int ub=s.length-1;
        while(ub>lb){
        char temp=s[lb];
            s[lb]=s[ub];
            s[ub]=temp;
            lb++;
            ub--;
        }
    }}