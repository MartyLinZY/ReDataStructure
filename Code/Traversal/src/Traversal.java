import java.util.Scanner;

public class Traversal {
    /**
     * 根据传递的树，用递归方法进行前中后序遍历
     * @param root 传递的树
     */
    public static void preorder(BinaryNode root) {
        if (root != null) {
            if(!root.element.equals("*")) {
                System.out.print(root.element);
                System.out.print(" ");
            }
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void inorder(BinaryNode root) {
        if (root != null) {
            inorder(root.left);
            if(!root.element.equals("*")){
            System.out.print(root.element);
            System.out.print(" ");
            }
            inorder(root.right);

        }
    }

    public static void postorder(BinaryNode root) {
        if (root != null) {
            postorder(root.left);
            postorder(root.right);
            if(!root.element.equals("*")) {
                System.out.print(root.element);
                 System.out.print(" ");
            }
        }
    }
/*

 */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        String str1="A B D E J H C F";
       // String str1=sc.nextLine();
        String[] str1list=str1.split(" ");
        String str2="D B J E H A C F";
       // String str2=sc.nextLine();
        String[] str2list=str2.split(" ");
        BinaryNode root=MakeTree.MakeTree(str1list,str2list);
        System.out.println("先序遍历为：");
        preorder(root);
        System.out.println("\n中序遍历为：");
        inorder(root);
        System.out.println("\n后序遍历为：");
        postorder(root);
    }
}
