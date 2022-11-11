import java.util.ArrayList;

public class MaxHeap {
    ArrayList<Integer> heap = new ArrayList<>();

    boolean isEmpty() {
        // Implement the isEmpty() function here
        return (heap.size() == 0);
    }

    int getSize() {
        // Implement the getSize() function here
        return heap.size();
    }

    int getMax() {
        // Implement the getMax() function here
        int ans = Integer.MIN_VALUE;
        if(!isEmpty()) ans = heap.get(0);
        return ans;

    }

    void insert(int element) {
        heap.add(element);
        upheapify(heap.size()-1);
    }

    private void upheapify(int index){
        if (index == 0) return;
        int pI = parentIndex(index);
        if (heap.get(pI) < heap.get(index)){
            int temp = heap.get(index);
            heap.set(index, heap.get(pI));
            heap.set(pI,temp);
        }
        else return;
        upheapify(pI);
    }

    private int parentIndex(int index){
        if ((index -1)/2 >= 0) index = (index - 1)/2;
        return index;
    }

    int removeMax() {
        // Implement the removeMax() function here
        int ans = Integer.MIN_VALUE;
        if (getSize() > 0){
            ans = heap.get(0);
            heap.set(0,heap.get(getSize()-1));
            heap.remove(getSize()-1);
            heapify(0);
        }

        return ans;

    }

    private void heapify(int index){
        int l = index*2 + 1;
        int big = index;
        if (l < getSize()) big = (heap.get(index) > heap.get(l))? index : l;
        int r = l + 1;
        if (r < getSize()) big = (heap.get(big) > heap.get(r))? big : r;
        if (index == big) return;
        int temp = heap.get(index);
        heap.set(index, heap.get(big));
        heap.set(big,temp);
        heapify(big);
    }

    public void print(){
        int binaryPow = 2;
        int index = 1;
        System.out.println(heap.get(0));
        while (index < getSize()){
            int i = 0;
            while (i < binaryPow){
                System.out.print(heap.get(index)+" ");
                index ++;
                i++;
                if (index >= getSize()) break;
            }
            System.out.println();
            binaryPow *= 2;
        }
    }
}
