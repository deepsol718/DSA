public class Queue <T>{
    Node<T> head;
    Node<T> tail;
    int size = 0;

    Queue (T data){
        head = new Node<>(data);
        tail = head;
        size++;
    }

    Queue (){
        //do nothing;
    }

    public void enqueue(T data){
        Node<T> temp = new Node<>(data);
        if (size == 0){
            head = temp;
            tail = head;
        }
        else{
            tail.next = temp;
            tail = tail.next;
        }
        size++;
    }

    public T dequeue(){
        if (size == 0){
            //write exception here;
        }
        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    public T front(){
        if (size == 0){
            return null;
        }
        return head.data;
    }

    public boolean isEmpty(){
        return (size == 0);
    }
}
