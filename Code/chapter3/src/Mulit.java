import java.util.Scanner;

public class Mulit {
    public static MultiNode add(MultiNode n1,MultiNode n2){
        if(n1==null&&n2==null)
            return null;
        if(n1==null||n2==null)
            return n1==null?n2:n1;
        MultiNode node=new MultiNode(0,0);
        MultiNode result=node;
        while(n1!=null&&n2!=null){
            if(n1.exp>n2.exp){
                node.next=new MultiNode(n1.con,n1.exp);
                n1=n1.next;
            }
            if(n1.exp<n2.exp){
                node.next=new MultiNode(n2.con,n2.exp);
                n2=n2.next;
            }
            if(n1.exp==n2.exp){
                node.next=new MultiNode(n1.con+n2.con,n1.exp);
                n1=n1.next;
                n2=n2.next;
            }
        }
        if(n1!=null)
            node.next=n1;
        if(n2!=null)
            node.next=n2;
        return result;
    }
    public static MultiNode make(int m){
        MultiNode result=null;
        MultiNode node=null;
        result.next=node;
        if(m<=0)
            return null;
        Scanner sc=new Scanner(System.in);
        for(int i=0;i<m;i++){
            String str=sc.nextLine();
            String[] strList=str.split(" ");
            node=new MultiNode(Integer.parseInt(strList[0]),Integer.parseInt(strList[1]));
            node=node.next;
        }
        return result.next;
    }

}
class MultiNode{
    int con;
    int exp;
    MultiNode next;
    MultiNode(int i,int j){
        con =i;
        exp =j;
    }
}
