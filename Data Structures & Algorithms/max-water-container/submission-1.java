class Solution {
    public int maxArea(int[] heights) {
        if (heights.length == 0) return -1;
        int start = 0;
        int end = heights.length - 1;
        int maxArea = 0;
        int currArea = 0;

        while (start < end){
             currArea = (end - start) * Math.min(heights[start], heights[end]);
           if (heights[start] > heights[end]){
                end--;
            } else {
                start++;
            }
           
            maxArea = Math.max(currArea, maxArea);
        }
        return maxArea;

    }
}
