// LeetCode 217. Contains Duplicate
// https://leetcode.com/problems/contains-duplicate/
// Time Complexity: O(n)
// Space Complexity: O(n)
//
// Approach:
// Use a HashSet to keep track of numbers we've seen so far.
// If a number appears again, return true. Otherwise, after scanning all numbers, return false.

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}
