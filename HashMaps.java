import java.util.ArrayList;

public class HashMaps <K,V>{
    ArrayList<MapNode<K,V>> bucket = new ArrayList<>();
    int bucketSize = 20;
    int size = 0;
    float loadFactor;

    public HashMaps(){
        for (int i = 0; i < bucketSize; i++){
            bucket.add(null);
        }
    }

    public void put(K key, V value){
        MapNode<K,V> node = new MapNode<>(key,value);
        int index = hashing(key);
//        System.out.println(index);
        MapNode<K,V> head = bucket.get(index);
        while (head != null){
            if (head.key.equals(key)){
                head.value = value;
                return;
            }
            head = head.next;
        }
        size++;
        head = bucket.get(index);
        bucket.set(index,node);
        node.next = head;
        loadFactor = (float) size/bucketSize;
        if (loadFactor > 0.75){
            rehashing();
        }
    }

    public boolean containsKey(K key){
        int index = hashing(key);
        MapNode<K,V> head = bucket.get(index);
        while (head != null){
            if (head.key == key) return true;
            head = head.next;
        }

        return false;
    }

    public void remove(K key){
        int index = hashing(key);
        MapNode<K,V> head = bucket.get(index);
        MapNode<K,V> tail = null;
        while (head!=null){
            if (head.key.equals(key)){
                if (tail == null){
                    bucket.set(index,head.next);
                }
                else{
                    tail.next = head.next;
                }
                size--;
                tail = head;
                head = head.next;
            }
        }
    }

    private int hashing(K key){
        int hashCode = key.hashCode();
//        System.out.println("key: "+key+ " hashCode: "+hashCode);
        if (hashCode < 0) hashCode *= -1;
        return (hashCode%bucketSize);
    }

    private void rehashing(){
        System.out.println("Rehashing"+" Size: "+size);
        ArrayList<MapNode<K,V>> temp = bucket;
        bucketSize *= 2;

        bucket = new ArrayList<>();

        for (int i = 0; i < bucketSize; i++){
            bucket.add(null);
        }
        for (int i = 0; i < temp.size(); i++){
            MapNode<K,V> head = temp.get(i);
            while (head !=null ){
                put(head.key,head.value);
                head = head.next;
            }
        }
    }

    public void print(){
        System.out.print("HashMap: {");
        for (int i = 0; i < bucketSize; i++){
            MapNode<K,V> head = bucket.get(i);
            while (head != null){
                System.out.print("("+head.key+","+head.value+")");
                head = head.next;
            }
        }
        System.out.print("}");
    }

}
