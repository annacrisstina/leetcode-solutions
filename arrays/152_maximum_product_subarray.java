// 152. Maximum Product Subarray
// https://leetcode.com/problems/maximum-product-subarray/
// Time: O(n) | Space: O(1)
// Explanation:
// We track both the maximum and minimum product at each step because
// a negative number can flip them — the next maximum might come from a previous minimum.

class Solution {
    public int maxProduct(int[] nums) {
        int maxProd = nums[0];
        int minProd = nums[0];
        int total = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int x = nums[i];
            int tempMax = x;
            if (x * maxProd > tempMax) tempMax = x * maxProd;
            if (x * minProd > tempMax) tempMax = x * minProd;

            int tempMin = x;
            if (x * maxProd > tempMin) tempMin = x * maxProd;
            if (x * minProd > tempMin) tempMin = x * minProd;

            maxProd = tempMax;
            minProd = tempMin;

            total = Math.max(total, maxProd); 
        }
        return total;
    }
}
