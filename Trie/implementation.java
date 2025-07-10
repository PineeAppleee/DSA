package trie;

public class implementation {
    static class Node{
        Node []child;
        boolean eow;
        Node(){
            child = new Node[26];
            for(int i =0;i<26;i++){
                child[i] = null;}
            eow = false;}}




    public static void main(String[] args) {
        implementation h = new implementation();
     String[] word = {"a","app","apple","ap","banana","mango","appl"};
        String m = "apple";
       for(int i =0;i< word.length;i++){
          insert(word[i]);
       }
      h.cheackallpre(root,new StringBuilder(""));
        System.out.println(h.ans);

//        System.out.println(findword(key));
//
//        System.out.println(findprfix("manis"));
//        System.out.println(search("thor"));
//        System.out.println(search("their"));
//        System.out.println(search("pineapple"));

    }
    static Node root=new Node();
        public static void insert(String word){
            Node curr = root;
            for(int i =0;i<word.length();i++){
                int idx = word.charAt(i)-'a';

                if(curr.child[idx] == null){
                    curr.child[idx]= new Node();
                }
                if(i == word.length()-1){
                    curr.child[idx].eow = true;
                }
                curr  = curr.child[idx];
            }
        }
         String ans ="";
    public  void cheackallpre(Node root,StringBuilder temp){
        if(root==null){
            return;
        }
      for(int i =0;i<26;i++){
          if(root.child[i]!=null&&root.child[i].eow==true){
              temp.append((char)(i+'a'));
              if(temp.length()>ans.length()){
                  ans =temp.toString();
              }
              cheackallpre(root.child[i],temp);
              temp.deleteCharAt(temp.length()-1);
          }
      }
    }
    public static int allsubstring(Node key){
        if(root==null){
            return 0;
        }

        int count=0;
        for(int i =0;i<26;i++){
            if(root.child[i]!=null){
                count += allsubstring(root.child[i]);
            }
        }
        return count+1;
    }

        public static boolean findword(String key){
            if(key.length()==0){
                return true;
            }
            for(int i =1;i<=key.length();i++){
                String firstpart = key.substring(0,i);
                String secondpart = key.substring(i);
                if(search(firstpart)&&findword(secondpart)){
                    return true;
                }
            }
            return false;
        }
        public static boolean findprfix(String prefix){

            Node curr = root;
            for(int i =0;i<prefix.length();i++){
                int idx = prefix.charAt(i)-'a';
                if(curr.child[idx]==null){
                    return false;
                }
                curr = curr.child[idx];
            }
            return true;
        }
        public static boolean search(String word){
            Node curr = root;
            for(int i =0;i<word.length();i++){
                int idx = word.charAt(i)-'a';

                Node baby = curr.child[idx];
                if(baby == null){
                    return false;
                }
                if(i == word.length()-1&&baby.eow==false){
                    return false;
                }
                curr = baby;
            }
            return true;
        }
    }

