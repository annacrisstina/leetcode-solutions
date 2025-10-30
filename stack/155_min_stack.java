// LeetCode 155. Min Stack
// https://leetcode.com/problems/min-stack/
// Time Complexity: O(1) per operation
// Space Complexity: O(n)
//
// Approach:
// Use two stacks: one to store values and one to store the minimum so far.
// Every push adds both the value and the current min (to keep them in sync).
// getMin() simply returns the top of the minStack.


class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        stack = new ArrayDeque<>();
        minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        } else {
            minStack.push(minStack.peek());
        }
    }
    
    public void pop() {
        if (!stack.isEmpty()) {
            stack.pop();
            minStack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
