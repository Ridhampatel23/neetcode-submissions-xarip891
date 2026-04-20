public class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int currSum = 0;
        for (int n : nums){
            if (currSum < 0) currSum = 0;
            currSum += n;
            res = Math.max(currSum, res);
        }

        return res;
    }
}
