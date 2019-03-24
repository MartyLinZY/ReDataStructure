import java.util.ArrayList;
import java.util.Arrays;

public class Josephus {
    public static int josephus(int n,int m){
        Node initialPortion=new Node(1);
        Node temp=initialPortion;
        for(int i=2;i<=n;i++){
            temp.next=new Node(i);
            temp=temp.next;
        }
        temp.next=initialPortion;
        Node start=temp;
        while(start!=start.next){
            for(int k=0;k<m-1;k++){
                start=start.next;
            }
            //System.out.println("delete "+Integer.toString(start.next.i));
            start.next=start.next.next;
        }
        return start.i;

    }
    public static int josephusSet(int n,int m){
        int[] list=new int[n];
        for(int i=0;i<n;i++){
            list[i]=i+1;
        }
        int delete=0;
        while(n!=1){
            int x;
            delete+=m;
            delete--;
            if(delete>=n){
                x=list[(delete)%n];
                delete=delete%n;
            }
            else{
                x=list[delete];
            }
            for(int i=0;i<list.length;i++){
                if(list[i]>x){
                    list[i-1]=list[i];
                }
            }
         //   System.out.println("delete "+Integer.toString(x));
            //System.out.println(Arrays.toString(list));
            n--;
        }
        return list[0];
    }
}
class Node{
    int i;
    Node next;
    Node(int num){
        i=num;
    }

    public static void main(String[] args) {
        System.out.println(Josephus.josephus(199,13));
        System.out.println(Josephus.josephusSet(8,4));
    }
}

