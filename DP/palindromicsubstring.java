package dp;

public class palindromicsubstring {
    static String temp ="";
    public static void main(String[] args) {
        String str1 = "abb";
        String str2 ="";
        for(int i =str1.length()-1;i >= 0;i--){
            str2 += str1.charAt(i);
        }
        rec(str1,str2,str1.length()-1,str2.length()-1);

    }

    public static  void rec(String str1,String str2,int m, int n){
        if(m<0||n<0){
            System.out.println(temp);
            return ;}
        if(str1.charAt(m)== str2.charAt(n)) {
            temp+=str1.charAt(n);
        rec(str1,str2,m-1,n-1);
        return;
        }
        if(str1.charAt(m)>=str2.charAt(n))
           rec(str1,str2,m-1,n);
       else
            rec(str1,str2,m,n-1);
       // return ;
    }
}
