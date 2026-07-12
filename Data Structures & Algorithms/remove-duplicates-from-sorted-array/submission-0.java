class Solution {
    public int removeDuplicates(int[] nums) {
        int left = 0;
        int k = 1;

        for (int right = 1; right < nums.length; right++) {
            if (nums[left] == nums[right]) {
                // It's a duplicate, do nothing and let the loop continue
                continue;
            } else {
                // Found a new unique element
                left++;
                nums[left] = nums[right];
                k++;
            }
        }

        return k;
    }
}
    