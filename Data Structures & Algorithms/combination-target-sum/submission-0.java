
class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> combinationSum(int[] nums, int target) {
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

        curr.add(nums[index]);
        dfs(nums, target - nums[index], curr, index);

        curr.remove(curr.size() - 1);
        dfs(nums, target, curr, index + 1);
    }
}
