package tree;
class TreeNode{
    TreeNode left ;
    TreeNode right;
    int val;
    TreeNode(int val){
        this.val=val;
    }

}
public class lca {
    public static void main(String[] args) {
    TreeNode root = new TreeNode(4);

    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||root==p||root==q){
            return root;
        }
        TreeNode Left= lowestCommonAncestor(root.left,p,q);
        TreeNode Right= lowestCommonAncestor(root.right,p,q);
        // if root left == null so return right
        if(Left==null){
            return Right;
        }
        // if root right == null so return right
        else if(Right==null){
            return Left;
        }
        // this is the case in which the elements are found in first node
        else{
            // root.left!=null && root.right!=null so we can return root itself
            return root;
        }
    }
}
