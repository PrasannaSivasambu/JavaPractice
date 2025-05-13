package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.*;
public class CountAndSay {

    static String count1(int n) {
        String result = "1";  // Start with the first term "1"

        for (int i = 2; i <= n; i++) {
            StringBuilder currentTerm = new StringBuilder();
            int count = 1;

            // Iterate through the previous term
            for (int j = 1; j < result.length(); j++) {
                // If the current digit is the same as the previous one, increment the count
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    // Otherwise, append the count and the digit to the current term
                    currentTerm.append(count).append(result.charAt(j - 1));
                    count = 1;  // Reset the count for the new digit
                }
            }

            // Append the last group of digits
            currentTerm.append(count).append(result.charAt(result.length() - 1));

            result = currentTerm.toString();  // Update the result with the current term
        }

        return result;  // Return the n-th term
    }

    static String count(int i){
        StringBuilder s= new StringBuilder("1");
        List<String> d= new LinkedList<>();
        for (int x=1; x<i; x++){
            Pattern pattern = Pattern.compile("(.)\\1*");
            Matcher matcher = pattern.matcher(s.toString());

            List<String> groups = new ArrayList<>();
            while (matcher.find()) {
                groups.add(matcher.group());
            }
            System.out.println(groups);
            s= new StringBuilder(
                    groups.stream()
                    .flatMap(
                    element->element.chars()
                            .mapToObj(e->(char)e)
                            .collect(
                                    Collectors.groupingBy(e->e,Collectors.counting())
                            )
                    .entrySet()
                    .stream()
                            .peek(System.out::println)
                    .map(
                            ele->Long.toString(ele.getValue())+ele.getKey())


                    )
                     .collect(Collectors.joining(""))
            );
            d.add(s.toString());
            System.out.println(s);

        }
        return d.getLast().toString();
    }

    public static void main(String[] args) {

        System.out.println(count(4));
    }
}
