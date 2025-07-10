package stack;

import java.util.ArrayList;
import java.util.Stack;

public class solve {
    public static void main(String[] args) {
        String str = postfix("+1+(8-(3+4-3))");
        System.out.println(perform(str));
    }
    public static int perform(String s){
        Stack<Integer> st = new Stack<>();
        int sum =0;
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(i==s.length()-1&&(ch=='-')){
                sum=sum*-1;
                break;
            } else if (i==s.length()-1&&(ch=='+')) {
                break;
            }
            else if(ch=='+'){
                int a = st.pop();
                int b = st.pop();
                sum =  (b+a);
                st.push(sum);
            }
            else if(ch=='-'){
                int a = st.pop();
                int b = st.pop();
                sum =  (b-a);
                st.push(sum);
            }
            else {
                st.push(ch-'0');
            }
        }
        return sum;
    }
    public static String postfix(String s){
        Stack<Character> st = new Stack<>();
        StringBuilder str = new StringBuilder();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch>=48&&ch<=57){
                continue;
            }else{
                if(ch==')'){
                    while(st.peek()!='('){
                        str.append(st.peek());
                        st.pop();
                    }st.pop();
                }else{
                    st.push(ch);
                }}
        }
        while(!st.isEmpty()){
            str.append(st.peek());
            st.pop();
        }

        return str.toString();

    }
    public static ArrayList<Integer> findin(String s){
        ArrayList<Integer> list = new ArrayList<>();
        for(int i =0;i<s.length();i++){
            char ch = s.charAt(i);
            int sum = 0;
            if(ch>=48&&ch<=57){
                while(ch!='+'||ch!='-'){
                    sum = sum+(ch-'0');
                    sum=sum*10;
                }
            }
            list.add(sum);
            sum =0;
        }
        return list;
    }
}
