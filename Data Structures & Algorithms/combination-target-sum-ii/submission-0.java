class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        res = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<>();
        dfs(nums, target, curr, 0);
        return res;
    }

    public void dfs(int[] nums, int target, List<Integer> curr, int index){
        if (target == 0){
            res.add(new ArrayList(curr));
            return;
        }

        if (target < 0 || index >= nums.length){
            return;
        }

        for (int i = index; i < nums.length; i++){
            if (i > index && nums[i] == nums[i-1]) continue;
            curr.add(nums[i]);
            dfs(nums, target - nums[i], curr, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}