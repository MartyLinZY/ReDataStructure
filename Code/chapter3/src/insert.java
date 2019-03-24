public class insert {
    public Node Insert(Node l1,Node l2){
        Node Lnew=new Node(0);
        Node L=Lnew;
        if(l1==null||l2==null) {
            return null;
        }
        while(l1!=null&&l2!=null){
            if(l1.i==l2.i){
                Lnew.next=new Node(l1.i);
                l1=l1.next;
                l2=l2.next;
            }
            if(l1.i>l2.i){
                l2=l2.next;
            }
            if(l1.i<l2.i){
                l1=l1.next;
            }
            Lnew=Lnew.next;
        }
        return L.next;
    }

    public Node InsertCom(Node l1,Node l2){
        Node Lnew=new Node(0);
        Node L=Lnew;
        if(l1==null||l2==null){
            return (l1==null)?l2:l1;
        }

        while(l1!=null&&l2!=null){
            Lnew.next=new Node(l1.i<l2.i?l1.i:l2.i);

            if(l1.i==l2.i){
                l1=l1.next;l2=l2.next;}
            else{
                if(l1.i>l2.i){
                    l2=l2.next;
                }
                else{l1=l1.next;}
            }
            Lnew=Lnew.next;
        }
        if(l1!=null){
            Lnew.next=l1;
        }
        if(l2!=null){
            Lnew.next=l2;
        }
        return L.next;
    }
}
