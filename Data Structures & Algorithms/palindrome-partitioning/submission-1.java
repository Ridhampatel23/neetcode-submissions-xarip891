class Solution {
    List<List<String>> result;
    List<String> currString;

    public List<List<String>> partition(String s) {
        result = new ArrayList<>();
        currString = new ArrayList<>();
        dfs(0, 0, s);
        return result;
    }

    public void dfs(int start, int end, String s){
        if (end >= s.length()){
            if(start == end){
                result.add(new ArrayList<>(currString));
            }
            return;
        }

        if (isPalindrome(s, start, end)){
            currString.add(s.substring(start, end + 1));
            dfs(end + 1, end + 1, s);
            currString.remove(currString.size() - 1);
        }

        dfs(start, end + 1, s);
    }


    public boolean isPalindrome(String s, int left, int right){
        while (left < right){
            if (s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
