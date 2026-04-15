class MinStack {
    int minimum = 0;
    Stack<int[]> stack; //pairs: val, minVal

    public MinStack() {
        stack = new Stack<>();
    }
    
    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(new int[]{val, val});
        } else {
            int currMin = Math.min(val, stack.peek()[1]);
            stack.push(new int[]{val, currMin});
        }
    }
    
    public void pop() {
        if (stack.isEmpty()) return;
       else stack.pop();
    }
    
    public int top() {
        return stack.peek()[0];
    }
    
    public int getMin() {
        return stack.peek()[1];
    }
}
