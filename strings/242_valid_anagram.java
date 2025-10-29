// LeetCode 242. Valid Anagram
// https://leetcode.com/problems/valid-anagram/
// Time Complexity: O(n log n)
// Space Complexity: O(1)  (în afară de array-urile sortate)

import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] arr1 = s.toCharArray();
        char[] arr2 = t.toCharArray();

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }
}
