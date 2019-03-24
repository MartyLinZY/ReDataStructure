import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;

public class Main {
    ArrayList<Integer> list=new ArrayList<>();
    Map<Integer,Integer> map =new HashMap<>();
    Map<Integer,Integer> mapKey =new HashMap<>();//key是可以获得key的
    public int[][] graph;
    public int loopnum=0;
    ArrayList<String> loopset=new ArrayList<>();
    String string="";
    public void changeGraph(int[][] g){
        if(isGraph(g)){
            graph=g;
        }
    }
    Main (){
        int[][] list=fileReader();
        for(int i=0;i<list.length;i++){
            for(int j=0;j<2;j++){
                if(!map.containsValue(list[i][j])){
                    map.put(map.size()+1,list[i][j]);
                }
            }
        }
        int[] mapvalue=new int[map.size()];
        for(int i=0;i<mapvalue.length;i++){
            mapvalue[i]=map.get(i+1);
        }
        for(int i=0;i<mapvalue.length;i++){
            mapKey.put(mapvalue[i],i+1);
        }
        int[][] gra=new int[map.size()][map.size()];
        for(int i=0;i<list.length;i++){
            int[] next;
            next=list[i];
            gra[mapKey.get(next[0])-1][mapKey.get(next[1])-1]=1;
        }
        graph=gra;
    }
    private boolean isGraph(int[][] graph){
        int length=graph.length;
        for(int i=0;i<graph.length;i++)
            if(graph[i].length!=length) {
                return false;}
        return true;
    }
    private int[][] fileReader(){
        Scanner input=new Scanner(System.in);
        ArrayList<String> filelist=new ArrayList<>();
        String s;
        int counter=0;
        while(!(s=input.nextLine()).equals("ok")){
            filelist.add(s);
            counter++;
        }
        int[][] graphLoop=new int[counter][2];
        for(int i=0;i<graphLoop.length;i++){
            String[] strings=filelist.get(i).split(",");
            graphLoop[i][0]=Integer.parseInt(strings[0]);
            graphLoop[i][1]=Integer.parseInt(strings[1]);
        }
        input.close();
        return graphLoop;
    }
    private boolean loopFinder(int[][] graph){
        int[] isVisited=new int[graph.length];
        for(int i=0;i<graph.length;i++){
            for(int j=0;j<graph.length;j++){
                if(graph[i][j]==1){
                    if(isVisited[j]==0){
                        isVisited[j]=1;
                        i=j;
                        j=-1;
                    }else{
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public String[] rotateArr(String[] strings){
        int min=Integer.parseInt(strings[0]);
        int state=0;
        for(int i=0;i<strings.length;i++){
            if(min>Integer.parseInt(strings[i])){
                min=Integer.parseInt(strings[i]);
                state=i;}
        }
        for(int i=0;i<state;i++){
            for(int j=0;j<strings.length-1;j++){
                String stemp=strings[j];
                strings[j]=strings[j+1];
                strings[j+1]=stemp;
            }
        }
        return strings;
    }
    private void loopPrinter(int node){
        int index;
        if((index=list.indexOf(node))!=-1){
            while(index<list.size()){
                string=string+" "+map.get(list.get(index)+1);
                index++;
            }
            loopset.add(string);
            string="";

            return;
        }
        list.add(node);
        for(int i=0;i<graph.length;i++){
            if(graph[node][i]==1)
                loopPrinter(i);
        }
        list.remove(list.size()-1);
    }
    public static void main(String[] args) {
        Main l = new Main();

        if (l.loopFinder(l.graph)) {
            System.out.println(1);
            l.loopPrinter(0);


            String[][] strlist=new String[100][];
            for (int i=0;i<l.loopset.size();i++){
                String[] xjbtemp=l.loopset.get(i).replaceFirst(" ","").split(" ");
                xjbtemp=l.rotateArr(xjbtemp);
                strlist[xjbtemp.length]=xjbtemp;
            }
            for(int i=0;i<100;i++){
                if(strlist[i]!=null){
                    l.loopnum++;
                }}
            System.out.println(l.loopnum);
            for(int i=0;i<100;i++){
                if(strlist[i]!=null){
                    System.out.print(strlist[i][0]);
                    for(int j=1;j<strlist[i].length;j++){
                        System.out.print(" "+strlist[i][j]);}
                    System.out.println();
                }
            }
        }
        else{
            System.out.println(0);
        }
    }
}