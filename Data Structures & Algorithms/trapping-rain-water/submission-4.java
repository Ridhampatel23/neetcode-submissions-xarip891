class Solution {
    public int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }
         int[] leftMax = new int[height.length];
         int[] rightMax = new int[height.length];
          leftMax[0] = height[0];;
         rightMax[height.length - 1] = height[height.length - 1] ;
         int rMax = height[0]; int lMax = height[height.length - 1];

         for (int i = 1; i < height.length - 1; i++){ 
            if (height[i] > rMax) rMax = height[i];
            leftMax[i] = rMax;
         }

        for (int i = height.length -2; i >= 0; i--){ 
            if (height[i] > lMax) lMax = height[i];
            rightMax[i] = lMax;
         }

int result = 0;
         for (int i = 0; i < height.length - 1; i++){ 
            result += Math.min(leftMax[i], rightMax[i]) - height[i];
         }

return result;
    }
}
