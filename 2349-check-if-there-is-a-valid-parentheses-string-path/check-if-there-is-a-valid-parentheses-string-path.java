class Solution {
    public boolean hasValidPath(char[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        // Total path length must be even
        if ((m + n - 1) % 2 != 0) {
            return false;
        }

        // dp[i][j][balance]
        // true = cell (i,j) par ye balance possible hai
        boolean[][][] dp = new boolean[m][n][m + n];

        // Starting cell must be '('
        if (grid[0][0] == ')') {
            return false;
        }

        dp[0][0][1] = true;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                // Starting cell already handled
                if (i == 0 && j == 0) {
                    continue;
                }

                int change = (grid[i][j] == '(') ? 1 : -1;

                // From top
                if (i > 0) {
                    for (int balance = 0; balance < m + n; balance++) {

                        if (dp[i - 1][j][balance]) {

                            int newBalance = balance + change;

                            if (newBalance >= 0) {
                                dp[i][j][newBalance] = true;
                            }
                        }
                    }
                }

                // From left
                if (j > 0) {
                    for (int balance = 0; balance < m + n; balance++) {

                        if (dp[i][j - 1][balance]) {

                            int newBalance = balance + change;

                            if (newBalance >= 0) {
                                dp[i][j][newBalance] = true;
                            }
                        }
                    }
                }
            }
        }

        // Final balance must be 0
        return dp[m - 1][n - 1][0];
    }
}