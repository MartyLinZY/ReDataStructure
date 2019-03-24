import java.util.Arrays;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MakeTree {
    /*
    根据后序生成树
    public static BinaryNode MakeTree(String suffix) {
        if (suffix != null) {
            String[] list = suffix.split(" ");
            Stack<BinaryNode> stack = new Stack<>();

            Pattern pattern = Pattern.compile("[0-9]*");
            for (int i = 0; i < list.length; i++) {
                Matcher isNum = pattern.matcher(list[i]);
                if (!isNum.matches()) {

                    BinaryNode root = new BinaryNode(list[i]);
                    root.left = stack.pop();
                    root.right = stack.pop();
                    stack.push(root);
                } else {
                    stack.push(new BinaryNode(list[i]));
                }
            }
            return stack.pop();
        }
        return null;
    }
*/

    /**
     * 通过前序、中序生成树
     * 遍历中先根据前序获得当前树的根，然后再中序中根据根分开左右子树
     * 递归调用本身，用copyOfRange方法获得左右子树对应的字符数组
     * @param preSort 前序遍历的string数组
     * @param inSort 中序遍历的string数组
     * @return 生成的树
     */
    public static BinaryNode MakeTree(String[] preSort,String[] inSort) {

        if(preSort==null || inSort==null){
            return null;
        }
        BinaryNode root=null;
        for(int i=0;i<inSort.length;i++){
            if(inSort[i].equals(preSort[0])){
                root=new BinaryNode(preSort[0]);
                root.left=MakeTree(
                        Arrays.copyOfRange( preSort, 1, i+1),
                        Arrays.copyOfRange( inSort, 0, i));
                root.right=MakeTree(
                        Arrays.copyOfRange( preSort, i+1, preSort.length),
                        Arrays.copyOfRange( inSort, i+1, inSort.length));
            }
        }
        return root;
    }

    public static void main(String[] args) {
        String[] str1="ABDCEGFHI".split("");
        String[] str2="DBAEGCHFI".split("");
        System.out.print(str1);
        BinaryNode root=MakeTree(str1,str2);
        System.out.print(root);
    }
}
