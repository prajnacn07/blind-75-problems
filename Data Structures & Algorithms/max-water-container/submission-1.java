class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length-1;
        int maxArea = 0;

        while(left < right){
            int width = right - left;
            int heightOfCont = Math.min(heights[right], heights[left]);
            maxArea = Math.max(maxArea, width*heightOfCont);

            if(heights[left] < heights[right]){
                left++;
            }else{
                right--;
            }
        }

        return maxArea;
    }
}
