// The best strategy is to make the rightmost number zero.
// E.g. for 10237 and target 2, we can add 3 to make it 10240. This removes 7 from the digit sum.

// Note that it won't do us any good if we add less than 3.

// 10240: add 60 to make it 10300.
// 10300: add 700 to make it 11000.
// Now, the number is beautiful, and the result is 700 + 60 + 3 == 763.

// The time complexity of this is O(log(n) ^ 2). We process logn digits, and for each iteration we calculate digit sum, which is also log(n).
class Solution {
    public long makeIntegerBeautiful(long n, int target) {
        long ans = 0;
        long factor = 10;
        while(getSum(n) > target){
            long rem = n % factor;
            n += factor - rem; //adding to number
            ans += factor - rem; //adding to answer
            factor *= 10;
        }
        
        return ans;
    }
    
    //Getting the sum of Digit
    public long getSum(long n){
        long sum = 0;
        while(n != 0){
            sum = sum + n % 10;
            n /= 10;
        }
        return sum;
    }
}
