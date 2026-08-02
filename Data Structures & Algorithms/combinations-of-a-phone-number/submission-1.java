class Solution {
   private List<String> res = new ArrayList<>();
    private String[] digitsToChar = {
        "", "", "abc", "def", "ghi", "jkl", "mno", "qprs", "tuv", "wxyz"
    };

    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) return res;
        dfs(0, "", digits);
        return res;
    }

    public void dfs(int index, String currStr, String digits){
        if (currStr.length() == digits.length()){
            res.add(currStr);
            return;
        }

        String chars = digitsToChar[digits.charAt(index) - '0'];
        for (char c : chars.toCharArray()){
            dfs(index + 1, currStr + c, digits);

        }

    }
}
