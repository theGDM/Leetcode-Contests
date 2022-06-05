// You are given a 0-indexed array nums that consists of n distinct positive integers. Apply m operations to this array, where in the ith operation you replace the number operations[i][0] with operations[i][1].
// It is guaranteed that in the ith operation:
// operations[i][0] exists in nums.
// operations[i][1] does not exist in nums.
// Return the array obtained after applying all the operations.

// Example 1:
// Input: nums = [1,2,4,6], operations = [[1,3],[4,7],[6,1]]
// Output: [3,2,7,1]
// Explanation: We perform the following operations on nums:
// - Replace the number 1 with 3. nums becomes [3,2,4,6].
// - Replace the number 4 with 7. nums becomes [3,2,7,6].
// - Replace the number 6 with 1. nums becomes [3,2,7,1].
// We return the final array [3,2,7,1].

// Example 2:
// Input: nums = [1,2], operations = [[1,3],[2,1],[3,2]]
// Output: [2,1]
// Explanation: We perform the following operations to nums:
// - Replace the number 1 with 3. nums becomes [3,2].
// - Replace the number 2 with 1. nums becomes [3,1].
// - Replace the number 3 with 2. nums becomes [2,1].
// We return the array [2,1].

//TC : O(n) + O(m)
//SC : O(n)
class Solution {
    public int[] arrayChange(int[] nums, int[][] operations) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0;i < nums.length; ++i){ //O(n) To create hashmap
            hm.put(nums[i], i);
        }
        
        for(int i = 0; i < operations.length; ++i){ //to perform replacement operation
            int key = operations[i][0];
            if(hm.containsKey(key)){
                nums[hm.get(key)] = operations[i][1]; //replace
                hm.put(operations[i][1], hm.get(key)); //putting the new updated value in hashmap with same index
                hm.remove(key); //removing the previous value from the hashmap
            }
        }
        
        return nums;
    }
}
