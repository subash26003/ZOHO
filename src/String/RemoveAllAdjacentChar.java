package String;

public class RemoveAllAdjacentChar {
    public static void main(String[] args) {
        String s = "aaabbccdeefaaabccc";
        int n = s.length();
        int i = 0 , j = 1;
        int count = 0;
        StringBuilder res = new StringBuilder();
        while(i < n ){

            while(i+1 < n && s.charAt(i) == s.charAt(i+1)) count++;

            if(count <= 1 ){
                res.append(s.charAt(i));
                i++;
            }else{
                i+= count;
            }
            count = 0;
        }

    }
}
