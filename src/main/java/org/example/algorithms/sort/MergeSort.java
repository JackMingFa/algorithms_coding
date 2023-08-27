package org.example.algorithms.sort;


/**
 * 归并排序：  采用的就是 分治的思想， 递归的将一个数组一分为二。 将 分离后的两个数组分别排序。最后合并。
 */
public class MergeSort {
     private static int[] temp;
    public static void main(String[] args) {
        int[] a = {9,8,7,6,5,4,3,2,1,0};
        temp = new int[a.length];
        //sort(a, 0, a.length - 1);
        sort(a);
        for (int i : a) {
            System.out.print(i + ",");
        }

    }

    // 自底向上的归并排序
    public static void sort(int[] arr){
        int n = arr.length;
        // sz 从 1 开始、 1,2,4,8,16,32,64,128,
        // 也是运用的是分治的思想
        for (int sz = 1; sz < n; sz = sz + sz) {
            for (int lo = 0; lo < n - sz; lo += sz + sz) {  // lo < n -sz --->  假设 sz 为整个数组的 1/2.  即最后一次排序。 执行到此 结束
                merge(arr, lo, lo+sz -1, Math.min(lo+sz+sz-1, n -1));
            }
        }
    }


    // 自定向下的归并排序
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
            temp[k] = arr[k];  // 需要一个 辅助 数组
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
