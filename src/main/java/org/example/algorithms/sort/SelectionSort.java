package org.example.algorithms.sort;



/**
 * 选择排序：
 *  思想： 首先在数组中找到最小的元素，将它和数组的第一个元素交换位置(如果最小元素就在第一个位置，则它就和自己交换位置)，
 *        其次，找到第二小的元素，然后和数组的第二个位置进行交换。以此类推，知道最后一个元素。
 *  时间复杂度：第一次比较 N-1 次，第二次比价 N-2 ...... 2 , 1 ----->  (N-1) + (N -2) + .....+ 2 + 1 =  (N-1) ((N-1) +1) / 2  ~ N²/2。O(N²)
 *  空间复杂度：选择排序一共需要交换 N 次。  O(N)
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] ints = {8, 5, 1, 9, 5, 0, 8};
        SelectionSort selectionSort = new SelectionSort();
        int[] sort = selectionSort.sort(ints);
        for (int i : sort) {
            System.out.print(i + ",");
        }
    }
    private int[] sort(int[] order) {
        for (int i = 0; i < order.length; i++) {
            int min = i;
            for (int j = i + 1; j < order.length ; j++) {
                System.out.print(min + ",");
                if (less(order[min], order[j])) min = j;// 注意这个 比较的地方。
            }
            System.out.println();
            exch(order, i, min);
        }
        return order;
    }


    public boolean less(int a, int b) {
        return a > b;
    }
    private void exch(int[] a, int currentPosition, int min) {
        int temp = a[currentPosition];
        a[currentPosition] = a[min];
        a[min] = temp;
    }
}
