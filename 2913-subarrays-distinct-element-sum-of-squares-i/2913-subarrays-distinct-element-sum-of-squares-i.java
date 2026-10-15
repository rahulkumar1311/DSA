class Solution {
    public int sumCounts(List<Integer> nums) {
        int sum = 0; 
        int n = nums.size(); 
        for (int i = 0; i < n; i++) { 
            for (int j = i; j < n; j++) { 
                int distinct = 0; 
                for (int k = i; k <= j; k++) { 
                    boolean duplicate = false; 
                    for (int l = i; l < k; l++) { 
                        if (nums.get(k).equals(nums.get(l))) { 
                            duplicate = true; 
                            break; 
                            } 
                            } 
                            if (!duplicate) { distinct++; 
                            } 
                            } 
                            sum += distinct * distinct; 
                            } 
                            } 
                            return sum;
    }
}