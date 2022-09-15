package xin.twodog.algorithm.offer;

public class SearchingAlgorithm {
    /**
     * ### 解题思路
     * 1. 往右🫱递增 ，往下⬇️递增
     * 2. 从左下角开始判断是最快的，为啥呢？
     * 3. 往下没有了，只能往右或者往上，比目标小就往右🫱，反之向上，向上之后，又是一个新的左下角。
     * @param matrix
     * @param target
     * @return
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int i = matrix.length - 1;
        int j = 0;
        while (i >= 0 && j < matrix[0].length) {
            if (matrix[i][j] > target) i--;
            else if (matrix[i][j] < target) j++;
            else return true;
        }
        return false;
    }
}
