class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String c : tokens){
            
                 switch (c) {
                    case "+": stack.push(stack.pop() + stack.pop()); break;
                    case "-": 
                    int a = stack.pop();
                    int b = stack.pop();
                    stack.push(b - a); 
                    
                    break;
                    case "*": stack.push(stack.pop() * stack.pop()); break;
                    case "/":
                    int den = stack.pop();
                    int num = stack.pop();
                     stack.push(num / den); 
                     
                     break;
                    default: stack.push(Integer.parseInt(c));
                }         
        }
        return stack.pop();
    }
}
