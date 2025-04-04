import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.stream.Collectors;

class Solution {
    public boolean isAnagram(String s, String t) {
        

      String m=  s.chars().mapToObj(Character::toString).sorted().collect(Collectors.joining(""));
      String n=  t.chars().mapToObj(Character::toString).sorted().collect(Collectors.joining(""));

      char c[]=s.toCharArray();
    

    //   Arrays
      if(m.equals(n)) return true;

      return false;
    }
}

public class Anagram {

    public static void main(String[] args) {
        
        Solution s=new Solution();
        System.out.println( s.isAnagram("anagram", "nagraam"));

            LocalDate start = LocalDate.of(2024, 2, 1);
        LocalDate end = LocalDate.of(2025, 5, 13);

        Period period = Period.between(start, end);

        System.out.println("Years: " + period.getYears());
        System.out.println("Months: " + period.getMonths());
        System.out.println("Days: " + period.getDays());
    }
    
}
