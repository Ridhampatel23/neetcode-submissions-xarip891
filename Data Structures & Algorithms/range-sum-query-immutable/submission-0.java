class NumArray {
    int[] prefix;
    int[] nums;
    public NumArray(int[] nums) {
        prefix = new int[nums.length];

        prefix[0] = nums[0];
        for (int i = 1; i < nums.length; i++){
            prefix[i] = nums[i] + prefix[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left > right) return -1;

        int preRight = prefix[right];
        int preLeft = left > 0 ? prefix[left - 1] : 0;
        return preRight - preLeft;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */