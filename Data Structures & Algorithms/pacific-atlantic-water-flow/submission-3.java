class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length;
        int COLS = heights[0].length;
        
        boolean[][] pacific = new boolean[ROWS][COLS];
        boolean[][] atlantic = new boolean[ROWS][COLS];

        //Pacific Top and Left
        for(int r = 0; r < ROWS; r++){
            dfs(heights, r, 0, pacific, heights[r][0]); 
        }
        for(int c = 0; c < COLS; c++){
            dfs(heights, 0, c, pacific, heights[0][c]);
        }

        //Atlantic Bottom and Right
        for(int r = 0; r < ROWS; r++){
            dfs(heights, r, COLS - 1, atlantic, heights[r][COLS - 1]); 
        }
        for(int c = 0; c < COLS; c++){
            dfs(heights, ROWS - 1, c, atlantic, heights[ROWS - 1][c]);
        }

        List<List<Integer>> res = new ArrayList<>();
        for(int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                if (atlantic[r][c] && pacific[r][c]){
                    res.add(Arrays.asList(r, c));
                }
            }
        }
                    return res;

    }

    public void dfs(int[][] heights, int r, int c, boolean[][] visited, int prevHeight){
        if (r < 0 || c < 0 || r > heights.length - 1 || c > heights[0].length - 1) return;

        if (visited[r][c]) return;

        if (heights[r][c] < prevHeight) return;

        visited[r][c] = true;

        int[][] DIRS = {{1, 0}, {-1, 0}, {0 , 1}, {0, -1}};

         for (int[] dir : DIRS) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            dfs(heights, nr, nc, visited, heights[r][c]);
        }
    }
}
