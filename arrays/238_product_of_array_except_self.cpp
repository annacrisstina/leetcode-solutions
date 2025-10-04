// Problem: 238. Product of Array Except Self
// Link: https://leetcode.com/problems/product-of-array-except-self/
// Time complexity: O(n)
// Space complexity: O(n) for main version, O(1) extra space for optimized follow-up
//
// Idea:
// For each element, compute the product of all numbers to its left and right without using division.
// - First approach uses two extra arrays (prefix and suffix).
// - Optimized approach reuses the answer array and one variable for the right product.

#include <vector>
using namespace std;

class Solution {
public:
    // Main solution (O(n) time, O(n) space)
    vector<int> productExceptSelf(vector<int>& nums) {
        int n = nums.size();
        vector<int> prefix(n, 1), suffix(n, 1), answer(n);

        for (int i = 1; i < n; i++)
            prefix[i] = prefix[i - 1] * nums[i - 1];

        for (int i = n - 2; i >= 0; i--)
            suffix[i] = suffix[i + 1] * nums[i + 1];

        for (int i = 0; i < n; i++)
            answer[i] = prefix[i] * suffix[i];

        return answer;
    }

private:
    // Follow-up (O(n) time, O(1) extra space)
    // Store prefix directly in answer[] and multiply by right product on the second pass.
    vector<int> productExceptSelfOptimized(vector<int>& nums) {
        int n = nums.size();
        vector<int> answer(n, 1);

        for (int i = 1; i < n; i++)
            answer[i] = answer[i - 1] * nums[i - 1];

        int right = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] *= right;
            right *= nums[i];
        }

        return answer;
    }
};
