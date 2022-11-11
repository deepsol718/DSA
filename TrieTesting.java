import java.util.Scanner;

public class TrieTesting {
    public static void runner(){
//        Scanner scan = new Scanner(System.in);
        TriesClass tries = new TriesClass();

        String[] strArr = new String[]{"anil","deepak","pushpu","prabal","nikhil","lalit","ani"};


        for (int i = 0; i < strArr.length; i++){
            tries.add(strArr[i]);
//            System.out.println();
        }

        tries.print();
        String s = "an";

        System.out.println("contains "+s+": "+ tries.search(s));


    }
}
