package xin.twodog.algorithm.offer;

import java.util.HashMap;
import java.util.Map;

public class ArrayProblem {
    public static void main(String[] args) throws Exception {
        ArrayProblem arrayProblem = new ArrayProblem();
        int[] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        int[] nums2 = new int[]{0};
        int repeatNumber = arrayProblem.findRepeatNumber(nums);
        System.out.println(repeatNumber);
        System.out.println(arrayProblem.missingNumber(nums2));

    }

    public int findRepeatNumber(int[] nums) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > 1)
                return nums[i];
        }
        throw new Exception("数组里没有重复的值！");
    }

    /**
     * Map省事，但是忽略了有序，增加了时间复杂度，不如在值变化的阶段终止统计，就有效利用了有序这一个条件：
     * 比如 有 1，2，3，4，4， ... 10 w 个数字 ...
     *
     * @param nums
     * @param target
     * @return
     */
    public int searchCountInOrderArray(int[] nums, int target) {
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                flag = true;
                count++;
            } else if (nums[i] != target) {
                flag = false;
            } else if (i > 1 && nums[i - 1] == target && flag == false) {
                break;
            }
        }
        return count;
    }

    /**
     * 一开始没有想到所有的情况，有点面向bug编程
     * BDD: 如果没有TDD那可能就BDD
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        if (nums.length == 1) return nums[0] == 1 ? 0 : 1;
        int i;
        for (i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] != 1) {
                return nums[i] - 1;
            }
        }
        if (nums[0] != 0)
            return nums[i - 1] + 1;
        else return 0;

    }
}
