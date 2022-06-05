class Solution {
    //order does not matter, as we need to just count the number of such subsequence
    public int partitionArray(int[] nums, int k) {
        if(nums.length <= 1) return nums.length;
        
        //sorting the array
        Arrays.sort(nums); //uses tim sort algorithm O(nlogn)
        
        int min = nums[0];
        int ans = 1; //atleast one subsequence will be there
        for(int i = 1;i < nums.length; ++i){ //o(n)
            if(nums[i] <= min + k){
                continue;
            }else{
                ++ans; //implies starting of new subsequence
                min = nums[i];
            }
        }
        
        return ans;
    }
}
