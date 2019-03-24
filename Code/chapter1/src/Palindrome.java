public class Palindrome {

    public boolean word(String str,int low,int high,int length){
        char[] strList=str.toCharArray();
        if(length==1||length==0){
            return true;
        }
        if(strList[low]!=strList[high]){
            return false;
        }
        return word(str,low+1,high-1,length-2);
    }


    public boolean sentence(String str,int low,int high){
        char[] list=str.toCharArray();
        int n=0;
        for(int i=0;i<list.length-1;i++){

        }
        return true;
    }
}
