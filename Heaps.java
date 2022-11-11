import java.util.Scanner;
import java.util.PriorityQueue;

public class Heaps {
    public static void helper(){
//        minHeap();
        inbuilt();
    }


    public static void minHeap(){
        int[] arr = {1,2,34,5,43,89,78,302,405,67,4,6,7,8};
        int[] brr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};

//        MinHeap heap = new MinHeap();
//
//        for (int x : arr){
//            heap.insert(x);
//        }
//
////        heap.print();
////        System.out.println("min heap: "+heap.extractMin());
////        heap.print();
//        int min = heap.extractMin();
//
//        while (min != -1){
//            System.out.print(min + " ");
//            min = heap.extractMin();
//        }

        MaxHeap mheap = new MaxHeap();

        for (int x : arr){
            mheap.insert(x);
        }

        mheap.print();
        System.out.println("Descending order: ");

        int max = mheap.removeMax();

        while (max != Integer.MIN_VALUE) {
            System.out.print(max + " ");
            max = mheap.removeMax();
        }
    }

    public static void inbuilt(){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] arr = {1,2,34,5,43,89,78,302,405,67,4,6,7,8};
        for (int i = 0; i < arr.length; i++){
            pq.add(arr[i]);
        }

        while (!pq.isEmpty()){
            System.out.print(pq.element()+" ");
            pq.remove();
        }
    }
}
