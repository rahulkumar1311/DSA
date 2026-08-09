class Solution {
    public int stoneGameII(int[] piles) {
        int n = piles.length;

        int[] suffix = new int[n + 1];

        for (int i = n - 1; i >= 0; i--) {
            suffix[i] = suffix[i + 1] + piles[i];
        }
        int[][] dp = new int[n][n + 1];

        return solve(0, 1, piles, suffix, dp);
    }
    private int solve(int i, int M, int[] piles, int[] suffix, int[][] dp) {
        if (i >= piles.length) {
            return 0;
        }
        if (i + 2 * M >= piles.length) {
            return suffix[i];
        }
        if(dp[i][M] != 0) {
            return dp[i][M];
        }
        int best = 0;

        for(int x = 1; x <= 2 * M; x++) {
            int opponent =solve(
                i + x,
                Math.max(M, x),
                piles,
                suffix,
                dp
            );

            int current = suffix[i] - opponent;

            best = Math.max(best, current);
        }

        dp[i][M] = best;

        return best;
    }
}