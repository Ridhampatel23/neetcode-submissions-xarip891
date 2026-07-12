class Solution {
    private Map<Integer, Integer> counts;
    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {

        res = new ArrayList<>();
        counts = new HashMap<>();
        List<Integer> curr = new ArrayList<>();

        for (int n : nums){
            counts.put(n, counts.getOrDefault(n, 0) + 1);
        }

        dfs(nums, curr);
        return res;        
    }

    public void dfs(int[] nums, List<Integer> curr){
        if (curr.size() == nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }

        for (int n : counts.keySet()){
            if (counts.get(n) > 0){
                curr.add(n);
                counts.put(n, counts.get(n) - 1);
                dfs(nums, curr);
                counts.put(n, counts.get(n) + 1);
                curr.remove(curr.size() - 1);
            }
        }
    }
}