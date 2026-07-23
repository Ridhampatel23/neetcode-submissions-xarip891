class Solution {
    public boolean exist(char[][] board, String word) {
        int ROWS = board.length;
        int COLS = board[0].length;
        int[][] visited = new int[ROWS][COLS];

         for (int r = 0; r < ROWS; r++) {
            for (int c = 0; c < COLS; c++) {
                if (dfs(board, visited, r, c, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
        
    public boolean dfs(char[][] board, int[][] visited, int sr, int sc, String word, int index){
        if (index == word.length()) return true;
        if (sr < 0 || sr >= board.length || sc < 0 || sc >= board[0].length || visited[sr][sc] == 1 || board[sr][sc] != word.charAt(index)) {
            return false;
        }

        if (index == word.length() - 1) return true;
        
        visited[sr][sc] = 1;
        
        boolean res = (dfs(board, visited, sr + 1, sc, word, index + 1) ||
        dfs(board, visited, sr, sc + 1, word, index + 1) ||
        dfs(board, visited, sr - 1, sc, word, index + 1) ||
        dfs(board, visited, sr, sc - 1, word, index + 1));

        visited[sr][sc] = 0;
        return res;
    }
}