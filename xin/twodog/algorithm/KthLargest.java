package xin.twodog.algorithm;

import java.util.PriorityQueue;
import java.util.Queue;

public class KthLargest {
    // 给定一个数组，然后给定一个值k, 找出第K大的元素
    Queue<Integer> queue = new PriorityQueue<Integer>();
    boolean equalK = false;

    public KthLargest(int k, int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            queue.add(nums[i]);
        }
        if (nums.length < k) equalK = true;

        while (queue.size() > k) {
            queue.poll();
        }
    }

    //处理这个的时候需要思考,当我第一次add的数据进来刚好是K个，这时候我不能减，有两种情况，一种是大于K一种是刚好等于K
    public int add(int val) {
        queue.add(val);
        if (!equalK) {
            queue.poll();
        }
        equalK = false;
        return queue.peek();
    }
}
