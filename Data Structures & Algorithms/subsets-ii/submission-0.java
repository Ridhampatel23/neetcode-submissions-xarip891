class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        dfs(0, nums, curr, res);
        return res;
    }


    public void dfs(int index, int[] nums, List<Integer> curr, List<List<Integer>> res){
        if (index == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        curr.add(nums[index]);
        dfs(index + 1, nums, curr, res);
        curr.remove(curr.size() - 1);

        while(index + 1 < nums.length && nums[index] == nums[index + 1]){
            index++;
        }

        dfs(index + 1, nums, curr, res);
    }
}