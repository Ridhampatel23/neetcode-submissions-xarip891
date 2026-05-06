class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<int[]> stack = new Stack<>(); //pair: temperature, index
        int[] output = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++){
            //keep popping and calculating output while stack isnt empty and curr temp is greater than stack
            while (!stack.isEmpty() && temperatures[i] > stack.peek()[0]){
                int index = stack.pop()[1];
                output[index] = i - index;
            }
            //otherwise push the temp and index on stack since they are smaller than top of the stack
            stack.push(new int[]{temperatures[i], i});
        }
        return output;
    }
}
