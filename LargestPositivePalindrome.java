import java.util.*;
import java.util.stream.Collectors;
import java.util.function.Function;

public class LargestPositivePalindrome {
    public static String solution(String S) {

     List<Integer> list=new ArrayList<>();   
        for(int i=0; i<S.length(); i++){
           list.add(Character.getNumericValue(S.charAt(i))); 
        }
        
      Map<Integer,Long> map=  list.stream().collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
      
       map.entrySet().stream().sorted((a1,a2)->a2.getValue().compareTo(a1.getValue())); 

    Optional<Integer> max= map.keySet().stream().sorted((a1,a2)->a2.compareTo(a1)).limit(1).findFirst();

    Optional<Map.Entry<Integer,Long>> d=map.entrySet().stream().filter(e->e.get==0 && e.getValue()==S.length()).findAny();

        if(d.isPresent()&&d.get().getValue()==(long)S.length()){
            return "0";
        }

        Optional<Map.Entry<Integer,Long>> di=map.entrySet().stream().filter(e->e.getKey()==0 && e.getValue()==S.length()-1).findAny();
      
        if(di.isPresent()&&di.get().getValue()==Long.parseLong(Integer.toString(S.length()-1))){
       
          return max.get().toString();
      }
      
      StringBuilder result= new StringBuilder();

     

     if( map.values().stream().filter(i->i>1).findAny().isPresent()){
      
     for(Map.Entry<Integer,Long> s : map.entrySet()){
         if(s.getValue()>1){
        //    System.out.println( result.append(s.getKey()));
           result.append(s.getKey());
         }
     }

     StringBuilder another=new StringBuilder(result.reverse());
     if(!result.toString().contains(max.get().toString())) result.append(max.get());
     result.append(another);
     System.out.println( result);
     
     
     }
      else{
         return max.get().toString();
     }


        return result.toString();
    }

    public static void main(String[] args) {
        Solution sr = new Solution();
        System.out.println(solution("11223345"));

    }
}