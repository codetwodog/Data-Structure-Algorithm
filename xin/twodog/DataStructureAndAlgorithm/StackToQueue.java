package xin.twodog.DataStructureAndAlgorithm;

import java.util.Stack;

/**
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 * 思路：
 * 1.队列先进先出
 * 2.每次pop前都要把stack1的值全部搞到stack2，然后输出
 */
public class StackToQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        int poptemp = -1;
        if (stack1.size() > 0) {
            while (stack1.size() > 0) {
                int a = stack1.pop();
                stack2.push(a);
            }
            poptemp = stack2.pop();
            while (stack2.size() > 0) {
                int a = stack2.pop();
                stack1.push(a);
            }
        }
        return poptemp;
    }

    /**
     * 测试
     * @param args
     */
    public static void main(String[] args) {
        StackToQueue stackToQueue = new StackToQueue();
        stackToQueue.push(1);
        stackToQueue.push(2);
        stackToQueue.push(3);
     /*   while (stackToQueue != null){
            System.out.println(stackToQueue.pop());
        }*/
        System.out.println(stackToQueue.pop());
        System.out.println(stackToQueue.pop());

    }
}
