public class PrintStringCodes {
    public static void printCodes(String s, String temp){
        if (s.length()==0){
            System.out.println(temp);
            return;
        }

        printCodes(s.substring(1),temp+(char)convert(s.substring(0,1)));

        if (s.length()>=2){
            int t = convert(s.substring(0,2));
            if (t != 0){
                printCodes(s.substring(2),temp+(char)(t));
            }
        }

    }

    public static int convert(String str){
        int t = Integer.parseInt(str);
        if (t > 0 && t < 27){
            return t + 96;
        }
        return 0;
    }
}
