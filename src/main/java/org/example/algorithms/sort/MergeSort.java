package org.example.algorithms.sort;


/**
 * 归并排序：  采用的就是 分治的思想， 递归的将一个数组一分为二。 将 分离后的两个数组分别排序。最后合并。
 */
public class MergeSort {
     private static int[] temp;
    public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2,1,0};
        temp = new int[a.length];
        sort(a, 0, a.length - 1);
        for (int i : a) {
            System.out.print(i + ",");
        }

    }
    private static void sort(int[] arr, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo)/2;
        sort(arr, lo, mid);
        sort(arr, mid+1, hi);
        merge(arr, lo, mid, hi);
    }

    // 原地归并排序
    private static void merge(int[] arr,int lo,int mid, int hi) {
        //
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            temp[k] = arr[k];
        }
        // 在这里进行排序的时候 最多只有 两个元素 或者 一个
        for (int k = lo ; k <= hi; k ++ ) {
            if (i > mid) arr[k] = temp[j++];  // 左边用尽 取右边
            else if (j > hi) arr[k] = temp[i++];  // 右边用尽  取左边
            else if (temp[j] < temp[i]) arr[k] = temp[j++]; // 右边 比 左边 小, 取右边
            else arr[k] = temp[i++];  // 右边 大于等于 左边, 取左边
        }
    }
}
