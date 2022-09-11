package xin.twodog.DataStructureAndAlgorithm.offer;

import java.util.Stack;

public class StackProblem {
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.min();
     */

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());
    }

    static class CQueue {
        private Stack<Integer> ints1;
        private Stack<Integer> ints2;

        public CQueue() {
            ints1 = new Stack<>();
            ints2 = new Stack<>();
        }

        public void appendTail(int value) {
            ints1.push(value);
        }

        public int deleteHead() {
            if (ints1.empty()) {
                return -1;
            }
            while (!ints1.empty()) {
                ints2.push(ints1.pop());
            }
            Integer pop = ints2.pop();
            while (!ints2.empty()) {
                ints1.push(ints2.pop());
            }
            return pop;
        }
    }

    /**
     * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。
     * 什么样子的序列在减去一个值之后还可以获得最小值,O(1)复杂度获得最小值，这tm一定是一个map，一排序必定不是O(1)
     */
    static class MinStack {
        private Stack<Integer> integersStack1;
        private Stack<Integer> integersStack2;
        private Integer minInteger;

        /**
         * initialize your data structure here.
         */
        public MinStack() {
            integersStack1 = new Stack<>();
            integersStack2 = new Stack<>();
            minInteger = Integer.MIN_VALUE;
        }

        public void push(int x) {
            integersStack1.push(x);
            if (integersStack2.isEmpty() || integersStack2.peek() >= x)
            integersStack2.push(x);
        }

        public void pop() {
            if (integersStack2.isEmpty()){
                integersStack1.pop();
            }
            else if (integersStack1.pop().equals(integersStack2.peek())) {
                integersStack2.pop();
            }
        }

        public int top() {
            return integersStack1.peek();
        }

        public int min() {
            return integersStack2.peek();
        }
    }



}
