// LeetCode 347. Top K Frequent Elements
// https://leetcode.com/problems/top-k-frequent-elements/
// Time Complexity: O(n log k)
// Space Complexity: O(n)
//
// Approach:
// 1. Count frequencies using a HashMap.
// 2. Use a min-heap (PriorityQueue) to keep only the top k elements
//    with the highest frequency.
// 3. Extract the elements from the heap into an array result.

import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of each number
        Map<Integer, Integer> freq = new HashMap<>();
        for (int n : nums) {
            freq.put(n, freq.getOrDefault(n, 0) + 1);
        }

        // Step 2: Use a min-heap to store top k frequent elements
        PriorityQueue<Map.Entry<Integer, Integer>> heap =
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            heap.offer(entry);
            if (heap.size() > k) {
                heap.poll(); // remove least frequent
            }
        }

        // Step 3: Build result array from heap
        int[] res = new int[k];
        for (int i = k - 1; i >= 0; i--) {
            res[i] = heap.poll().getKey();
        }

        return res;
    }
}
