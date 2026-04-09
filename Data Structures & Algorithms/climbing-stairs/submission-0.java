class Solution {
    public int climbStairs(int n) {
        //one - ways to reach current step
        //two - ways to reach previous step
        int one = 1, two = 1;

        for(int i=0; i<n-1; i++){
            int temp = one;
            one = one + two;
            two = temp;
        }

        return one;
    }
}
