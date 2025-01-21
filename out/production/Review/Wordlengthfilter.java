package out.production.Review;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Wordlengthfilter {

    public static void main(String[] args) {
        String s="New York City, the most populous city in the United States, located in the state of NEW YORK";
        System.out.println( Arrays.stream(s.split(" ")).filter(c->c.length()<=5).map(r->{
            if(r.contains(",")){
                return r.substring(0, r.length()-1);
            }
            return r;
        }).map(e->e.toUpperCase()).distinct().collect(Collectors.joining(" ")) );

        List<String> list=Arrays.asList("apple", "banana", "apricot", "blueberry", "avocado");

        System.out.println( list.stream().collect(Collectors.toMap((key)->key.substring(0,1),(value)->value.toUpperCase(), (v1,v2)->v1+";"+v2)));
        
    }

    
}