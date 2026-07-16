class Solution {
    List<String> res;
    StringBuilder stack;
    public List<String> generateParenthesis(int n) {
    res = new ArrayList<>();
    stack = new StringBuilder();
    dfs(0, 0, n);
    return res;        
    }

    public void dfs (int openC, int closeC, int n){
        //Base case
        if (openC == closeC && openC == n){
            res.add(stack.toString());
            return;
        }

         if (openC < n) {
            stack.append('(');
            dfs(openC + 1, closeC, n);
            stack.deleteCharAt(stack.length() - 1);
        }
        if (closeC < openC) {
            stack.append(')');
            dfs(openC, closeC + 1, n);
            stack.deleteCharAt(stack.length() - 1);
        }
    }
}
