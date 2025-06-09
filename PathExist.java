import java.util.*;
public class PathExist {

    public static boolean dfsTraversal(Map<Integer,List<Integer>> map,Set<Integer> visitedSet,int start, int end,boolean track){

        if (visitedSet.contains(start))  return track;
        if (start==end){
            //  track=track || true;
             return true;
        }  
        if(visitedSet.size()==map.keySet().size()) {
            // track=track || false;
            return false;
        } 

        visitedSet.add(start);
        System.out.println(start);
        

        for(Integer i : map.get(start)){
           if(dfsTraversal(map,visitedSet,i,end,track)) return true;
        }
        return  false;
    }

    public static void main(String[] args) {
        int n=5,start=3,end=4;
        int[][] edges={{0,1},{0,2},{3,4},{2,5},{5,4}};
        Map<Integer,List<Integer>> map= new HashMap<>();
        Set<Integer> set = new HashSet<>();

        for(int[] a : edges){

            int src=a[0],dest=a[1];
            System.out.println(src+" "+dest);
            
                
                List<Integer> li= map.getOrDefault(src, new ArrayList<>());
                if(li.isEmpty())  map.put(src, li);
                li.add(dest);
               

                // }
                // else{
                // List<Integer> l =  new ArrayList<>(dest);
                // map.put(src, l);
                // }

                List<Integer> lis= map.getOrDefault(dest, new ArrayList<>());
                if(lis.isEmpty()) map.put(dest, lis);
                lis.add(src);
                
                


                // else{
                // List<Integer> l =  new ArrayList<>(src);
                // map.put(dest, l);
                // }
                
            }
            System.out.println(map);
            System.out.println("verify "+dfsTraversal(map,set,start,end,false));

           
             
    }
       
        
    
    
}
