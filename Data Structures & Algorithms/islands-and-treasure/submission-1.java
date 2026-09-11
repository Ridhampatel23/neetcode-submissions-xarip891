class Solution {
    public void islandsAndTreasure(int[][] grid) {
        Queue<int[]> q = new ArrayDeque<>();
        int ROWS = grid.length;
        int COLS = grid[0].length;
        
        // Standard directions array for moving Up, Down, Left, Right
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                if (grid[r][c] == 0) q.offer(new int[]{r, c});
            }
        }
        if (q.size() == 0) return;

        int dis = 1;
        while(!q.isEmpty()){
            int qSize = q.size();

            
            for (int i = 0; i < qSize; i++){
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];

                for (int[] dir : directions){
                    int nRow = r + dir[0];
                    int nCol = c + dir[1];
                    if (nRow >= ROWS || nCol >= COLS || nRow < 0 || nCol < 0 || grid[nRow][nCol] != Integer.MAX_VALUE) {
                    continue;
                    }

                    q.add(new int[] {nRow, nCol});
                    grid[nRow][nCol] = dis;
                }
            }
            dis++;
        }
        
    }
}
