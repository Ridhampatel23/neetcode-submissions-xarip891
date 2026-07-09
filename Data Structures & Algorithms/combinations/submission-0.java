class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> curr = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        dfs(1, n, k, curr, res);
        return res;
    }

    public void dfs (int index, int n, int pairNum, List<Integer> curr, List<List<Integer>> res){
        if (curr.size() == pairNum){
            res.add(new ArrayList<>(curr));
            return;
        }
        if (index > n) {
            return;
        }

        curr.add(index);
        dfs(index + 1, n, pairNum, curr, res);

        curr.remove(curr.size() - 1);
        dfs(index + 1, n, pairNum, curr, res);

    }
}