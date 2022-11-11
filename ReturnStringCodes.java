public class ReturnStringCodes {
    public static String[] stringCodes(String s,String temp, String[] ans){
        if (s.length()==0){
            ans = array(ans);
            ans[ans.length-1] = temp;
            return ans;
        }

        ans = stringCodes(s.substring(1),temp + (char)convert(s.substring(0,1)),ans);

        if (s.length() >= 2){
            int t = convert(s.substring(0,2));
            if (t != 0){
                ans = stringCodes(s.substring(2),temp + (char)t, ans);
            }
        }

        return ans;

    }

    public static int convert (String str){
        int t = Integer.parseInt(str);
        if (t < 27 && t > 0){
            return t + 96;
        }
        return 0;
    }

    public static String[] array(String[] arr){
        String[] tempArr = new String[arr.length+1];
        for (int i = 0; i < arr.length; i ++){
            tempArr[i] = arr[i];
        }

        return tempArr;
    }

}
