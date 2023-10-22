package org.exercise;

import java.util.Arrays;

public class maxSatisfaction {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        /////////log///////
//        for (int i=0;i<satisfaction.length;i++) {
//            System.out.print(satisfaction[i]+" ");
//        }
//        System.out.println();
        /////////log///////
        if(satisfaction[satisfaction.length-1]<=0){
            return 0;
        }
        int res=0;
        if(satisfaction[0]>=0){
            for (int i=0;i<satisfaction.length;i++) {
                res += satisfaction[i] * (i + 1);
            }
            return res;
        }
        if(satisfaction.length<=1){
            return satisfaction[0];
        }
        int zeroPoint=findClose2Zero(satisfaction);
        /////////log///////
        //System.out.println(zeroPoint);
        /////////log///////
        int right=0;
        for(int i=zeroPoint;i<satisfaction.length;i++){
            right+=satisfaction[i];
        }
        int start=-1;
        for(int i=zeroPoint-1;i>=0;i--){
            right+=satisfaction[i];
            if (right<0){
                start=i+1;
                break;
            }
            if(i==0)
                start=0;
        }
        System.out.println(start);
        for(int i=0;start+i<satisfaction.length;i++){
            res+=satisfaction[start+i]*(i+1);
        }
        return res;
    }
    public int findClose2Zero(int[] a){
        for (int i=0;i<a.length-1;i++){
            if (a[i]<0&&a[i+1]>=0)
                return i+1;
        }
        return -1;
    }

    public static void main(String[] args) {
        maxSatisfaction msf=new maxSatisfaction();
        int[] example= {0,1};
        System.out.println(msf.maxSatisfaction(example));
    }
}
