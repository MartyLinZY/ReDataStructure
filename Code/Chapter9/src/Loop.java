import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Loop {
    ArrayList<Integer> list=new ArrayList<>();
    Map<Integer,Integer> map =new HashMap<>();
    Map<Integer,Integer> mapKey =new HashMap<>();//key是可以获得key的
     public int[][] graph;
     ArrayList<String> loopset=new ArrayList<>();
     String string="";
  public void changeGraph(int[][] g){
        if(isGraph(g)){
            graph=g;
        }
    }
    Loop (){
        File f=new File("D:\\CSHomework\\DS\\Chapter9\\src\\edges2.txt");
        int[][] list=fileReader(f);
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
    private int[][] fileReader(File f){
        try{
            ArrayList<String> filelist=new ArrayList<>();
        BufferedReader br=new BufferedReader(new FileReader(f));
        String s;
        int counter=0;
        while((s=br.readLine())!=null){
            filelist.add(s);
            counter++;
        }
        int[][] graphLoop=new int[counter][2];
        for(int i=0;i<graphLoop.length;i++){
            String[] strings=filelist.get(i).split(",");
            graphLoop[i][0]=Integer.parseInt(strings[0]);
            graphLoop[i][1]=Integer.parseInt(strings[1]);
        }
        br.close();
            return graphLoop;
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;
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
    public static void main(String[] args) {
        Loop l = new Loop();

        if (l.loopFinder(l.graph)) {
    //       for(int i=0;i<l.graph.length;i++){
    //           for(int j=0;j<l.graph.length;j++){
    //               System.out.print(l.graph[i][j]+" ");
    //           }
    //           System.out.println();
    //       }
            System.out.println(1);
            l.loopPrinter(0);
            System.out.println(l.loopset.size());
            String[][] strlist=new String[100][];
            for (int i=0;i<l.loopset.size();i++){
                String[] xjbtemp=l.loopset.get(i).replaceFirst(" ","").split(" ");
                xjbtemp=l.rotateArr(xjbtemp);
                strlist[xjbtemp.length]=xjbtemp;
            }
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
            System.out.print(0);
        }
    }
}