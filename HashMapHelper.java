public class HashMapHelper {
    public static void helper(){

//        MapNode<Integer,String> a = new MapNode<>(1,"deepak");
//        MapNode<Integer,String> b = new MapNode<>(1,"deepak");
//        String a = "deepak";
//        String b = "Deepak";
//        Integer a = 78;
//        Integer b = 78;
//        System.out.println(a.hashCode());
//        System.out.println(b);

        HashMaps<Integer, Character> map = new HashMaps<>();

        for (int i = 0; i < 180; i ++){
            map.put(i+1,(char)(i));
        }

        map.print();

    }
}
