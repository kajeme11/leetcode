package main.java.com.problems.heaps;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInAnArray215 {

    public static void main(String[] args) {

//        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    }


    /*
    We want to create a minHeap that will store up to k elements
    once the minHeap size is more than k, we pop off an element
    that element will be the minimum at that current time, if we keep doing
    this at the end of looping the array, we will have the k largest elements
    in the minHeap, with the kth largest element at the front of the minHeap


        1.create a minHeap using PriorityQueue, that is meant to be as big as k
        2.loop over nums array and add nums[i] into heap,
        3.if heap > k, then poll an element
        4.return the first element in minHeap

        Time Complexity O(nlogk), for traversing n elements, and adding to minheap logk
        Space Complexity O(k), for k elements stored in minHeap
    */
    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(int num: nums){
            minHeap.add(num);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        return minHeap.poll();
    }
}
