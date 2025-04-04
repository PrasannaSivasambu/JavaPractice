import java.util.*;

class TreeNode {
    int val;
    TreeNode left, right;
    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

class BinaryTree {
    public void bfs(TreeNode root) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<TreeNode> stack= new Stack<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");

            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
            stack.push(node);
        }
        System.out.println();
        while (!stack.isEmpty()) {

            System.out.print(stack.pop().val+" ");
            
        }
    }

   
    public class BFSExample{
        public static void main(String[] args) {
            TreeNode root = new TreeNode(1);
            root.left = new TreeNode(2);
            root.right = new TreeNode(3);
            root.left.left = new TreeNode(4);
            root.left.right = new TreeNode(5);
    
            BinaryTree tree = new BinaryTree();
            System.out.println("BFS (Level Order Traversal):");
            tree.bfs(root);
        }
    }
}
