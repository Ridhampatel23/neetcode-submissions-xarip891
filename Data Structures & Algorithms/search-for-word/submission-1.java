class Solution {
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        

         for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
        
    public boolean dfs(char[][] board, int sr, int sc, String word, int index){
        if (index == word.length()) return true;
        if (sr < 0 || sr >= board.length || sc < 0 || sc >= board[0].length || board[sr][sc] == '.' || board[sr][sc] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) return true;
        
        board[sr][sc] = '.';
        
        boolean res = (dfs(board, sr + 1, sc, word, index + 1) ||
        dfs(board, sr, sc + 1, word, index + 1) ||
        dfs(board, sr - 1, sc, word, index + 1) ||
        dfs(board,  sr, sc - 1, word, index + 1));

        board[sr][sc] = word.charAt(index);
        return res;
    }
}