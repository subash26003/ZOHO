package String;

public class AllAlpha {
    public static void main(String[] args) {
        String a = "abc defGhi JklmnOP QRStuvw xyz";
        int[] arr = new int[26];

        for(int i = 0 ; i < a.length() ; i++){
            char ch  = Character.toLowerCase(a.charAt(i));
            if(ch < 97 || ch > 122) continue;
            arr[ch - 'a'] = 1;
        }
        boolean pan = true;
        for(int i : arr){
            if(i < 1){
                pan = false;
                break;
            }
        }

        System.out.println(pan ? "yes" : "no");
    }
}
