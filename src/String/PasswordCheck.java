package String;

public class PasswordCheck {
    public static void main(String[] args) {
        String s = "subash@" ;

        int size = s.length();
        if(size < 8) {
            System.out.println("weak");
            return;
        }
        boolean alpha = false;
        for (int i = 0; i < 26; i++) {
            char ch = (char)('a' + i);
            if(s.indexOf(Character.toUpperCase(ch)) != -1 || s.indexOf(ch) != -1){
                alpha = true;
                break;
            }
        }
        boolean num = false;
        for (int i = 0 ; i < 9 ; i++){
            char ch = (char) ('0' + i);

            if(s.indexOf(ch) != -1){
                num = true;
                break;
            }
        }

        if(alpha && num){
            System.out.println("Strong");
        }else if(alpha || num){
            System.out.println("Good");
        }else{
            System.out.println("Weak");
        }

    }
}
