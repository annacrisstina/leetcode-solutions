// Problem: 11. Container With Most Water
// Link: https://leetcode.com/problems/container-with-most-water/
// Time complexity: O(n)
// Space complexity: O(1)
//
// Approach:
// Use two pointers (left, right) to form the widest container initially.
// Compute the area = min(height[left], height[right]) * (right - left).
// Move the pointer at the shorter line inward, since that might increase the minimum height
// and potentially lead to a larger area.

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;

        while (left < right) {
            int h = Math.min(height[left], height[right]);
            int width = right - left;
            int area = h * width;
            
            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
