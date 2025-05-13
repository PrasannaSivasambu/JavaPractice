package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MergeIntervals {

    static  List<int[]> doMergeIntervals(int[][] i){
        int j[] =i[0],k=1;
        List<int[]> list = Arrays.stream(i).collect(Collectors.toList());


       while (k<i.length) {
           System.out.println(j[1]+" "+list.get(1)[0]);
           if(j[1]>list.get(1)[0]){
               int l[]= new int[2];
               l[0]=j[0];
               l[1]=list.get(1)[1];
               list.removeFirst();
               list.removeFirst();
               list.addFirst(l);
               j=l;
               System.out.println(Arrays.toString(l));
           }
           k++;
       }
      return list;

    }
    public static void main(String[] args) {
        int[][] i = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        Arrays.sort(i,(a,b)->Integer.compare(a[0],b[0]));
        List<int[]> l=doMergeIntervals(i);
        l.stream().map(Arrays::toString).forEach(System.out::println);

        List<Integer> o = new ArrayList<>(Arrays.asList(1,2,3));
        o.removeFirst();
        System.out.println(o.getClass().getName());

    }
}
