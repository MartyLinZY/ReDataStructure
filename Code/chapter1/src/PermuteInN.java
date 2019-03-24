import java.util.Scanner;
public class PermuteInN {
    int[] a;
    void permute(int n,int r){
        for(int i=n;i>=1;i--){
            a[r-1]=i;
            if(r==1){
                for(int j=a.length-1;j>=0;j--){
                    System.out.print(a[j]+" ");
                }
                System.out.println();
            }
            else{
                n=i;
                permute(n-1,r-1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int r=sc.nextInt();
        PermuteInN pu=new PermuteInN();
        pu.a=new int[r];
        pu.permute(n,r);
    }
}
