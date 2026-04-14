class Solution {
    public int maxArea(int[] heights) {
        int n = heights.length;
        int result = 0;
        int left = 0;
        int right = n - 1;
        while (left < right){
          result = Math.max(Math.min(heights[left], heights[right]) * (right - left), result);
          if(heights[left] < heights[right]) left++;
          else right--;
        }
        
        return result;
    }
}
