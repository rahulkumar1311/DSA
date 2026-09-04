class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {

            int leftMax = nums[0];
            int rightMin = nums[i];

            // 0 se i tak maximum
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, nums[j]);
            }

            // i se n-1 tak minimum
            for (int j = i; j < n; j++) {
                rightMin = Math.min(rightMin, nums[j]);
            }

            // Instability score
            int instability = leftMax - rightMin;

            if (instability <= k) {
                return i;
            }
        }

        return -1;
    }
}