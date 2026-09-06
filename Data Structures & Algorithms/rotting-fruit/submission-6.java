class Solution {
    public int orangesRotting(int[][] grid) {
        int fresh = 0, time = 0;
        int ROWS = grid.length;
        int COLS = grid[0].length;
        Queue<int[]> q = new ArrayDeque<>();

        for (int r = 0; r < ROWS; r++){
            for (int c = 0; c < COLS; c++){
                if (grid[r][c] == 1){
                    fresh++;
                }
                if (grid[r][c] == 2){
                    q.add(new int[]{r, c});
                }
            }
        }

        while (!q.isEmpty() && fresh > 0){
            int qLength = q.size();
            for (int i = 0; i < qLength; i++){
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                

                int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};                
for (int[] dir : directions) {
                    int row = r + dir[0];
                    int col = c + dir[1];
                    if (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length
                            && grid[row][col] == 1) {
                        grid[row][col] = 2;
                        q.offer(new int[]{row, col});
                        fresh--;
                    }
                    
                }
            }
            time++;
        }  
          return fresh == 0 ? time : -1;
    }
}
