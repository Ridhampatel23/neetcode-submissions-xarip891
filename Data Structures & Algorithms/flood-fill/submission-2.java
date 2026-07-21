class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int target = image[sr][sc];
        return dfs(image, sr, sc, color, target);
    }

    public int[][] dfs(int[][] image, int sr, int sc, int color, int target){
        int row = image.length;
        int col = image[0].length;
        if (sr < 0 || sr >= image.length || sc < 0 || sc >= image[0].length || image[sr][sc] != target) {
            return image;
        }

        if (image[sr][sc] == color) return image;
        
        if (image[sr][sc] == target){
            image[sr][sc] = color;
        }

        dfs(image, sr + 1, sc, color, target);
        dfs(image, sr, sc + 1, color, target);
        dfs(image, sr - 1, sc, color, target);
        dfs(image, sr, sc - 1, color, target);

        return image;

    }
}