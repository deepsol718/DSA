public class MinHeap {
    private int[] arr = new int[10];
    private int size = 0;

    public void insert(int data){
        if (size == arr.length) changeSize();
        arr[size] = data;
        upheapify(size);
        size++;
    }

    public int extractMin(){
        if (size == 0){
            return -1;
        }
        int ans = arr[0];
        arr[0] = arr[size-1];
        arr[size-1] = 0;
        size--;
        heapify(0);
        return ans;
    }

    private void heapify(int index){
        int l = 2*index + 1;
        int small = index;
        if (l < size) small = (arr[index] > arr[l])? l : index;
        int r = l + 1;
        if (r < size) small = (arr[small] > arr[r])? r : small ;
        if (small == index) return;
        int temp = arr[index];
        arr[index] = arr[small];
        arr[small] = temp;
        heapify(small);
    }

    private void upheapify(int index){
        if (index == 0) return;
        int indexP = parent(index);
        if (arr[index] < arr[indexP]){
            int temp = arr[index];
            arr[index]  = arr[indexP];
            arr[indexP] = temp;
        }
        else return;
        upheapify(indexP);
    }


    private void changeSize(){
        int[] temp = arr;
        arr = new int[2*size];
        for (int i = 0; i < temp.length; i++ ){
            arr[i] = temp[i];
        }
    }

    private int parent(int index){
        if (index == 0) return 0;
        return (index-1)/2;
    }



    public void print(){
        int binaryPow = 2;
        int index = 1;
        System.out.println(arr[0]);
        while (index < size){
            int i = 0;
            while (i < binaryPow){
                System.out.print(arr[index]+" ");
                index ++;
                i++;
                if (index >= size) break;
            }
            System.out.println();
            binaryPow *= 2;
        }
    }
}
