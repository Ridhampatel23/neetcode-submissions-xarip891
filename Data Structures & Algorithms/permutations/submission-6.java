class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        recurPermute(nums, 0, ans);
        return ans;
        
    }

    public void recurPermute(int[] nums, int index, List<List<Integer>> ans){
        // Base case
        if (index == nums.length){
            //make a copy of the array to a new list
            List<Integer> curr = new ArrayList<>();
            for (int x : nums) curr.add(x);
            ans.add(curr);
            return;
        }

        for (int i = index; i < nums.length; i++){
            swap(i, index, nums);
            recurPermute(nums, index + 1, ans);
            swap(i, index, nums);
        }
    }

    public void swap(int i, int j, int[] nums){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
}