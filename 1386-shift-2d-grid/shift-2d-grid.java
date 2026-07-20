class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        int size = m * n;

        k %= size;

        int [][] ans = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0;j<n;j++){
                int idx = i*n + j;
                int newIdx = (idx + k) % size;

                int row  = newIdx / n;
                int col = newIdx % n;

                ans[row][col] = grid[i][j];
            }
        }
        List<List<Integer>> res = new ArrayList<>();

        for(int i=0;i<m;i++){
            List<Integer> list = new ArrayList<>();
            for(int j=0;j<n;j++){
                list.add(ans[i][j]);
            }
            res.add(list);
        }
        return res;
    }
}