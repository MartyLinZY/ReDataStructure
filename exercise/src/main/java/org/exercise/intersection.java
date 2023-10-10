package org.exercise;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class intersection {
    public int[] intersection(int[] nums1, int[] nums2) {
        if(nums1==null||nums2==null)
            return null;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        List<Integer> res=new ArrayList<>();
        for(int i=0,j=0;i<nums1.length&&j<nums2.length;){
            if(nums1[i]<nums2[j]){
                i++;
            }else
            if(nums1[i]>nums2[j]){
                j++;
            }
            else {
                if(res.contains(nums1[i])){
                    i++;
                    j++;
                }else
                    res.add(nums1[i]);
            }

        }
        int[] result=new int[res.size()];
        int i=0;
        for(Integer num:res){
            result[i]=num;
            i++;
        }
        return result;
    }

    public static void main(String[] args) {
        intersection in=new intersection();
        int[] nums1={1,2,2,1};
        int[] nums2={2,2};
        int[] res=in.intersection(nums1,nums2);
        for(int num:res){
            System.out.println(num+" ");
        }

    }
}
