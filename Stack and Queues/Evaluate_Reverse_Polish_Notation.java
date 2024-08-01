class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int d2 = stack.pop();
                int d1 = stack.pop();
                int res = 0;

                if (token.equals("+")) {
                    res = d1 + d2;
                } else if (token.equals("-")) {
                    res = d1 - d2;
                } else if (token.equals("*")) {
                    res = d1 * d2;
                } else if (token.equals("/")) {
                    res = d1 / d2;
                }
                stack.push(res);
            } else {
                stack.push(Integer.valueOf(token)); // Using Integer.valueOf()
            }
        }

        return stack.pop();
    }
}