package org.exercise;

public class countSeniors {
    public int countSeniors(String[] details) {
        int res=0;
        for (String s:details){
            if(s.charAt(11)-'0'>6)
                res++;
            if(s.charAt(11)-'0'==6&&s.charAt(12)-'0'>0)
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        countSeniors cs=new countSeniors();
        System.out.println(cs.countSeniors(new String[]{"7868190130M7522", "5303914400F9211", "9273338290F4010"}));
    }
}
