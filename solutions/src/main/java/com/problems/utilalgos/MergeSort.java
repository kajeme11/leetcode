package main.java.com.problems.utilalgos;

import java.util.Arrays;

public class MergeSort {

    public static void main(String[] args) {
        int[] a = {3, 1, 6, 8, 3, 7, 5, 7};
        sort(a, 0, a.length - 1);
        Arrays.stream(a).forEach(x -> System.out.print(x + ", "));
    }


    public static void sort(int[] a, int left, int right){
        if(left >= right){
            return;
        }
        int m = left + (right - left)/2;
        sort(a, left, m);
        sort(a, m + 1, right);
        merge(a, m, left, right);
    }

    public static void merge(int[] a,int m, int left, int right){

        int r = 0;
        int l = 0;
        int k = left;
        int[] leftArr = Arrays.copyOfRange(a, left, m + 1);
        int[] rightArr = Arrays.copyOfRange(a, m + 1, right + 1);

        while(r < rightArr.length && l < leftArr.length){
            if(rightArr[r] >= leftArr[l]){
                a[k++] = leftArr[l++];
            }else{
                a[k++] = rightArr[r++];
            }
        }
        while(r < rightArr.length){
            a[k++] = rightArr[r++];
        }
        while(l < leftArr.length){
            a[k++] = leftArr[l++];
        }
    }
}
