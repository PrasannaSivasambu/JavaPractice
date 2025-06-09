import java.lang.classfile.components.ClassPrinter.Node;
import java.util.LinkedList;
import java.util.Queue;

class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val,TreeNode left,TreeNode right){
        this.left=left;
        this.right=right;
        this.val=val;
    }
    TreeNode(int val){
        this.val=val;
    }
    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.val+" "+this.left+" "+this.right;
    }
}
public class validBinarySearch {
    public static boolean isValidBST(TreeNode root) {
        return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private static boolean validate(TreeNode node, long min, long max) {
        if (node == null) return true;
        System.out.println(node.val+" "+min+" "+max);
        if (node.val <= min || node.val >= max) return false;

        return validate(node.left, min, node.val) &&
               validate(node.right, node.val, max);
    }

    public static boolean bfsSearch(TreeNode t){

        Queue<TreeNode> q = new LinkedList<>();
        int min=Integer.MIN_VALUE, max=Integer.MAX_VALUE;
        
        q.add(t);
        while (!q.isEmpty()) {
            TreeNode node = q.poll();
            System.out.println(node);
            if(node.left!=null) {
                if(node.left.val<node.val){
                    // node.left.val;
                    q.add(node.left);
                }
                else{
                    return false;
                }
            }
            if( node.right!=null){
                if (node.right.val>node.val) {
                    q.add(node.right);
                }
                else{
                    return false;
                }
            }    
        }

        return true;
    }


    public static void main(String[] args) {
            TreeNode t1=new TreeNode(1);
            TreeNode t2=new TreeNode(2);
            TreeNode t3=new TreeNode(3);
            TreeNode t4=new TreeNode(4);
            TreeNode t5=new TreeNode(5);
            TreeNode t6=new TreeNode(3);
            TreeNode t7=new TreeNode(7);
            t3.left=t2;
            t2.left=t1;
            t3.right=t4;
            t4.right=t5;
            t4.left=t6;
            t2.right=t7;

        System.out.println( isValidBST(t3));
    }

    
}
