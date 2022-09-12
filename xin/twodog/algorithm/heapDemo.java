package xin.twodog.algorithm;

/**
 * 堆排序
 * 1.对一个数组两个值的交换
 * 2.堆调整函数
 * 3. 总函数
 */
public class heapDemo {
    public static void main(String[] args) {
        int a[] = {5, 6, 4, 7, 1};
        heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }

    public static void heapSort(int[] a) {
        for (int i = a.length / 2 - 1; i >= 0; i--) {
            heapAdjust(a, i, a.length);
        }
        for (int i = a.length - 1; i >= 0; i--) {
            swap(a, 0, i);
            heapAdjust(a, 0, i);
        }
    }

    public static void heapAdjust(int[] a, int i, int length) {
        int temp = a[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            if (k + 1 < length && a[k] < a[k + 1]) {
                k++;
            }
            if (a[k] > temp) {
                swap(a, i, k);
                i = k;
            } else {
                break;
            }
        }
    }

    public static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
