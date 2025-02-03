public class RemoveDuplicate {

    static char otherCase(char c){
        char other;
        if((c >= 97 && c <= 123)  || (c >= 65 && c <= 91)){
            other = c >= 97 && c <= 123 ? (char)(c - 32) : (char)(c + 32);
        }else{
            other = c;
        }
        return other;
    }
    public static void main(String[] args) {
        String s = "aBuzZ9900";
        StringBuilder res = new StringBuilder();
        for(int i = 0 ; i < s.length() ; i++){
            char c = s.charAt(i);
            char other = otherCase(c);
            if(res.indexOf(c + "") == -1 && res.indexOf(other + "") == -1){
                res.append(c);
            }else{
                while(res.indexOf(c + "") != -1 || res.indexOf(other + "") != -1){
                        if(c == '9'){
                            c = '0';
                        }else if(c == 'Z'){
                            c = 'A';
                        }else if(c == 'z'){
                            c = 'a';
                        }else{
                            c++;
                        }
                    other = otherCase(c);

                }
                res.append(c);
            }
        }

        System.out.println(res);

    }
}
