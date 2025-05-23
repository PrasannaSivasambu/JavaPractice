package org.example;

import java.util.Collections;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Palindrome {

    public static  boolean checkPalindrome(String s){
        StringBuilder str = new StringBuilder(s);
        if(str.reverse().toString().equals(s)) return true;

        return false;
    }
    public static void main(String[] args) {
       System.out.println(checkPalindrome("madam"));

       String s="madam";
       System.out.println( s.chars().mapToObj(e->(char)e).collect(Collectors.toCollection(LinkedList::new)).reversed().stream().map(ek->Character.toString(ek)).collect(Collectors.joining()));

       
    }
}

