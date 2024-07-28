class Solution {
    int count = 0;

    // BACKTRACKING + RECURSION
    private void solveRec(String s, int idx, StringBuilder sb, String t) {
        // Base Case
        if (idx >= s.length()) {
            if (sb.toString().equals(t)) {
                count++;
                return;
            } else {
                return;
            }
        }

        // take Case
        sb.append(s.charAt(idx));
        solveRec(s, idx + 1, sb, t);
        sb.deleteCharAt(sb.length() - 1);

        // non-take Case
        solveRec(s, idx + 1, sb, t);
    }




    // DP + Memoization
    private int solveMemo(String s, int idx, String t, int t_idx, int[][] dp) {
        // Base Case
        if (t_idx >= t.length())
            return 1;
        if (idx >= s.length())
            return 0;

        // step-2 => if already calculate just return it
        if (dp[idx][t_idx] != -1) {
            return dp[idx][t_idx];
        }

        // step-3 => if not calculate just calculate it and then return it
        int take = 0;
        int nontake = 0;
        // case when character are equal we take it
        if (s.charAt(idx) == t.charAt(t_idx)) {
            take = solveMemo(s, idx + 1, t, t_idx + 1, dp);
            nontake = solveMemo(s, idx + 1, t, t_idx, dp);
            return dp[idx][t_idx] = take + nontake;
        }

        // case when character aren't equal
        return dp[idx][t_idx] = solveMemo(s, idx + 1, t, t_idx, dp);
    }

    // Drive Function
    public int numDistinct(String s, String t) {
        // Recursion + Backtracking
        // solveRec(s, 0, new StringBuilder(), t);
        // return count;



        // DP + Memoization
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }

        return solveMemo(s, 0, t, 0, dp);
    }
}