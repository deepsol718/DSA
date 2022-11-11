public class printStringPermutation {

    public static void printPermutation(String s, String tempAns){

        if (s.length()==0){
            System.out.println(tempAns);
            return;
        }

        for (int i = 0; i < s.length(); i++){
            printPermutation(s.substring(0,i)+s.substring(i+1), tempAns+s.charAt(i));
        }

    }
}
