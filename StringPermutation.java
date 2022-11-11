public class StringPermutation {

    public static String[] permutation(String s,String temp, String[] arr){

        if (s.length()==0){
            arr = array(arr);
            arr[arr.length-1] = temp;
            return arr;
        }

        for (int i = 0; i < s.length(); i++){
            arr = permutation(s.substring(0,i)+s.substring(i+1),temp+s.charAt(i),arr);
        }

        return arr;
    }

    public static String[] array (String[] s){
        String[] tempS = new String[s.length+1];

        for (int i = 0; i < s.length; i++){
            tempS[i] = s[i];
        }

        return tempS;
    }
}
