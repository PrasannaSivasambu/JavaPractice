import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;
class Solution {
    public String solution(String S) {

     List<Integer> list=new ArrayList<>();   
        for(int i=0; i<S.length(); i++){
           list.add(Integer.valueOf(S.charAt(i))); 
        }
        
      Map<Integer,Long> map=  list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
       map.entrySet().stream().sorted((a1,a2)->a2.getValue().compareTo(a1.getValue()));
    Optional<Integer> max= map.keySet().stream().limit(1).findFirst();

      if(map.entrySet().stream().filter(e->e.getKey()==0).count()==S.length()-1){
          return max.get().toString();
      }
      if(map.entrySet().stream().filter(e->e.getKey()==0).count()==S.length()){
          return "0";
      }

      StringBuilder result= new StringBuilder();

     

     if( map.values().stream().filter(i->i>1).findAny().isPresent()){
      
     for(Map.Entry<Integer,Long> s : map.entrySet()){
         if(s.getValue()>1){
           System.out.println( result.append(s.getKey()));
           result.append(s.getKey());
         }
     }

     StringBuilder another=result.reverse();
     result.append(max.get());
     result.append(another);
     System.out.println( result);
     
     
     }
      else{
         return max.get().toString();
     }


        return result.toString();
    }
}

public class NewClass {

    public static void main(String[] args) {
        List<List<List<Integer>>> nestedLists = Arrays.asList(

            Arrays.asList(Arrays.asList(1, 2, 3)),

            Arrays.asList(Arrays.asList(4, 6, 5))

        );
            
            nestedLists.stream().flatMap(e->e.stream().flatMap(List::stream)).distinct().map(ele->Math.sqrt(ele)).forEach(System.out::println);
 
        int[] f={1,2,3,4};
            
            Arrays.stream(f).mapToObj(Integer::valueOf).toArray(Integer[]::new);

        Set<Integer> d= new HashSet<>();  
        String s="f";
        System.out.println(s.charAt(0));     

        Solution sr=new Solution();
        System.out.println( sr.solution("39878"));

    }
    
}
