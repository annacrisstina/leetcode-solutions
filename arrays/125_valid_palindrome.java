// LeetCode 125. Valid Palindrome
// https://leetcode.com/problems/valid-palindrome/
// Time Complexity: O(n)
// Space Complexity: O(1)
//
// Approach:
// Use two pointers (left and right) to check characters from both ends.
// Ignore non-alphanumeric characters using Character.isLetterOrDigit().
// Compare lowercase versions of characters. If all match, it's a palindrome.

class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) return false;

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            // Skip non-alphanumeric chars from the left
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            // Skip non-alphanumeric chars from the right
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            // Compare ignoring case
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
