import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ProjectInyterview {

    public static void main(String[] args) {
        Integer nums[]={1,2,3};
        Set <List<Integer>> list= new HashSet();
        list.add(new ArrayList<>());
        list.add(new ArrayList<>(Arrays.asList(nums)));

        
        for(int i=0; i<nums.length; i++){
            list.add(new ArrayList<>(Arrays.asList(nums[i])));
           
            for(int j=i+1; j<nums.length; j++){
                list.add(new ArrayList(Arrays.asList(nums[i],nums[j])));    
            }
        }
        list.stream().map(List::stream).forEach(System.out::println);
        
        System.out.println(list);
    }
    
}
