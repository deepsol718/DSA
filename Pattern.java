public class Pattern {

    Pattern(){
        int n = 40;
        String[] arr = new String[n];

        for (int i = 0; i < n; i++){
            arr[i] = palindrome(i+1);
        }

        int len = arr[n-1].length();

        for (int i = 0; i < n; i++){
            int space = (len - arr[i].length())/2 ;
            while(space > 0){
                System.out.print(" ");
                space--;
            }
            System.out.print(arr[i]);
            System.out.println();
        }
    }

    String palindrome(int n){
        if (n == 1) return "1";
        String s = ""+n+""+n;
        int count = n+1;

        for (int i = 1; i < n-1; i++){
            int len = s.length();
            s = s.substring(0,len/2) + count + "" + count + s.substring(len/2);
            count++;
        }
        int len = s.length();
        s = s.substring(0,len/2) + count + s.substring(len/2);

//        System.out.println(s);

        return s;
    }
}
