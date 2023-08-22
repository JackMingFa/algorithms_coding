package org.example.algorithms.sort;


/**
 * 希尔排序:
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] a = {9,8,6,5,4,3,2,1,0};
        int[] b = {1,2,3,4,5,6,7,8,9};
        int[] sort = new ShellSort().sort(a);
        for (int i : sort) {
            System.out.print(i + ",");
        }
    }

    private int[] sort(int[] arr) {
        int N = arr.length;
        // 确定 排序的递增 序列
        int h = 1;
        while (h < N/3) h = 3*h + 1; // 递增序列 --> 1,4,13,40,121,364,1093
        while (h >= 1) {
            System.out.println("h: " +h);
            //将数组变为h 有序
            for (int i = h; i < N; i++) {
                // 将a[i] 插入到a[i-h], a[i-2h],a[i-3h] ..... 中
                for (int j = i; j >= h && less(arr[j], arr[j-h]) ; j -= h) {
                    exch(arr, j, j-h);
                }
            }
            h = h/3;
        }
        return arr;
    }
    private boolean less(int a, int b) {
        return a < b;
    }
    private void exch(int[] arr, int i, int j) {
        int i1 = arr[i];
        arr[i] = arr[j];
        arr[j] = i1;
    }
}
