class Solution {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] > max){
                max = nums[i];
            }
        }
        
        int maxLen = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == max){
                int j = i;
                int len = 0;
                while(j < nums.length && nums[j] == max){
                    len++;
                    j++;
                }
                
                i = j;
                maxLen = Math.max(maxLen, len);
            }
        }
        
        return maxLen;
    }
}
