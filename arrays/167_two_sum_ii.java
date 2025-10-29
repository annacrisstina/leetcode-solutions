// LeetCode 167. Two Sum II - Input Array Is Sorted
// https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// Time Complexity: O(n)
// Space Complexity: O(1)
//
// Approach:
// Since the array is sorted, use the two-pointer technique.
// Start from both ends and move pointers toward the middle
// depending on whether the sum is smaller or larger than target.

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // LeetCode expects 1-based indices
                return new int[] {left + 1, right + 1};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        // If no solution (shouldn't happen per problem statement)
        return new int[] {-1, -1};
    }
}
