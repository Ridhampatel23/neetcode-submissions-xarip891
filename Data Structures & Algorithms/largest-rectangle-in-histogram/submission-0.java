class Solution {
    public int largestRectangleArea(int[] heights) {
        int result = 0;
        Stack<int[]> stack = new Stack<>(); // pair: index, height

        for (int i = 0; i < heights.length; i++){
            int start = i;
            while (!stack.isEmpty() && stack.peek()[1] > heights[i]){
                int[] top = stack.pop();
                int index = top[0];
                int height = top[1];
                result = Math.max(result, height * (i - index));
                start = index;
            }
            stack.push(new int[]{start, heights[i]});
        }

        for (int[] pair : stack){
            int index = pair[0];
            int height = pair[1];
            result = Math.max (result, height * (heights.length - index));
        }
        return result;

    }
}
