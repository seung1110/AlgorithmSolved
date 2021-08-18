package programmers;

public class No60058 {

	public static void main(String[] args) {
    	String p = "()))((()";
    	String answer = null;
    	
    	answer = rec(p);
    	
    	
    	
    	System.out.println(answer);
    	System.out.println(answer.equals("()(())()"));
    }
    public static String rec(String str){
    	System.out.println(str);
        if(str.length() == 0){
            return "";
        }
        String u,v;
        
        u = str.substring(0,balance_int(str)+1);
        v = str.substring(u.length());
        
        if(correct_check(u)){
            v = rec(v);
            return u + v;
        }else{
            if(u.length() == 2 && v.length() == 0){
                return "()";
            }
            String temp = "(";
            temp += rec(v);
            temp += ")";
            for(int i = 1;i < u.length()-1; i++){
                if(u.charAt(i) == '('){
                    temp += ")";
                }else{
                    temp += "(";
                }
            }
            return temp;            
        }
    }
    
    public static boolean correct_check(String str){
        int l,r;
        l = r = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(')
                l++;
            else
                r++;
            if(r > l){
                return false;
            }
        }
        return true;
    }
    
       public static boolean balance_check(String str){
        int l,r;
        l = r = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(')
                l++;
            else
                r++;
        }
        return l== r;
    }
    
    public static int correct_int(String str){
        int l,r;
        l = r = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(')
                l++;
            else
                r++;
            if(r > l){
                if(i==0)
                    return 0;
                else
                    return i-1;
            }
        }
        return 0;
    }
    
    public static int balance_int(String str){
        int l,r;
        l = r = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '(')
                l++;
            else
                r++;
            if(l == r){
                return i;
            }
        }
        return 0;
    }

}
