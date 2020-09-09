package sort;

import sort.insertion.InsertionSort;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] a = {4, 8, 7, 6, 4 ,1 ,2};
        InsertionSort.sort(a);
        System.out.println(Arrays.toString(a));
    }
}
