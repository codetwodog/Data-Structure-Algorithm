package xin.twodog.DataStructureAndAlgorithm.offer;

import java.util.Stack;

public class Offer {
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

    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(2);
        System.out.println(cQueue.deleteHead());


    }

}
