class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n=temperatures.length;
        int[] ans = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<n; i++) {
            int curr = temperatures[i];
            while (!stack.isEmpty() && temperatures[stack.peek()] < curr) {
                int j = stack.pop();
                ans[j] = i-j;
            }
            stack.push(i);
        }
        return ans;
    }
}