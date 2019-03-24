public class BinaryNode {
    BinaryNode(){left=right=null;}
    BinaryNode(String e)
    {element=e; left=right=null;}
    BinaryNode(String e,  BinaryNode l, BinaryNode r)
    {element=e;  left=l;  right=r; }

    String element;
    BinaryNode  left;    //left subtree
    BinaryNode  right;   //right subtree

}
