class Solution {

    public int stoneGameV(int[] stoneValue) {

        int n = stoneValue.length;

        // Prefix sum
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stoneValue[i];
        }

        // dp[l][r] = maximum score from l to r
        int[][] dp = new int[n][n];

        // length = 2 se start
        for (int len = 2; len <= n; len++) {

            for (int l = 0; l + len - 1 < n; l++) {

                int r = l + len - 1;

                for (int cut = l; cut < r; cut++) {

                    int leftSum =
                        prefix[cut + 1] - prefix[l];

                    int rightSum =
                        prefix[r + 1] - prefix[cut + 1];

                    if (leftSum < rightSum) {

                        dp[l][r] = Math.max(
                            dp[l][r],
                            leftSum + dp[l][cut]
                        );

                    } 
                    else if (leftSum > rightSum) {

                        dp[l][r] = Math.max(
                            dp[l][r],
                            rightSum + dp[cut + 1][r]
                        );

                    } 
                    else {

                        dp[l][r] = Math.max(
                            dp[l][r],
                            leftSum + dp[l][cut]
                        );

                        dp[l][r] = Math.max(
                            dp[l][r],
                            rightSum + dp[cut + 1][r]
                        );
                    }
                }
            }
        }

        return dp[0][n - 1];
    }
}