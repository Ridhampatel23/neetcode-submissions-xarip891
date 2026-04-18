class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        int totalWater = 0;

        while (left < right){
            if (leftMax < rightMax){
                left++;
                leftMax = Math.max(leftMax, height[left]);
                totalWater += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                totalWater += rightMax - height[right];
            }
        }
        return totalWater;
    }
}
