// Problem: Two Sum
// Link: https://leetcode.com/problems/two-sum/
// Time complexity: O(n)
// Space complexity: O(n)
// Idea: Use a hash map to check if the complement (target - num) exists.

#include <unordered_map>
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        // Time complexity: O(n^2)
        /*for (int i = 0; i < nums.size(); i++) {
            for (int j = i+1; j < nums.size(); j++) {
                if (nums[i] + nums[j] == target) {
                    return {i, j};
                }
            }
        }*/

        // Time complexity: O(n)
        unordered_map<int, int> mp;
        for (int i = 0; i < nums.size(); i++) {
            int rest = target - nums[i];
            if (mp.find(rest) != mp.end()) {
                return {mp[rest], i};
            }
            mp[nums[i]] = i;
        }
        return {};
    }
};
