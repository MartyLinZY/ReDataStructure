public class OneInBinary {
    public static int oneInBinary(int n){

        if(n==0){
            return 0;
        }
        else{
            if(n%2==0){
                return oneInBinary(n/2);
            }
            else{
                return oneInBinary(n/2)+1;
            }
        }

    }

    public static void main(String[] args) {
        System.out.println(OneInBinary.oneInBinary(6));
    }
}
