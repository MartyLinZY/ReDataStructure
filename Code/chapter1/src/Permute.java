public class Permute {
    public void permute( String str ){
        char[] strList=str.toCharArray();
        permute(strList,0,strList.length-1);
    }
    private void permute( char [] str, int low, int high ){
        if(low==high){
            for(int i=0;i<=str.length-1;i++){
                System.out.print(str[i]);
            }
            System.out.println();
        }

            for(int i=low;i<str.length;i++){
                int flag=1;
                for(int k=low;k<i;k++){
                    flag=1;
                    if(str[k]==str[i]){
                        flag=0;
                        break;
                    }
                }
                if(flag==1){
                swap(str,i,low);
                permute(str,low+1,str.length-1);
                swap(str,i,low);
            }}
        }

    private void  swap(char[] str,int i,int j){
        char temp=str[i];
        str[i]=str[j];
        str[j]=temp;
    }

    public static void main(String[] args) {
        Permute p=new Permute();
        p.permute("baby");
    }
}
