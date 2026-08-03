public class Solution {

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        List<String> part = new ArrayList<>();
        dfs(0, s, part, res);
        return res;
    }

    private void dfs(int index, String s, List<String> part, List<List<String>> res) {
        if (index == s.length()) {
            res.add(new ArrayList<>(part));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPali(s, index, i)) {
                part.add(s.substring(index, i + 1));
                dfs(i + 1, s, part, res);
                part.remove(part.size() - 1);
            }
        }
    }

    private boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}