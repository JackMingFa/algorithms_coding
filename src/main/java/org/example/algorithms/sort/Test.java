package org.example.algorithms.sort;


import java.util.Random;

/**
 * 希尔排序和 插入排序的比较
 *
 * 随机生成 5 个10万数量的整型数组
 *
 * 结论;   希尔排序的效率 要远远高于  插入排序
 *
 * 比较次数
 * 交换次数
 *
 */
public class Test {
    private long compN = 0;
    private long exchN = 0;

    public static void main(String[] args) {

        // 创建一个 随机数组  100000
        Random random = new Random();
        int[] array = random.ints(100000).toArray();

        int[] insert = array.clone();
        int[] shell = array.clone();

        Test test = new Test();
        test.insertSort(insert);
        // test.shellSort(array);
        System.out.println("比较次数： " + test.compN);
        System.out.println("交换次数： " + test.exchN);

        test.compN = 0;
        test.exchN = 0;
        test.shellSort(shell);
        // test.shellSort(array);
        System.out.println("比较次数： " + test.compN);
        System.out.println("交换次数： " + test.exchN);



    }

    private int[] insertSort(int[] arrays) {
        int n = arrays.length;
        for (int i = 1; i < n; i++) {
            // 升序
            // 注意; 这里的逻辑是， 当后一个数 小于前一个数时， 交换他们的位置。
            for (int j = i; j > 0 && less(arrays[j] , arrays[j - 1]) ; j--) {
                exch(arrays, j , j - 1 );
            }
        }
        return arrays;
    }

    private int[] shellSort(int[] arr) {
        int N = arr.length;
        // 确定 排序的递增 序列
        int h = 1;
        while (h < N/3) h = 3 * h + 1; // 递增序列 --> 1,4,13,40,121,364,1093
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
        compN ++;
        return a < b;
    }
    private void exch(int[] arr, int i, int j) {
        exchN ++;
        int i1 = arr[i];
        arr[i] = arr[j];
        arr[j] = i1;
    }
}
