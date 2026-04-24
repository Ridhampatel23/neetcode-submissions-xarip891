class Solution {
    public int calPoints(String[] operations) {
        Deque<Integer> stack = new ArrayDeque<>();
        int output = 0;

        for (String n : operations){
           
            if(n.equals("+")){
                int top = stack.pop();
                int add = top + stack.peek();
                stack.push(top);
                stack.push(add);
                output += add;
            } else if (n.equals("C")){
                output -= stack.pop();
                
            } else if (n.equals("D")){

                stack.push(stack.peek() * 2);
                output += stack.peek();

            } else{
                stack.push(Integer.parseInt(n));
                output += stack.peek();
            }
        }
        return output;
    }
}