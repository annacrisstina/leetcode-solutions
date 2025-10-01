// Problem: Maximum Subarray
// Link: https://leetcode.com/problems/maximum-subarray/

// 1. Kadane's Algorithm (O(n))
// 2. Divide & Conquer (O(n log n), follow-up)

// Time Complexity: O(n) for Kadane, O(n log n) for Divide & Conquer
// Space Complexity: O(1) for Kadane, O(log n) for recursion stack in Divide & Conquer

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    // Kadane's Algorithm (O(n))
    int maxSubArray(vector<int>& nums) {
        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.size(); i++) {
            currentSum = max(nums[i], currentSum + nums[i]);
            maxSum = max(maxSum, currentSum);
        }
        return maxSum;
    }

    // Divide & Conquer (O(n log n))
    int maxSubArrayDivideConquer(vector<int>& nums) {
        return maxSubArrayHelper(nums, 0, nums.size() - 1);
    }

private:
    int maxCrossingSum(vector<int>& nums, int left, int mid, int right) {
        // max sum in left half ending at mid
        int leftSum = INT_MIN, sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            leftSum = max(leftSum, sum);
        }

        // max sum in right half starting at mid+1
        int rightSum = INT_MIN;
        sum = 0;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            rightSum = max(rightSum, sum);
        }

        return leftSum + rightSum;
    }

    int maxSubArrayHelper(vector<int>& nums, int left, int right) {
        if (left == right) return nums[left];

        int mid = (left + right) / 2;

        int leftMax = maxSubArrayHelper(nums, left, mid);
        int rightMax = maxSubArrayHelper(nums, mid + 1, right);
        int crossMax = maxCrossingSum(nums, left, mid, right);

        return max({leftMax, rightMax, crossMax});
    }
};
