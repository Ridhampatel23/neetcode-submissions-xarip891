class Solution {
    //For o(1) space, we use negative marking
    public int findDuplicate(int[] nums) {
        for (int i = 0; i < nums.length; i++){
            //The absolute value will check if the index of current number is marked negative
            // if it has, we found the duplicate and return true.
            int index = Math.abs(nums[i]);
            if (nums[index] < 0){
                return index;
            }
            nums[index] *= -1;
        }
        return -1;
    }
}
