package org.example.algorithms.sort;


/**
 * #####  插入排序
 * 思想： 将一个数插入到已经有序的队列的合适位置，同时为了给药插入元素腾出位置，我们需要将其余所有元素在插入之前都右移一位。
 * 时间,空间复杂度：最坏情况下 需要进行 N²/2 次比较 --- N²/2 次交换。 最好情况下进行 N-1 次比较 和 0 次交换.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] a = {9,8,6,5,4,3,2,1,0};
        int[] b = {1,2,3,4,5,6,7,8,9};
        int[] sort = new InsertionSort().sort(a);
        for (int i : sort) {
            System.out.print(i + ",");
        }
    }
    // 最好情况下， 比较N - 1 次。
    private int[] sortGood(int[] arrays) {
        int n = arrays.length;
        // 升序
        // 注意; 这里的逻辑是， 当后一个数 小于前一个数时， 交换他们的位置。
        for (int j = n; j > 0 && less(arrays[j] , arrays[j - 1]) ; j--) {
            exch(arrays, j , j - 1 );
        }
        return arrays;
    }
    // 最坏情况下
    private int[] sort(int[] arrays) {
        int n = arrays.length;
        for (int i = 1; i < n; i++) {
            // 升序
            // 注意; 这里的逻辑是， 当后一个数 小于前一个数时， 交换他们的位置。
            for (int j = i; j > 0 && less(arrays[j] , arrays[j - 1]) ; j--) {
                exch(arrays, j , j - 1 );
            }
            System.out.println();
        }
        return arrays;
    }
    private boolean less(int a, int b) {
        System.out.print("*");
        return a < b;
    }
    private void exch(int[] a, int i, int j) {
        int i1 = a[i];
        a[i] = a[j];
        a[j] = i1;
    }
}
