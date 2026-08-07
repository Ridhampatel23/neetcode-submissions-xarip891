class Solution {
    Set<Integer> col = new HashSet<>();
    Set<Integer> posDiag = new HashSet<>();
    Set<Integer> negDiag = new HashSet<>();
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        dfs(0, n, board);
        return res;
    }


    public void dfs(int r, int n,char[][] board){
        
        if (r == n){
            List<String> curr = new ArrayList<>();
            for (char[] row : board){
                curr.add(new String(row));
            }
            res.add(curr);
            return;
        }

        for (int c = 0; c < n; c++){
            if (col.contains(c) || posDiag.contains(r + c) 
                || negDiag.contains(r - c)) {
                    continue;
                }

            col.add(c);
            posDiag.add(r + c);
            negDiag.add(r - c);
            board[r][c] = 'Q';

            dfs(r + 1, n, board);

            col.remove(c);
            posDiag.remove(r + c);
            negDiag.remove(r - c);
            board[r][c] = '.';
        }

    }
}
