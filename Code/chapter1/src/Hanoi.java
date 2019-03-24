public class Hanoi {
    private void move(int n,char a,char b,char c){
        if(n>0){
            move(n-1,a,c,b);
            System.out.println("One disk is moved From "+a+" to "+c+".");
            move(n-1,b,c,a);
            //递归思路，模拟最后一步的过程，先把前n-1个从a->c->b，再把第n个放到c，最后把n-1个b->c->a
        }
    }
    public static void main(String[] args) {
        Hanoi h=new Hanoi();
        h.move(20,'A','B','C');
        System.out.println("Hanoi is finished");
    }
}
