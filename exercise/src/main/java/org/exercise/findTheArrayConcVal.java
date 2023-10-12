package org.exercise;

public class findTheArrayConcVal {
    public long findTheArrayConcVal(int[] nums) {
        if (nums.length==2)
            return calculateFirstAndLast(nums[0],nums[1])+nums[1];
        if(nums.length==1)
            return nums[0];
        long connect=0;
        int i=0, j= nums.length-1;
        while(i<j){
            connect+=calculateFirstAndLast(nums[i],nums[j])+nums[j];
            if(j-i>2){
                i++;
                j--;
            }else
            if (j-i==2){
                return connect+nums[i+1];
            }
            else
            if(j-i<2)
                return connect;

        }
        return 0;
    }
    public long calculateFirstAndLast(long first,long last){
        while (last > 0){
            last = last / 10;              //a的值等于接受的用户输入的值
            first*=10;                 //数据位数计数
        }
        return first;
    }

    public static void main(String[] args) {
        findTheArrayConcVal ft=new findTheArrayConcVal();
        System.out.println(ft.findTheArrayConcVal(new int[]{92,14}));
    }
}
