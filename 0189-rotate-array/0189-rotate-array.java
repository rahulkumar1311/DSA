// class Solution {
//     public void rotate(int[] nums, int k) {
//         int n = nums.length;
//         k = k % n;
//         for(int i = 0; i < k; i++){
//             int last = nums[n - 1];
//             for(int j = n - 1; j > 0; j--){
//                 nums[j] = nums[j - 1];
//             }
//             nums[0] = last;
//         }
   
//     }
// }
class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        Reverse(nums, 0, n - 1);
        Reverse(nums, 0, k - 1);
        Reverse(nums, k, n - 1);
    }
    void Reverse(int[] nums, int p, int r) {
        while (r > p) {
            int temp = nums[p];
            nums[p] = nums[r];
            nums[r] = temp;
            p++;
            r--;
        }
    }
}