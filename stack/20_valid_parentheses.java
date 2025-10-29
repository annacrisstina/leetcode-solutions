// LeetCode 20. Valid Parentheses
// https://leetcode.com/problems/valid-parentheses/  
// Time Complexity: O(n)
// Space Complexity: O(n)
//
// Approach:
// Use a stack to track opening brackets. When a closing bracket shows up,
// check if the stack top matches the corresponding opening bracket. At the end,
// valid only if the stack is empty.

import java.util.*;

class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();

        for (char c : s.toCharArray()) {
            if (!map.containsKey(c)) {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
