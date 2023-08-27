package org.example.algorithms.sort;

public class QuickSort {
    public static void main(String[] args) {
        int[] a = {8,7,6,5,4,9,3,2,1,0};
//        int partition = partition(a, 0, 9);
//        System.out.println(partition);
        sort(a, 0, 9);
        for (int i : a) {
            System.out.print(i+", ");
        }
    }

    public static void sort(int[] arr, int lo, int hi) {
        if (hi <= lo) return ;
        int j = partition(arr, lo, hi);
        sort(arr, lo, j-1);
        sort(arr, j+1, hi);

    }

    private static int partition(int[] arr, int lo, int hi) {
        int i = lo, j = hi + 1;
        int v = arr[lo];
        while (true) {
            // 扫描 左右,    左边的数据 小于 v , 右边的数 大于 v
            while (less(arr[++i], v)) if(i == hi) break;
            while (less(v, arr[--j])) if(j == lo) break;
            if (i >= j) break;
            exch(arr, i, j);
        }
        exch(arr, lo, j);
        return j;
    }

    private static boolean less(int a, int b) {
        return  a < b;
    }
    private static void exch(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
