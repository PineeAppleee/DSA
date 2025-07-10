package tree;

import java.util.*;
class treeinfo{
    int diam;
    int height;
    treeinfo(int diam,int height){
        this.diam =  diam;
        this.height = height;
    }
}

public class buildingtree {
    static Scanner sc = null;
    public static void main(String[] args) {
        binarytree t = new binarytree();
        int nodes[]={1,2,3,-1,-1,4,-1,-1,5,-1,-1};
        Node root = t.oftree(nodes);
      //  oleveltraversel(root);
      //  System.out.println(diam(root).diam);
      Node n1 = new Node(3);
      Node n2 = new Node(5);
        Node n3 = lca(root,n1,n2);
        System.out.println(n3.data);
       // System.out.println(finddiameter(root));
//        sunm_of_node(root,2);
//        olevel(root,2);
//        System.out.println(diam(root).diam);
//        System.out.println(root.data);
//        System.out.println(height(root));
//        System.out.println(finddiameter(root));
//       newpre(root);
       //sc = new Scanner(System.in);
       //Node root = createTree();
//       preorder(root);
//        System.out.println();

//        System.out.println();
        //leftviewprint(root);
    }
//    code to convert a tree into a doublyLinkedList....
    public static Node converttolinked(Node root){
        if(root==null){
            return null;
        }
        Node prev = null;
        Node head = converttolinked(root.left);
        if(prev == null){
            head = root;
        }else{
            root.left=prev;
            prev.Right=root;
        }
        prev = root;
        converttolinked(root.Right);
        return head;
    }
    static treeinfo diam(Node root){
        if (root==null){
            return new treeinfo(0,0);
        }
        treeinfo left = diam(root.left);
        treeinfo right= diam(root.Right);
        int height = Math.max(left.height,right.height)+1;
        int diam1 = left.diam;
        int diam2 = right.diam;
        int diam3 = diam1+diam2+1;
        int newdia = Math.max(diam1,Math.max(diam2,diam3));
        return new treeinfo(newdia,height);

    }
    static void newpre(Node root){
        if(root==null){
            return;
        }
        System.out.print(root.data+" ");
        newpre(root.left);


        newpre(root.Right);

    }
    static int height(Node root){
        if(root == null){
            return 0;
        }
        int left = height(root.left);
        int right = height(root.Right);
        return Math.max(left,right)+1;
    }
    static int hash(Node root){
        HashMap<Node,Integer> h = new HashMap<>();
        if(root==null){
            return 0;
        }

       int left= hash(root.left);
       int right= hash(root.left.Right);
        return h.put(root,h.getOrDefault(root,Math.max(left,right)));

    }
    public static boolean findpath(Node root,ArrayList<Node> l,int n){
        if(root==null){
            return false;
        }
        l.add(root);
        if(root.data==n){
            return true;
        }
        if(findpath(root.left,l,n)||findpath(root.Right,l,n)){
            return true;
        }
        l.remove(l.size()-1);
        return false;

    }
    public static Node lca(Node root,Node n1,Node n2){
        // using dfs
       if(root==null||n1==null||n2==null){
        return root;
       }
      Node l= lca(root.left,n1,n2);
       Node r =lca(root.Right,n1,n2);
       if(l==null){
        return r;
       }else if(r==null){
        return l;
       }else{
        return root;
       }
    }
    static int finddiameter(Node root){
        if(root==null){
            return 0;
        }
        int left = finddiameter(root.left);
        int right =finddiameter(root.Right);
        int height = height(root.left)+height(root.Right)+1;
        return Math.max(left,Math.max(right,height));
    }
    static Node createTree(){

        Node root = null;
        System.out.println("Enter Data");
        int data = sc.nextInt();
        if(data==-1){
            return null;
        }
        root = new Node(data);
        System.out.println("Enter left "+data);
        root.left = createTree();
        System.out.println("Enter right "+data);
        root.Right=createTree();
        return root;

    }
    static void preorder(Node root){

        if(root == null){
            return ;
        }
         preorder(root.left);
        System.out.print(root.data+" ");
        preorder(root.Right);
    }
   static void oleveltraversel(Node root){
        if(root==null){
            return;
        }
       Queue<Node> q  = new LinkedList<>();
       q.add(root);
       q.add(null);
       while(!q.isEmpty()){

           Node curr =  q.remove();
           if(curr == null){
               System.out.println();
               if(q.isEmpty()){
                   break;
               }else{
               q.add(null);
               }
           }
           else {
               System.out.print(curr.data+" ");
               if (curr.left != null) {
                   q.add(curr.left);
               }
               if (curr.Right != null) {
                   q.add(curr.Right);
               }

           }
       }

   }
   static void olevel(Node root,int k){
        if(root==null){
            return;
        }
        if(k==0){
            System.out.println(root.data);
        }else{
        olevel(root.left,k-1);
        olevel(root.Right,k-1);}
   }
    static void leftview(Node root, ArrayList<Node> list, int level){
        if(root == null){
            return ;
        }
        if(list.get(level)==null){
            list.add(root);
        }
        leftview(root.left,list,level+1);
        leftview(root.Right,list,level+1);
    }
    static void leftviewprint(Node root){
        ArrayList<Node> list = new ArrayList<>();
        leftview(root,list,0);
        for(Node curr : list){
            System.out.println(curr.data+" ");
        }
    }
    static int sum =0;
    static void sunm_of_node(Node root,int k){

     if(root == null){
         return ;
     }

     sunm_of_node(root.left,k-1);
     sunm_of_node(root.Right,k-1);
        if(k==0){
            System.out.println( sum+= root.data);
        }



}}


class  binarytree{
    static int idx =-1;
    static Node oftree(int [] nodes){
        idx++;
        if(nodes[idx]==-1){
            return null;
        }
        Node newNode = new Node(nodes[idx]);
        newNode.left = oftree(nodes);
        newNode.Right = oftree(nodes);
        return newNode;
    }
}

class Node{
    Node left,Right;
    int data;
    public Node(int data){
        this.data= data;
//        this.left = null;
//        this.Right= null;
    }
}
