// Problem: 283. Move Zeroes
// Link: https://leetcode.com/problems/move-zeroes/
// Time complexity: O(n)
// Space complexity: O(1)
// 
// Approach:
// Use two pointers — one iterates (i), and the other (lastNonZero) tracks the next
// position where a non-zero should go. This keeps relative order and works in-place.
//
// Follow-up optimization: minimize total writes by first shifting non-zero elements
// forward, then filling the rest with zeros.

#include <vector>
#include <algorithm>
using namespace std;

class Solution {
public:
    // Main solution (O(n)) — standard two-pointer approach
    void moveZeroes(vector<int>& nums) {
        int lastNonZero = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums[i] != 0) {
                if (i != lastNonZero)
                    swap(nums[i], nums[lastNonZero]);
                lastNonZero++;
            }
        }
    }

private:
    // Follow-up (O(n)) — minimize total operations
    // Instead of swapping, copy non-zero elements first and fill zeros after.
    void moveZeroesOptimized(vector<int>& nums) {
        int pos = 0;
        for (int num : nums)
            if (num != 0)
                nums[pos++] = num;
        while (pos < nums.size())
            nums[pos++] = 0;
    }
};
