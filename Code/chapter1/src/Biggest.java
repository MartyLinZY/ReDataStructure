public class Biggest {
    public int chooseBiggest(int[] a,int max,int i){
        if(i>a.length-1){
            return max;
        }
        else{
            if(a[i]<max){
                return chooseBiggest(a,max,++i);
            }
            else{
                return chooseBiggest(a,a[i],++i);
            }
        }
        }

    public static void main(String[] args) {
        int[] a={1,2,3,4,9,4,100};
        Biggest b=new Biggest();
        System.out.println(b.chooseBiggest(a,0,0));
    }
    }
class Average{
    public double average(int[] a,double ave,int i){
        if(i>a.length-1){
            return ave;
        }
        else{
            ave=(ave*i+a[i])/(i+1);
            return average(a,ave,++i);
        }

    }

    public static void main(String[] args) {
        Average av=new Average();
        int[] a={1,2,3,4};
        System.out.println(av.average(a,0,0));
    }
}
