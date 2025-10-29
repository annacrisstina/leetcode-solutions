class Solution {
     public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int ans = 0;
        int[] lastIndex = new int[128];
        Arrays.fill(lastIndex, -1);

        int start = 0;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            start = Math.max(start, lastIndex[c] + 1);
            ans = Math.max(ans, i - start + 1);
            lastIndex[c] = i;
        }

        return ans;
}
}
