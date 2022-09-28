//TC : O(n);
//SC : O(n);
class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        int[] prefix = new int[nums.length]; //upto i tak kitne smaller hai, i ko include karte hue, from left
        int[] suffix = new int[nums.length]; //ith element se kitne element bade hai, usko include karte hue
        
        prefix[0] = 1;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] <= nums[i - 1]){
                prefix[i] = prefix[i - 1] + 1;
            }else{
                prefix[i] = 1;
            }
        }
        
        suffix[nums.length - 1] = 1;
        for(int i = nums.length - 2; i >= 0; --i){
            if(nums[i] <= nums[i + 1]){
                suffix[i] = suffix[i + 1] + 1;
            }else{
                suffix[i] = 1;
            }
        }
        
        List<Integer> res = new ArrayList<>();
        for(int i = k; i < nums.length - k; ++i){
            if(prefix[i - 1] >= k && suffix[i + 1] >= k){
                res.add(i);
            }
        }
        
        return res;
    }
}
