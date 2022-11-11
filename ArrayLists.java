public class ArrayLists<T>{
    private T[] array ;
    private int index = 0;
    private int size = 0;

    public ArrayLists(int size){
        array = (T[])new Object[size];
        this.size = size;
    }

    public ArrayLists(){
        //array = null;
       // System.out.println("empty constructor is invoked");
    }

    public void add(T object){
        if (size == 0){
            array = (T[])new Object[10];
            size = array.length;
        }
        if (index + 2 >= size){
            doubleSize();
        }
        array[index] = object;
        index++;
    }

    public void add(int i, T object){
        if (i >= index){
            System.out.println("keep index below the size : "+index);
            return;
        }
        else {
            array[i] = object;
        }
    }

    public T get(int i){
        if (i >= index){
            System.out.println("index out of bound : "+index);
            //exception
        }
        return array[i];
    }

    public int size(){
        return index;
    }

    public void remove(int i){
        if (i >= index){
            System.out.println("index out of bound : "+index);
            return;
        }
        if (i < index - 1){
            //array[i] = array[i+1];
            for (int j = i; j < index-1; j++){
                array[j] = array[j+1];
            }
        }
        index--;
    }

    public void doubleSize(){
        T[] tempArr = (T[]) new Object[2*size];
        for (int i = 0; i < size; i++){
            tempArr[i] = array[i];
        }
        array = tempArr;
        size = array.length;
    }

    public boolean isEmpty(){
        return (index == 0);
    }

}
